class Solution {
    public static List<String>ans=new ArrayList<>();
    public static void  generating( char []a,int idx,int n,int oc,int cc){
        if(idx==n){
                ans.add(new String(a));
             return;

        }

        if(oc<n/2){
            a[idx]='(';
            generating(a,idx+1,n,oc+1,cc);

        }

        if(oc>cc){
            a[idx]=')';
            generating(a,idx+1,n,oc,cc+1);
        }
       
    }
    public List<String> generateParenthesis(int n) {
        char a[]=new char[2*n];
        ans.clear();
        generating(a,0,2*n,0,0);
         return ans;
        
    }
}