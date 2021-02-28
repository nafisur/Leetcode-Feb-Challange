/*
Given a balanced parentheses string S, compute the score of the string based on the following rule:

() has score 1
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.
 

Example 1:

Input: "()"
Output: 1
Example 2:

Input: "(())"
Output: 2
Example 3:

Input: "()()"
Output: 2
Example 4:

Input: "(()(()))"
Output: 6

*/
class Solution {
    public int scoreOfParentheses(String S) {
     int i = 0, n = S.length(), open = -1, ans = 0;
        while (i < n) {
            while (i < n && S.charAt(i++) == '(') open++;
            
            ans += Math.pow(2, open);
            
            while(i < n && S.charAt(i++) == ')') open--;
        }
            
        return ans;
    }
}