package com.company.classes;

// Класс списка. Реализует односвязный список.
public class MyList {

    // Элемент списка
    // Содержит в себе вектор и указатель на следующий элемент
    private class MyListItem {

        private final MyVector data;
        private MyListItem next;

        public MyListItem(MyVector item) {
            data = item;
            next = null;
        }

        public MyListItem getNext() {
            return next;
        }

        public void setNext(MyListItem next) {
            this.next = next;
        }

        public MyVector getData() {
            return data;
        }
    }

    private MyListItem head; // Заголовочный элемент
    private MyListItem last; // Последний элемент

    // Вставка элемента в список
    public boolean add(MyVector item) {
        // Если список пуст, то просто меняем связи
        if (head == null) {
            head = new MyListItem(item);
            last = head;
        } else {
            if (!isItemContains(item)) {
                var cur = new MyListItem(item);
                last.setNext(cur);
                last = cur;
            } else {
                return false;
            }
        }
        return true;
    }

    // Возвращает суммарную длину всех отрезков
    public double getSumLength() {
        var result = 0.0;
        if (head != null) {
            var cur = head;
            do {
                result += cur.getData().getLength();
                cur = cur.getNext();
            } while (cur != null);
        }
        return result;
    }

    @Override
    public String toString() {
        if (head == null) {
            return null;
        } else {
            var builder = new StringBuilder();
            var cur = head;
            do {
                builder.append(cur.getData().toString());
                cur = cur.getNext();
                if (cur != null) builder.append(" -> ");
            } while (cur != null);
            return builder.toString();
        }
    }

    private boolean isItemContains(MyVector item) {
        var cur = head;
        // Тут проходим по всему списку
        do {
            // Если нашли такой же, дальше смотреть смысла нет
            if (cur.getData().equals(item)) return true;
            cur = cur.getNext();
        } while (cur != null);
        return false;
    }
}
