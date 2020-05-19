package self.search;

import java.util.Arrays;

public class 背包问题 {


    public static void main(String[] var0) {
        int[] var1 = new int[]{3, 4, 5, 6};
        int[] var2 = new int[]{2, 3, 4, 5};
        byte var3 = 8;
        System.out.println(Arrays.deepToString(knapsack01(var1, var2, var3)));
    }

    public static int[][] knapsack01(int[] var0, int[] var1, int var2) {
        int[][] var3 = new int[var0.length + 1][var2 + 1];

        int var4;
        for(var4 = 0; var4 < var2 + 1; ++var4) {
            var3[0][var4] = 0;
        }

        for(var4 = 0; var4 < var0.length + 1; ++var4) {
            var3[var4][0] = 0;
        }

        for(var4 = 1; var4 <= var0.length; ++var4) {
            for(int var5 = 1; var5 <= var2; ++var5) {
                if (var5 < var1[var4 - 1]) {
                    var3[var4][var5] = var3[var4 - 1][var5];
                } else {
                    var3[var4][var5] = Math.max(var0[var4 - 1] + var3[var4 - 1][var5 - var1[var4 - 1]], var3[var4 - 1][var5]);
                }
            }
        }

        return var3;
    }

    public static int knapsack(int[] var0, int[] var1, int var2) {
        int var3 = var1.length;
        int[][] var4 = new int[var3 + 1][var2 + 1];

        int var5;
        for(var5 = 0; var5 <= var2; ++var5) {
            var4[0][var5] = 0;
        }

        for(var5 = 0; var5 <= var3; ++var5) {
            var4[var5][0] = 0;
        }

        int var6;
        for(var5 = 1; var5 <= var3; ++var5) {
            for(var6 = 1; var6 <= var2; ++var6) {
                if (var1[var5 - 1] <= var6) {
                    var4[var5][var6] = Math.max(var0[var5 - 1] + var4[var5 - 1][var6 - var1[var5 - 1]], var4[var5 - 1][var6]);
                } else {
                    var4[var5][var6] = var4[var5 - 1][var6];
                }
            }
        }

        int[][] var13 = var4;
        var6 = var4.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            int[] var8 = var13[var7];
            int[] var9 = var8;
            int var10 = var8.length;

            for(int var11 = 0; var11 < var10; ++var11) {
                int var12 = var9[var11];
                System.out.format("%5d", var12);
            }

            System.out.println();
        }

        return var4[var3][var2];
    }
}
