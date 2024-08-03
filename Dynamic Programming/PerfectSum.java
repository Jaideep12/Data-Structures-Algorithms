// Given an array arr of size n of non-negative integers and an integer sum, the task is to count all subsets of the given array with a sum equal to a given sum.

// Note: Answer can be very large, so, output answer modulo 109+7.

class PerfectSum{
	public int perfectSum(int arr[],int n, int sum) 
	{
        return countSubsetsHelper(arr, sum, 0, 0);
	} 
	
	public int countSubsetsHelper(int[] arr, int sum, int currentIndex, int currentSum) {
        // If the current sum is equal to the target sum, return 1 (count this subset)
        if (currentSum == sum) {
            return 1;
        }

        // If we've reached the end of the array, return 0 (no more subsets to explore)
        if (currentIndex == arr.length) {
            return 0;
        }

        // Option 1: Include the current element in the subset
        int includeCurrent = countSubsetsHelper(arr, sum, currentIndex + 1, currentSum + arr[currentIndex]);

        // Option 2: Exclude the current element from the subset
        int excludeCurrent = countSubsetsHelper(arr, sum, currentIndex + 1, currentSum);

        // Return the sum of both options (count of valid subsets)
        return includeCurrent + excludeCurrent;
    }
}
