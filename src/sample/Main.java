package sample;

import java.util.*;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Main {

    public static int n;
    public static Scanner s;
    public static boolean b = true;
    public static int anz;

    public static void main(String[] args) {

        eingeben();

    }

    public static void eingeben() {
        s = new Scanner(System.in);

        try {
            n = s.nextInt();
        } catch (Exception e) {
            System.out.println("Bitte Zahlen eingeben!");
            System.exit(0);
        }

        if (n == 0) {
            System.out.println("Die Zahl muss groeßer als 0 sein!");
            System.exit(0);
        }
        if (n == 1) {
            loesen(n, "A", "B", "C");
            System.out.println("");
            System.out.println("Die benoetigen " + 1 + " Zuege!");
        }
        if (n > 1) {
            anz = anzahl(n);
            loesen(n, "A", "B", "C");
            System.out.println("");
            System.out.println("Die benoetigen " + anz + " Zuege!");
        }
    }

    public static void loesen(int n, String start, String zp, String ende) {
        if (n == 1) {
            System.out.println("Bewege: " + start + " -> " + ende);
        } else {
            loesen(n - 1, start, ende, zp);
            System.out.println("Bewege: " + start + " -> " + ende);
            loesen(n - 1, zp, start, ende);
        }
    }

    public static int anzahl(int n) {
        int anz = (int) Math.pow(2, n) - 1;
        if (n == 1) {
            return 1;
        }
        return anz;
    }
}
