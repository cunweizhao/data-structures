package com.zcw.data.frequent;

import com.zcw.data.maxheap.Solution;

import java.util.*;

/**
 * @ClassName : SolutionFrequent
 * @Description :
 * @Author : Zhaocunwei
 * @Date: 2020-08-21 09:24
 */
public class SolutionFrequent {
//    private class Freq implements Comparable<SolutionFrequent.Freq>{
private class Freq {
        //元素是谁， 频次
        public int e,freq;
        public Freq(int e,int freq){
            this.e=e;
            this.freq=freq;
        }
//        @Override
//        public int compareTo(SolutionFrequent.Freq another) {
//            if(this.freq <another.freq){
//                return -1;
//            }else if(this.freq > another.freq){
//                return 1;
//            }
//            return 0;
//        }


    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        //元素与频次封装
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                //对应的num数据，频次+1
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        //求出前K个频次最高的元素
        //使用优先队列
//        PriorityQueue<SolutionFrequent.Freq> pq = new PriorityQueue<>(new FreqComparator());
        PriorityQueue<SolutionFrequent.Freq> pq = new PriorityQueue<>(new Comparator<Freq>(){
            // 创建匿名类，只使用一次
            @Override
            public int compare(Freq a, Freq b) {
                return a.freq-b.freq;
            }
        });
        for (int key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(new SolutionFrequent.Freq(key, map.get(key)));
            } else if (map.get(key) > pq.peek().freq) {
                pq.remove();
                pq.add(new SolutionFrequent.Freq(key, map.get(key)));
            }
        }
        LinkedList<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove().e);
        }
        return res;
    }
    /**
     * 实现比较器
     */
//    private class FreqComparator implements Comparator<Freq>{
//
//        @Override
//        public int compare(Freq a, Freq b) {
//            return a.freq -b.freq;
//        }
//    }

}
