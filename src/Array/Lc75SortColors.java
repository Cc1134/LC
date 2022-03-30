package Array;

public class Lc75SortColors {
    // 75. 颜色分类
    public void sortColors(int[] nums) {
        // 不使用sort函数，被排序的数字的取值只有可能是三种之一
        // 那么记录下来三种数字分别有几个，然后重新赋值，即可
        // 先记录下来三种数字分别有几个
        int[] count = new int[3];
        for(int num: nums){
            count[num]++;
        }
        // 然后重新按照排了序的顺序对数组进行赋值
        int index = 0;
        // 先摆放所有的0
        for(int i = 0; i < count[0]; i++){
            nums[index] = 0;
            index++;
        }
        // 再摆放所有的1
        for(int i = 0; i < count[1]; i++){
            nums[index] = 1;
            index++;
        }
        // 最后同理，摆放所有的2
        for(int i = 0; i < count[2]; i++){
            nums[index] = 2;
            index++;
        }
    }

}
