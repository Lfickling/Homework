/*
 * CS 2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Prg 04 - Student class
 * Author:
 */

public class Student {

    private String name;
    private static int MAX_RETAKES = 3;
    private double results[];
    private int retakes;

    public Student(String name) {
        this.name = name;
        results = new double[MAX_RETAKES];
        int retakes = 0;
    }

    public String getName() {
        return name;
    }

    public int getRetakes() {
        return retakes;
    }

    // TODO: finish the method implementation
    public boolean canTakeQuiz() {
        return false;
    }

    // TODO: finish the method implementation
    public void addResult(double result) {

    }

    // TODO: finish the method implementation
    public double finalGrade() {
        return 0;
    }

    @Override
    public String toString() {
        String str = name + ",";
        for (int i = 0; i < retakes; i++)
            str += String.format("%.2f", results[i]) + ",";
        for (int i = retakes; i < MAX_RETAKES; i++)
            str += ",";
        return str + String.format("%.2f", finalGrade());
    }
}
