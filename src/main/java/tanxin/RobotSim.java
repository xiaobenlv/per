package tanxin;

import java.util.*;

public class RobotSim {
    public int robotSim(int[] commands, int[][] obstacles) {
//
//        int[][] dx={{0,1},{1,0},{0,-1},{-1,0}};
//        int p=0;
//        int q=0;
//        int max=0;
//        Map<String,Boolean> map=new HashMap();
////        1.先将 障碍都存入到map中，然后可以 利用map.contain这个方法，在确定走的时候，看这条路上是否有障碍物
////        2.遍历commands，如果是-1、-2 改变方向 方向变量的存储 有技巧
//
//        for (int i=0;i<obstacles.length;i++){
//            map.put(obstacles[i][0]+","+obstacles[i][1],true);
//        }
//        int k=0;
//        for (int command:commands){
//            if (command==-1){
////                用一个中间量k（即对于dx方向数组的系数，）
//                k=(k+1)%4;
//            }else if (command==-2){
//                k=(k+4-1)%4;
//            }else {
////               定义数组，分别存横、纵 的1，0 ；1就走，0就不走，每一步每一步因为中间判断是否有障碍物
//                int cur[]=dx[k];
//                for (int i=0;i<command;i++){
//                    if (map.containsKey((p+cur[0])+","+q+cur[1])){
//                        break;
//                    }
//                    p+=cur[0];
//                    q+=cur[1];
//                }
//
//                max=Math.max(max,p*p+q*q);
//
//
//            }
//        }
        int max = 0;
        int[][] dx = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int k = 0;
        Map<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < obstacles.length; i++) {
            map.put(obstacles[i][0] + "," + obstacles[i][1], true);
        }
        int p = 0, q = 0;
        for (int command : commands) {
            if (command == -1) {
                k = (k + 1) % 4;
            } else if (command == -2) {
                k = (k + 4 - 1) % 4;
            } else {
                int cur[] = dx[k];
                for (int i = 0; i < command; i++) {
//                    因为 比如确定向上走，需要判断 纵轴上的点 是都有障碍，（在command之间），如果有break（停留在之前的点），如果没有循环了command次，已经走到目的地
                    if (map.containsKey((p + cur[0]) + "," + (q + cur[1]))) {
                        break;
                    }
                    p += cur[0];
                    q += cur[1];
                }
                max = Math.max(max, p * p + q * q);
            }
        }
        return max;
    }

    public static void main(String[] args) {

        int[] commands={4,-1,4,-2,4};
        int[][] obstacles={{2,4}};
        RobotSim robotSim=new RobotSim();
        int max=robotSim.robotSim(commands,obstacles);
        System.out.println(max);

    }

}
