package primes.code;

import java.util.ArrayList;

public class Factors {
    public static ArrayList<Integer> primeFactorization(int num) {
        ArrayList<Integer> toReturn = new ArrayList<Integer>();
        int initNum = num;
        
        for (int i = 2; i <= initNum; i++) {
            if (!isPrime(i)) {
                continue;
            }

            if (num == 1) {
                break;
            }

            if (num % i == 0) {
                toReturn.add(i);
                num /= i;
                i--;
            }
        }

        return toReturn;
    }

    public static boolean isPerfect(int num) {
        return sumDivisors(num) / 2 == num;
    }

    public static boolean isPrime(int num) {
        return divisors(num).size() < 3;
    }

    public static ArrayList<Integer> divisors(int num) {
        ArrayList<Integer> toReturn = new ArrayList<Integer>();
        
        int idx = 0;
        for (int i = 1; i < (int) Math.sqrt(num) + 1; i++) {
            if (num % i == 0) {
                toReturn.add(idx, i);

                if (i != num / i) {
                    toReturn.add(toReturn.size() - idx, num / i);
                }

                idx++;
            }
        }

        return toReturn;
    }

    public static int sumDivisors(int num) {
        int total = 0;
        ArrayList<Integer> nums = divisors(num);
        
        for (int i : nums) {
            total += i;
        }

        return total;
    }
}