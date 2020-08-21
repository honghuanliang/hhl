package com.example.test;

import com.example.entity.Letter;
import org.junit.Test;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class)
public class LetterCombinationTests {

    /**
     * Write a program to convert the digits from 0 to 9 into letters
     */
    @Test
    public void test1() {
        Letter letter = new Letter("2", "9");
        String[] letters = letter.getAllLetters();
        for (String str : letters) {
            System.out.print(str + " ");
        }
        System.out.println();
    }

    /**
     * The program need to support converting the digits from 0 to 99 into letters
     */
    @Test
    public void test2() {
        Letter letter = new Letter("2", "99");
        String[] letters = letter.getAllLetters();
        for (String str : letters) {
            System.out.print(str + " ");
        }
        System.out.println();
    }
}
