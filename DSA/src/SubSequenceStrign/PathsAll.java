package SubSequenceStrign;

public class PathsAll {
    public static void main(String[] args) {
        boolean[][] board = {
                {true ,true,true},
                {true,false,false},
                {true , true , true}
        };

        path("" , board,0 , 0);

    }
    public static void path(String p ,boolean[][] maze ,  int col , int row){
        {
            if(row ==maze.length-1 && col == maze[0].length-1){
                System.out.println(p);
                return;
            }

            if(!maze[row][col]){
                return;
            }

            if(row < maze.length-1){
                path(p +'D',maze, row+1 , col);

            }
            if(col < maze[0].length-1){
                path(p + 'R' , maze,row ,col+1);

            }

            if(row > 0){
                path(p + 'U' , maze,row-1 ,col);

            }

            if(col >0){
                path(p + 'L' , maze,row ,col-1);

            }


            //this line is where the function will be ove
            //so before the fucntion is removed we also will remove the changes that we have made
            maze[row][col] = true;

        }
    }

    public static void pathprint(String p ,boolean[][] maze ,  int col , int row , String path , int step){
        {
            if(row ==maze.length-1 && col == maze[0].length-1){
                System.out.println(p);
                return;
            }

            if(!maze[row][col]){
                return;
            }

            if(row < maze.length-1){
                pathprint(p +'D',maze, row+1 , col, path , step+1);

            }
            if(col < maze[0].length-1){
                pathprint(p + 'R' , maze,row ,col+1 , path , step+1);

            }

            if(row > 0){
                pathprint(p + 'U' , maze,row-1 ,col , path , step+1);

            }

            if(col >0){
                pathprint(p + 'L' , maze,row ,col-1, path , step+1);

            }


            //this line is where the function will be ove
            //so before the fucntion is removed we also will remove the changes that we have made
            maze[row][col] = true;

        }
    }
}
