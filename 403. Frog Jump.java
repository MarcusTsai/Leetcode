/* The example is as follows,
 * if stones = [0,1,3,5,6,8,12,17]
 * {17=[], 0=[1], 1=[1, 2], 3=[1, 2, 3], 5=[1, 2, 3], 6=[1, 2, 3, 4], 8=[1, 2, 3, 4], 12=[3, 4, 5]}
 * stone @ 1, the frog can jump 1,2 since k=1
 * stone @ 3, the frog can jump 1, 2, 3 since k=2
 * stone @ 5, the frog can jump 1, 2, 3 since k=2
 * stone @ 6, the frog can jump 2, 3, 4 for k=3 and 1, 2 for k=1 ==> [1, 2, 3, 4]
 * ...
 */

public boolean canCross(int[] stones) {
	if(stones.length==0) {
	  return true;	
	}
	HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>(stones.length);
    
    // put stone @ 0 = [1]
    for(int i=0; i<stones.length; i++) {
       map.put(stones[i], new HashSet<Integer>());	
    }
    
    map.get(0).add(1);
    
    for(int i=0; i<stones.length-1; i++) {
    	int stone = stones[i];
    	for(int step:map.get(stone)) {
    		int reach = step + stone;
    		
    		if(reach==stones[stones.length-1]) {
    		  return true;	
    		}
    		
    		if(map.get(reach)!=null) {
    		  if(step-1>0) {
    		    map.get(reach).add(step-1);
    	      } 
    	      map.get(reach).add(step);
    	      map.get(reach).add(step+1);
    	    }
    	} 

    }
    return false;
}

