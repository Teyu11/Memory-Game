/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3question1;

import static assignment3question1.Concentration.values;
import java.util.Scanner;

/**
 * This class is used to simulate the Memory game
 *
 * @author SHREYA
 */
public class MemoryGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int rowC1;
        int columnC1;
        int rowC2;
        int columnC2;
        // creating an object of the concentration class
        Concentration obj = new Concentration();
        obj.shuffle(values);

        // System.out.println(Arrays.deepToString(obj.values));
        Scanner scanner = new Scanner(System.in);
        while (Concentration.pairs > 0) {
            System.out.println("Please enter the first card's row followed by column: \n");
            System.out.print("Row 1: ");
            rowC1 = scanner.nextInt();
            System.out.print("Column 1: ");
            columnC1 = scanner.nextInt();
            //Checking if row and column number are valid
            while (!obj.validInput(rowC1) || !obj.validInput(columnC1)) {
                System.out.println("invalid i/p");
                System.out.print("Row 1: ");
                rowC1 = scanner.nextInt();
                System.out.print("Column 1: ");
                columnC1 = scanner.nextInt();
            }

            //Reveal the first card
            obj.displayBoard(rowC1, columnC1);

            System.out.println("\nPlease enter the second card's row followed by column: \n");
            System.out.print("Row 2: ");
            rowC2 = scanner.nextInt();
            System.out.print("Column 2: ");
            columnC2 = scanner.nextInt();

            //Checking if row and column number are valid
            while (!obj.validInput(rowC2) || !obj.validInput(columnC2)) {
                System.out.println("invalid i/p");
                System.out.print("Row 2: ");
                rowC2 = scanner.nextInt();
                System.out.print("Column 2: ");
                columnC2 = scanner.nextInt();
            }
            //If the same card is selected ask the user to open a different card 
            if (rowC1 == rowC2 && columnC1 == columnC2) {
                System.out.println("\nSelect 2 different cards \n");
                System.out.println("Please enter the second card's row followed by column: \n");
                System.out.print("Row 2: ");
                rowC2 = scanner.nextInt();
                System.out.print("Column 2: ");
                columnC2 = scanner.nextInt();
            }
            //Reveal the 2 cards
            obj.displayBoard(rowC1, columnC1, rowC2, columnC2);
            //If cards match they're retained on the board
            obj.foundPair(rowC1, columnC1, rowC2, columnC2);

        }

    }

}
