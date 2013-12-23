package com.mukhar;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import edu.princeton.cs.introcs.In;

public class EulerianCycleCreatorTest {

  private ArrayList<String> input;
  private EulerianCycleCreator ecc;
  private ArrayList<String> expected;

  @Before
  public void setUp() throws Exception
  {
    ecc = new EulerianCycleCreator();
  }

  @Test
  public void testCreateCycle01()
  {
    readTestData("src/com/mukhar/eulerian_cycle_sample.txt");
    ArrayList<String> actual = ecc.createCycle(input);
    // temp remove last node id (which should be equal to first node id
    actual.remove(actual.size() - 1);
    while (!(actual.get(0).equals(expected.get(0)) && actual.get(1).equals(
        expected.get(1))))
      actual.add(actual.remove(0));

    actual.add(actual.get(0));
    assertEquals(expected, actual);
  }

  @Test
  public void testCreateCycle02()
  {
    readTestData("src/com/mukhar/eulerian_cycle.txt");
    ArrayList<String> actual = ecc.createCycle(input);
    // temp remove last node id (which should be equal to first node id
    actual.remove(actual.size() - 1);
    while (!(actual.get(0).equals(expected.get(0)) && actual.get(1).equals(
        expected.get(1))))
      actual.add(actual.remove(0));

    actual.add(actual.get(actual.size() - 1));
    System.out.println(actual);
    System.out.println(expected);
    assertEquals(expected, actual);
  }

  @Test
  public void testCreateCycle03()
  {
    readQuizData("src/com/mukhar/dataset_57_2.txt");
    ArrayList<String> actual = ecc.createCycle(input);
    System.out.println(actual.toString().replace(", ","->"));
  }

  public void readTestData(String name)
  {
    In in = new In(name);
    in.readLine(); // ignore Input
    String s = "";
    input = new ArrayList<>();
    while (!(s = in.readLine()).equalsIgnoreCase("Output")) {
      input.add(s);
    }
    expected = new ArrayList<String>();
    String ex = in.readLine();
    String[] nodes = ex.replace(">", "").split("-");
    for (String s2 : nodes)
      expected.add(s2);
  }

  public void readQuizData(String name)
  {
    In in = new In(name);
    String s = "";
    input = new ArrayList<>();
    while ((s = in.readLine()) != null) {
      input.add(s);
    }
  }
}
