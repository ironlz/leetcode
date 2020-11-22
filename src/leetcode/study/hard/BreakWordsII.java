package leetcode.study.hard;

import java.util.*;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * <p>
 * 说明：
 * <p>
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * 示例 2：
 * <p>
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BreakWordsII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> directory = new HashSet<>(wordDict);
        List<String> result = new ArrayList<>();
        collectWords(result, "", s, directory);
        return result;
    }

    /**
     * 收集计算结果
     *
     * @param result      结果集合
     * @param prefix      前缀
     * @param sourceWords 剩余单词
     * @param directory   字典
     */
    private void collectWords(List<String> result, String prefix, String sourceWords, Set<String> directory) {
        if (sourceWords.isEmpty()) {
            result.add(prefix);
            return;
        }
        for (int i = 1; i <= sourceWords.length(); i++) {
            String substring = sourceWords.substring(0, i);
            if (directory.contains(substring)) {
                collectWords(result, prefix.isEmpty() ? substring : prefix + " " + substring, sourceWords.substring(i), directory);
            }
        }
    }

    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>();
        a.add(1);
        a.add(2);
        a.add(3);
        Set<Integer> b = new HashSet<>();
        b.add(2);
        b.add(3);
        b.add(4);

        a.retainAll(b);
        System.out.println(a);
        System.out.println(b);
    }
}
