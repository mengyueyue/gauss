package test.数学.middle;

/**
 * Created by mengyue on 2019/3/1.
 */
public class 汉诺塔 {


    public void hanoi(int n, char A, char B, char C) {
        if (n == 1) {
            move(A, C);
        } else {
            hanoi(n - 1, A, C, B);//步骤1 按ACB数序执行N-1的汉诺塔移动
            move(A, C);             //步骤2   执行最大盘子移动
            hanoi(n - 1, B, A, C);//步骤3 按BAC数序执行N-1的汉诺塔移动
        }
    }

    private void move(char A, char C) {//执行最大盘子的从A-C的移动
        System.out.println("move:" + A + "--->" + C);
    }

    public static void main(String[] args) {
        汉诺塔 hanoi = new 汉诺塔();
        System.out.println("移动汉诺塔的步骤：");
        hanoi.hanoi(64, 'a', 'b', 'c');
        System.out.println("done");
    }
}

