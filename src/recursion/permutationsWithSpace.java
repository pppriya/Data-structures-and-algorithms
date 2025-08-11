package recursion;

import java.util.ArrayList;
import java.util.List;

public class permutationsWithSpace {
    public static void main(String[] args) {
        boolean chcek = reorderedPowerOf2(1234);
    }
    public static void allCombinations(List<Integer>digits, int[] track, List<Integer>curr){
        if(curr.size() == digits.size()){
            System.out.println(curr);
            return;
        }

        for(int i=0; i<digits.size(); i++){
            if(track[i] == 0){
                track[i] = 1;
                curr.add(digits.get(i));
                allCombinations(digits, track, curr);
                curr.remove(curr.size()-1);
                track[i] = 0;
            }
        }
    }
    public static  boolean reorderedPowerOf2(int n) {
        List<Integer> digits = new ArrayList<>();
        while(n>0) {
            digits.add(n % 10);
            n = n / 10;
        }
        int[] track = new int[digits.size()];
        List<Integer> curr = new ArrayList<>();
        allCombinations(digits, track, curr);
        return true;
    }
}
