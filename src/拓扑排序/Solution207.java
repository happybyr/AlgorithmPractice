package 拓扑排序;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution207 {
    // 207. 课程表
    // https://leetcode.cn/problems/course-schedule/solutions/250377/bao-mu-shi-ti-jie-shou-ba-shou-da-tong-tuo-bu-pai-/?envType=daily-question&envId=2023-09-09
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> next = new ArrayList<>();
        for(int i=0 ; i<numCourses ; i++){
            next.add(new ArrayList<>());
        }
        for(int[] ele : prerequisites) {
            inDegree[ele[0]]++;
            next.get(ele[1]).add(ele[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0 ; i<numCourses ; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }

        int count = 0;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            count++;
            List<Integer> curNext = next.get(cur);
            for(int i : curNext){
                inDegree[i]--;
                if(inDegree[i] == 0){
                    queue.add(i);
                }
            }
        }
        return count == numCourses;
    }

     public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}