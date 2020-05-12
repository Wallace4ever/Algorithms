package edu.KeyToOffer.Robust;

/**
 * 不使用类库实现次方运算，不考虑大数问题
 * 在代码鲁棒性方面需要考虑指数为0、为负数的情况，以及底数为0的同时指数为负数的情况
 */
public class Power {
    public double getPower(double base, int exponent) {
        if (exponent==0)return 1;
        double result=0.0;
        if (base==0.0)return result;
        if (exponent > 0) {
            result=getResult(base,exponent);
            return result;
        }
        result=getResult(base,-exponent);
        return 1.0/result;
    }
    //直接计算次方，这里底数不为0，指数为正整数
    public double getResult(double base, int exponent) {
        double result=base;
        for (int i=1;i<exponent;i++){
            result*=base;
        }
        return result;
    }
    //现在来使用递归优化这一部分，减少计算量,使用位操作提升整数运算速度
    public double getResult2(double base, int exponent) {
        if (exponent == 1) {
            return base;
        }
        if ((exponent & 0x1)==0) {
            double half = getResult2(base, exponent >> 1);
            return half * half;
        } else {
            double half=getResult2(base,(exponent-1)>>1);
            return half*half*base;
        }
    }
}
