/*
 * CS 2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Prg 04 - QuizApp class
 * Author:
 */

import java.io.*;
import java.util.*;

public class QuizApp {

    private static final String STUDENTS_FILE_NAME = "students.csv";
    private static final String QUIZ_FILE_NAME     = "quiz.txt";
    private static final double TOLLERANCE         = 0.0001;
    public static Scanner sc = new Scanner(System.in);

    // instance variables
    private Hashtable<String, Student> students;
    private LinkedList<Question> quiz;
    private String title;

    public QuizApp() throws FileNotFoundException {
        loadStudents();
        loadQuiz();
    }

    // TODO: finish the implementation of the method
    public void loadStudents() throws FileNotFoundException {

    }

    // TODO: finish the implementation of the method
    public void saveStudents() throws FileNotFoundException {

    }

    // TODO: finish the implementation of the method
    public void loadQuiz() throws FileNotFoundException {

    }

    public void runQuiz() {
        System.out.println("This quiz is about: " + title);
        System.out.print("What's your name? ");
        String name = sc.nextLine();
        Student student = students.get(name);
        if (student == null) {
            student = new Student(name);
            students.put(name, student);
        }
        int correct = 0;
        if (student.canTakeQuiz()) {
            Iterator<Question> it = quiz.iterator();
            while (it.hasNext()) {
                Question question = it.next();
                System.out.println(question);
                System.out.print("Answer: ");
                int answer = sc.nextLine().toLowerCase().charAt(0) - 'a';
                if (answer == question.getCorrect()) {
                    correct++;
                    System.out.println("Correct!");
                }
                else
                    System.out.println("Incorrect!");
                System.out.println();
            }
            double grade = (double) correct / quiz.size() * 100;
            System.out.println("Your grade this time was: " + String.format("%.2f", grade));
            student.addResult(grade);
        }
        else
            System.out.println("Sorry but you cannot take this quiz anymore!");
    }

    public static void main(String[] args) throws FileNotFoundException {
        QuizApp quizApp = new QuizApp();
        quizApp.runQuiz();
        quizApp.saveStudents();
    }
}
