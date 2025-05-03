public class Solution {
    public int nchoc(int A, ArrayList<Integer> B) {
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder()); // MaxHeap

        for (int chocolates : B) {
            p.add(chocolates);
        }

        long maxCho = 0;
        int MOD = 1000000007;

        while (A-- > 0) {
            int max = p.poll();
            maxCho = (maxCho + max) % MOD;
            p.add(max / 2);
        }

        return (int) maxCho;
    }
}
