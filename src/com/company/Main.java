package com.company;

import com.company.classes.ListReader;

public class Main {

    public static void main(String[] args) {

        var listReader = new ListReader();
        try {
            var list = listReader.readFromFile("input.txt");
            System.out.println(list);

            var sum = list.getSumLength();
            System.out.println(sum);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
