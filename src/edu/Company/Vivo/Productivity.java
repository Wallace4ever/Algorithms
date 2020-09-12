package edu.Company.Vivo;

import org.junit.Test;

/**
 * 在vivo产线上，每位职工随着对手机加工流程认识的熟悉和经验的增加，日产量也会不断攀升。
 * 假设第一天量产1台，接下来2天(即第二、三天)每天量产2件，接下来3天(即第四、五、六天)每天量产3件 ... ...
 * 以此类推，请编程计算出第n天总共可以量产的手机数量。
 */
public class Productivity {
    public int solution (int n) {
        int days = 1, sum = days * (days + 1);
        while (sum < 2 * n) {
            days++;
            sum = days * (days + 1);
        }
        int product = 0, i = 1;
        while (i < days) {
            product += i * i;
            i++;
        }
        i--;
        int remain = n - ((1 + i) * i / 2);
        product += days * remain;
        return product;
    }

    @Test
    public void test() {
        System.out.println(solution(11));
    }
}
