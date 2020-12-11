package edu.uwb.css143b2020fall.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.ArrayList;

@Service
public class SearcherImpl implements Searcher {
    public List<Integer> search(String keyPhrase, Map<String, List<List<Integer>>> index) {
        List<Integer> result = new ArrayList<>();
        Map<String, List<List<Integer>>> WordIdx = new HashMap<>();
        keyPhrase = keyPhrase.trim();
        String[] word = keyPhrase.split("\\s+");

        List<List<Integer>> listOne = new ArrayList<>();
        for (int i = 0; i < word.length; i++) {
            if (!index.containsKey(word[i])) {
                return result;
            }
            List<Integer> listTwo = new ArrayList<>();
            for (int j = 0; j < index.get(word[i]).size(); j++) {
                if (!index.get(word[i]).get(j).isEmpty()) {
                    listTwo.add(j);
                }
            }
            //get common element
            List<Integer>
            listCommon = new ArrayList<Integer>(listTwo);
            listCommon.retainAll(listOne);


        }
        return result;
    }
}