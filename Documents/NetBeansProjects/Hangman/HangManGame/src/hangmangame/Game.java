/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmangame;

/**
 *
 * @author enesc
 */
public class Game {

    private final String wordToGuess;
    private String hits = "";
    private String misses = "";
    private final static int MAX_TRIES = 7;
            

    public Game(String wordToGuess) {
        this.wordToGuess = wordToGuess;
    }

    public boolean checkIfGuessed(char guess) {
        for (char a : wordToGuess.toCharArray()) {
            if (guess == a) {
                hits += guess;
                return true;
            }
        }

        misses += guess;
        return false;
    }

    public void displayUpdatedGuesses() {
        char default_char = '_';
        String msg = "";
        for ( char a: wordToGuess.toCharArray() ) {
            if ( hits.indexOf(a) > -1 )
                msg += Character.toUpperCase(a);
            else
                msg += default_char;
        }
        
        System.out.println(msg);
    }
    
    
    public boolean wordGuessed() {
        char default_char = '_';
        String msg = "";
        for ( char a: wordToGuess.toCharArray() ) {
            if ( hits.indexOf(a) > -1 )
                msg += a;
            else
                msg += default_char;
        }
        
        return msg.contains("_");
    }
    
    public boolean allGuessed() {
        return hits.length() == wordToGuess.length();
    }
    
    public int triesRemain() {
        return  MAX_TRIES - misses.length()  ;
    }
    
    public boolean wordIsGuessed() {
        return wordToGuess.length() == hits.length();
    }
    
    public int getTotalTries() {
        return this.misses.length() + this.hits.length();
    }
    
    public String getWord() {
        return wordToGuess;
    }

}
