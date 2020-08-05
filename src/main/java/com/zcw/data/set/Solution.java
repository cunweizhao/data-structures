package com.zcw.data.set;

import java.util.TreeSet;
/**
 * @ClassName : Solution
 * @Description : 通过集合解决唯一摩斯密码词
 * @Author : Zhaocunwei
 * @Date: 2020-08-05 14:18
 */
public class Solution {
    public  int uniqueMorseRepresentations(String[] words){
        String[] codes={
                ".-", "-...", "-.-.", "-..", ".",
                "..-.","--.","....","..",".---",
                "-.-",".-..","--","-.","---",".--.",
                "--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
        };
        TreeSet<String> set = new TreeSet<>();
        for(String word: words){
            StringBuilder res = new StringBuilder();
            for(int i=0; i<word.length();i++){
                res.append(codes[word.charAt(i) - 'a']);
            }
            set.add(res.toString());
        }
        return set.size();
    }
}
