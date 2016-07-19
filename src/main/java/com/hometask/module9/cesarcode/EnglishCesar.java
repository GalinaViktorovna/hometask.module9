package com.hometask.module9.cesarcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnglishCesar {

    private final static List<Character> ALPHABET = new ArrayList<>();
    private final static int ALPHABET_SIZE = 26;
    private final static int[] CONTROL_TYPE = {0, 1};
    private final int key;
    private String text;

    public EnglishCesar(String text, int key) {
        this.text = text;
        this.key = key;
    }

    static {
        for (char c = 'A'; c <= 'Z'; c++) {
            ALPHABET.add(c);
            Collections.unmodifiableList(ALPHABET);
        }
    }

    @Override
    public String toString() {
        return "EnglishCesar{" +
                "ALPHABET=" + ALPHABET +
                '}';
    }

    void toCrypt(int type) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < text.length(); ++i) {
            char c = text.charAt(i);
            int index = ALPHABET.indexOf(Character.toUpperCase(c));
            int newIndex = (index + key) % ALPHABET_SIZE;
            switch (type) {
                case 0:
                    newIndex = (index + key) % ALPHABET_SIZE;
                    break;
                case 1:
                    newIndex = ((index - key + ALPHABET_SIZE) % ALPHABET_SIZE);
            }

            if (Character.isUpperCase(c)) {
                output.append(ALPHABET.get(newIndex));
            } else if ((!Character.isAlphabetic(c))) {
                output.append(c);
            } else {
                output.append(Character.toLowerCase(ALPHABET.get(newIndex)));
            }
        }
        System.out.println(text = output.toString());
    }

    public void toEncrypt() {
        toCrypt(CONTROL_TYPE[0]);
    }

    public void toDecrypt() {
        toCrypt(CONTROL_TYPE[1]);
    }
}

