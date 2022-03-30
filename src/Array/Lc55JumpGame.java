package Array;

public class Lc55JumpGame {
    public boolean canJump(int[] nums) {
        int life = 1;
        for(int n: nums){
            if(life == 0){
                return false;
            }
            life--;
            life = life >= n?life:n;
        }
        return true;
    }

}
