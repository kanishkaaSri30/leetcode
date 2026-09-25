class Solution {
    public List<String> braceExpansionII(String expression) {
        HashSet<String>set = helper(expression, 0, expression.length());
        List<String>ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }

    public HashSet<String> helper(String exp, int st, int end){
        HashSet<String>result = new HashSet<>();
        HashSet<String>curr = new HashSet<>();
        curr.add("");
        int i = st;
        while(i<end){
            char ch = exp.charAt(i);

            if(ch=='{'){
                int braces=1;
                int j = i+1;
                while(j<end && braces!=0){
                    if(exp.charAt(j)=='{'){
                        braces++;
                    }
                    else if(exp.charAt(j)=='}'){
                        braces--;
                    }
                    j++;
                }
                HashSet<String>tem = helper(exp, i+1, j-1);
                HashSet<String>tem2 = new HashSet<>();
                for(String m : curr){
                    for(String n : tem){
                        tem2.add(m+n);
                    }
                }
                curr = tem2;
                i=j;

            }
            else if(ch==','){
                result.addAll(curr);
                curr = new HashSet<>();
                curr.add("");
                i++;
            }
            else{
                HashSet<String>temp = new HashSet<>();
                for(String k : curr){
                    temp.add(k+ch);
                }
                curr = temp;
                i++;
            }
        }

        result.addAll(curr);
        return result;
    }
}