package com.company.classes;

public class Utils {

    // Точность сравнения чисел с плавающей запятой
    public static final double eps = Math.pow(10, -6);

    // Просто через == сравнивать числа некорректно из-за формата чисел с плавающей запятой
    // Считаем разницу чисел с определённой точностью
    public static boolean isDoubleEquals(double a, double b) {
        return Math.abs(a - b) < Utils.eps;
    }
}
