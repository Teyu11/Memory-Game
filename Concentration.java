/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3question1;

import static assignment3question1.Concentration.dollar;
import java.util.Random;

/**
 * Class to simulate the Memory game in which the idea of the game is to find
 * identical pairs among a shuffled pack of cards laid out. A player then
 * selects two cards that are face down, turns them face up, and if the cards
 * match they are left face up. If the two cards do not match they are returned
 * to their original face down position. The game continues until all cards are
 * face up.
 *
 * @author SHREYA
 */
public class Concentration {

    static char[][] values = {
        {'A', '2', 'Q', 'J'}, {'K', '5', '9', '6'},
        {'2', 'A', '9', '6'}, {'5', 'K', 'Q', 'J'}
    };
    static char[][] dollar = {{'$', '$', '$', '$'}, {'$', '$', '$', '$'},
    {'$', '$', '$', '$'}, {'$', '$', '$', '$'}
    };

    //count of number of pairs left to be found
    static int pairs = 8;

    /**
     * Method that displays the card deck after the second card is chosen. Only
     * if a match is found it is kept face up otherwise it is again kept face
     * down.
     *
     * @param a Row of Card1
     * @param b Column of Card1
     * @return void
     */
    void displayBoard(int a, int b) {
        System.out.println("\n");
        System.out.printf("%-4s", "");
        for (int i = 0; i < dollar.length; i++) {
            System.out.printf("%-4d", i + 1);
        }
        System.out.println();
        for (int i = 0; i < dollar.length; i++) {
            System.out.printf("%-4d", i + 1);
            for (int j = 0; j < dollar.length; j++) {
                //Display the selected card
                if (i == (a - 1) && j == (b - 1)) {
                    System.out.printf("%-4c", values[i][j]);
                } else {
                    System.out.printf("%-4c", dollar[i][j]);
                }
            }
            System.out.println();
        }

    }

    /**
     * Method that displays the card deck after the second card is chosen. Only
     * if a match is found it is kept face up otherwise it is again kept face
     * down
     *
     * @param a Row of Card1
     * @param b Column of Card1
     * @param c Row of Card2
     * @param d Column of Card2
     * @return void
     */
    void displayBoard(int a, int b, int c, int d) {
        System.out.println("\n");
        System.out.printf("%-4s", "");
        for (int i = 0; i < dollar.length; i++) {
            System.out.printf("%-4d", i + 1);
        }
        System.out.println();
        for (int i = 0; i < dollar.length; i++) {
            System.out.printf("%-4d", i + 1);
            for (int j = 0; j < dollar.length; j++) {
                //Display both the selected cards
                if (i == (a - 1) && j == (b - 1) || i == (c - 1) && j == (d - 1)) {
                    System.out.printf("%-4c", values[i][j]);
                } else {
                    System.out.printf("%-4c", dollar[i][j]);
                }
            }
            System.out.println();
        }

    }

    /**
     * Method that checks if there is a match and permanently keeps those cards
     * open on the board if there's a match
     *
     * @param a Row of Card1
     * @param b Column of Card1
     * @param c Row of Card2
     * @param d Column of Card2
     * @return void
     */
    void foundPair(int a, int b, int c, int d) {
        if (values[a - 1][b - 1] == values[c - 1][d - 1]) {
            dollar[a - 1][b - 1] = values[a - 1][b - 1];
            dollar[c - 1][d - 1] = values[c - 1][d - 1];
            pairs--;
            System.out.println("\nCongratulations you have found one pair!");
            displayBoard(a, b, c, d);
        }
    }

    /**
     * Method to check if input is valid
     *
     * @param a which is an integer value that represents the row and column
     * number
     * @return boolean
     */
    boolean validInput(int a) {
        boolean flag = true;
        if (a < 1 || a > 4) {
            flag = false;
        }
        return flag;
    }

    /**
     * Shuffle method uses Fisher–Yates to shuffle a 2-D array
     *
     * @param a which is a char 2-D array that holds all the cards
     * @return void
     */
    void shuffle(char[][] a) {
        Random random = new Random();

        for (int i = a.length - 1; i > 0; i--) {
            for (int j = a[i].length - 1; j > 0; j--) {
                int m = random.nextInt(i + 1);
                int n = random.nextInt(j + 1);

                char temp = a[i][j];
                a[i][j] = a[m][n];
                a[m][n] = temp;
            }
        }
    }
}
