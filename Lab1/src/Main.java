//import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*Scanner input = new Scanner(System.in);
        System.out.print("Enter a number for Lucas number: ");
        int n = input.nextInt();*/

        int n = 11;

        int sum = 0;
        for(int i = 0; i < n;i++) {
            int lucas = Lucas.lucasNumber(i);
            sum += lucas;
        }
        System.out.println("Sum of Lucas first numbers: " + (sum));
    }
}
