package String;

/**
 * @ClassName: Lc93RestoreIPAddresses
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/13/22 11:55 am
 * @Version 1.0
 */
public class Lc93RestoreIPAddresses {
    void dfs(char[] s, int i, Integer IPval, int count, char[] buf, List<String> ans){
        if(?){ // 已经用完了最后一位数
            if(?){ // 已放入三个句点
                ans.add(String.copyValueOf(?, ?, ?));
            }
            return;
        }
        //case2: 向当前拼接的str字符串追加一个句点
        if(
                IPval != ? // IPval中存在已“吞入”的有效数字字符
            && ? // 句点数量小于3
            ){
            buf[i+count] = '.';
            dfs(?, ?, ?, ?, ?, ?);
        }
        //case1: 向当前拼接的str字符串追加一个新的数字
        //IP = IP*10+s[i]
        int nextIP = (IPval==null?0:IPval)*10+(?);
        if(
                !(IPval的前导字符是一个'0')
             && ? // IPval的取值范围应该符合IP规定
            ){
            buf[i+count] = s[i];
            dfs(?, ?, ?, ?, ?, ?);
        }
    }
    public List<String> restoreIpAddresses(String _s) {
        char[] s = _s.toCharArray();
        char[] buf = new char[23];
        List<String> ans = new ArrayList<>();
        dfs(?, ?, ?, ?, ?, ?);
        return ans;
    }

}

