/**
 * 给定一个字符串s和一些 长度相同 的单词words 。找出 s 中恰好可以由words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑words中单词串联的顺序。
 *
 * 思路：遍历给定字符串 ， 按words给的size截取字符串，通过统计等长单词出现的次数，来判断是否符合条件
 *      （哈希表法）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

package Unity3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    HashMap<String, Integer> t;
    public List<Integer> findSubstring(String s, String[] words) {
        List ans = new LinkedList();
        t = count(words); // 条件字符串的hash表
        System.out.println("t = " + t);
        Integer tol_size = words.length * words[0].length();
        System.out.println("tol_size = " + tol_size);
        for (int i = 0 ; i+tol_size-1<s.length();i++){
            System.out.println("isSame(s.substring(i,i+tol_size),words) = " + isSame(s.substring(i,i+tol_size),words));
            if (isSame(s.substring(i,i+tol_size),words)){
                ans.add(i);
            }
        }
        return ans;
    }

    // 传入截取好的字符串 ， 经过此函数后 ， 判断是否与条件字符串组的hash表一样
    private boolean isSame(String s,String[] words){
        HashMap<String, Integer> map =new HashMap<>();// 单词出现的次数
        Integer m = words[0].length();// 每个单词的长度
        // 注意截取字符串  Java中的截取是开始位置与结束位置-1  同时注意判断条件是i+m-1
        for (int i = 0;i+m-1<s.length();i+=m){
            String s1 = s.substring(i, i+m);
            Integer o = map.getOrDefault(s1, 0);
            map.put(s1,++o);
        }
        System.out.println("map_ans = " + map);
        return same(map,t);
    }

    private boolean same(HashMap<String, Integer> a,HashMap<String, Integer> b){
        if (a.size()!=b.size()) return false;
        for (String s : a.keySet()){
            // Java 基本语法 ： int和Integer直接用==比较的话 不论值是否一样 ， 都会返回false
            //              原因：int为基本类型 ， Integer为类
            int i = a.get(s);
            if (!b.containsKey(s)||b.get(s)!=i) return false;
        }
        return true;
    }

    // 首先先对题目条件的words进行统计
    private HashMap<String, Integer> count(String[] words){
        HashMap<String, Integer> map = new HashMap();
        for (int i = 0; i < words.length;i++){
            Integer o =map.getOrDefault(words[i],0);
            map.put(words[i],++o);
        }
        return map;
    }

}
