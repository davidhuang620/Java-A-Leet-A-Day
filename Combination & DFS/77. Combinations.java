/*

Time Complexity = O(答案个数 * 构造每个答案的时间)
http://www.jiuzhang.com/qa/2994/
 
Combination and Permutation: 
https://betterexplained.com/articles/easy-permutations-and-combinations/
C(8,3) = 8*7*6 / no-order redundancy = 8*7*6/3! = 8!/(3! * 5!) 
P(8,3) = 8*7*6 = 8!/5!

*/

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        comb(n, k, 1, new ArrayList<>(), ans);
        return ans;
    }
    
    private void comb(int n, int k, int index, ArrayList<Integer> subset, List<List<Integer>> ans){
        if (k == 0){
            ans.add(new ArrayList<>(subset));
            return;
        }
        while (index <= n){
            subset.add(index);
            comb(n, k - 1, index + 1, subset, ans);
            index ++;
            subset.remove(subset.size() - 1);
        }
    }
    
}
