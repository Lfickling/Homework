/*Program:CS1Calculator

        Description: very basic calculator that keeps track of the number of calculations you are making.

        Author: Letitia Fickling

        Date: 2/25/2020

        Assumptions and Limitations:
            · no real numbers (integers only)
            · input numbers and answers will fit in the range of the int data type
            · division is integer division
            · binary operations only (two operands)
            · addition, subtraction, multiplication, and division are the only operations supported
            · perfect user: all input will be correct (y or n only; integers only for operands)
            · results are not saved
            · the user wants to do at least one problem */

import java.util.Scanner;

public class CS1Calculator {

    private Scanner scanner;
    int quantityAdditionProblems;
    int quantitySubtractionProblems;
    int quantityMultiplicationProblems;
    int quantityDivisionProblems;
    int quantityTotalProblems;

    public CS1Calculator() { //initializes counters to zero instatiates and initializes a scanner to read from the keyboard
        quantityAdditionProblems=0;
        quantitySubtractionProblems=0;
        quantityMultiplicationProblems=0;
        quantityDivisionProblems=0;
        quantityTotalProblems=0;
        scanner = new Scanner(System.in);
    }

    private void printIntro() { //explains program to user
            System.out.println("\nWelcome to the calculator!");
    }

    private void calculate() { //method to conduct the calculator operations
        String anotherProblem = "";
        while (!anotherProblem.equals("n")) {
            System.out.println("Select the problem type you would like to calculate by entering the first letter of the operation.");
            System.out.println("(A)ddition \n(S)ubtraction \n(M)ultiplication \n(D)ivision");
            System.out.print("\nOperation? ");
            String operationType = scanner.next();
            operationType = operationType.toUpperCase();
            if (operationType.equals("A")) {
                System.out.println("\nYou selected addition.");
            }
            else if (operationType.equals("S")) {
                System.out.println("\nYou selected subtraction.");
            }
            else if (operationType.equals("M")) {
                System.out.println("\nYou selected multiplication.");
            }
            else if (operationType.equals("D")) {
                System.out.println("\nYou selected division.");
            }
            System.out.print("Enter your first number: ");
            String firstOperand = scanner.next();
            int firstNumber = Integer.parseInt(firstOperand);
            System.out.print("Enter your second number: ");
            String secondOperand = scanner.next();
            int secondNumber = Integer.parseInt(secondOperand);
            int answer;
            if (operationType.equals("A")) {
                answer = firstNumber + secondNumber;
                System.out.println("\nThe answer is " + answer + ".");
                quantityAdditionProblems++;
            }
            else if (operationType.equals("S")) {
                answer = firstNumber - secondNumber;
                System.out.println("\nThe answer is " + answer + ".");
                quantitySubtractionProblems++;
            }
            else if (operationType.equals("M")) {
                answer = firstNumber * secondNumber;
                System.out.println("\nThe answer is " + answer + ".");
                quantityMultiplicationProblems++;
            }
            else if (operationType.equals("D")) {
                answer = firstNumber / secondNumber;
                System.out.println("\nThe answer is " + answer + ".");
                quantityDivisionProblems++;
            }
            System.out.print("\nWould you like to do another problem? (y/n) ");
            anotherProblem = scanner.next();
        }
    }

    private void printReport() { //method to print final report of calculations
        System.out.println("\nCalculator Report");
        System.out.println("Addition problems: " + quantityAdditionProblems);
        System.out.println("Subtraction problems: " + quantitySubtractionProblems);
        System.out.println("Multiplication problems: " + quantityMultiplicationProblems);
        System.out.println("Division problems: " + quantityDivisionProblems);
        System.out.println("Total problems: " + quantityTotalProblems);
    }

    public static void main(String args[]) {
        CS1Calculator newCalculator = new CS1Calculator();
        newCalculator.printIntro();
        newCalculator.calculate();
        newCalculator.printReport(); // goes to print report method

    }
}
