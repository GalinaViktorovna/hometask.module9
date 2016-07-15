package com.hometask.module9.cesarcode;

import java.util.ArrayList;
import java.util.List;

public class EnglishCesar {

    private final static List<Character> alphabet = new ArrayList<>();
    private final static int n = 26;
    private int key;
    static {
        for (char c = 'A'; c <= 'Z'; c++) {
            alphabet.add(c);
        }
    }

    public String getAfterEncrypt() {
        return afterEncrypt;
    }

    public String getAfterDecrypt() {
        return afterDecrypt;
    }

    private String afterEncrypt;
    private String afterDecrypt;

    public int getKey() {
        return key;
    }


    @Override
    public String toString() {
        return "EnglishCesar{" +
                "alphabet=" + alphabet +
                '}';
    }

    public static int findInEnglish(char c) {
        int rez = -1;

        for (int i = 0; i < alphabet.size(); ++i) {
            if (Character.toUpperCase(c) == alphabet.get(i))
                rez = i;
        }
        return rez;
    }

    public static boolean isEnglish(char c) {
        int i = (int) c;
        if (((i >= 65 && i <= 90) || (i >= 96 && i <= 122))) return true;
        else {
            return false;
        }
    }

    public void toEncrypt(String text, int key) {
        StringBuilder output = new StringBuilder();
        this.key = key;
        for (int i = 0; i < text.length(); ++i) {
            char c = text.charAt(i);
            int y = (findInEnglish(c) + key) % n;

            if (Character.isUpperCase(c)) {
                output.append(alphabet.get(y));

            } else if ((!isEnglish(c))) {
                output.append(c);
            } else {
                output.append(Character.toLowerCase(alphabet.get(y)));
            }
        }
        afterEncrypt = output.toString();
    }

    public void toDecrypt() {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < afterEncrypt.length(); ++i) {
            char c = afterEncrypt.charAt(i);

            int x = ((findInEnglish(c) - key + n) % n);
            if (Character.isUpperCase(c)) {
                output.append(alphabet.get(x));
            } else if (!isEnglish(c)) {
                output.append(c);
            } else {
                output.append(Character.toLowerCase(alphabet.get(x)));
            }
        }

        afterDecrypt = output.toString();
    }
}
