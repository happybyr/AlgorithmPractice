package Floyd算法;

import java.util.ArrayList;
import java.util.List;

//Floyd算法是一种“多源”最短路径算法，一次计算能得到图中每一对结点之间（多对多）的最短路径。后面要介绍的Dijkstra、Bellman-Ford、SPFA都是“单源”最短路径算法，一次计算能得到一个起点到其他所有点（一对多）的最短路径。
//状态dp[k][i][j]表示在包含1～k点的子图上，点对i、j之间的最短路径。当从子图1～k−1扩展到子图1～k时
//dp[k][i][j] = min(dp[k−1][i][j], dp[k−1][i][k] + dp[k−1][k][j])
//o(n^3)

class Solution1462 {
    // 1462. 课程表 IV
    //https://leetcode.cn/problems/course-schedule-iv/solutions/2438246/python3javacgotypescript-yi-ti-shuang-ji-0rmo/?envType=daily-question&envId=2023-09-12
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] dp = new boolean[numCourses][numCourses];
        for(int[] arr : prerequisites){
            dp[arr[0]][arr[1]] = true;
        }
        for(int k = 0 ; k<numCourses ; k++){
            for(int i=0 ; i<numCourses ; i++){
                for(int j=0 ; j<numCourses ; j++){
                    dp[i][j] |= (dp[i][k] && dp[k][j]);
                }
            }
        }
        List<Boolean> res = new ArrayList<>();
        for(int[] query : queries) {
            res.add(dp[query[0]][query[1]]);
        }

        return res;
    }

    // 《程序设计竞赛》例题10-2.蓝桥公园
    // 略


}