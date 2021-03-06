package 动态规划;//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 你可以假设数组中无重复元素。 
//
// 示例 1: 
//
// 输入: [1,3,5,6], 5
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [1,3,5,6], 2
//输出: 1
// 
//
// 示例 3: 
//
// 输入: [1,3,5,6], 7
//输出: 4
// 
//
// 示例 4: 
//
// 输入: [1,3,5,6], 0
//输出: 0
// 
// Related Topics 数组 二分查找 
// 👍 665 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length==0)return 0;
        if(nums[nums.length-1]<target)return nums.length;
        int st=0;
        int ed=nums.length-1;
        while(st<=ed){
            int mid=st+(ed-1)/2;
            if(nums[mid]<target)
                st=mid+1;
            else
                ed=mid-1;
        }
        return st;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
