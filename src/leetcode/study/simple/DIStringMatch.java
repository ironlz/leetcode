package leetcode.study.simple;

/**
 * 给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
 *
 * 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
 *
 * 如果 S[i] == "I"，那么 A[i] < A[i+1]
 * 如果 S[i] == "D"，那么 A[i] > A[i+1]
 *
 *
 * 示例 1：
 *
 * 输出："IDID"
 * 输出：[0,4,1,3,2]
 * 示例 2：
 *
 * 输出："III"
 * 输出：[0,1,2,3]
 * 示例 3：
 *
 * 输出："DDI"
 * 输出：[3,2,0,1]
 *
 *
 * 提示：
 *
 * 1 <= S.length <= 1000
 * S 只包含字符 "I" 或 "D"。
 *
 */
public class DIStringMatch {
    /**
     * 该问题是有规律的，所有的D对应的为降序，I对应的为升序，且降序为从右侧最大值开始[N, N-1, N-2,...]，
     * 升序为从左侧最小值开始，[0, 1, 2,...]
     * 算法复杂度O(N)
     * @param S 排序规则
     * @return 排序后的数组
     */
    public int[] diStringMatch(String S) {
        int N = S.length();
        // 构建结果数组
        int[] result = new int[N + 1];
        // 升序起始值
        int leftIndex = 0;
        // 降序起始值
        int rightIndex = N;
        // 按照排序规则插入对应的值
        for(int i = 0; i < N; i++){
            if(S.charAt(i) == 'I'){
                result[i] = leftIndex;
                leftIndex++;
            }else if(S.charAt(i) == 'D'){
                result[i] = rightIndex;
                rightIndex--;
            }
        }
        // 剩下最后一个元素放到最后的位置
        result[N] = leftIndex;
        return result;
    }
}
