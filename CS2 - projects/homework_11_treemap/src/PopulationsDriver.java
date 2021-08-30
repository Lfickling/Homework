/*
 * CS 2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Homework 11 - PopulationsDriver class
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class PopulationsDriver {

    private static final String FILE_NAME = "population.csv";
    private TreeMap<String, Integer> pops;

    public PopulationsDriver() throws FileNotFoundException {
        pops = new TreeMap<>();
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

    // TODO: build a string with all of the state populations (one state per line)
    public String toString() {

        // TODO: first use keySet to get a Set reference of the keys
        Set<String> keySet = pops.keySet();
        // TODO: then get an iterator from the set of keys
        Iterator<String> i = keySet.iterator();
        // TODO: iterate over the keys and build a string with the (state, pop) pairs
        String str = "";
        while (i.hasNext()) {
            String state = i.next();
            str += state + ": " + getPopulation(state) + "\n";
        }
        // return the generated string
        return str;
    }

    public static void main(String[] args) throws FileNotFoundException {
        PopulationsDriver pd = new PopulationsDriver();
        System.out.println("Population of CO = " + pd.getPopulation("CO"));
        System.out.println(pd);
    }
}
