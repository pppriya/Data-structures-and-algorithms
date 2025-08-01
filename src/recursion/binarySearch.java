package recursion;

public class binarySearch {
    public static void main(String[] args) {
        int[] arr = {1,5,7,19,33,263,453,983};
        int target = 7;
        System.out.println(searchElement(arr, target, 0, arr.length-1));
    }

    public static int searchElement(int[] arr, int target, int start, int end){
        if(start >  end)return -1;
        int mid = (end+start)/2;
        if(arr[mid] == target)return mid;
        if(target < arr[mid])
            return searchElement(arr, target, start, mid-1);
        return searchElement(arr, target, mid+1, end);
    }
}
