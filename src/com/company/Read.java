package com.company;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.NumberFormat;

public class Read {
    static InputStreamReader r;
    static BufferedReader br;

    static {
        r = new InputStreamReader(System.in);
        br = new BufferedReader(r);
    }

    public Read() {
    }

    public static String getString() {
        try {
            return br.readLine();
        } catch (Exception var0) {
            return "";
        }
    }

    public static Number getNumber() {
        String numberString = getString();

        try {
            numberString = numberString.trim().toUpperCase();
            return NumberFormat.getInstance().parse(numberString);
        } catch (Exception var1) {
            return new Integer(0);
        }
    }

    public static int getInt() {
        return getNumber().intValue();
    }

    public static long getLong() {
        return getNumber().longValue();
    }

    public static float getFloat() {
        return getNumber().floatValue();
    }

    public static double getDouble() {
        return getNumber().doubleValue();
    }

    public static char getChar() {
        String s = getString();
        return s.length() >= 1?s.charAt(0):'\n';
    }
}
