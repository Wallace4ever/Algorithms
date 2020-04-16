package edu.seu;

import java.util.*;

/**
 * 华为2020机试第一题，每行输入针对候选者的投票
 * 如Tom,Andy,Tomcat,Tom,Julia,Dave,Andy
 * 得票最高的取姓名首字母靠前的
 */
public class CountUsingMap {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        while(s.hasNextLine()){
            String input=s.nextLine();
            String[] div=input.split(",");//读入一行输入并拆分至数组
            Map<String,Count> counter=new HashMap<String,Count>();
            /**
             * 使用HashMap来分拣，姓名为key，票数封装在类Count中，不使用Integer的原因是前者可以使用get/set方法方便修改票数
             * 使用HashMap的目的是将重复输入的人名最终封装在输出的Map.Entry<String name,Count count>中，再进一步得到票数最高者的List
             * 如果不考虑重复输入的情况，则可以跳过这一步直接构建List<实体类>来排序
             * 并且，如果直接设计实体类来构建List的话，可以自定义实体类的compareTo()方法来实现更多维度的数据排序
             * 如：封装实体类Candidate(){int count,Date birthDay,String name}实现Comparable<Candidate>接口，其compareTo(Candidate c)方法为{
             *     int result=0;
             *     if(this.count>c.count){//先按票数排序
             *         result=1;
             *     }else{//如果票数相同则按生日排序
             *         result=-this.birthDay.compareTo(c.birthDay);//加负号则为降序，不加则为升序
             *         if(result==0){//如果生日相同则按姓名排序
             *             result=this.name.compareTo(c.name);
             *         }
             *     }
             *     return result;
             * }
             * 这样就实现了按不同优先级维度的排序，使用List自带的sort()方法或Collections.sort()即可完成排序
             * 相比之下使用HashMap来分拣并输出EntrySet没有实现排序
             * 将EntrySet中票数最多的人添加到List中仅实现了票数这一维度的（部分）排序
             */
            for (String d:div){
                if(!counter.containsKey(d)){
                    counter.put(d,new Count(1));
                }else{
                    Count c=counter.get(d);
                    c.setCou(c.getCou()+1);
                }
            }
            //取得HashMap中存储的条目的集合，便于迭代判断票数最多的人
            //注意，Map输出的EntrySet不会按照姓名排序，即使先排序div并按照姓名顺序插入HashMap中输出也是这样，所以要在后面排序
            Set<Map.Entry<String,Count>> itr=counter.entrySet();
            int max=0;
            //如果有多个人同时获得最大票数，则放入动态数组中
            List<String> ls=new ArrayList<String>();
            for (Map.Entry<String,Count> item:itr){
                if (item.getValue().getCou()>max){
                    max=item.getValue().getCou();
                    ls.clear();
                    ls.add(item.getKey());
                }else if(item.getValue().getCou()==max){
                    ls.add(item.getKey());
                }
            }//List<实体类>构建完成
            /**
             * 方法一：将ArrayList转成String类数组再用Arrays工具类排序
             */
            String[] output=new String[ls.size()];
            //List的toArray()方法返回的数组是Object[]且不能强制类型转换，toArray(<T>[])是将数组中的值复制到T类型的数组中
            //数组空间不足则复制到新建的同类型数组中如String[] y = x.toArray(new String[0]);
            ls.toArray(output);
            //排序得票最高者人名并输出第一个
            Arrays.sort(output);
            System.out.println(output[0]);

            /**
             * 方法二，使用List自带的sort()方法排序，List有序可重复，Set、Map因为无序所以不可排序不带有sort()方法（TreeSet、TreeMap除外）
             * 该sort()方法是JDK1.8新增的
             */
            //也可以使用实现了Comparator接口的比较器（业务排序类）来直接对List排序，业务排序类必须重写compare()方法
            //如果比较器为空则按照List中存储的实体类的自然顺序排序，List中的实体类必须实现Comparable接口重写compareTo()方法
            ls.sort(null);
/*          ls.sort(new Comparator<String>() {//这里是新建一个匿名内部类，并直接调用了String类的compareTo()方法，如果没有自定义比较逻辑则多此一举
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });*/
            System.out.println(ls.get(0));

            /**
             * 方法三：直接使用java.util.Collections工具类对List进行排序
             */
            Collections.sort(ls);//Collections.sort(ls,Comparator c);
            System.out.println(ls.get(0));
        }
    }
}

class Count{
    private int cou;

    public Count(int cou) {
        this.cou = cou;
    }

    public int getCou() {
        return cou;
    }

    public void setCou(int cou) {
        this.cou = cou;
    }
}