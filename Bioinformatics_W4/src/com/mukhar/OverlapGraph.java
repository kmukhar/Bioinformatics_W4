package com.mukhar;

import java.util.ArrayList;
import java.util.TreeMap;

public class OverlapGraph {
    public ArrayList<String> constructOverlapList(ArrayList<String> kmers) {
        ArrayList<String> result = new ArrayList<>();
        TreeMap<String, String> prefixes = new TreeMap<>();
        TreeMap<String, String> suffixes = new TreeMap<>();

        for (String kmer : kmers) {
            prefixes.put(kmer.substring(0, kmer.length() - 1), kmer);
            suffixes.put(kmer, kmer.substring(1));
        }

        for (String skey : suffixes.keySet()) {
            String suffix = suffixes.get(skey);
            if (prefixes.containsKey(suffix))
                result.add(skey + " -> " + prefixes.get(suffix));
        }

        return result;
    }

    public ArrayList<String> constructOverlapList(String text, int k) {
        ArrayList<String> kmers = new ArrayList<>();
        int start = 0;
        while (start + k <= text.length()) {
            String s = text.substring(start, start + k);
            kmers.add(s);
            ++start;
        }
        return constructOverlapList(kmers);
    }
}
