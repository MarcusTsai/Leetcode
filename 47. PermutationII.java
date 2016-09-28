public class PermutationII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();


        if(nums!=null || nums.length != 0){
            Arrays.sort(nums);
            System.out.println("sorted array: " + Arrays.toString(nums));
            boolean[] visited = new boolean[nums.length];
            helper(result, current, nums, visited);
        }
        return result;
    }


    private void helper(List<List<Integer>> result, List<Integer> current, int[] nums, boolean[] visited) {
        if(current.size() == nums.length) {
            result.add(new ArrayList(current));
            return;
        }

        //System.out.println("curr: " + current.toString());

        for(int i=0; i<nums.length; i++) {
            if(!visited[i]) {
                if(i>0 && nums[i]==nums[i-1] && visited[i-1]) {
                  //System.out.println("dup: " + current.toString());
                  return;
                }
                current.add(nums[i]);
                visited[i] = true;
                helper(result, current, nums, visited);

                // restore to the previous status
                current.remove(current.size()-1);
                visited[i] = false;

            }
        }

    }
    public static void main(String[] args) {
        PermutationII test = new PermutationII();
        int[] input = {1, 2, 1};
        System.out.println(test.permuteUnique(input));

    }
}