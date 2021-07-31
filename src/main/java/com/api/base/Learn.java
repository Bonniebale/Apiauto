package com.api.base;

import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.*;

public class Learn {


    @Test
    public void array(){//2个数组合成一个数组,过滤掉重复数据，并排序
        int[] num1 = {1,4,7,9,1,55,3};
        int[] num2 = {11,4,8,9,21,75,3};
        Arrays.asList(num1);//该方法是将数组转化成List集合的方法。如果输出，输出的是一个引用，如：[[I@6acdbdf5]
        // （1）该方法适用于对象型数据的数组（String、Integer...）
        /*（2）该方法不建议使用于基本数据类型的数组（byte,short,int,long,float,double,boolean）
        （3）该方法将数组与List列表链接起来：当更新其一个时，另一个自动更新
        （4）不支持add()、remove()、clear()等方法*/
       /* 【2.Arrays.asList()是个坑】
        用此方法得到的List的长度是不可改变的，
        总结：如果你的List只是用来遍历，就用Arrays.asList()。
        如果你的List还要添加或删除元素，还是乖乖地new一个java.util.ArrayList，然后一个一个的添加元素。*/

        //将 数组num1的数据放进list中
        List list = new ArrayList();
        for(int i : num1){
            list.add(i);
        }
        System.out.println("for循环迭代后的list1集合为："+list+"。合并后的数组中总个数为："+list.size());
        List list2 = new ArrayList();
        for(int i : num2){
            list2.add(i);
        }
        System.out.println("for循环迭代后的list2集合为："+list2+"。合并后的数组中总个数为："+list2.size());

        //将list、list1合成一个数组并过滤（两个数组取并集）
        Set set = new HashSet();
        set.addAll(list);
        System.out.println("set加了list以后："+set+"。合并后的数组中总个数为："+set.size());
        set.addAll(list2);
        System.out.println("set加了list2以后："+set+"。合并后的数组中总个数为："+set.size());

        //排序
        Set setSort  = new TreeSet();
        setSort.addAll(list);
        System.out.println("setSort加了list以后："+setSort+"。合并后的数组中总个数为："+setSort.size());
        setSort.addAll(list2);
        System.out.println("setSort加了list2以后："+setSort+"。合并后的数组中总个数为："+setSort.size());


        //两个数组取交集
        Set jiaoji = new TreeSet();
        for (int i = 0; i < list2.size(); i++){
            if (list.contains(list2.get(i))){
                jiaoji.add(list.get(i));
            }
        }
        System.out.println("两个数组取交集："+jiaoji+"。合并后的数组中总个数为："+jiaoji.size());

    }
    public void arrayToList(){

    }

    public static void main(String[] args){

    }
}
