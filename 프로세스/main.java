import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++) {
            q.add(i);
        }
        while(!q.isEmpty()) {
            answer++;
            int priority = 0;
            for(int temp : q) {
                priority = Math.max(priority, priorities[temp]);
            }
            int idx = -1;
            while(true) {
                idx = q.poll();
                if(priorities[idx] == priority) {
                    break;
                }
                q.add(idx);
            }
            if(idx == location)
                return answer;
        }
        return -1;
    }
}