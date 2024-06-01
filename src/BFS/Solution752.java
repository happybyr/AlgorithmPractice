package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution752 {
    // 单向bfs
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>();
        for(String s : deadends){
            deadSet.add(s);
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int depth = 0;
        queue.offer("0000");
        visited.add("0000");
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0 ; i<size ; i++){
                String str = queue.poll();
                if(deadSet.contains(str)){
                    continue;
                }
                if(target.equals(str)){
                    return depth;
                }
                for(int j=0 ; j<=3 ; j++){
                    String upStr = changeUp(str, j);
                    if(!visited.contains(upStr)){
                        queue.add(upStr);
                        visited.add(upStr);
                    }
                    String downStr = changeDown(str, j);
                    if(!visited.contains(downStr)){
                        queue.add(downStr);
                        visited.add(downStr);
                    }
                }
            }
            depth++;
        }
        return -1;
    }

    private String changeUp(String str , int i){
        char[] arr = str.toCharArray();
        if(arr[i] == '9'){
            arr[i] = '0';
        }else{
            arr[i] = (char)(arr[i]+1);
        }
        return new String(arr);
    }

    private String changeDown(String str , int i){
        char[] arr = str.toCharArray();
        if(arr[i] == '0'){
            arr[i] = '9';
        }else{
            arr[i] = (char)(arr[i]-1);
        }
        return new String(arr);
    }


    /**
     * 打开转盘锁
     * 思路：双向 BFS
     * 将密码锁当作图，每个节点有 8 个相邻的节点，求最短距离
     *
     * @param deadends 死亡密码
     * @param target   目标密码
     * @return 从 "0000" -> target 经过的最短步数
     */
    public static int openLock2(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for (String s : deadends) {
            deads.add(s);
        }
        // 用集合不用队列，可以快速判断元素是否存在
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        Set<String> visited = new HashSet<>();

        int step = 0;
        q1.add("0000");
        q2.add(target);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            // 哈希集合在遍历的过程中不能修改，用 temp 存储扩散结果
            Set<String> temp = new HashSet<>();

            /* 将 q1 中的所有节点向周围扩散 */
            for (String cur : q1) {
                /* 判断是否到达终点 */
                if (deads.contains(cur)) {
                    continue;
                }
                if (q2.contains(cur)) {
                    return step;
                }
                visited.add(cur);

                /* 将一个节点的未遍历相邻节点加入集合 */
                for (int j = 0; j < 4; j++) {
                    String up = upOne(cur, j);
                    if (!visited.contains(up)) {
                        temp.add(up);
                    }
                    String down = downOne(cur, j);
                    if (!visited.contains(down)) {
                        temp.add(down);
                    }
                }
            }
            /* 在这里增加步数 */
            step++;
            // temp 相当于 q1
            // 这里交换 q1 q2，下一轮 while 就是扩散 q2
            q1 = q2;
            q2 = temp;
        }
        return -1;
    }

    /**
     * 将 s[idx] 向上拨动一次
     *
     * @param s   字符串：表示当前的密码
     * @param idx 字符串的索引：表示当前密码的第 idx 个字符
     * @return 将 s[idx] 向上拨动一次的密码
     */
    public static String upOne(String s, int idx) {
        char[] ch = s.toCharArray();
        if (ch[idx] == '9') {
            ch[idx] = '0';
        } else {
            ch[idx] += 1;
        }
        return new String(ch);
    }

    /**
     * 将 s[idx] 向下拨动一次
     *
     * @param s   字符串：表示当前的密码
     * @param idx 字符串的索引：表示当前密码的第 idx 个字符
     * @return 将 s[idx] 向下拨动一次的密码
     */
    public static String downOne(String s, int idx) {
        char[] ch = s.toCharArray();
        if (ch[idx] == '0') {
            ch[idx] = '9';
        } else {
            ch[idx] -= 1;
        }
        return new String(ch);
    }
}
