package org.consistent.practice.dsa.day5;

public class CorporateFlightBooking {
    public static void main(String[] args) {
        CorporateFlightBooking cfb = new CorporateFlightBooking();
        int[][] bookings = new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int n = 5;
        int[] result = cfb.corpFlightBookings(bookings, n);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int[] booking : bookings) {
            ans[booking[0]-1] += booking[2];
            if (booking[1] < n) {
                ans[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i] + ans[i-1];
        }
        return ans;
    }
}
