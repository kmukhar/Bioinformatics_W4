package com.mukhar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class DeBruijnGraph {
    public ArrayList<String> createGraph(String text, int k) {
        ArrayList<String> result = new ArrayList<>();
        TreeMap<String, ArrayList<String>> map = new TreeMap<>();
        int start = 0;
        while (start + k <= text.length()) {
            String sub1 = text.substring(start, start + k - 1);
            String sub2 = text.substring(start + 1, start + k);
            ArrayList<String> temp = map.get(sub1);
            if (temp == null)
                temp = new ArrayList<>();
            temp.add(sub2);
            map.put(sub1, temp);
            ++start;
        }
        createResult(result, map);
        return result;
    }

    private void createResult(ArrayList<String> result, TreeMap<String, ArrayList<String>> map) {
        for (String key : map.keySet()) {
            ArrayList<String> next = map.get(key);
            if (next.size() > 0) {
                Collections.sort(next);
                StringBuilder sb = new StringBuilder();
                sb.append(key).append(" -> ");
                for (String s : next)
                    sb.append(s).append(",");
                sb.deleteCharAt(sb.length() - 1);
                result.add(sb.toString());
            }
        }
    }

    public ArrayList<String> createGraph(ArrayList<String> kmers) {
        ArrayList<String> result = new ArrayList<>();

        OverlapGraph og = new OverlapGraph();
        ArrayList<String> aList = og.constructOverlapList(kmers);
        TreeMap<String, ArrayList<String>> map = new TreeMap<>();
        for (String s : aList) {
            String[] sub = s.split(" ");
            ArrayList<String> temp = map.get(sub[0]);
            if (temp == null)
                temp = new ArrayList<>();
            temp.add(sub[1]);
            map.put(sub[0], temp);
        }
        createResult(result, map);
        return result;
    }
}
