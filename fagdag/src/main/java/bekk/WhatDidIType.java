package main.java.bekk;

import java.io.*;

/*
* kilde: http://www.javaprogrammingforums.com/whats-wrong-my-code/4549-help-messy-code.html
 */

public class WhatDidIType {

    public static void main(String[] args) throws IOException {
        BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));

        String in, yes;

        do {
            System.out.print("press any key from the keyboard:");
            String input = dataIn.readLine();

            if (input.equalsIgnoreCase("a") || input.equalsIgnoreCase("e") || input.equalsIgnoreCase("i")
                    || input.equalsIgnoreCase("o") || input.equalsIgnoreCase("u")) {
                in = "vowel";
                System.out.println(input + " is " + in);
            } else if (input.equalsIgnoreCase("b") || input.equalsIgnoreCase("c") || input.equalsIgnoreCase("d") ||
                    input.equalsIgnoreCase("k") || input.equalsIgnoreCase("f") || input.equalsIgnoreCase("g") ||
                    input.equalsIgnoreCase("h") || input.equalsIgnoreCase("j") || input.equalsIgnoreCase("l") ||
                    input.equalsIgnoreCase("m") || input.equalsIgnoreCase("n")
                    || input.equalsIgnoreCase("p") || input.equalsIgnoreCase("q") || input.equalsIgnoreCase("r")
                    || input.equalsIgnoreCase("s") || input.equalsIgnoreCase("t") || input.equalsIgnoreCase("v")
                    || input.equalsIgnoreCase("w") || input.equalsIgnoreCase("x") || input.equalsIgnoreCase("y")
                    || input.equalsIgnoreCase("z")) {

                in = "consonant";
                System.out.println(input + " is " + in);
            } else {

                System.out.println("Unrecognized");
            }

            System.out.print("Try again y/n: ");
            yes = dataIn.readLine();
        }

        while (yes.equalsIgnoreCase("y"));
        System.out.println("Bye Bye!!");
    }
}