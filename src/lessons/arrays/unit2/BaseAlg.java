package lessons.arrays.unit2;

import java.util.Arrays;

/**
 * 典型的排序算法思想、二分查找思想在解 LeetCode 题目时很有用。
 */
public class BaseAlg {
    /**
     * 给定一个包含红色、白色和蓝色，一共n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * <p>
     * 此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
     * <p>
     * <p>
     * <p>
     * 进阶：
     * <p>
     * 你可以不使用代码库中的排序函数来解决这道题吗？
     * 你能想出一个仅使用常数空间的一趟扫描算法吗？
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [2,0,2,1,1,0]
     * 输出：[0,0,1,1,2,2]
     * 示例 2：
     * <p>
     * 输入：nums = [2,0,1]
     * 输出：[0,1,2]
     * 示例 3：
     * <p>
     * 输入：nums = [0]
     * 输出：[0]
     * 示例 4：
     * <p>
     * 输入：nums = [1]
     * 输出：[1]
     * <p>
     * <p>
     * 提示：
     * <p>
     * n == nums.length
     * 1 <= n <= 300
     * nums[i] 为 0、1 或 2
     * <p>
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/all-about-array/x9wv2h/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * 颜色分类 - 解题思路
     * 基数排序法
     * 可以采用基数排序法的思想，用一个数组记录下 0，1，3 的次数，后重排，这个算法对数组进行了两次遍历，其实有一种只进行一次遍历的方法。
     *
     * 三路快速排序方法
     * 设置三个 lt, gt, i 定义：nums[0...lt] == 0，nums[lt+1...i-1] = 1，nums[gt...n-1] == 2，遍历一遍改数列保持这个定义。
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/all-about-array/x9dam3/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums 要处理的数组
     */
    public void sortColors(int[] nums) {
        int minIndex = 0;
        int maxIndex = nums.length - 1;
        while (minIndex < nums.length && nums[minIndex] == 0) {
            minIndex++;
        }
        while (maxIndex >= 0 && nums[maxIndex] == 2) {
            maxIndex--;
        }
        for (int i = minIndex; i < nums.length && i <= maxIndex; i++) {
            if (nums[i] == 0 && i != minIndex) {
                int tmp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex++] = tmp;
                i--;
            }
            else if (nums[i] == 2) {
                int tmp = nums[i];
                nums[i] = nums[maxIndex];
                nums[maxIndex--] = tmp;
                i--;
            }
        }
    }

    /**
     * 数组中的第K个最大元素
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     *
     * 示例 1:
     *
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     * 示例2:
     *
     * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     * 输出: 4
     * 说明:
     *
     * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/all-about-array/x90rpm/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * 利用快速排序的思想，从数组 S 中随机找出一个元素 X，把数组分为两部分 Sa 和 Sb。Sa 中的元素大于等于 X，Sb 中元素小于 X。这时有两种情况：
     *
     * Sa 中元素的个数小于 k，则 Sb 中的第 k-|Sa| 个元素即为第k大数；
     * Sa 中元素的个数大于等于 k，则返回 Sa 中的第 k 大数。时间复杂度近似为 O(n)
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/all-about-array/x979o1/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * 
     * @param nums 要计算的数组
     * @param k 要查找的第k大数
     * @return 第k大数的值
     */
    public int findKthLargest(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] > nums[j - 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;
                }
            }
        }
        return nums[k - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2,1};
        BaseAlg baseAlg = new BaseAlg();

        baseAlg.sortColors(nums);
        System.out.println(Arrays.toString(nums));

        int[] topK = {5,2,4,1,3,6,0};
        System.out.println(baseAlg.findKthLargest(topK, 4));
    }
}
