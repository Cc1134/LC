package String;

/**
 * @ClassName: Lc97InterleavingString
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/13/22 11:48 am
 * @Version 1.0
 */
public class Lc97InterleavingString {
    int[][] map;
    //Map<Pair<Integer, Integer>, Boolean> map = new HashMap<>();
    boolean inter(char[] s1, char[] s2, char[] s3, int n, int m){
        assert s1.length-n + s2.length-m == s3.length-(n+m);
        if(s1.length-n == 0 && s2.length-m == 0 && s3.length-(m+n) == 0){
            return true;
        }
        //pair(Cn1, Cm2), pair(n, m)
        if(map[m][n] != 0){
            return map[m][n] == 1;
        }
        boolean ans = false;
        if(s1.length-n > 0 && s1[n] == s3[n+m]){
            ans = ans || inter(s1, s2, s3, n+1, m);
        }
        if(s2.length-m > 0 && s2[m] == s3[n+m]){
            ans = ans || inter(s1, s2, s3, n, m+1);
        }
        map[m][n] = ans?1:-1;
        return ans;
    }
    public boolean isInterleave(String _s1, String _s2, String _s3) {
        char[] s1 = _s1.toCharArray();
        char[] s2 = _s2.toCharArray();
        char[] s3 = _s3.toCharArray();
        if(s1.length + s2.length != s3.length){
            return false;
        }
        map = new int[s1.length+1][s2.length+1];
        return inter(s1, s2, s3, 0, 0);
    }
}

