import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成的问题
 * 22号
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParentheses {

    private List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        helper(n, 0, 0, "");
        return list;
    }

    private void helper(int n, int left, int right, String s) {
        if (left == n && right == n) {
            list.add(s);
            return;
        }
        if(left<n){
            helper(n,left+1,right,s+"(");
        }
        if(right<left){
            helper(n,left,right+1,s+")");
        }

    }


}
