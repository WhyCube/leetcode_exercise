package 滑动窗口;//给你一个字符串 S、一个字符串 T 。请你设计一种算法，可以在 O(n) 的时间复杂度内，从字符串 S 里面找出：包含 T 所有字符的最小子串。
//
// 
//
// 示例： 
//
// 输入：S = "ADOBECODEBANC", T = "ABC"
//输出："BANC" 
//
// 
//
// 提示： 
//
// 
// 如果 S 中不存这样的子串，则返回空字符串 ""。 
// 如果 S 中存在这样的子串，我们保证它是唯一的答案。 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 713 👎 0

import java.util.*;

//方法--滑动窗口
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        if(s.length()==0||t.length()==0||s.length()<t.length())
            return "";
        int [] win=new int[128];
        int [] tf=new int[128];
        int dist=0;
        int minlen=s.length()+1;
        int left=0;
        int right=0;
        char[] tc=t.toCharArray();
        char[] sc=s.toCharArray();
        int slen=s.length();
        int tlen=t.length();
        int aimleft=0;
        for(char x:tc)
            tf[x]++;

        while(right<slen){
            if(tf[sc[right]]==0){
                right++;
                continue;
            }
            if(win[sc[right]]<tf[sc[right]]){
                dist++;
            }
            win[sc[right]]++;
            right++;
            while(dist==tlen){
                if(minlen>right-left){
                    minlen=right-left;
                    aimleft=left;
                }
                if(tf[sc[left]]==0){
                    left++;
                    continue;
                }
                if(win[sc[left]]==tf[sc[left]])
                    dist--;
                win[sc[left]]--;
                left++;
            }
        }
        if(minlen==slen+1)
            return "";
        return s.substring(aimleft,aimleft+minlen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
