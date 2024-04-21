package com.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        JacksonIamRolePolicyVerifier verifier = new JacksonIamRolePolicyVerifier();

        try {
            System.out.println("Welcome to the IAM Role Policy Verifier!");

            while (true) {
                System.out.print("\nEnter the path to the IAM role policy JSON file (or 'exit' to quit): ");
                String input = reader.readLine();

                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting the program...");
                    break;
                }

                File file = new File(input);
                if (!file.exists()) {
                    System.out.println("File not found! Please enter a valid file path.");
                    continue;
                }

                try {
                    boolean result = verifier.verifyIamRolePolicyResourceField(file);
                    if (result) {
                        System.out.println("Resource field verification: PASSED");
                    } else {
                        System.out.println("Resource field verification: FAILED");
                    }
                } catch (IOException e) {
                    System.out.println("Error reading the file: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading input: " + e.getMessage());
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("Error closing reader: " + e.getMessage());
            }
        }
    }
}
