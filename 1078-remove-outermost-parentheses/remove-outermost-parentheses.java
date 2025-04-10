class Solution {
    public String removeOuterParentheses(String s) {
        int count  = 0;
        StringBuilder str = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if (ch == '(') {
                if (count > 0) str.append('(');
                count++;
            }
            else {
                count--;
                if (count>0) str.append(')');
            
            }
        }
        return str.toString();
    }
}