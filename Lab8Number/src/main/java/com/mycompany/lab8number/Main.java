/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab8number;

import edu.tarleton.logging.Logger;
import java.io.IOException;
import static java.lang.Math.abs;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("How many guesses would you like?");
        Scanner sc = new Scanner(System.in);
        int guesses = sc.nextInt();
        Random rand = new Random();
        int randNum = abs((rand.nextInt() % 100) + 1);
        int min = 0;
        int max = 100;

        for (int i = 0; i < guesses; i++) {
            System.out.printf("Choose a number between %d-%d%n", min, max);
            int guess = sc.nextInt();

            if (guess > randNum) {
                max = guess;
            } else if (guess < randNum) {
                min = guess;
            } else if (guess == randNum) {
                System.out.println("Correct");
                break;
            }
        }
        System.out.printf("The number is %d", randNum);
        try {
            //System.out.println(line);
            Logger log = new Logger("log.txt");
            log.log("Program ran");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
