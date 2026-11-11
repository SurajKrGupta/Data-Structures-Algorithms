class Solution {
    public boolean isValid(String s) {
        if(s.length()<2) return false;
        Stack<Character>st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(' || ch=='{'||ch=='[') st.push(s.charAt(i));
            else{
                if(st.isEmpty()) return false;
                char p=st.pop();
                if(ch==')' && p=='(' || ch=='}' && p=='{' || ch==']' && p=='['){}
                else return false;
            }
        }
        return st.isEmpty();
    }
}