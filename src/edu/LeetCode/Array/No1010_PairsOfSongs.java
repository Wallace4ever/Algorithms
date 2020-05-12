package edu.LeetCode.Array;

/**
 * 1010. 总持续时间可被 60 整除的歌曲
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。
 * 形式上，我们希望索引的数字 i 和 j 满足  i < j 且有 (time[i] + time[j]) % 60 == 0。（即先后顺序反过来也只算一对）
 *
 * 思路：使用数组count[60]（HashMap也可以，Map的key就对应数组的下标0~59）作为哈希表来存储每首歌除60的余数的计数。
 * count[i]表示time[]数组中对60取模结果为i的歌曲的数量，除了count[0]和count[30]外，count[i]和count[60-i]的乘积就是匹配的歌曲对数目
 * 为避免重复计算歌曲对，下标从1~29进行计算
 * 而count[0]和count[30]中，各自取任意两首歌曲组合都满足要求，则计数为n(n-1)/2
 */
public class No1010_PairsOfSongs {
    public int numPairsDivisibleBy60(int[] time) {
        int[] count=new int[60];
        for(int i=0;i<time.length;i++){
            count[time[i]%60]+=1;
        }
        int couples;
        couples=count[0]*(count[0]-1)/2+count[30]*(count[30]-1)/2;
        for(int i=1;i<=29;i++){
            couples+=count[i]*count[60-i];
        }
        return couples;
    }
}