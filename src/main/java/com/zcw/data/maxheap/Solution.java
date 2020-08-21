package com.zcw.data.maxheap;


import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
/**
 * @ClassName : Solution
 * @Description : Leetcode上优先队列相关问题
 * @Author : Zhaocunwei
 * @Date: 2020-08-11 14:34
 */
public class Solution {

    private class Freq implements Comparable<Freq>{
        //元素是谁， 频次
        public int e,freq;
        public Freq(int e,int freq){
            this.e=e;
            this.freq=freq;
        }
        @Override
        public int compareTo(Freq another) {
            if(this.freq <another.freq){
                return 1;
            }else if(this.freq > another.freq){
                return -1;
            }
            return 0;
        }


    }
    public List<Integer> topKFrequent(int[] nums,int k){
     //元素与频次封装
        TreeMap<Integer,Integer> map =new TreeMap<>();
        for(int num:nums){
            if(map.containsKey(num)){
               //对应的num数据，频次+1
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
        }
        //求出前K个频次最高的元素
        //使用优先队列
        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for(int key: map.keySet()){
            if(pq.getSize() <k){
                pq.enqueue(new Freq(key,map.get(key)));
            }else if(map.get(key)>pq.getFront().freq){
                pq.dequeue();
                pq.enqueue(new Freq(key,map.get(key)));
            }
        }
        LinkedList<Integer> res = new LinkedList<>();
        while(!pq.isEmpty()){
            res.add(pq.dequeue().e);
        }
        return res;
    }
}
