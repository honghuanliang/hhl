package com.example.test;

import com.example.entity.WordBreak;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


public class WordBreakTest {

    /**
     * Consider the following dictionary
     * { i, like, sam, sung, samsung, mobile, ice, cream, man go}
     * Input: "ilikesamsungmobile"
     * Output: i like sam sung mobile
     * i like samsung mobile
     */
    @Test
    public void test1() {
        Set<String> customSet = new HashSet<>();
        String[] temp_customSet = {"mobile", "samsung", "sam", "sung", "man", "mango", "icecream", "and", "go", "i", "like", "ice", "cream"};
        for (String temp : temp_customSet) {
            customSet.add(temp);
        }
        WordBreak.wordBreakPrintAll("ilikesamsung", customSet);
        System.out.println();

    }

}
