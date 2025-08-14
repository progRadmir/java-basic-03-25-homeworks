package ru.otus.java.basic.homeworks.homework18.Tree;

import java.util.Collections;
import java.util.List;

public class TreeSearch<T extends Comparable<T>> implements SearchTree<T> {
    private final List<T> list;
    private Tree tree;

    public TreeSearch(List<T> list) {
        this.list = list;
        getSortedList();
        tree = new Tree(list, 0, list.size() - 1);
    }

    public List<T> getSortedList() {
        Collections.sort(list);
        return list;
    }

    public T find (T a) {
        return tree.find(a);
    }


    private class Tree {
        private Tree left;
        private Tree right;
        private T value;

        private Tree(List<T> list, int start, int end) {
            int pivot = (start + end) / 2;
            value = list.get(pivot);
            if (pivot - 1 >= start) {
                left = new Tree(list, start, pivot - 1);
            }
            if (end >= pivot + 1) {
                right = new Tree(list, pivot + 1, end);
            }
        }

        private T find(T a) {
            int compare = a.compareTo(value);
            if (a == value) {
                return a;
            }
            if (compare < 0 && left != null) {
                return left.find(a);
            }
            if (compare > 0 && right != null) {
                return right.find(a);
            }
            return null;
        }

    }
}
