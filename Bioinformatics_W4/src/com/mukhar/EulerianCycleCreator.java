package com.mukhar;

import java.util.*;

public class EulerianCycleCreator {
  public ArrayList<String> createCycle(ArrayList<String> input)
  {
    Hashtable<Node, ArrayList<Edge>> edges = new Hashtable<>();
    Hashtable<Node, Node> nodes = new Hashtable<>();
    Node curNode = null;

    // convert input strings to edges and nodes
    for (String s : input) {
      String[] node = s.replace(">", "").split("-");
      Node start = new Node(node[0]);
      if (curNode == null)
        curNode = start;
      nodes.put(start, start);
      String[] destNodes = node[1].split(",");
      for (String s2 : destNodes) {
        Node end = new Node(s2);
        Edge edge = new Edge(start, end);
        ArrayList<Edge> temp = edges.get(start);
        if (temp == null)
          temp = new ArrayList<>();
        temp.add(edge);
        edges.put(start, temp);
      }
    }

    // start at a node with 2+ outgoing edges
    for (Node n : nodes.values())
      if (edges.get(n).size() > 1) {
        curNode = n;
        break;
      }

    ArrayList<String> result = new ArrayList<>();
    result.add(String.valueOf(curNode.getId()));

    while (edges.size() > 0) {
      ArrayList<Edge> nextEdge = edges.remove(curNode);
      if (nextEdge != null) {
        Node next = nextEdge.remove(0).end;
        result.add(String.valueOf(next.getId()));
        System.out.println("Edges remaining: " + edges.size());
        if (nextEdge.size() > 0) {
          edges.put(curNode, nextEdge);
        }
        curNode = next;
      } else {
        // there must still be edges, so get an edge that connects the cycle
        result.remove(0);
        ArrayList<Edge> curEdge = null;
        while (curEdge == null) {
          String strNode = result.get(0);
          curNode = new Node(strNode);
          curEdge = edges.get(curNode);
          if (curEdge != null) {
            result.add(strNode);
          } else {
            result.add(result.remove(0));
          }
        }
      }
    }

    return result;
  }

}
