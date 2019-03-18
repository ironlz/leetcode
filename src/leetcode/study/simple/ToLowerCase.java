package leetcode.study.simple;

/**
 * 将指定字符串转换为小写字母
 */
public class ToLowerCase {
    /**
     * 将字符串转换为小写字母
     * @param str 要转换的字符串
     * @return 转换后的字符串
     */
    public String toLowerCase(String str) {
        char[] chs = str.toCharArray();
        for(int i = 0; i < chs.length; i++){
            chs[i] = Character.toLowerCase(chs[i]);
        }
        return new String(chs);
    }
}
