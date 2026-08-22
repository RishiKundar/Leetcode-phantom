class Solution {
    public int[] sortedSquares(int[] main_arr) {
        int pos_count = 0;
        int neg_count = 0;
        int[] result = new int[main_arr.length];
        for(int num : main_arr){
            if(num >= 0){
                pos_count++;
            }else{
                neg_count++;
            }
        }

        int[] pos_arr = new int[pos_count]; // Postive Array
        int[] neg_arr = new int[neg_count]; // Negative Array

        int p = 0;
        int n = 0;
        for (int num : main_arr) {
            if (num < 0)
                neg_arr[n++] = num;
            else
                pos_arr[p++] = num;
        }

        if(pos_arr.length == 0){ // if only negative elements are present
            squareArr(neg_arr);
            reverseArr(neg_arr);
            return neg_arr;
        }

        if(neg_arr.length == 0){ // if only positive elements are present
            squareArr(pos_arr);
            return pos_arr;
        }

        squareArr(pos_arr); // Positive Square Arr
        squareArr(neg_arr); // Negative Square Arr
        reverseArr(neg_arr); // Reverse Array

        result = mergeTwoSortedArray(pos_arr,neg_arr);
        return result;
        
    }

    private static int[] mergeTwoSortedArray(int[] poss_arr, int[] neg_arr){
        int p_length = poss_arr.length;
        int n_length = neg_arr.length;
        int[] result_arr = new int[p_length + n_length];

        int i = 0; // Positive Array
        int j = 0; // Negative Array
        int idx = 0; // Result Index

        while (i < p_length && j < n_length){
            if(poss_arr[i] < neg_arr[j]){
                result_arr[idx] = poss_arr[i];
                i++;
                idx++;
            }else{
                result_arr[idx] = neg_arr[j];
                j++;
                idx++;
            }
        }

        while(i < p_length){
            result_arr[idx] = poss_arr[i];
            i++;
            idx++;
        }

        while(j < n_length){
            result_arr[idx] = neg_arr[j];
            j++;
            idx++;
        }

        return result_arr;
    }

    private static void squareArr(int[] arr){
        for(int i = 0; i <= arr.length - 1; i++){
            arr[i] = arr[i] * arr[i];
        }
    }

    private static void reverseArr(int[] arr){
        int i = 0;
        int j = arr.length-1;

        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}