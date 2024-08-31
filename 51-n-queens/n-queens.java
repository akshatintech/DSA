class Solution {

    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        if(n ==0 ){
            return result;
        }


        //Creating the board for the answer
        List<String> board = new ArrayList<>();     //For n =3 {"..." , "..." , "..."} intially

        for(int i = 0; i< n ; i++){
            StringBuilder row = new StringBuilder();

            for(int j = 0; j < n ; j++){
                row.append('.');
            }
            board.add(row.toString());
        }

        solve(board ,0);

        return result;
        
    }


    private void solve(List<String> board , int row){

        if(row == board.size()){
            result.add(new ArrayList<>(board));
            return ;
        }


        //Place one queen at every row and then check before placing
        // in every direction there is a risk of being attacked
        // ie. up , diagonally
        // top to bottom row , we need to check before if we put a queen
        // vertically up in some row or diagonally upwards in some row


        for(int i = 0; i< board.size();i++){

            if(isValid(board , row , i)){
                StringBuilder newRow =  new StringBuilder(board.get(row));
                newRow.setCharAt(i , 'Q');
                board.set(row , newRow.toString());

                solve(board , row+1);


                newRow.setCharAt(i , '.');
                board.set(row , newRow.toString());

    
            }
        }
    }


    private boolean isValid(List<String> board , int row , int col){

        //Look For Up
        for(int i = row ; i >=0; i--){
            if(board.get(i).charAt(col) == 'Q'){
                return false;
            }
        }

        //Check the left Diagonals
        for(int i = row , j = col ; i>=0 && j >= 0; i--, j-- ){
            if(board.get(i).charAt(j) == 'Q'){
                return false;
            }
        }

        //Check For Right Diagonals
        for(int i = row , j = col ; i >=0 && j < board.size() ; i--, j++){
            if(board.get(i).charAt(j) == 'Q'){
                return false;
            }
        }

        return true;


    }
}