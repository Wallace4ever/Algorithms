package edu.LeetCode.ADT;

import java.util.Arrays;

/**
 * 设计一个小顶堆
 */
public class DesignHeap <Key extends Comparable<Key>>{
    private Key[] heap;
    private int capacity;
    private int size;

    public DesignHeap(int initialCapacity) {
        this.capacity = initialCapacity;
        size = 0;
        heap = (Key[]) new Comparable[capacity+1];
    }

    public void offer(Key element) {
        if (size == capacity) {//扩容
            heap = Arrays.copyOf(heap, capacity * 2 + 1);
            capacity *= 2;
        }
        size++;
        heap[size] = element;
        swim(size);
    }

    public Key poll() {
        swap(1, size);
        Key min = heap[size];
        heap[size] = null;
        size--;
        sink(1);
        return min;
    }

    public Key peek() {
        return heap[1];
    }

    private void swim(int index) {
        while (index > 1 && heap[index].compareTo(heap[index / 2]) > 0) {
                swap(index, index / 2);
                index /= 2;
        }
    }

    private void sink(int index) {
        while (index * 2 <= size) {
            int smaller = index * 2;
            if (smaller + 1 <= size && heap[smaller+1].compareTo(heap[smaller]) < 0) {
                smaller ++;
            }
            if (heap[smaller].compareTo(heap[index]) > 0) {
                break;
            }
            swap(index,smaller);
            index = smaller;
        }
    }

    private void swap(int i, int j) {
        Key temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
