package 数组;//给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
//
// 
//
// 示例 1： 
//
// 输入：[-4,-1,0,3,10]
//输出：[0,1,9,16,100]
// 
//
// 示例 2： 
//
// 输入：[-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// -10000 <= A[i] <= 10000 
// A 已按非递减顺序排序。 
// 
// Related Topics 数组 双指针 
// 👍 117 👎 0

/*
双指针法
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortedSquares(int[] A) {
        if(A[0]>=0){
            for(int i=0;i<A.length;i++)
                A[i]*=A[i];
            return A;
        }
        int []B=new int[A.length];
        int st=0;
        int ed=A.length-1;
        int p=A.length-1;
        while(st<=ed){
            int a=A[st]*A[st];
            int b=A[ed]*A[ed];
            B[p--]=a>b?a:b;
            int x=a>b?st++:ed--;
        }
        return B;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
