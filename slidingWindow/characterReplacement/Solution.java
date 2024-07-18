import java.util.*;

class Solution{
    public static void main(String[] args) {
        int ans = characterReplacement("ds",2);
        System.out.println(ans);
    }
    public static int characterReplacement(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();
        int ans = 0;
        int left=0,right=0;
        while (right<s.length()) { 
            char rCh = s.charAt(right);
            map.put(rCh, map.getOrDefault(rCh, 0)+1);
            while(map.size() > 2){
                char lCh = s.charAt(left);
                if (map.get(lCh)>1) {
                    map.put(lCh, map.get(lCh)-1);
                }else{
                    map.remove(lCh);
                }
                left++;
            }
            if(map.size() == 2){
                int minValue = Integer.MAX_VALUE;
                while(minValue>2){
                    char lCh = s.charAt(left);
                    for (Map.Entry<Character,Integer> entry : map.entrySet()) {
                        minValue = Math.min(minValue, entry.getValue());
                    }
                    if (minValue>2) {
                        map.put(lCh, map.get(lCh)-1);
                        left++;
                    }
                }
            } 
            ans = Math.max(ans, right-left+1);
            right++;
        }
        return ans;
    }
}