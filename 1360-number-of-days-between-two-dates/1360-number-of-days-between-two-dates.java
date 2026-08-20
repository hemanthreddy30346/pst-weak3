class Solution {
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(days(date1) - days(date2));
    }

    int days(String s) {
        int y = Integer.parseInt(s.substring(0, 4));
        int m = Integer.parseInt(s.substring(5, 7));
        int d = Integer.parseInt(s.substring(8));

        int[] a = {31,28,31,30,31,30,31,31,30,31,30,31};

        int ans = d;

        for (int i = 1971; i < y; i++)
            ans += (i % 4 == 0 && (i % 100 != 0 || i % 400 == 0)) ? 366 : 365;

        for (int i = 0; i < m - 1; i++)
            ans += a[i];

        if (m > 2 && y % 4 == 0 && (y % 100 != 0 || y % 400 == 0))
            ans++;

        return ans;
    }
}