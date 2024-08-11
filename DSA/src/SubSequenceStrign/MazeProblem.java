package SubSequenceStrign;

public class MazeProblem {
    public static void main(String[] args) {
       // System.out.println(count(3,3));
        //pathDiag    ("" , 3 ,3);
        boolean[][] board = {
                {true ,true,true},
                {true,false,false},
                {true , true , true}
        };

        pathwithObstacle("" , board,0 , 0);

    }

    static int count(int row ,int col){
        if(row == 1 || col ==1){
            return 1;
        }

        return count(row-1 , col) + count(row , col-1);
    }

    static void pathDiag(String p , int row , int col){
        if(row ==1 && col == 1){
            System.out.println(p);
            return;
        }

        if(row > 1 && col > 1){
            if( row == col){
                pathDiag(p +'D', row-1 , col-1);
            }

        }

        if(row > 1){
            pathDiag(p +'V', row-1 , col);

        }
        if(col > 1){
            pathDiag(p + 'H' , row ,col-1);

        }


    }


    public static void pathwithObstacle(String p ,boolean[][] maze ,  int col , int row){
        {
            if(row ==maze.length-1 && col == maze[0].length-1){
                System.out.println(p);
                return;
            }

            if(!maze[row][col]){
                return;
            }

            if(row < maze.length-1){
                pathwithObstacle(p +'D',maze, row+1 , col);

            }
            if(col < maze[0].length-1){
                pathwithObstacle(p + 'R' , maze,row ,col+1);

            }


        }
    }
}
