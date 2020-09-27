package com.company.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListReader {

    private static final int vectorSize = 4;

    // Считывает отрезки из файла и возвращает список отрезков
    public MyList readFromFile(String filePath) throws Exception {
        try (var reader = new BufferedReader(new FileReader(filePath))) {
            var list = new MyList();

            String str;
            while ((str = reader.readLine()) != null) {
                var numbers = Stream.of(str.split(" "))
                        .limit(ListReader.vectorSize)
                        .map(x -> Double.parseDouble(x))
                        .collect(Collectors.toCollection(ArrayList::new));

                if (numbers.size() != ListReader.vectorSize) throw new Exception("Недостаточно точек в строке");
                list.add(new MyVector(numbers.get(0), numbers.get(1), numbers.get(2), numbers.get(3)));
            }

            return list;
        }
    }
}
