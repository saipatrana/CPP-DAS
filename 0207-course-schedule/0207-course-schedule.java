class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];









        for(int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);

            indegree[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int completed = 0;

        while(!queue.isEmpty()) {
            int course = queue.poll();

            completed++;

            for(int next : adj.get(course)) {
                indegree[next]--;

                if(indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return completed == numCourses;
    }
}