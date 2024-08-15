// Given arrival and departure times of all trains that reach a railway station. Find the minimum number of platforms required for the railway station 
// Consider that all the trains arrive on the same day and leave on the same day. Arrival and departure time can never be the same for a train 
//   but we can have arrival time of one train equal to departure time of the other. At any given instance of time, 
// same platform can not be used for both departure of a train and arrival of another train. In such cases, we need different platforms.

// Input: n = 6, arr[] = {0900, 0940, 0950, 1100, 1500, 1800}, 
//             dep[] = {0910, 1200, 1120, 1130, 1900, 2000}
// Output: 3
// Explanation: There are three trains during the time 0940 to 1200. So we need minimum 3 platforms.

class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr); 
        Arrays.sort(dep); 
  
        int plat_needed = 1, result = 1; 
        int i = 1, j = 0; 
  
        while (i < n && j < n) { 
        
            if (arr[i] <= dep[j]) { 
                plat_needed++; 
                i++; 
            } 
  
            else if (arr[i] > dep[j]) { 
                plat_needed--; 
                j++; 
            } 
  
            if (plat_needed > result) 
                result = plat_needed; 
        } 
  
        return result; 
        
    }
    
}
