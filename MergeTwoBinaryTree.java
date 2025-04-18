
class Solution{
    
    private void heapify(int arr[], int i, int n) {
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;
        
        if(left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if(right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        
        if(largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            
            heapify(arr, largest, n);
        }
    }
    
    public int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        int ans[] = new int[m+n];
        
        int j=0;
        for(int i=0;i<n; i++) {
            ans[j] = a[i];
            j++;
        }
        
        for(int i=0; i<m; i++) {
            ans[j] = b[i];
            j++;
        }
        
        n = ans.length;
        
        for(int i = n/2-1; i>=0; i--) {
            heapify(ans, i, n);
        }
        
        return ans;
    }
}
