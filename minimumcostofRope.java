

class Solution {
    public static int minCost(int[] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : arr) {
            minHeap.add(num);
        }

        int cost = 0;

        while (minHeap.size() > 1) {
            int first = minHeap.poll();
            int second = minHeap.poll();

            int newRope = first + second;
            cost += newRope;

            minHeap.add(newRope);
        }

        return cost;
    }
}