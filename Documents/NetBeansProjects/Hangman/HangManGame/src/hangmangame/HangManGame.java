/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmangame;

import java.util.Scanner;

/**
 *
 * @author enesc
 */
public class HangManGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        WordGenerator wg = new WordGenerator("resources/fisier_cuvinte.txt");

        String word;
        word = wg.getRandomWord();
        System.out.println(word);

        Game game = new Game(word);

        System.out.println("The game begins:\n");
        game.displayUpdatedGuesses();

        while (game.triesRemain() != 0 && game.wordGuessed()) {
            System.out.print("Please enter a char: ");
            Scanner sc = new Scanner(System.in);
            char userLetter = sc.next().charAt(0);
            System.out.println("You're guess is " + game.checkIfGuessed(userLetter));
            game.displayUpdatedGuesses();
            System.out.println("You have " + game.triesRemain() + " tries ...\n\n");
        }

        if (game.allGuessed()) {
            System.out.println("Congratulations !!!!\n"
                    + "You guessed the word in "
                    + game.getTotalTries()
                    + " tries !!!");
        } else {
            System.out.println("Bummer\nGood luck next time ...\n\n"
                    + "The word was " + game.getWord().toUpperCase());
        }

    }

}
