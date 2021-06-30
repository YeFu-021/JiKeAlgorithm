package Unity3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubdomainVisitCount {
    HashMap<String, Integer> ans = new HashMap<>();

    public List<String> subdomainVisits(String[] cpdomains) {

        for (String s : cpdomains) {
            String[] s1 = s.split(" ");
            int time = Integer.valueOf(s1[0]);// 整个域名访问的次数
            String temp = "";
            // s1[1] 中存储域名
            String[] split = s1[1].split("\\."); // 如何将split里的域名排列组合
            for (int i = split.length - 1; i >= 0; i--) {
                // 为顶级域名
                if (i == split.length - 1) temp = split[i];
                else temp = split[i] + "." + temp;// 将域名组合

                ans.put(temp, ans.getOrDefault(temp, 0) + time);

            }
        }
        List<String> answer = new ArrayList<>();
        for (String key : ans.keySet()) {
            answer.add(String.valueOf(ans.get(key)) + " " + key);
        }
        return answer;
    }
}
