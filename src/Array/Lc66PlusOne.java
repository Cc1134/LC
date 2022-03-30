package Array;

public class Lc66PlusOne {
    public int[] plusOne(int[] digits) {
        int numOfNines = 0;
        for(int i = digits.length-1; i >= 0 && digits[i] == 9; i--){
            //789590594024899999999
            //789590594024900000000
            digits[i] = 0;
            numOfNines++;
        }
        if(numOfNines == digits.length){
            //old_len
            digits = new int[digits.length+1];
            //new_len == old_len+1
        }
        //[new_len-1-old_len]
        digits[digits.length-1-numOfNines]++;
        return digits;
    }

}
