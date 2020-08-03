package edu.KeyToOffer.TearDown;

import java.util.HashMap;
import java.util.Map;

public class CloneComplexList {
    public RandomListNode Clone1(RandomListNode pHead) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode originPointer = pHead, clonedPointer = dummy;
        while (originPointer != null) {
            clonedPointer.next = new RandomListNode(originPointer.label);
            clonedPointer = clonedPointer.next;
            map.put(originPointer,clonedPointer);
            originPointer = originPointer.next;
        }
        clonedPointer = dummy.next;
        originPointer = pHead;
        while (originPointer != null) {
            if (originPointer.random != null) {
                clonedPointer.random = map.get(originPointer.random);
            }
            originPointer = originPointer.next;
            clonedPointer = clonedPointer.next;
        }
        return dummy.next;
    }

    public RandomListNode Clone2(RandomListNode pHead) {
        linearDuplicate(pHead);
        setRandom(pHead);
        return detachCloned(pHead);
    }

    private void linearDuplicate(RandomListNode pHead) {
        if (pHead == null) return;
        RandomListNode nextTarget = pHead.next;
        RandomListNode clonedTarget = new RandomListNode(pHead.label);
        pHead.next = clonedTarget;
        clonedTarget.next = nextTarget;
        linearDuplicate(nextTarget);
    }

    private void setRandom(RandomListNode pHead) {
        if (pHead == null) return;
        RandomListNode cloned = pHead.next;
        cloned.random = pHead.random == null ? null : pHead.random.next;
        setRandom(cloned.next);
    }

    private RandomListNode detachCloned(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode clonedHead = pHead.next;
        RandomListNode odd = pHead;
        while (odd != null) {
            RandomListNode even = odd.next;
            odd.next = even.next;
            odd = even.next;
            even.next = odd == null ? null : odd.next;
        }
        return clonedHead;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}