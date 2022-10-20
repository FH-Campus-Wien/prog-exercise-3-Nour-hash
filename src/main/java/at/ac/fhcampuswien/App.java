package at.ac.fhcampuswien;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {

    // Implement all methods as public static

    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results
        // etc.

        int[] array1 = new int[]{1, 2, 3, 4, 5};
        int[] array2 = new int[]{100, 99, 60, 44,2};

        int[] array3 = new int[]{0, 0, 4, 4, 4, 8, 2, 9, 3};
        oneMonthCalendar(28,2);
       // guessingGame(randomNumberBetweenOneAndHundred());
        swapArrays(array1,array2);
        lcg(12345);
        camelCase("AnY noise annoYs an oYster but a noisY noise annoYs an oYster more");
        checkDigit(array3);
    }


    public static void oneMonthCalendar(int tage, int ersterTag)
    {/*
        int k =(7-ersterTag)+1;
        int l =0;
        if(ersterTag>1) {
            for (int i = 1; i <= ersterTag;i++) {

                System.out.print(" ");
            }
        }
        for (int i = 1; i <= (7-ersterTag)+1 ; i++) {
            l++;
            System.out.print(l+"  ");
        }
        System.out.println();


        for (int i = 0; i < tage/7; i++) {
            for (int j = 0; j < 7; j++) {
                k++;
                if (k <= 9) {
                    System.out.print(k+"  ");
                } else if (k>9) {
                    System.out.print(k+" ");
                }

                if (k == tage) {
                    break;
                }

            }
            System.out.println();
        }

  */  }

    public static long[] lcg(long seed){

        long[] X = new long[10];
        long c= 12345;
        long m= (long) Math.pow(2,31);
        long a= 1103515245;

        X[0]= ((a*seed)+c)%m;

        for (int i = 1; i < X.length; i++) {

                X[i]=((a*X[i-1])+c)%m;

        }

        return X;

    }


    public static void guessingGame(int numberToGuess){

        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 10; i++) {

            System.out.print("Guess number "+i+": ");
            int input = sc.nextInt();

            if (numberToGuess == input) {
                System.out.println("You won wisenheimer!");
                break;
            } else if (numberToGuess < input&&i<=9) {
                System.out.println("The number AI picked is lower than your guess.");
            } else if (numberToGuess > input&&i<=9){
                System.out.println("The number AI picked is higher than your guess.");
            }
            if (i == 10&&numberToGuess != input) {
                System.out.println("You lost! Have you ever heard of divide & conquer?");
            }


        }

    }

    public static int randomNumberBetweenOneAndHundred(){

                int min = 0;
                int max = 100;
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }

    public static boolean  swapArrays(int[] firstArray,int[] secondArray)
    {
        int[] array = new int[firstArray.length];

        if (firstArray.length != secondArray.length) {
            return false;
        }
        else{
            for (int i = 0; i < firstArray.length; i++) {
                array[i]=firstArray[i];
                firstArray[i]=secondArray[i];
                secondArray[i]=array[i];
            }

            return true;
        }

    }

    public static String camelCase(String parameterS){

            char[] chars = parameterS.toCharArray();
            if (chars[0] >= 97 && chars[0] <= 122)
                chars[0] -= 32;

            for (int i = 0; i < chars.length; i++) {
                if (i >= 1 && chars[i-1] == ' ' && chars[i] >= 97 && chars[i] <= 122){
                    chars[i] -= 32;
                }
                if (i >= 1 && chars[i-1] != ' ' && chars[i] >= 65 && chars[i] <= 90){
                    chars[i] += 32;
                }
            }

            for (int i = 0; i < chars.length; i++) {
                if ((chars[i] > 0 && chars[i] <= 64) || (chars[i] >= 91 && chars[i] <= 96) || (chars[i] >= 123 && chars[i] <= 127)){
                    chars[i] = 32;
                }
            }
        StringBuffer stringBuffer = new StringBuffer();
        for (char aChar : chars) {
            if ((aChar != ' ') && (aChar != '\t')) {
                stringBuffer.append(aChar);
            }
        }

        String noSpaceStr2 = stringBuffer.toString();

        System.out.println(noSpaceStr2);

        return noSpaceStr2;
    }

    public static int checkDigit(int[] digits){

        int gewichtung = 0;
        int produkt = 0;
        int sum= 0;
        int rest = 0;
        int pruefziffer = 0;

        for (int i = 0; i < digits.length ; i++) {
            gewichtung= i+2;
            produkt= digits[i]*gewichtung;
            sum += produkt;
            rest = sum%11;
            pruefziffer= 11-rest;
        }

        if (pruefziffer == 11) {
            pruefziffer=5;
        } else if (pruefziffer==10) {
            pruefziffer=0;

        }
System.out.println(pruefziffer);
        return pruefziffer;
    }

}