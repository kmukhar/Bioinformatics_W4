package com.mukhar;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.Out;

public class DeBruijnGraphTest {

    private int k;

    private String text;

    private ArrayList<String> expected;

    private DeBruijnGraph dbg;

    @Before
    public void setUp() throws Exception {
        dbg = new DeBruijnGraph();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCreateGraph01() {
        readTestData("src/com/mukhar/debruijn_graph_string_sample.txt");
        ArrayList<String> actual = dbg.createGraph(text, k);
//        System.out.println(actual);
//        System.out.println(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void testCreateGraph02() {
        readTestData("src/com/mukhar/debruijn_graph_string.txt");
        ArrayList<String> actual = dbg.createGraph(text, k);
//        System.out.println(actual);
//        System.out.println(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void testCreateGraph03() {
        readQuizData("src/com/mukhar/dataset_53_6.txt");
        ArrayList<String> actual = dbg.createGraph(text, k);
//        System.out.println(actual.toString().replace(",", System.getProperty("line.separator")));
        printToFile(actual);
    }

    public void readTestData(String name) {
        In in = new In(name);
        in.readLine(); // ignore Input
        k = in.readInt();
        in.readLine();
        text = in.readLine();
        in.readLine();
        expected = new ArrayList<>();
        String s = "";
        while ((s = in.readLine()) != null) {
            expected.add(s);
        }
    }

    public void readQuizData(String name) {
        In in = new In(name);
        k = in.readInt();
        in.readLine();
        text = in.readLine();
    }

    private void printToFile(ArrayList<String> actual) {
        Out out = new Out("src/com/mukhar/output.txt");
        for (String s : actual)
            out.println(s);
        out.close();
    }

}
