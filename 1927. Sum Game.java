class Solution {
    public boolean sumGame(String num) {
        int n = num.length();

        int sum1 = 0, sum2 = 0;
        int q1 = 0, q2 = 0;

        for (int i = 0; i < n / 2; i++) {
            if (num.charAt(i) == '?')
                q1++;
            else
                sum1 += num.charAt(i) - '0';
        }

        for (int i = n / 2; i < n; i++) {
            if (num.charAt(i) == '?')
                q2++;
            else
                sum2 += num.charAt(i) - '0';
        }

        // Odd number of '?' -> Alice wins
        if ((q1 + q2) % 2 == 1)
            return true;

        double diff = sum1 - sum2;
        double qDiff = (q2 - q1) * 9.0 / 2;

        return diff != qDiff;
    }
}