class Solution {
    public int calculateHours(int[] piles, int rate){
        int hours = 0;
        for(int i = 0; i < piles.length; i++){
            int h = piles[i] / rate;
            int mod = piles[i] % rate;
            hours+= mod != 0 ? h + 1: h;
        }
        return hours;
    }

    public int findOptimalRate(int[] piles, int targetHours, int maxBananas){
        int l = 1, r = maxBananas;
        int res = 0;
        while(l <= r){
            int m = (l + r)/ 2;
            int h = calculateHours(piles, m);
            System.out.println("Rate: " + m + " Hours: " + h);
            if(h <= targetHours){
                res = m;
                r = m - 1;
            }else {
                l = m + 1;
            }
        }
        return res;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int maxBananas = 0;
        for(int i = 0; i < piles.length; i++){
            maxBananas = Math.max(maxBananas, piles[i]);
        }
        return findOptimalRate(piles, h, maxBananas);
    }
}
