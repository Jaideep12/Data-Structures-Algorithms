// Geek is going for a training program. He can perform any of these activities: Running, Fighting, and Learning Practice. 
// Each activity has some point on each day. As Geek wants to improve all his skills, he can't do the same activity on two consecutive days. 
// Help Geek to maximize his merit points as you are given a 2D array of points arr, corresponding to each day and activity.

// Example:
// Input: n=3 and arr[]= [[1,2,5],[3,1,1],[3,3,3]]
// Output:11
// Explanation:Geek will learn a new move and earn 5 point then on second day he will do running and earn 3 point and on third day he will do fighting 
// and earn 3 points so, maximum point is 11.

class GeekTraining {
    public int maximumPoints(int arr[][], int n) {
                // Initialize a memoization table with -1 values
        int dp[][] = new int[n][4];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        // Start the recursive calculation from the last day (n - 1) with the last activity (3)
        return f(n - 1, 3, arr, dp);
    }
    
    static int f(int day, int last, int[][] points, int[][] dp) {
        // If the result is already calculated, return it
        if (dp[day][last] != -1) return dp[day][last];

        // Base case: When it's the first day (day == 0)
        if (day == 0) {
            int maxi = 0;
            for (int i = 0; i <= 2; i++) {
                if (i != last)
                    maxi = Math.max(maxi, points[0][i]);
            }
            return dp[day][last] = maxi; // Store and return the result
        }

        int maxi = 0;
        // Loop through the three activities on the current day
        for (int i = 0; i <= 2; i++) {
            if (i != last) {
                // Calculate the points for the current activity and recursively
                // calculate the maximum points for the previous day
                int activity = points[day][i] + f(day - 1, i, points, dp);
                maxi = Math.max(maxi, activity); // Update the maximum points
            }
        }

        return dp[day][last] = maxi; // Store and return the result
    }
}
