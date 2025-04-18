class Solution{
    
    // Height of heap = log   (N)
    //                     2
    
    static int heapHeight(int N, int arr[]){
        if(N == 1) return 1;
        return (int)(Math.log(N) / Math.log(2));
    }
}


// or

class Solution{
    static int heapHeight(int N, int arr[]){
        if(N == 1) return 1;
        int height = 0;
        while(N > 1) {
            height++;
            N /= 2;
        }
        return height;
    }
}
