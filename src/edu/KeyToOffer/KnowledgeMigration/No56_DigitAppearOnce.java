package edu.KeyToOffer.KnowledgeMigration;

public class No56_DigitAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int xor = 0, bitOf1 = 0;
        for (int num : array)
            xor ^= num;
        while ((xor & 1) != 1) {
            bitOf1++;
            xor >>= 1;
        }
        for (int num : array) {
            if (((num >> bitOf1) & 1) == 1)
                num1[0] ^= num;
            else
                num2[0] ^= num;
        }
    }
}
