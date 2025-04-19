

class Solution
{
    static class Node {
        int val;
        int row;
        int col;
        
        Node(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        // Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        
        PriorityQueue<Node> p = new PriorityQueue<>((a,b)->a.val-b.val); // Min Heap
        
        for(int i=0;i<arr.length; i++) {
            p.offer(new Node(arr[i][0], i, 0));
        }
        
        while(!p.isEmpty()) {
            Node curr = p.poll();
            ans.add(curr.val);
            
            // If next column exists in the same row, add to heap
            if (curr.col + 1 < K) {
                p.offer(new Node(arr[curr.row][curr.col + 1], curr.row, curr.col + 1));
            }
        }
        
        return ans;
    }
}
