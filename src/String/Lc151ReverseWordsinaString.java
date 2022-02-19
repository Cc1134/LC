package String;

/**
 * @ClassName: Lc151ReverseWordsinaString
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/13/22 11:39 am
 * @Version 1.0
 */
public class Lc151ReverseWordsinaString {
    // 151. 翻转字符串里的单词
    public String reverseWords(String _s) {
        char[] s = _s.toCharArray(); // 转化为char数组
        int start = s.length-1; // 右指针从倒数第一个元素开始扫描
        StringBuilder ans = new StringBuilder(s.length); // 初始化
        while(start >= 0){ // 当右指针没有扫到左侧结尾的时候
            while(start >= 0 && s[start] == ' '){
                start--; // 左移右指针，直到遇到一个单词的最右侧字符
            }
            int end = start;
            while(end >= 0 && s[end] != ' '){
                end--; // 左移左指针，直到遇到这一单词的左侧第一个空格
            }
            if(start - end > 0){ // 如果这样一个单词是存在的(左右指针跨度不为0)
                for(int j = end+1; j <= start; j++){
                    ans.append(s[j]); // 遍历这个单词，写入builder
                }
                ans.append(' '); // 单词尾部添加分隔符空格
            }
            start = end; // 下一个单词的起点至少从这个单词的左侧空格开始
        }
        ans.setLength(ans.length() - 1); // 移除builder中多余的最后一个空格
        return ans.toString(); // 返回最终的字符串
    }

}

