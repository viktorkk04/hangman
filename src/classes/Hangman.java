package classes;

import processing.core.PApplet;

public class Hangman {
    int lives = 6;
    private String secretWord;
    private char[] guessedLetters;

    private int incorrectGuesses;

    public Hangman(String word){
        
            incorrectGuesses = 0;

            secretWord = word.toLowerCase();
            guessedLetters = new char[secretWord.length()];

            //init partial word, and set all
            //letters to '_'
            guessedLetters = new char[word.length()];
            for (int i = 0; i < guessedLetters.length; i++){
            guessedLetters[i] = '_';
            }
        
    }

    public char[] getGuessedLetters(){
        return guessedLetters;
    }

    public boolean guess(char letter){
        
        char lowerCase = Character.toLowerCase(letter);
        
        boolean letterInSecretWord = false;
        for (int i = 0; i < secretWord.length(); i++){
            if (secretWord.charAt(i) == lowerCase){
              guessedLetters[i] = lowerCase;
              letterInSecretWord = true;
            }
          }
        
        if (!letterInSecretWord) {
            incorrectGuesses++; 
        }
    
        return letterInSecretWord;
    
    }

    public void drawGuessedLetters(PApplet p){
        if (incorrectGuesses < lives){
        //draw word on screen
        p.textSize(32);
        for (int i = 0; i < guessedLetters.length; i++){
            //draw guessed letter in center of the screen
            p.text(guessedLetters[i], p.width/2+20*i-
                guessedLetters.length*20/2, p.height/2);
        }
        
    }
        else{
            p.textSize(64);
            p.text("Game Over", p.width/4, p.height/2);
        }
    }

    public boolean isAlive(){
        return incorrectGuesses < lives;
    }
}
