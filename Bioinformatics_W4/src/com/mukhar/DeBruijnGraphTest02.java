package com.mukhar;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.Out;

public class DeBruijnGraphTest02 {

  private ArrayList<String> kmers;
  private ArrayList<String> expected;
  private DeBruijnGraph dbg;

  @Before
  public void setUp() throws Exception
  {
    dbg = new DeBruijnGraph();
  }

  @After
  public void tearDown() throws Exception
  {
  }

  @Test
  public void testCreateGraph01()
  {
    readTestData("src/com/mukhar/debruijn_graph_kmers_sample.txt");
    ArrayList<String> actual = dbg.createDeBruijnGraph(kmers);
    assertEquals(expected, actual);
    // for (String s : actual)
    // System.out.println(s);
  }

  @Test
  public void testCreateGraph02()
  {
    readTestData("src/com/mukhar/debruijn_graph_kmers.txt");
    ArrayList<String> actual = dbg.createDeBruijnGraph(kmers);
    assertEquals(expected, actual);
    // for (String s : actual)
    // System.out.println(s);
  }

  @Test
  public void testCreateGraph03()
  {
    readQuizData("src/com/mukhar/dataset_54_7.txt");
    ArrayList<String> actual = dbg.createDeBruijnGraph(kmers);
    printToFile(actual);
  }

  public void readTestData(String name)
  {
    In in = new In(name);
    in.readLine(); // ignore Input
    kmers = new ArrayList<>();
    String s = "";
    while (!(s = in.readLine()).equalsIgnoreCase("Output:")) {
      kmers.add(s);
    }
    expected = new ArrayList<>();
    while ((s = in.readLine()) != null) {
      expected.add(s);
    }
  }

  public void readQuizData(String name)
  {
    In in = new In(name);
    kmers = new ArrayList<>();
    String s = "";
    while ((s = in.readLine()) != null) {
      kmers.add(s);
    }
  }

  private void printToFile(ArrayList<String> actual)
  {
    Out out = new Out("src/com/mukhar/output.txt");
    for (String s : actual)
      out.println(s);
    out.close();
  }
}
