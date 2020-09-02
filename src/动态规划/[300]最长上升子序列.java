package 动态规划;//给定一个无序的整数数组，找到其中最长上升子序列的长度。
//
// 示例: 
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4 
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。 
//
// 说明: 
//
// 
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。 
// 你算法的时间复杂度应该为 O(n2) 。 
// 
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗? 
// Related Topics 二分查找 动态规划 
// 👍 943 👎 0

/*
最长上升字串
O（n2）
dp[j]表示以nums[j]结尾的前j的最长上升子序列的长度
dp[j]=dp[i]+1 if nums[j]>nums[i]

贪心+二分搜索
O（nlogn）
用一个tail数组 tail[i]表示所有长度为i+1的上升子序列结尾最小的值

 */
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*
    //二分
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return 1;
        int [] dp=new int[nums.length];
        Arrays.fill(dp,1);
        int gbmax=0;
        for(int i=1;i<nums.length;i++){
            int maxval=0;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j])
                    maxval=Math.max(dp[j],maxval);
            }
            dp[i]=maxval+1;
            gbmax=Math.max(gbmax,dp[i]);
        }
        return gbmax;
    }

     */
    //贪心+二分
    public int lengthOfLIS(int[] nums){
        if(nums.length==0)return 0;
        if(nums.length==1)return 1;
        int [] tail=new int[nums.length];
        int sym=1;
        tail[0]=nums[0];
        for(int i=0;i<nums.length;i++){
            if(tail[sym-1]<nums[i])
                tail[sym++]=nums[i];
            else {
                int st=0;
                int ed=sym-1;
                while(st<=ed){
                    int mid=st+(ed-st)/2;
                    if(tail[mid]<nums[i])st=mid+1;
                    else
                        ed=mid-1;
                }
                tail[st]=nums[i];
            }
        }
        return sym;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
