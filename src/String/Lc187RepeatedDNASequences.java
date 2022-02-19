package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName: Lc187RepeatedDNASequences
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/14/22 10:36 pm
 * @Version 1.0
 */
public class Lc187RepeatedDNASequences {
}



class Solution3 {
    int charToInt(char c){
        if(c == 'A'){
            return 0;
        }
        if(c == 'C'){
            return 1;
        }
        if(c == 'G'){
            return 2;
        }
        if(c == 'T'){
            return 3;
        }
        return -1;
    }
    char intToChar(int i){
        if(i == 0){
            return 'A';
        }
        if(i == 1){
            return 'C';
        }
        if(i == 2){
            return 'G';
        }
        if(i == 3){
            return 'T';
        }
        return 0;
    }
    public List<String> findRepeatedDnaSequences(String _s) {
        char[] s = _s.toCharArray();
        if(s.length <= 10){
            return new ArrayList<>();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        //第一个"长度是10的子串"s[0:10]
        //[0], [1], [2], [3], [4], [5], [6], [7], [8], [9]
        int M = 1;
        int hashCode = 0;
        for(int i = 0; i < 10; i++){
            hashCode = hashCode*4+charToInt(s[i]);
            M *= 4; // M在循环结束时，是4^10
        }
        map.put(hashCode, 1);
        int L = 0;
        int R = 10;
        while(R < s.length){
            //s[1:11]
            //[1], [2], [3], [4], [5], [6], [7], [8], [9], [10]
            //s[R]更新到hashCode里
            hashCode = hashCode*4+charToInt(s[R]);
            //hashCode: xxxxx xxxxx s[R]共计有11位
            hashCode %= M;
            map.put(hashCode, map.getOrDefault(hashCode, 0)+1);
            L++;
            R++;
        }
        List<String> ans = new ArrayList<>();
        char[] buf = new char[10];
        for(int hash: map.keySet()){
            if(map.get(hash) > 1){
                for(int i = 9; i >= 0; i--){
                    buf[i] = intToChar(hash%4);
                    hash /= 4;
                }
                ans.add(String.valueOf(buf));
            }
        }
        return ans;
    }
}




class Solution2 {
    static char[] intToChar = new char[]{'A', 'C', 'G' ,'T'};
    static int[] charToInt = new int[26];
    public List<String> findRepeatedDnaSequences(String _s) {
        List<String> ans = new ArrayList<>();
        if(_s.length() <= 10){
            return ans;
        }
        char[] s = _s.toCharArray();
        charToInt['A'-'A'] = 0;
        charToInt['C'-'A'] = 1;
        charToInt['G'-'A'] = 2;
        charToInt['T'-'A'] = 3;
        HashMap<Integer, Integer> map = new HashMap<>();
        //第一个"长度是10的子串"s[0:10]
        //[0], [1], [2], [3], [4], [5], [6], [7], [8], [9]
        int hashCode = 0;
        for(int i = 0; i < 10; i++){
            //(00)+(00,01,10,11)
            hashCode = (hashCode<<2)|charToInt[s[i]-'A'];
        }
        //sum[i: 0,3](2^i) = 8+4+2+1 = 2^4-1
        //sum[i: 0,19](2^i) = 2^20-1
        int M = (1<<20)-1;
        map.put(hashCode, 1);
        int L = 0;
        int R = 10;
        while(R < s.length){
            //s[1:11]
            //[1], [2], [3], [4], [5], [6], [7], [8], [9], [10]
            //s[R]更新到hashCode里
            hashCode = (hashCode<<2)|charToInt[s[R]-'A'];
            //hashCode: xxxxx xxxxx s[R]共计有11位
            hashCode &= M;//M是二进制前20位全部为1的数字
            map.put(hashCode, map.getOrDefault(hashCode, 0)+1);
            L++;
            R++;
        }
        char[] buf = new char[10];
        for(int hash: map.keySet()){
            if(map.get(hash) > 1){
                for(int i = 9; i >= 0; i--){
                    buf[i] = intToChar[hash&3];
                    hash >>= 2;
                }
                ans.add(String.valueOf(buf));
            }
        }
        return ans;
    }
}