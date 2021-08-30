/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Prg03 - Leaderboard class
 * Name(s): Letitia Fickling
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Scanner;

public class Leaderboard {

    private static final String FILE_NAME = "players.csv";
    private BinaryTree boards[];

    // TODO: finish the implementation of the method
    public Leaderboard() throws FileNotFoundException {

        // TODO: initialize one BinaryTree for each game (must use "boards" instance variable)
        boards = new BinaryTree[Game.values().length];
        for (int i = 0; i < Game.values().length; i++) {
            BinaryTree newTree = new BinaryTree();
            boards[i] = newTree;
        }

        // TODO: add all players in "players.csv" to the right BinaryTree based on the games that they are playing
        Scanner in = new Scanner(new FileInputStream("players.csv"));
        String line;
        while (in.hasNextLine()) {
            line = in.nextLine();
            String data[] = line.split(",");
            String name = data[0];
            Game game = Game.values()[Integer.parseInt(data[1])];
            int score = Integer.parseInt(data[2]);
            this.add(name, game, score);
        }
        in.close();
    }

    // TODO: add the player with the given name and score to the correct binary tree depending on the informed game parameter (to simplify, assume that the given player is NOT currently in the binary tree)
    public void add(final String name, final Game game, int score) {
        Player newPlayer = new Player(name,score);
        boards[game.getValue()].add(newPlayer);
    }

    // TODO: display the BinaryTree associated with the given game
    public void list(final Game game) {
        System.out.println(game + " Leaderboard:");
        System.out.print(boards[game.getValue()] + "\n");
    }

    // TODO: save all binary trees into "players.csv"
    public void save() throws FileNotFoundException {
        PrintStream out = new PrintStream(new FileOutputStream("players.csv"));
        for (int i = 0; i < Game.values().length; i++) {
            Iterator<Player> it = boards[i].iterator();
            while (it.hasNext()) {
                Player player = it.next();
                out.println(player.getName() + "," + i + "," + player.getScore());
            }
        }
        out.close();
        System.out.print("done!");
    }

    public static void main(String[] args) throws FileNotFoundException {
        Leaderboard lb = new Leaderboard();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Options: [list | add | save | exit]");
            System.out.print("? ");
            String option = sc.nextLine();
            if (option.equals("list")) {
                System.out.println("game? ");
                Game game = Game.values()[Integer.parseInt(sc.nextLine())];
                lb.list(game);
            }
            else if (option.equals("add")) {
                System.out.println("name? ");
                String name = sc.nextLine();
                System.out.println("game? ");
                Game game = Game.values()[Integer.parseInt(sc.nextLine())];
                System.out.println("score? ");
                int score = Integer.parseInt(sc.nextLine());
                lb.add(name, game, score);
            }
            else if (option.equals("save"))
                lb.save();
            else
                break;
        }
    }
}
