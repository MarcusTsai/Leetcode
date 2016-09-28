public class Solution {
    /*
     * if there is a circle, it is not possible to 
     * finish the all courses
     * note: any nodes (course) that connects to the the circle 
     * are not being finished 
     */ 
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        
        for (int i=0; i<prerequisites.length; i++) {
            int pre = prerequisites[i][1];
            int target = prerequisites[i][0];
            if (matrix[pre][target] == 0) {
                indegree[target]++;
            }
            matrix[pre][target] = 1;
        }
        
        // start node
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<numCourses; i++) {
            if(indegree[i]==0) {
              queue.add(i);    
            }
        }
        
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.remove();
            count++;
            
            // BFS
            for(int i=0; i<numCourses; i++) {
                if(matrix[course][i]==1) {
                  indegree[i]--;
                  /* if all the prerequisites to the course
                   * has been taken (indegree[i]==0), 
                   * this course can be as the prerequisities 
                   * of another course
                   */
                  if(indegree[i]==0){
                    queue.add(i);
                  }
                }
            }
            
        }
        
        return count == numCourses;
    }
}