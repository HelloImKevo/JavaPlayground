package com.kevo.junk;

import java.util.Scanner;

/**
 * @author kevo
 */
public class StringFormatTest {

    public static void main(String[] args) {
        Scanner personInfo = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = personInfo.nextLine();

        System.out.println("Enter your age: ");
        int age = extractInt(personInfo);

        System.out.println("Enter your major: ");
        String major = personInfo.nextLine();

        System.out.println("Enter your dream job: ");
        String dreamJob = personInfo.nextLine();

        String formattedMessage = String.format("Hello my name is %s "
                + "and I am %d years old. I am enjoying my time studying %s, "
                + "and I want to be a %s when I grow up!",
                name, age, major, dreamJob);
        System.out.println(formattedMessage);
    }

    private static int extractInt(final Scanner input) {
        try {
            return Integer.parseInt(input.nextLine());
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            return 0;
        }
    }
}
