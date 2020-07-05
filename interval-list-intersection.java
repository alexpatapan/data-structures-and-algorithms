class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        ArrayList<int[]> result = new ArrayList<>();
        
        int i = 0;
        int j = 0;
        
        
        while (i < A.length && j < B.length) {

            int start = Math.max(A[i][0], B[j][0]);
            int end = Math.min(A[i][1], B[j][1]);
            
            if (start <= end) result.add(new int[]{start, end});
        
            if (A[i][1] < B[j][1]) {
                i++;
            } else{
                j++;
            }
            
        }
        
        return result.toArray(new int[result.size()][2]);
        
    }
}
