package SlidingWindow.longestSubstringWithAtMostTwoDistinctCharacters;
import java.util.*;
class Solution {
    public static void main(String[] args) {
        int ans = longestkSubstr("aabacbebebe",3);
        System.out.println(ans);
    }
    public static int longestkSubstr(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();
        int left = 0,right = 0;
        int ans = 0;
        while(right<s.length()){ 
            //O(S)
            char ch = s.charAt(right);
            map.put(ch,map.getOrDefault(ch, 0)+1);
            char leftCh = s.charAt(left);
            while(map.size()>k && map.containsKey(leftCh)){
                leftCh = s.charAt(left);
                if(map.get(leftCh)>1){
                    map.put(leftCh,map.get(leftCh)-1);
                }else{
                    map.remove(leftCh);
                }
                left++;
            }
            ans = Math.max(ans,right-left+1);
            right++;
        }
        if (map.size()>=k) {
            return ans;
        }
        return -1;
    }
}

//https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article