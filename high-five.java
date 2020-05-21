/**
Leetcode 1086 - High Five

This solution utilizes a TreeMap to maintain ordering amongst keys, and a priorityQueue to extract the 5 largest elements for each key
*/
class Solution {
    public int[][] highFive(int[][] items) {
        // use minheap and if size is larger than 5 remove
        
        TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
        
        for (int i = 0; i < items.length; i++) {
            if (map.get(items[i][0]) == null) {
                map.put(items[i][0], new PriorityQueue<Integer>());
            }
            
            map.get(items[i][0]).add(items[i][1]);
            
            if (map.get(items[i][0]).size() > 5) {
                map.get(items[i][0]).remove();
            }
        }
        int[][] result = new int[map.entrySet().size()][2];
        
        int i = 0;
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            result[i][0] = entry.getKey();
            int mean = 0;
            while (entry.getValue().size() != 0) {
                mean += entry.getValue().remove();
            }
            
            result[i++][1] = mean / 5;
        }
        return result;
    }
}
