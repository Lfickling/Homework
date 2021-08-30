/*
 * CS 2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Homework 10 - PopulationsDriver class
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Scanner;

public class PopulationsDriver {

    private static final String FILE_NAME = "population.csv";
    private Hashtable<String, Integer> pops;

    public PopulationsDriver() {
        pops = new Hashtable<>();
        loadData();
    }

    // TODO: finish the implementation of the method
    // this method should read all of the population data from "populations.csv into the hashtable "pops"
    public void loadData() throws FileNotFoundException {
        Scanner in = new Scanner(new FileInputStream(FILE_NAME));
        String line;
        while (in.hasNextLine()) {
            line = in.nextLine();
            String data[] = line.split(",");
            String state = data[0];
            int pop = Integer.parseInt(data[1]);
            pops.put(state, pop);
        }
        in.close();
    }

    // TODO: return the state population by querying the hashtable "pops"
    public int getPopulation(String state) {
        int pop = pops.get(state);
        return pop;
    }

    public static void main(String[] args) {
        PopulationsDriver pd = new PopulationsDriver();
        System.out.println("Population of CO = " + pd.getPopulation("CO"));
    }
}
