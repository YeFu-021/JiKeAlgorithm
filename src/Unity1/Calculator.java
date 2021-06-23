/**
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *输入：s = "1 + 1"
 * 输出：2
 *
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 */

package Unity1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculator {
    public int calculate(String s) {
        List<String> tokens = new ArrayList<>();
        Stack<String> ops = new Stack<>();
        boolean need_zeros = true;
        boolean nums_start = false;
        int nums = 0;

        for (char c : s.toCharArray()) {
            // 处理数字
            if (c>='0'&&c<='9'){
                nums = nums * 10 + Integer.parseInt(String.valueOf(c));
                nums_start = true;
                continue;
            }
            else if(nums_start){
                tokens.add(String.valueOf(nums));
                System.out.println(String.valueOf(nums));
                nums_start = false;
                need_zeros = false;
                nums = 0;
            }
            // 处理空格
            if (c==' ') continue;;
            // 处理运算符
            if (c=='('){
                ops.push(String.valueOf(c));
                need_zeros = true;
                continue;
            }
            if (c==')'){
                while (!ops.empty()&&!ops.peek().equals("(")){
                    tokens.add(ops.pop());
                }
                if(!ops.empty()) ops.pop();// 将左括号pop出去
                need_zeros = false;
                continue;
            }
            if (need_zeros) tokens.add("0");
            // 处理+-*/
            if (!ops.empty()&&getRank(ops.peek())>=getRank(String.valueOf(c))){
                tokens.add(ops.pop());
            }
            ops.push(String.valueOf(c));
            need_zeros = true;
        }


        if (nums_start) tokens.add(String.valueOf(nums));
        while (!ops.empty()) tokens.add(ops.pop());
        EvaluateReversePolishNotation eva = new EvaluateReversePolishNotation();
        String[] s1 = tokens.toArray(new String[tokens.size()]);
        return eva.evalRPN(s1);
    }



    private int getRank(String c) {
        if (c.equals("+")||c.equals("-")) return 1;
        if (c.equals("*")||c.equals("/")) return 2;
        return 0;
    }

}
