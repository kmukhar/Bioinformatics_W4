package com.mukhar;

import java.util.ArrayList;
import java.util.TreeMap;

public class StringComposition {
    public ArrayList<String> decompose(String text, int k) {
        ArrayList<String> result = new ArrayList<>();
        TreeMap<String,String> tm = new TreeMap<>();
        int start = 0;
        while (start + k <= text.length()) {
            String s = text.substring(start, start + k);
            tm.put(s, s);
            ++start;
        }
        result.addAll(tm.keySet());
        return result;
    }
}
