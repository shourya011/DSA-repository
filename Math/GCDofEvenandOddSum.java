class Solution {
    public int gcdOfOddEvenSums(int n) {
        int evenSum = 0;
        for(int i=1;i<=n;i++){
            evenSum += (2*i);
        }
        int oddSum = 1;
        for(int i=1;i<n;i++){
            oddSum += (2*i)+1;
        }
        return findGCD(evenSum,oddSum);
    }
    public static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }
}