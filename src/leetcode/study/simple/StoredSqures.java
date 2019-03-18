package leetcode.study.simple;

import java.util.Arrays;

/**
 * 计算升序数组的平方，并保持升序
 */
public class StoredSqures {
    /**
     * 计算升序数组的平方，并保持升序。
     * 平方后的数组存在以下规律：
     *  1、假设A全是正数，则平方后依然是升序的
     *  2、假设A全是复数，则平方后为降序的
     *  3、假设A即存在正数，又存在负数，则平方后先降序后升序。
     * 因此可以先寻找这个最小数，然后向两边查找，拷贝两边的较小值
     * @param A 升序数组
     * @return 平方后的升序数组
     */
    public static int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];// 结果数组
        int index = 0;
        int min = Integer.MAX_VALUE;
        int left = index - 1;
        int right = index + 1;
        // 计算平方后的数组并查找最小值
        for(int i = 0; i < A.length; i++){
            A[i] = A[i] * A[i];
            if(A[i] < min){
                min = A[i];
                index = i;
            }
        }
        left = index - 1;
        right = index + 1;
        result[0] = min;
        index = 1;
        // 向两侧查找，并拷贝较小的值到结果数组中
        while (left > -1 && right < result.length){
            if(A[left] < A[right]){
                result[index] = A[left];
                left--;
            }else{
                result[index] = A[right];
                right++;
            }
            index++;
        }
        // 如果右侧剩余，因为右侧是升序的，所以直接拷贝
        if(left < 0){
            System.arraycopy(A,right, result, index, result.length - index);
        }else{
            // 左侧剩余时，左侧是降序的，因此拷贝时需要调整顺序。
            while(left >= 0){
                result[index] = A[left];
                index++;
                left--;
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] t1 = {-3, -1, 0};
        System.out.println(Arrays.toString(sortedSquares(t1)));
    }
}
