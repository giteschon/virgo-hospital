/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanakasalo.console;

import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author Ivy
 */
public class ConsoleUtilities {

    private ConsoleUtilities() {
    }

    public static int readInt(InputStream in) {
        Scanner scanner = new Scanner(in);
        int number = 0;
        String regex = "\\d+";
        String line = "";
        do {
            line = scanner.nextLine();
            try {
                number = Integer.parseInt(line);
            } catch (Exception e) {
                System.out.println("Please insert a number");

            }
        } while (!line.matches(regex));

        return number;
    }

    public static String readString(InputStream in) {
        Scanner scanner = new Scanner(in);

        return scanner.nextLine();
    }

}
