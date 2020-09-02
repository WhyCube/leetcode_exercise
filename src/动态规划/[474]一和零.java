package 动态规划;//在计算机界中，我们总是追求用有限的资源获取最大的收益。
//
// 现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。 
//
// 你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。 
//
// 注意: 
//
// 
// 给定 0 和 1 的数量都不会超过 100。 
// 给定字符串数组的长度不会超过 600。 
// 
//
// 示例 1: 
//
// 
//输入: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
//输出: 4
//
//解释: 总共 4 个字符串可以通过 5 个 0 和 3 个 1 拼出，即 "10","0001","1","0" 。
// 
//
// 示例 2: 
//
// 
//输入: Array = {"10", "0", "1"}, m = 1, n = 1
//输出: 2
//
//解释: 你可以拼出 "10"，但之后就没有剩余数字了。更好的选择是拼出 "0" 和 "1" 。
// 
// Related Topics 动态规划 
// 👍 202 👎 0

//类似于01背包问题

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int [][] dp=new int[m+1][n+1];
        int [][] x=new int[strs.length][2];
        for(int k=0;k<strs.length;k++){
            int m1=0;
            int n1=0;
            for(int j=0;j<strs[k].length();j++){
                if(strs[k].charAt(j)=='0')
                    m1++;
                else n1++;
            }
            for(int i=m;i>=0;i--)
                for (int j=n;j>=0;j--){
                    if(m1<=i&&n1<=j){
                        dp[i][j]=Math.max(dp[i][j],dp[i-m1][j-n1]+1);
                    }
                }
        }
        return dp[m][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
