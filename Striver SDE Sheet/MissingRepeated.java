class Solve {
    int[] findTwoElement(int a[]) {
        long n = a.length; // size of the array

        // Calculate the expected sum and sum of squares
        long SN = (n * (n + 1)) / 2; // Sum of first n natural numbers
        long S2N = (n * (n + 1) * (2 * n + 1)) / 6; // Sum of squares of first n natural numbers

        // Calculate the actual sum and sum of squares from the given array
        long S = 0, S2 = 0;
        for (int i = 0; i < n; i++) {
            S += a[i];
            S2 += (long)a[i] * (long)a[i];
        }

        // Calculate the differences
        long val1 = S - SN; // This is X - Y
        long val2 = S2 - S2N; // This is X^2 - Y^2

        // Determine X + Y from (X^2 - Y^2) / (X - Y)
        val2 = val2 / val1;

        // Find X and Y
        long x = (val1 + val2) / 2; // X = (X + Y + X - Y) / 2
        long y = x - val1; // Y = X - (X - Y)

        // Return the result as an array of two integers
        int[] ans = {(int)x, (int)y};
        return ans;
    }
}
