package com.test;

import java.util.Scanner;

public class Main {
    public static int a = 0;
    public static int b = 0;
    public static int rimA = 0;
    public static int rimB = 0;
    public static char ch = ' ';
    public static int res = 0;
    public static Scanner scanner = new Scanner(System.in);
    public static String temp = "";


    public static void main(String[] args) {
        while (true) {
            temp = scanner.nextLine();
            temp = temp.replace(" ", "");
            if (temp.contains("1") || temp.contains("2") || temp.contains("3")
                    || temp.contains("4") || temp.contains("5") || temp.contains("6")
                    || temp.contains("7") || temp.contains("0") || temp.contains("9")
                    || temp.contains("8")) naturalNumbers();
            else RunConvert();
        }
    }

    private static void naturalNumbers() {
        if (temp.indexOf('+') == 2) {
            a = Integer.parseInt(temp.substring(0, 2));
            b = Integer.parseInt(temp.substring(3, temp.length()));
            ch = '+';
        } else if (temp.indexOf('-') == 2) {
            a = Integer.parseInt(temp.substring(0, 2));
            b = Integer.parseInt(temp.substring(3, temp.length()));
            ch = '-';
        } else if (temp.indexOf('*') == 2) {
            a = Integer.parseInt(temp.substring(0, 2));
            b = Integer.parseInt(temp.substring(3, temp.length()));
            ch = '*';
        } else if (temp.indexOf('/') == 2) {
            a = Integer.parseInt(temp.substring(0, 2));
            b = Integer.parseInt(temp.substring(3, temp.length()));
            ch = '/';
        }


        if (temp.indexOf('+') == 1) {
            a = Integer.parseInt(temp.substring(0, 1));
            b = Integer.parseInt(temp.substring(2, temp.length()));
            ch = '+';
        } else if (temp.indexOf('-') == 1) {
            a = Integer.parseInt(temp.substring(0, 1));
            b = Integer.parseInt(temp.substring(2, temp.length()));
            ch = '-';
        } else if (temp.indexOf('/') == 1) {
            a = Integer.parseInt(temp.substring(0, 1));
            b = Integer.parseInt(temp.substring(2, temp.length()));
            ch = '/';
        } else if (temp.indexOf('*') == 1) {
            a = Integer.parseInt(temp.substring(0, 1));
            b = Integer.parseInt(temp.substring(2, temp.length()));
            ch = '*';
        }

        if (a <= 10 && b <= 10) {
            if (ch == '+')
                System.out.println(a + b);
            else if (ch == '-')
                System.out.println(a - b);
            else if (ch == '*')
                System.out.println(a * b);
            else System.out.println(a / b);
        } else throw new ArithmeticException();
    }


    private static void proverkaRimA() {
        if (!isBig10(temp)) {
            if (temp.substring(0, 3).contains("VIII")) rimA = 8;
            else if (temp.substring(0, 3).contains("VII")) rimA = 7;
            else if (temp.substring(0, 2).contains("IV")) rimA = 4;
            else if (temp.substring(0, 2).contains("IX")) rimA = 9;
            else if (temp.substring(0, 2).contains("VI")) rimA = 6;
            else if (temp.substring(0, 3).contains("III")) rimA = 3;
            else if (temp.substring(0, 2).contains("II")) rimA = 2;
            else if (temp.substring(0, 1).contains("I")) rimA = 1;
            else if (temp.substring(0, 1).contains("V")) rimA = 5;
            else if (temp.substring(0, 1).contains("X")) rimA = 10;
        } else throw new ArithmeticException();

        if (temp.contains("+")) ch = '+';
        else if (temp.contains("-")) ch = '-';
        else if (temp.contains("/")) ch = '/';
        else ch = '*';

    }

    private static void proverkaRimB() {
        if (!isBig10(temp)) {
            if (temp.substring(temp.length() - 3).contains("VIII")) rimB = 8;
            else if (temp.substring(temp.length() - 3).contains("VII")) rimB = 7;
            else if (temp.substring(temp.length() - 2).contains("IV")) rimB = 4;
            else if (temp.substring(temp.length() - 2).contains("IX")) rimB = 9;
            else if (temp.substring(temp.length() - 2).contains("VI")) rimB = 6;
            else if (temp.substring(temp.length() - 3).contains("III")) rimB = 3;
            else if (temp.substring(temp.length() - 2).contains("II")) rimB = 2;
            else if (temp.substring(temp.length() - 1).contains("I")) rimB = 1;
            else if (temp.substring(temp.length() - 1).contains("V")) rimB = 5;
            else if (temp.substring(temp.length() - 1).contains("X")) rimB = 10;
        } else throw new ArithmeticException();
    }

    private static void resultRim() {
        if (rimA <= 10 && rimB <= 10) {
            if (ch == '+')
                res = rimA + rimB;
            else if (ch == '-')
                res = rimA - rimB;
            else if (ch == '*')
                res = rimA * rimB;
            else res = rimA / rimB;
        } else throw new ArithmeticException();
    }

    public static void printRes() {
        String convertResToRim = String.valueOf(res);
        convertResToRim = convertResToRim.replace("99", "XCIX")
                .replace("100", "C").replace("90", "XC")
                .replace("80", "LXXX").replace("70", "LXX")
                .replace("72", "LXXII").replace("81", "LXXXI")
                .replace("60", "LX").replace("50", "L")
                .replace("63", "LXIII").replace("64", "LXIV")
                .replace("54", "LIV").replace("56", "LVI")
                .replace("40", "XL").replace("30", "XXX")
                .replace("42", "XLII").replace("45", "XLV")
                .replace("48", "XLVIII").replace("49", "XLIX")
                .replace("32", "XXXII").replace("35", "XXXV")
                .replace("20", "XX").replace("12", "XII")
                .replace("21", "XXI").replace("24", "XXIV")
                .replace("25", "XXV").replace("27", "XXVII")
                .replace("28", "XXVIII").replace("36", "XXXVI")
                .replace("11", "XI").replace("13", "XIII")
                .replace("14", "XIV").replace("15", "XV")
                .replace("16", "XVI").replace("17", "XVII")
                .replace("18", "XVIII").replace("19", "XIX")
                .replace("10", "X").replace('1', 'I').
                        replace("2", "II").replace("3", "III")
                .replace("4", "IV").replace('5', 'V')
                .replace("6", "VI").replace("7", "VII")
                .replace("8", "VIII").replace("9", "IX");

        System.out.println(convertResToRim);

    }

    public static boolean isBig10(String temp) {
        return temp.contains("XCIX")
                || temp.contains("C") || temp.contains("XC")
                || temp.contains("LXXX") || temp.contains("LXX")
                || temp.contains("LXXII") || temp.contains("LXXXI")
                || temp.contains("LX") || temp.contains("L")
                || temp.contains("LXIII") || temp.contains("LXIV")
                || temp.contains("LIV") || temp.contains("LVI")
                || temp.contains("XL") || temp.contains("XXX")
                || temp.contains("XLII") || temp.contains("XLV")
                || temp.contains("XLVIII") || temp.contains("XLIX")
                || temp.contains("XXXII") || temp.contains("XXXV")
                || temp.contains("XX") || temp.contains("XII")
                || temp.contains("XXI") || temp.contains("XXIV")
                || temp.contains("XXV") || temp.contains("XXVII")
                || temp.contains("XXVIII") || temp.contains("XXXVI")
                || temp.contains("XI") || temp.contains("XIII")
                || temp.contains("XIV") || temp.contains("XV")
                || temp.contains("XVI") || temp.contains("XVII")
                || temp.contains("XVIII") || temp.contains("XIX");
    }

    public static void RunConvert() {
        proverkaRimA();
        proverkaRimB();
        resultRim();
        printRes();
    }
}