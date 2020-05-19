package test.回溯算法.middle;

import java.util.Arrays;

/**
 * Created by mengyue on 2019-11-12.
 */
public class 单词搜索_79 {


    public static void main(String[] args) {

        System.out.println(Arrays.deepToString(direction));

    }

    /**
     *
     *                 (x-1,y)
     *
     *     (x,y-1)      (x,y)       (x,y+1)
     *
     *                 (x+1,y)
     *
     */
    private static int [][] direction = {
            {-1,0} , {0,-1}
            ,{0,1} ,{1,0}
    };// 这个顺序无所谓啦

    private static int x ,y ;

    private static boolean [] [] marked;

    private static char[][] new_board;

    private static String new_word;


    public static boolean exist(char[][] board, String word) {

        x = board.length;

        if(x == 0){
            return false;
        }

        y = board[0].length;

        new_board = board;

        marked = new boolean[x][y];

        new_word = word;

        for (int i = 0; i < x ; i++) {
            for (int j = 0; j < y; j++) {
                if(dfs(i ,j , 0)){
                    return true;
                }
            }
        }

        return false;

    }


    public static boolean dfs(int i , int j , int start){

        if(start == new_word.length() -1){
            return new_board[i][j] == new_word.charAt(start);
        }

        if (new_board[i][j] == new_word.charAt(start)){

            marked[i][j] = true;

            for (int k = 0; k < 4; k++) {

                int newX = i + direction[k][0];
                int newY = j + direction[k][1];

                if(isArea(newX , newY) && !marked[newX][newY]){

                    if(dfs(newX , newY  , start + 1)){
                        return true;
                    }
                }
            }

            marked[i][j] = false;
        }
        return false;
    }

    private static boolean isArea( int i , int j ){

        return i >= 0 && x > i && j >= 0 && y > j;

    }

}
