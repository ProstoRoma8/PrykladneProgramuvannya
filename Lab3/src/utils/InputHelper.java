package utils;

import java.util.Scanner;

/** inputHelper - клас який дозволяє зробити ввід у класі main чистішим **/
public class InputHelper {
    private static final Scanner sc = new Scanner(System.in);

    public static int nextInt(String msg) {
        System.out.print(msg);
        return sc.nextInt();
    }

    public static String nextLine(String msg) {
        System.out.print(msg);
        sc.nextLine(); // очищення
        return sc.nextLine();
    }
}
