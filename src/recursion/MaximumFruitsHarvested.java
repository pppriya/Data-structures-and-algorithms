package recursion;

import java.util.HashMap;
import java.util.Map;

public class MaximumFruitsHarvested {
    public static void main(String[] args) {
        int[][] fruits = {{2,8},{6,3},{8,6}};
        int startPos = 5, k =4;
        System.out.println(maxTotalFruits(fruits, startPos, k));
    }
    static int maxHarvest = Integer.MIN_VALUE;
    static int findTotalHarvest(Map<Integer, Integer> position, int startPos, int k, int currHarvest){

        currHarvest += position.getOrDefault(startPos, 0);
        position.remove(startPos);

        if(k <= 0 || startPos < 0){
            maxHarvest = Math.max(maxHarvest, currHarvest);
            return maxHarvest;
        }
        int left = findTotalHarvest(position, startPos-1, k-1, currHarvest);
        int right = findTotalHarvest(position, startPos+1, k-1, currHarvest);
        return Math.max(left, right);

    }
    public static int maxTotalFruits(int[][] fruits, int startPos, int k) {
        Map<Integer,Integer> position = new HashMap<>();
        for(int[] fruit : fruits)
            position.put(fruit[0], fruit[1]);
        return findTotalHarvest(position, startPos, k, 0);
    }
}
