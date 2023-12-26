package com.traveller.travellerApp;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class ReversePositiveIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // ArrayList<Integer> positiveIntegers = new ArrayList<>();

        // int num;
        // while ((num = scanner.nextInt()) >= 0) {
        // positiveIntegers.add(num);
        // }

        // for (int i = positiveIntegers.size() - 1; i >= 0; i--) {
        // System.out.print(positiveIntegers.get(i) + " ");
        // }
        String s = scanner.nextLine();
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stk.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (stk.isEmpty() || stk.peek() != '(') {
                    return;
                }
                stk.pop();
            }
        }
        if (stk.isEmpty()) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}
