class Solution {
    public boolean equationsPossible(String[] str) {
        int arr[] = new int[26];
        int f= 1;
        for(int i=0;i<str.length;i++){ // Here handled all '==' one.
            String s = str[i];
            int a = s.charAt(0)-'a';
            int b = s.charAt(3)-'a';
            if(s.charAt(1) == '='){
                if(a == b){
                    continue;
                }
                if(arr[a] != 0 && arr[b] != 0){
                    for(int i2=0;i2<26;i2++){
                        if(i2!=b){
                            if(arr[i2] == arr[b]){
                                arr[i2] = arr[a];
                            }
                        }
                    }
                    arr[b] = arr[a];
                }else if(arr[a] == 0 && arr[b]!= 0){
                    arr[a] = arr[b];
                }else if(arr[a] != 0 && arr[b] == 0){
                    arr[b] = arr[a];
                }else{
                    arr[a] = f;
                    arr[b] = f++;
                }
            }
        }
        for(int i=0;i<str.length;i++){  // Here cross checked all '!=' one
            String s = str[i];
            int a = s.charAt(0)-'a';
            int b = s.charAt(3)-'a';
            if(s.charAt(1) == '!'){
                if(a== b){
                    return false;
                }
                if(arr[a] != 0 && arr[b] != 0){
                    if(arr[a] == arr[b]){
                        return false;
                    }
                }else if(arr[a] == 0 && arr[b]!= 0){
                    arr[a] = f++;
                }else if(arr[a] != 0 && arr[b] == 0){
                    arr[b] = f++;
                }else{
                    arr[a] = f++;
                    arr[b] = f++;
                }
            }
        }
        return true;
    }
}