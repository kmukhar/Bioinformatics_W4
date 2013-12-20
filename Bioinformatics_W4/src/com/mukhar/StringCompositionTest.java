package com.mukhar;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.Out;

public class StringCompositionTest {

    private int k;

    private String text;

    private ArrayList<String> expected;

    private StringComposition sc;

    @Before
    public void setUp() throws Exception {
        expected = new ArrayList<>();
        sc = new StringComposition();
    }

    @After
    public void tearDown() throws Exception {
    }

    // @Test
    public void testDecompose01() {
        readTestData("src/com/mukhar/string_com_sample.txt");
        ArrayList<String> actual = sc.decompose(text, k);
        print(expected);
        print(actual);
        assertEquals(expected, actual);
    }

    // @Test
    public void testDecompose02() {
        readTestData("src/com/mukhar/string_com.txt");
        ArrayList<String> actual = sc.decompose(text, k);
        print(expected);
        print(actual);
        assertEquals(expected, actual);
    }

    private void print(ArrayList<String> expected) {
        StringBuilder sb = new StringBuilder();
        for (String s : expected) {
            sb.append(s).append(" ");
            if (sb.length() > 80) {
                System.out.println(sb.toString());
                sb.delete(0, sb.length());
            }
        }
        System.out.println(sb.toString());
    }

    @Test
    public void testDecompose03() {
        readQuizData("src/com/mukhar/dataset_51_3.txt");
        ArrayList<String> actual = sc.decompose(text, k);
        print(actual);
        printToFile(actual);
    }

    private void printToFile(ArrayList<String> actual) {
        Out out = new Out("src/com/mukhar/output.txt");
        for (String s : actual)
            out.println(s);
        out.close();
    }

    public void readTestData(String name) {
        In in = new In(name);
        in.readLine(); // ignore Input
        k = in.readInt();
        in.readLine();
        text = in.readLine();
        in.readLine(); // ignore Output
        int numLines = text.length() + 1 - k;
        for (int i = 0; i < numLines; i++)
            expected.add(in.readLine());
    }

    public void readQuizData(String name) {
        In in = new In(name);
        k = in.readInt();
        in.readLine();
        text = in.readLine();
    }
}
