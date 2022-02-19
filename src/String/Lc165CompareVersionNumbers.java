package String;

/**
 * @ClassName: Lc165CompareVersionNumbers
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/14/22 10:24 pm
 * @Version 1.0
 */
public class Lc165CompareVersionNumbers {
    int max(int a, int b){
        //返回a和b中取值更大的那个
    }
    int valueOf(char[] version, int start, int end){
        //返回以version[start]开头、以version[end-1]结尾的字符串
        //所表示的整数
        int ans = 0;
        for(int i = start; i < end; i++){
            ?
        }
        return ans;
    }
    int getEnd(char[] version, int start){
        //从start指针所指向的version[start]字符
        //找到以此开头的这一数字所结尾的句点'.'或终结下标(len)
        //当start==len时，返回len
        while(?){
            ?
        }
        return start;
    }
    int getStart(char[] version, int end){
        //从end指针所指向的version[end]句点'.'
        //找到下一个数字开头第一个字符的下标
        //当end==len时，返回len
        if(?){
            ?;
        }
        return end;
    }
    public int compareVersion(String _version1, String _version2) {
        char[] version1 = _version1.toCharArray();
        char[] version2 = _version2.toCharArray();
        int i = 0;
        int j = 0;
        while(
            ? < version1.length // version1中还有未处理的版本号数字
                || ? < version2.length // version2中还有未处理的版本号数字
            ){
            int num1;
            {
                int end = ?; // 找end指针
                num1 = ?; // 提取version[start:end]的值
                i = ?; // 找下一个start指针
            }
            int num2;
            {
                int end = ?;
                num2 = ?;
                j = ?;
            }
            if(num1 < num2){
                return ?;
            }
            if(num1 > num2){
                return ?;
            }
        }
        return ?;
    }

}

class Solution {
    int max(int a, int b){
        return a>=b?a:b;
    }
    int valueOf(char[] version, int start, int end){
        int ans = 0;
        for(int i = start; i < end; i++){
            ans = ans*10+version[i]-'0';
        }
        return ans;
    }
    int getEnd(char[] version, int start){
        while(start < version.length && version[start] != '.'){
            start++;
        }
        return start;
    }
    int getStart(char[] version, int end){
        if(end < version.length && version[end] == '.'){
            end++;
        }
        return end;
    }
    public int compareVersion(String _version1, String _version2) {
        char[] version1 = _version1.toCharArray();
        char[] version2 = _version2.toCharArray();
        int i = 0;
        int j = 0;
        while(i < version1.length || j < version2.length){
            int num1;
            {
                int end = getEnd(version1, i);
                num1 = valueOf(version1, i, end);
                i = getStart(version1, end);
            }
            int num2;
            {
                int end = getEnd(version2, j);
                num2 = valueOf(version2, j, end);
                j = getStart(version2, end);
            }
            if(num1 < num2){
                return -1;
            }
            if(num1 > num2){
                return 1;
            }
        }
        return 0;
    }
}