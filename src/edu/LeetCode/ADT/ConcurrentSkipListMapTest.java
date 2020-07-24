package edu.LeetCode.ADT;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListMapTest {
    //private static Map<String, String> MAP = new TreeMap<String, String>();
    private static Map<String, String> MAP = new ConcurrentSkipListMap<String, String>();

    public static void main(String[] args) throws InterruptedException {
        // 同时启动两个线程对map进行操作！
        new MyThread("A").start();
        new MyThread("B").start();
        Thread t=Thread.currentThread();
        t.sleep(1000L);
        printAll();
        printAll();
    }

    private static void printAll() {
        String key, value;
        for (Map.Entry<String, String> stringStringEntry : MAP.entrySet()) {
            key = stringStringEntry.getKey();
            value = stringStringEntry.getValue();
            System.out.print("(" + key + ", " + value + ") ");
        }
        System.out.println();
    }

    private static class MyThread extends Thread {
        MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            int i = 0;
            while (i++ < 6) {
                // "线程名" + "序号"
                String val = Thread.currentThread().getName() + i;
                MAP.put(val, "0");
                printAll();
            }
        }
    }
}
