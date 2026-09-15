class Solution {
    public boolean isValid(String s) {
        Stack<Character>st = new Stack<>();

        for(char ch : s.toCharArray()){
            st.push(ch);
            if(st.size()>=3){
                if(st.peek()=='c' && st.get(st.size()-2)=='b' && st.get(st.size()-3)=='a'){
                    st.pop();
                    st.pop();
                    st.pop();
                }
            }
        }
        return st.isEmpty();
    }
}