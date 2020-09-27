package com.company.classes;

import java.util.Comparator;
import java.util.Objects;

// Класс точки
public class MyPoint implements Comparator<MyPoint>, Comparable<MyPoint> {
    private final double x;
    private final double y;

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    // Считаем точки одинаковыми, если их координаты совпадают
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var myPoint = (MyPoint) o;
        return Utils.isDoubleEquals(this.getX(), myPoint.getX()) && Utils.isDoubleEquals(this.getY(), myPoint.getY());
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public int compare(MyPoint o1, MyPoint o2) {
        if (o1.equals(o2)) {
            return 0;
        } else {
            // Считаем расстояние от начала координат
            var pointLength1 = Math.sqrt(Math.pow(o1.getX(), 2) + Math.pow(o1.getY(), 2));
            var pointLength2 = Math.sqrt(Math.pow(o2.getX(), 2) + Math.pow(o2.getY(), 2));

            if (pointLength1 > pointLength2) return 1;
            else return -1;
        }
    }

    @Override
    public int compareTo(MyPoint o) {
        return this.compare(this, o);
    }

    @Override
    public String toString() {
        return "(" + this.getX() + "; " + this.getY() + ")";
    }
}
