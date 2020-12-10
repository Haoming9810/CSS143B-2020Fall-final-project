package edu.uwb.css143b2020fall.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IndexerImpl implements Indexer {
    public Map<String, List<List<Integer>>> index(List<String> docs) {
        Map<String, List<List<Integer>>> indexes = new HashMap<>();
        LinkedList words = new LinkedList();
        for (int i = 0; i < docs.size(); i++) {
            String[] word = docs.get(i).split("\\s+");
            for (int j = 0; j < docs.size(); j++) {
                if (!words.contains(word[j])) {
                    words.add(word[j]);
                }
            }

            for (int k = 0; k < words.size(); k++) {

                if (!words.contains(word[k])) {
                    List<List<Integer>> FirstList = new ArrayList<>();
                    indexes.put(word[k], FirstList);
                    for(int p = 0; p< words.size(); p++){
                        List<Integer> SecondList = new ArrayList<>();
                        FirstList.add(SecondList);
                    }
                }
                indexes.get(word[k]).get(i).add(k);
            }

        }
        return indexes;
    }
}