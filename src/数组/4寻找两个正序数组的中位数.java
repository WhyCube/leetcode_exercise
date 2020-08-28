package 数组;
//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
//
// 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
//
// 你可以假设 nums1 和 nums2 不会同时为空。
//
//
//
// 示例 1:
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
//
//
// 示例 2:
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
//
// Related Topics 数组 二分查找 分治算法
// 👍 3109 👎 0

//baseline 复杂度O（m+n）的算法 ，合并找到中位数
/*二分查找的思想，主要思想为在总长度已知的条件下，转化为找到第k个值的问题。
根据比较每个数组的第k/2的元素，进行比较，则每次将问题规模缩小为k/2个
注意 删除元素时要用减法，即当前位置减去前个位置。
时间复杂度为O（log（m+n））



 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        int k=len1+len2;
        if(k%2==1){
            return bin_findk(nums1,nums2,k/2+1);
        }
        else {
            double x=bin_findk(nums1,nums2,k/2);
            double y=bin_findk(nums1,nums2,k/2+1);
            System.out.println(x);
            System.out.println(y);
            return (bin_findk(nums1,nums2,k/2)+bin_findk(nums1,nums2,k/2+1))/2;
        }
    }
    private double bin_findk(int []nums1,int []nums2,int k){
        if(nums1.length==0)return (double)nums2[k-1];
        if(nums2.length==0)return (double)nums1[k-1];
        int len1=nums1.length;
        int len2=nums2.length;
        int Ap=0;
        int Bp=0;
        while (true){
            if(Ap==len1)
                return nums2[Bp+k-1];
            if(Bp==len2)
                return nums1[Ap+k-1];
            if(k==1)
                return (double)Math.min(nums1[Ap],nums2[Bp]);
            int half=k/2;
            int nAp=Math.min(Ap+half,len1)-1;
            int nBp=Math.min(Bp+half,len2)-1;
            if(nums1[nAp]<=nums2[nBp]){
                k -= nAp-Ap+1;
                Ap=nAp+1;
            }
            else{
                k-=nBp-Bp+1;
                Bp=nBp+1;
            }

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
