/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

package Unity1;

import java.util.Stack;

public class Parentheses {
    public boolean isValid(String s) {
        if(s.length()%2==1) return false;
        Stack<Character> stack = new Stack();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('||c=='['||c=='{'){
                stack.push(c);
            }
            else if(c==')'){
                if(stack.empty()) return false;// 可以判断当出现全是右括号时情况
                Character pop = stack.pop();
                if (pop.equals('(')) continue;
                return false;
            }
            else if (c==']'){
                if(stack.empty()) return false;// 可以判断当出现全是右括号时情况
                Character pop = stack.pop();
                if (pop.equals('[')) continue;
                return false;
            }
            else if (c=='}'){
                if(stack.empty()) return false;// 可以判断当出现全是右括号时情况
                Character pop = stack.pop();
                if (pop.equals('{')) continue;
                return false;
            }
        }
        return stack.empty();// 可以判断当出现全是左括号时情况
    }
}
