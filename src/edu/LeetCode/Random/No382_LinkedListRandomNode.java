package edu.LeetCode.Random;


import java.util.Random;

public class No382_LinkedListRandomNode {
    private final ListNode head;
    private final Random random = new Random();

    public No382_LinkedListRandomNode(ListNode head) {
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int appearance = 1, selectedValue = 0;
        ListNode temp = head;
        while (temp != null) {
            //也可以用(int)(appearance * Math.random()) == 0
            if (random.nextInt(appearance) + 1 == 1)
                selectedValue = temp.val;
            temp = temp.next;
            appearance++;
        }
        return selectedValue;
    }


    public static void main(String args[]) {
        No382_LinkedListRandomNode ins = new No382_LinkedListRandomNode(new ListNode(1));
        System.out.println(ins.getRandom());
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    ListNode() { }
}
