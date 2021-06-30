package Unity3;

import java.lang.reflect.Array;
import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap();
        for (String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> value = map.getOrDefault(key,new ArrayList<String>());
            value.add(s);
            map.put(key,value);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
