package com.traveller.travellerApp;

import java.util.ArrayList;
import java.util.HashMap;

public class Test {
    public static int target(ArrayList<Integer> list) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int c;
        for (int i = 0; i < list.size(); i++) {
            if (map.containsKey(list.get(i))) {
                c = map.get(list.get(i)) + 1;
                map.put(list.get(i), c);
            } else {
                map.put(list.get(i), 1);
            }
        }
        for (Integer i : map.keySet()) {
            if (map.get(i) >= list.size() / 2) {
                return i;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(7);
        list.add(2);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(32);
        list.add(32);
        list.add(32);
        list.add(32);
        list.add(32);

        System.out.println(target(list));
        // HashMap<Integer, Integer> map = new HashMap<>();
        // int c;
        // for (int i = 0; i < list.size(); i++) {
        // if (map.containsKey(list.get(i))) {
        // c = map.get(list.get(i)) + 1;
        // map.put(list.get(i), c);
        // } else {
        // map.put(list.get(i), 1);
        // }
        // }
        // for (Integer i : map.keySet()) {
        // if (map.get(i) >= list.size() / 2) {
        // System.out.println(i);

        // }

        // }
    }
}
