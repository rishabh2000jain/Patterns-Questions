import  java.util.*;
class FruitIntoBaskets{
    public static void main(String[] args) {
        int ans = Solution.totalFruit(new int[]{0,1,2,2});
        System.out.println(ans);
    }
}
class Solution {
    public static int totalFruit(int[] fruits) {
        Map<Integer,Integer> basket = new HashMap<>();
        int left = 0,right=0;
        int maxFruits = 0;
        while(right<fruits.length){
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0)+1);
            while(basket.size() > 2 && basket.containsKey(fruits[left])){
                if (basket.get(fruits[left])>1) {
                    basket.put(fruits[left], basket.get(fruits[left])-1);
                }else{
                    basket.remove(fruits[left]);
                }
                left++;
            }
            maxFruits = Math.max(maxFruits, right-left+1);
            right++;
        }
        return maxFruits;
    }
}      