package edu.KeyToOffer.Chain;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMap主体的实现都是借助HashMap来完成的，只是对其中的 recordAccess(), addEntry(), createEntry(), get(), clear()进行了重写。
 * 同时插入的时候调用了afterNodeAccess()方法以及afterNodeInsertion()方法,在HashMap中这两个方法是空实现,
 * 而在LinkedHashMap中则有具体实现,这两个方法也是专门给LinkedHashMap进行回调处理的。
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    //用户定义逻辑上的缓存大小，与initialCapacity不冲突，后者可以扩容
    private int cacheSize;

    /**
     * 父类构造方法默认AccessOrder为false，仅按照插入顺序排序
     * 重写构造方法时，设该值为true可以在访问元素时将其移到链表尾部
     */
    public LRUCache(int cacheSize) {
        super(16, 0.75f, true);
        this.cacheSize = cacheSize;
    }

    /**
     * 该方法在每次put或putAll方法时调用，检查新加入元素后是否需要删除最老的元素
     * LinkedHashMap中默认返回false即不删除，需要使用者重写该方法加入自己的策略
     * @param eldest 最老的元素，是否使用其属性来判断是否移除之由开发者决定
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() >= cacheSize;
    }
}
