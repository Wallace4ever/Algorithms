package edu.LeetCode.DFSBFS;

import java.util.*;

public class No127_WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        final int L = beginWord.length();
        //预处理：建立字典，内容为模式到所有匹配该模式的单词表的映射
        Map<String, List<String>> dict = new HashMap<>();
        wordList.forEach(word->{
            for (int i = 0; i < L; i++) {
                String mode = word.substring(0, i) + "*" + word.substring(i + 1, L);
                List<String> list = dict.getOrDefault(mode, new ArrayList<>());
                list.add(word);
                dict.put(mode, list);
            }
        });

        //BFS需要借助的队列
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        //BFS搜索到的深度，每搜索完一层就+1
        int depth=1;
        while (!queue.isEmpty()) {
            //记住当前层一共有多少节点，因为后面会不断加入下一层新节点
            int size = queue.size();
            while (size > 0) {
                String currentWord = queue.poll();
                size--;
                //获得当前队首单词的每一种模式
                for (int i = 0; i < L; i++) {
                    String mode = currentWord.substring(0, i) + "*" + currentWord.substring(i + 1, L);
                    //对于一种模式，查询到包含所有匹配单词的列表
                    for (String potentialMatch : dict.getOrDefault(mode, new ArrayList<>())) {
                        //如果列表中有目标单词，则说明当前单词可通过一次改变字母变成目标单词（因为当前单词必然不同于目标单词）
                        if (potentialMatch.equals(endWord)) {
                            return depth+1;
                        } else if (!visited.contains(potentialMatch)) {
                            //否则确保访问过的单词不会再被访问
                            visited.add(potentialMatch);
                            //并且将当前单词添加到搜索路径中，进入到BFS下一层搜索
                            queue.offer(potentialMatch);
                        }
                    }
                }
            }
            depth++;
        }
        return 0;
    }

}
