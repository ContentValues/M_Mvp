package cn.example.basict.list;

/**
 * Author：created by SugarT
 * Time：2019/11/20 18
 */
public class L_Recursive {

    public static void main(String args[]) {
        System.out.println(tribonacci(25));
    }


    /**
     * 泰波那契序列 Tn 定义如下： 
     *
     * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
     *
     * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：n = 4
     * 输出：4
     * 解释：
     * T_3 = 0 + 1 + 1 = 2
     * T_4 = 1 + 1 + 2 = 4
     * @param n
     * @return
     */
    public static int tribonacci(int n) {
        if(n == 0 ){
             return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        return tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3);
    }
}
