package 数组;
//给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
//
//
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marco
//s 贡献此图。
//
// 示例:
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6
// Related Topics 栈 数组 双指针
// 👍 23 👎 0

//巧妙de双指针
//使每次移动都保证是低移向高
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        if(height.length<3)return 0;
        int left=0;
        int right=height.length-1;
        int leftmax=height[left];
        int rightmax=height[right];
        int sum=0;
        while(left<right){
            if(leftmax<rightmax){
                sum+=leftmax-height[left++];
                leftmax=Math.max(leftmax,height[left]);
            }
            else{
                sum+=rightmax-height[right--];
                rightmax=Math.max(rightmax,height[right]);
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
