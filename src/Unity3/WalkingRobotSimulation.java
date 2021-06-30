/**
 * 机器人在一个无限大小的 XY 网格平面上行走，从点(0, 0) 处开始出发，面向北方。
 * 该机器人可以接收以下三种类型的命令 commands ：
 *
 * -2 ：向左转90 度
 * -1 ：向右转 90 度
 * 1 <= x <= 9 ：向前移动x个单位长度
 * 在网格上有一些格子被视为障碍物obstacles 。
 * 第 i个障碍物位于网格点 obstacles[i] = (xi, yi) 。
 *
 * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续尝试进行该路线的其余部分。
 *
 * 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。（即，如果距离为 5 ，则返回 25 ）
 *
 * 注意：
 *
 * 北表示 +Y 方向。
 * 东表示 +X 方向。
 * 南表示 -Y 方向。
 * 西表示 -X 方向。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/walking-robot-simulation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

package Unity3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WalkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        Map map = new HashMap();
        int[] local = new int[]{0,0}; // local[0]表示x轴  local[1]表示y轴

        List list = new LinkedList();
        // 存放障碍点，便于快速查找
        for (int i = 0 ;i<obstacles.length;i++){
            map.put(obstacles[i],i);
        }

        return 0;
    }
}
