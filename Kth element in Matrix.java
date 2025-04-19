// Binary Search 


class Solution
{
    // Function to count how many elements in the matrix are <= mid
    public static int countLessNum(int[][] mat, int mid, int N) {
        int count = 0;
        int row = N - 1; // Start from the last row
        int col = 0;     // Start from the first column
        
        // Traverse the matrix
        while (row >= 0 && col < N) {
            if (mat[row][col] <= mid) {
                // If the current element is <= mid, all elements in this row up to col are <= mid
                count += (row + 1);  // We can safely add all elements in the current row
                col++;               // Move to the next column
            } else {
                row--;               // If the current element is > mid, move to the previous row
            }
        }
        return count;    
    }
    
    // Function to find the kth smallest element
    public static int kthSmallest(int[][] mat, int n, int k)
    {
        int low = mat[0][0];
        int high = mat[n - 1][n - 1];
        
        // Perform binary search over the matrix's range of values
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            // Count how many elements in the matrix are <= mid
            int count = countLessNum(mat, mid, n);
            
            // If count is less than k, we need a larger value, so move `low`
            if (count < k) {
                low = mid + 1;
            } else {
                // Otherwise, we move `high` because mid might be the k-th smallest element
                high = mid;
            }
        }
        
        return low;  // When low == high, we've found the k-th smallest element
    }
}












//Heap technique


class Node implements Comparable<Node> {
    int data;
    int row;
    int col;
    
    Node(int data, int row, int col) {
        this.data = data;
        this.row = row;
        this.col = col;
    }
    
    public int compareTo(Node other) {
        return this.data - other.data;
    }
}


class Solution
{
	public static int kthSmallest(int[][]mat,int n,int k)
	{
        PriorityQueue<Node> minHeap = new PriorityQueue<>(); 
        
        // push the row values
        
        for(int i=0; i<n; i++) {
            minHeap.offer(new Node(mat[i][0],i,0));
        }
        
        // fetch the kth ele
        int count = 0;
        
        while(!minHeap.isEmpty()) {
            Node curr = minHeap.poll();
            count++;
            
            if(count == k) {
                return curr.data;
            }
            
            int newCol = curr.col + 1;
            if(newCol < n) {
                minHeap.offer(new Node(mat[curr.row][newCol], curr.row, newCol));
            }
        }
        
        return -1;
    }
}
