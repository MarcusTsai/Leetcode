/* ====== recursive 1 ====== */
/*  
 * [[1, 2, 3]->[1, 2]->[1, 3]->[1]->[2]->[2,3]->[3]->[]
 *             
 *              (1, 2, 3) => [1, 2, 3]
 *       (1, 2) (1, 2, _) => [1, 2]
 *   (1)        (1, _, 3) => [1, 3]
 *       (1, _) (1, _, _) => [1]
 *
 *       (_, 2) (_, 2, 3) => [2, 3]
 *   (_)        (_, 2, _) => [2]
 *       (_, _) (_, _, 3) => [3]
 *              (_, _, _) => []  
 */
public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();

    if(nums!=null) {
        Arrays.sort(nums);
        backtracing(res, nums, 0, new ArrayList<>());
    }
    return res;
}

private void backtracing(List<List<Integer>> res, int[] nums, int index, List<Integer> list) {
    if(index==n) {
      res.add(new Arrays<>(list));
      return;	
    }

    // select num[index] is selected
    list.add(nums[index]);
    backtracing(res, nums, i+1, list);

    // num[index] is not selected
    list.remove(list.size()-1);
    backtracing(res, nums, i+1, list);
    
}
/* ====== recursive 2 ====== */
/* []->[1]->[1, 2]->[1, 2, 3]->[1, 3]->[2, 3]->[2]->[3]
 * 
 *
 */
public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();

    if(nums!=null) {
        Arrays.sort(nums);
        backtracing(res, nums, 0, new ArrayList<>());
    }
    return res;
}

private void backtracing(List<List<Integer>> res, int[] nums, int start, List<Integer> list) {
    res.add(new ArrayList<Integer>(list));

    for(int i=start; i<nums.length; i++) {
       list.add(nums[i]);
       backtracing(res, nums, i+1, list);
       list.remove(list.size()-1);
    }
}

/* ====== bitwise ========== */   
public List<List<Integer>> subsets(int[] nums) {
 List<List<Integer>> res = new ArrayList<>();
       
 if(nums!=null) {
   int total = (int) Math.pow(2, nums.length);
   
   for(int j=0; j<total; j++) {
      List<Integer> list = new ArrayList<>();
      //System.out.println(j);
      for(int i=0; i<nums.length; i++) {
          
         if(((j>>i) & 1) == 1) {
           list.add(nums[i]);        
         }
         
      } 
      res.add(new ArrayList(list)) ;       
   }
 }
 return res;
}

 /* ====== iterative ====== */

public List<List<Integer>> subsets(int[] nums) {
 List<List<Integer>> res = new ArrayList<>();
       
 if(nums!=null) {
   res.add(new ArrayList<>());
   
   for(int i=0; i<nums.length; i++) {
      int size = res.size(); 
      for(int j=0; j<size; j++){
         List<Integer> list = new ArrayList(res.get(j)); 
         list.add(nums[i]);
         res.add(list); 
      } 
   }
 }
 return res;
}  