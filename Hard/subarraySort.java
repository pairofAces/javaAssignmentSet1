// Subarray sort

// import java.util.*;

// Complexity Analysis
    // Time: O(n) time, where (n) is the size of the input array

    // Space: O(1) constant space, due to no usage of external data structures

class Program {
    public static int[] subarraySort(int[] array) {
        // create two variables to represent the max and min
        int minOutOfOrder = Integer.MAX_VALUE;
        int maxOutOfOrder = Integer.MIN_VALUE;

        // initiate for loop to traverse the input array
        for(int i = 0; i < array.length; i++) {
            // create a variable to represent the current element during
            // the traversal
            int num = array[i];

            // create an if statement that will use a helper method
                // helper method will compare the inputs and return a boolean
            if (isOutOfOrder(i, num, array)) {
                minOutOfOrder = Math.min(minOutOfOrder, num);
                maxOutOfOrder = Math.max(maxOutOfOrder, num);
            }
        }

        if (minOutOfOrder == Integer.MAX_VALUE) {
                return new int[] {-1, -1};
            }

        // create an index variable to initiate at 0
        int subarrayLeftIndex = 0;

        // create a while loop to check if the element at
        // the index of (subarrayLeftIndex) is less than or
        // equal to the value of (minOutOfOrder)
        while (minOutOfOrder >= array[subarrayLeftIndex]) {
            // increment the left index variable
            subarrayLeftIndex++;
        }

        // create the index variable to start at the ending of the
        // array
        int subarrayRightIndex = array.length - 1;

        // create a while loop to check if the element at the index
        // of (subarrayRightIndex) is greater than or equal to
        // the value of (maxOutOfOrder)
        while (maxOutOfOrder >= array[subarrayRightIndex]) {
            subarrayRightIndex--;
        }

        // return a new array of the values of the index variables
        return new int[] {subarrayLeftIndex, subarrayRightIndex};
    }

    // create helper method
    public static boolean isOutOfOrder(int i, int num, int[] array) {
        // create if logic to check if the (i) input is equal to either
        // the starting or ending index of the input (array)
        if (i == 0) {
            // return the boolean of the result of checking if the 
            // input (num) is greater than the element
            // in (array) at the index of (i + 1)
            return num > array[i  + 1];
        }

        if (i == array.length - 1) {
            // return the boolean of the result of checking if the 
            // input (num) is less than the element
            // in (array) at the index of (i - 1)
            return num < array[i - 1];
        }

        return num > array[i + 1] || num < array[i - 1];
    }
}