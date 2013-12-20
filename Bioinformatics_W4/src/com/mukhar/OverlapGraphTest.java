package com.mukhar;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.Out;

public class OverlapGraphTest {

    private ArrayList<String> input;

    private ArrayList<String> expected;

    private OverlapGraph og;

    @Before
    public void setUp() throws Exception {
        input = new ArrayList<>();
        expected = new ArrayList<>();
        og = new OverlapGraph();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testConstructOverlapList01() {
        readTestData("src/com/mukhar/overlap_graph_sample.txt");
        ArrayList<String> actual = og.constructOverlapList(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testConstructOverlapList02() {
        readTestData("src/com/mukhar/overlap_graph_1.txt");
        ArrayList<String> actual = og.constructOverlapList(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testConstructOverlapList03() {
        readQuizData("src/com/mukhar/dataset_52_7.txt");
        ArrayList<String> actual = og.constructOverlapList(input);
        printToFile(actual);
    }

    public void readTestData(String name) {
        In in = new In(name);
        in.readLine(); // ignore Input
        String s = "";
        while (!(s = in.readLine()).equalsIgnoreCase("Output:")) {
            input.add(s);
        }
        while ((s = in.readLine()) != null) {
            expected.add(s);
        }
    }

    public void readQuizData(String name) {
        In in = new In(name);
        String s = "";
        while ((s = in.readLine()) != null) {
            input.add(s);
        }
    }
    private void printToFile(ArrayList<String> actual) {
        Out out = new Out("src/com/mukhar/output.txt");
        for (String s : actual)
            out.println(s);
        out.close();
    }
}
