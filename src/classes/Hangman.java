package classes;

public class Hangman {
    private String secretWord;
    private char[] guessedLetters;

    public Hangman(String word){
        secretWord = word;
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
        boolean letterInSecretWord = false;
        for (int i = 0; i < secretWord.length(); i++){
            if (secretWord.charAt(i) == letter){
              guessedLetters[i] = letter;
              letterInSecretWord = true;
            }
          }
        return letterInSecretWord;
    }
}
