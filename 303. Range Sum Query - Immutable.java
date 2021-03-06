public class NumArray {
  private int[] sum;

  public NumArray(int[] nums) {
      //sum[0] = nums[0];
      /* Cannot copy value from the array
       * instead, do the operation on origimal nums
       * and change the reference instead of array copy
       */
      for(int i = 1; i < nums.length; i++)
         nums[i] += nums[i - 1];

      this.sum = nums;
  }

  public int sumRange(int i, int j) {
      if(i == 0)
        return sum[j];

      return sum[j] - sum[i - 1];
  }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);