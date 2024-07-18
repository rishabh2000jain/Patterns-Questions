class StepByStepDirection{
    public static void main(String[] args) {
        Solution sol = new Solution();
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode ansister = commonAnsister(root,startValue,destValue);
        System.out.println(ansister.val);
        StringBuilder ssb = new StringBuilder();
        StringBuilder dsb = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        trackPath(ansister,startValue,ssb);
        trackPath(ansister,destValue,dsb);
        for(char ch:ssb.toString().toCharArray()){
            ans.append('U');
        }
        ans.append(dsb);
        return ans.toString();
    }
    boolean trackPath(TreeNode root, int s,StringBuilder sb){
        if(root == null ){
            return false;
        }
        if(root.val == s){
            return true;
        }

        sb.append('L');
        boolean l = trackPath(root.left,s,sb);
        if(l){
            return l;
        }else{
            sb.deleteCharAt(sb.length()-1);
        }
        sb.append('R');
        boolean r = trackPath(root.right,s,sb);
        if(r){
            return r;
        }else{
            sb.deleteCharAt(sb.length()-1);
        }
        return l || r;
    }

    TreeNode commonAnsister(TreeNode root, int s, int e){
        if(root==null){
            return null;
        }
        if(root.val == s || root.val == e){
            return root;
        }
        TreeNode l = commonAnsister(root.left,s,e);
        TreeNode r = commonAnsister(root.right,s,e);
        if(l!=null && r != null) return root;
        if(l!=null) return l;
        if(r!=null) return r;
        return null;

    }
}