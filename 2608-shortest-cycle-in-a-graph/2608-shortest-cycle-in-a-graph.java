class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int minCycle = Integer.MAX_VALUE;

        for (int start = 0; start < n; start++) {
            int[] dist = new int[n];
            Arrays.fill(dist, -1);
            Queue<Integer> queue = new LinkedList<>();

            dist[start] = 0;
            queue.offer(start);

            while (!queue.isEmpty()) {
                int curr = queue.poll();

                if (dist[curr] >= minCycle) break;

                for (int nbr : graph[curr]) {
                    if (dist[nbr] == -1) {
                        dist[nbr] = dist[curr] + 1;
                        queue.offer(nbr);
                    } else if (dist[nbr] >= dist[curr]) {
                        // Cycle found
                        minCycle = Math.min(minCycle, dist[curr] + dist[nbr] + 1);
                    }
                }
            }
        }

        return minCycle == Integer.MAX_VALUE ? -1 : minCycle;
    }
}