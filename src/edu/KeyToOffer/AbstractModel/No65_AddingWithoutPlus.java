package edu.KeyToOffer.AbstractModel;

import org.junit.Test;

public class No65_AddingWithoutPlus {
    public int Add(int num1,int num2) {
        int sum, carry;
        while (num2 != 0) {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }
        return num1;
    }

    @Test
    public void test() {
        System.out.println(Add(-1,-1));
    }
}
