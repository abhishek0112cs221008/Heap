class Solution {
    class Node {
        int val;
        int row;
        int col;

        Node(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Node> p = new PriorityQueue<>((a,b)->a.val-b.val); // min heap
        int max = Integer.MIN_VALUE;
        int start = 0, end = Integer.MAX_VALUE;

        for(int i=0; i<nums.size(); i++) {
            p.offer(new Node(nums.get(i).get(0), i, 0));
            max = Math.max(nums.get(i).get(0) , max);
        }

        while(true) {
            Node minNode = p.poll();
            int currMin = minNode.val;

            // Update range if it's better
            if(max - currMin < end - start || (max - currMin == end - start && currMin < start)) {
                start = currMin;
                end = max;
            }

            if(minNode.col + 1 < nums.get(minNode.row).size()) {
                int nextVal = nums.get(minNode.row).get(minNode.col + 1);
                p.offer(new Node(nextVal, minNode.row, minNode.col+1));
                max = Math.max(max, nextVal);
            }
            else break; 
        }

        return new int[]{start, end};
    }
}
