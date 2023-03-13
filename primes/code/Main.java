package primes.code;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // 60:  1, 2, 3, 4, 5, 6, 10, 12, 15, 20, 30, 60
        // 15:  1, 3, 5, 15
        // 100: 1, 2, 4, 5, 10, 20, 25, 50, 100
        // 90:  1, 2, 3, 5, 6, 9, 10, 15, 30, 45, 90
        

        while (true) {
            System.out.println("Enter a positive integer, or write something invalid to exit.");
            int num = 0;
            
            try {
                num = Integer.parseInt(s.nextLine().replace(" ", ""));
            } catch (Exception e) {
                break;
            }

            if (num < 0) {
                break;
            }
            
            System.out.print("Factors of " + num + ":  ");

            ArrayList<Integer> vals = Factors.divisors(num);
            
            for (int i = 0; i < vals.size(); i++) {
                int val = vals.get(i);
                System.out.print(val);

                if (i != vals.size() - 1) {
                    System.out.print(", ");
                }
            }

            System.out.print("\nPrime Factorization is  " + num + " = ");
            
            vals = Factors.primeFactorization(num);
            for (int i = 0; i < vals.size(); i++) {
                int val = vals.get(i);
                System.out.print(val);

                if (i != vals.size() - 1) {
                    System.out.print(" x ");
                }
            }

            System.out.print("\nSum of the factors of " + num + ":  " + Factors.sumDivisors(num));

            System.out.println("\n" + num + " is " + ( (Factors.isPerfect(num)) ? "" : "not " ) + "perfect.");
            System.out.println(num + " is " + ( (Factors.isPrime(num)) ?  "" : "not " ) + "prime.");
        }

        s.close();
    }
}
