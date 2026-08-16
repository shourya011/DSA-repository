class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int sum = 0;
        int step = 0;
        for(int i=0;i<requests.length;i++){
            sum += Math.abs(step-requests[i]);
            step = requests[i];
        }
        return sum;
    }
}


//4020. Elevator Requests I