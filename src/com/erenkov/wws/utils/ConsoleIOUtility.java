package com.erenkov.wws.utils;

import java.util.Scanner;

/**
 * This class provides methods for read/write information from/to console
 */
public class ConsoleIOUtility {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * This method prints a string to console
     *
     * @param s - string to print
     */
    public static void print(String s) {
        System.out.println(s);
    }


    /**
     * This method prints a string to the console, and reads a line into the buffer.
     *
     * @param outString line to print.
     * @return StringBuilder with input line.
     */
    public static StringBuilder read(String outString) {
        print(outString);
        StringBuilder buffer = new StringBuilder(scanner.nextLine().trim());
        printLine1();
        return buffer;
    }


    /**
     * This method prints a horizontal line to console
     */
    public static void printLine1() {
        print("--------------------------------------------------------------------------------------------");
    }


    /**
     * This method prints a double horizontal line to console
     */
    public static void printLine2() {
        print("============================================================================================");
    }


    /**
     * This method prints menu header
     *
     * @param menu menu
     */
    public static void printMenuHeader(String menu) {
        print("     " + menu + " MENU");
        printLine1();
    }
}




