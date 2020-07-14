package edu.LeetCode.DFSBFS;

import javafx.util.Pair;
import org.junit.Test;

import java.util.*;

public class No126_WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> lists=new ArrayList<>();
        if (!wordList.contains(endWord)) return lists;
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
        Queue<LinkedList<String>> queue = new ArrayDeque<>();
        LinkedList<String> path = new LinkedList<>();
        path.addLast(beginWord);
        queue.offer(path);

        //这里再用一个全局的visited就不合适咯
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        boolean reachMinDepth=false;
        while (!queue.isEmpty()) {
            //记住当前层一共有多少节点，因为后面会不断加入下一层新节点
            int size = queue.size();
            while (size > 0) {
                LinkedList<String> currPath = queue.poll();
                String currentWord=currPath.peekLast();
                size--;
                //获得当前队首路径最后一个单词的每一种模式
                for (int i = 0; i < L; i++) {
                    String mode = currentWord.substring(0, i) + "*" + currentWord.substring(i + 1, L);
                    //对于一种模式，查询到包含所有匹配单词的列表
                    for (String potentialMatch : dict.getOrDefault(mode, new ArrayList<>())) {
                        //如果列表中有目标单词，则说明当前单词可通过一次改变字母变成目标单词（因为当前单词必然不同于目标单词）
                        if (potentialMatch.equals(endWord)) {
                            reachMinDepth=true;
                            currPath.addLast(endWord);
                            lists.add(currPath);
                        } else if (!visited.contains(potentialMatch)) {
                            //如果像上一题一样加入，会使得部分路径搜索不完全
                            //visited.add(potentialMatch);
                            //并且将当前单词添加到搜索路径中，进入到BFS下一层搜索
                            LinkedList<String> nextPath=new LinkedList<>(currPath);
                            nextPath.addLast(potentialMatch);
                            queue.offer(nextPath);
                        }
                    }
                }
            }
            //当前层已经找到最短路径，直接返回结果
            if (reachMinDepth)
                return lists;
        }
        return lists;
    }

    @Test
    public void test() {
        List<List<String>> lists=findLadders("cet", "ism", Arrays.asList("kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"));
        lists.forEach(list->{
            list.forEach(word->System.out.print(word+" "));
            System.out.println();
        });
    }
}