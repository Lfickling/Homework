/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Student Names: Jose Garcia-Martinez 900908543; Letitia Fickling 900848908
 * Description: Prg01 - MoleculeDriver Class
 */

public class MoleculeDriver {

    public static void main(String[] args) {

        // creating "Carbon Dioxide: CO_2"
        Element C = new Element("C", "carbon");
        Element O = new Element("O", "oxygen");
        Molecule co2 = new Molecule("Carbon Dioxide");
        co2.add(O, 2);
        co2.add(C);
        System.out.println(co2);

        // creating "Caffeine: C_8H_10N_4O_2"
        Element N = new Element("N", "nitrogen");
        Element H = new Element("H", "hydrogen");
        Molecule caffeine = new Molecule("Caffeine");
        caffeine.add(N, 4);
        caffeine.add(O, 2);
        caffeine.add(H, 10);
        caffeine.add(C, 8);
        System.out.println(caffeine);

        // TODO: create your favorite molecule
        Element S = new Element("S", "sulfer");
        Molecule penicillin = new Molecule("Penicillin");
        penicillin.add(S, 1);
        penicillin.add(O, 4);
        penicillin.add(N, 2);
        penicillin.add(H, 11);
        penicillin.add(C, 9);
        System.out.println(penicillin);
    }

}
