package com.example.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
    private static Set<String> dictionary = new HashSet<>();

    // 如果可以将单词分割为以下部分，则返回true
    public static boolean wordBreak(String word, Set<String> dictionary) {
        int size = word.length();
        if (size == 0)
            return true;
        //检查所有单词
        for (int i = 1; i <= size; i++) {
            if (dictionary.contains(word.substring(0, i)) &&
                    wordBreak(word.substring(i, size), dictionary))
                return true;
        }
        // 查不到的返回false
        return false;
    }

    public static void wordBreakPrintAll(String s, Set<String> custmerSet) {
        if (custmerSet != null) {
            dictionary = custmerSet;
        }
        ArrayList<String> al = new ArrayList<String>();
        wordBreakRec2(s, al);

    }

    public static void wordBreakRec2(String s, ArrayList<String> al) {
        int len = s.length();
        if (len == 0) {
            System.out.println(al);
            return;
        }
        for (int i = 1; i <= len; i++) {
            String substr = s.substring(0, i);
            if (dictionaryContains(substr)) {
                al.add(substr);
                wordBreakRec2(s.substring(i), al);
                al.remove(al.size() - 1);
            }
        }
    }

    private static boolean dictionaryContains(String word) {
        for (String dic : dictionary) {
            if (dic.equals(word)) {
                return true;
            }
        }
        return false;
    }


}
