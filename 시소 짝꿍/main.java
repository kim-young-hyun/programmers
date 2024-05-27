class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        long[] count = new long[2001];
        for(int temp : weights) {
            count[temp]++;
        }
        for(int i = 100; i <= 1000; i++) {
            if(count[i] == 0)
                continue;
            long temp = count[i] - 1 + count[i * 2];
            if(i % 2 == 0) {
                temp += count[i / 2];
                temp += count[i * 3 / 2];
            }
            if(i % 3 == 0) {
                temp += count[i * 2 / 3];
                temp += count[i * 4 / 3];
            }
            if(i % 4 == 0) {
                temp += count[i * 3 / 4];
            }
            answer += temp * count[i];
        }
        return answer / 2;
    }
}