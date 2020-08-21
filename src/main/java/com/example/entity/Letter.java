package com.example.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class Letter {
    static Map<String, String> phone = new HashMap<String, String>() {
        {
            put("0", "");
            put("1", "");
            put("2", "a,b,c");
            put("3", "d,e,f");
            put("4", "g,h,i");
            put("5", "j,k,l");
            put("6", "m,n,o");
            put("7", "p,q,r,s");
            put("8", "t,u,v");
            put("9", "w,x,y,z");
        }
    };


    private String number;

    private String[] letters;

    private List<String> numberList = new ArrayList<>();

    private List<String> lettersList = new ArrayList<>();

    //通过传入的数字，找到需要的字母，放到两个集合里面，后面两个集合进行拼装
    public Letter(String... numbers) {
        Pattern pattern = compile("[0-9]*");
        for (String number : numbers) {
            String letter = Letter.getPhoneMap(number);
            if (letter != null) {//当输入的数字是0到9
                numberList.add(number);
                lettersList.add(letter);
            } else if (pattern.matcher(number).matches()) {//当输入的数字是0到99
                char[] numberCharArray = number.toCharArray();
                for (char numberChar : numberCharArray) {
                    String letter1 = Letter.getPhoneMap(String.valueOf(numberChar));
                    if (letter1 != null) {
                        lettersList.add(letter1);
                    }
                }
                numberList.add(number);
            }
        }
    }

    //比较输入的字符是否在map里面存在的
    public static String getPhoneMap(String number) {
        for (String letter : phone.keySet()) {
            if (letter.equalsIgnoreCase(number)) {
                return phone.get(letter);
            }
        }
        return null;
    }

    //获取我们输入的字符的所有相关字母组合
    public String[] getAllLetters() {
        String[] allLetters = new String[1];
        for (String letters : lettersList) {
            String[] split = letters.split(",");
            allLetters = allLetterAddLetters(allLetters, split);
        }
        return allLetters;
    }

    private String[] allLetterAddLetters(String[] letters1, String[] letters2) {
        String[] allLetters = new String[letters1.length * letters2.length];
        for (int i = 0; i < letters1.length; i++) {
            for (int j = 0; j < letters2.length; j++) {
                allLetters[i + letters1.length * j] = addLetter(letters1[i], letters2[j]);
            }
        }
        return allLetters;
    }

    private String addLetter(String s1, String s2) {
        if (s1 == null || "".equalsIgnoreCase(s1)) {
            s1 = "";
        }
        if (s2 == null || "".equalsIgnoreCase(s2)) {
            s2 = "";
        }
        return s1 + s2;
    }


    public String getDigit() {
        return number;
    }

    public String[] getLetters() {
        return letters;
    }

}
