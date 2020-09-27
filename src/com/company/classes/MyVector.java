package com.company.classes;

import java.util.Objects;

// Класс отрезка
public class MyVector {
    private final MyPoint pointA;
    private final MyPoint pointB;

    private double length = -1;

    public MyVector(MyPoint pointA, MyPoint pointB) {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public MyVector(double x1, double y1, double x2, double y2) {
        this(new MyPoint(x1, y1), new MyPoint(x2, y2));
    }

    // Ленивое вычисление длины отрезка
    // Считает только при первом обращении
    public double getLength() {
        if (this.length == -1) {
            this.length = Math.sqrt(Math.pow(pointB.getY() - pointA.getY(), 2) + Math.pow(pointB.getX() - pointA.getX(), 2));
        }
        return this.length;
    }

    @Override
    // Отрезки считаются одинаковыми, если их точки одинаковые
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var myVector = (MyVector) o;

        // Сортируем точки
        var firstVector = new SortedPoints(this);
        var secondVector = new SortedPoints(myVector);

        return firstVector.equals(secondVector);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointA, pointB, length);
    }

    @Override
    public String toString() {
        return "[" + this.pointA.toString() + "; " + this.pointB.toString() + "]";
    }

    private class SortedPoints {
        public final MyPoint minPoint;
        public final MyPoint maxPoint;

        public SortedPoints(MyVector vector) {
            if (vector.pointA.compareTo(vector.pointB) <= 0) {
                minPoint = vector.pointA;
                maxPoint = vector.pointB;
            } else {
                minPoint = vector.pointB;
                maxPoint = vector.pointA;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            var that = (SortedPoints) o;
            return this.minPoint.equals(that.minPoint) && this.maxPoint.equals(that.maxPoint);
        }

        @Override
        public int hashCode() {
            return Objects.hash(minPoint, maxPoint);
        }
    }
}
