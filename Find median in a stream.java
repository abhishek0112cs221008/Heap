
class Solution {
    
    public ArrayList<Double> getMedian(int[] arr) {
        ArrayList<Double> ans = new ArrayList<>();
        
        PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>();            
        
        
        for(int num : arr) {
            // step 1 : Insert into correct heap
            if(leftMaxHeap.isEmpty() || num <= leftMaxHeap.peek()) {
                leftMaxHeap.offer(num);
            }
            else {
                rightMinHeap.offer(num);
            }
            
            // Step 2: Balance the heaps
            if(leftMaxHeap.size() > rightMinHeap.size() + 1) {
                rightMinHeap.offer(leftMaxHeap.poll());
            }
            else if (rightMinHeap.size() > leftMaxHeap.size()) {
                leftMaxHeap.add(rightMinHeap.poll());
            }
            
            // Step 3: Get median
            if(leftMaxHeap.size() == rightMinHeap.size()) {
                double median = (leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0;
                ans.add(median);
            }
            else {
                double median = (double) leftMaxHeap.peek();
                ans.add(median);
            }
        } 
        
        return ans;
    }
}
