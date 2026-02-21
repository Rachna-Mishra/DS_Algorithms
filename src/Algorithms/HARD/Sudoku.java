package Algorithms.HARD;

class Sudoku {
    public void solveSudoku(int[][] mat) {
        // code here
        fillSudoku(mat, 0, 0);
    }
    public boolean fillSudoku(int[][] mat, int row, int col){
        int newRow = 0;
        int newCol = 0;
        if(row == mat.length){
            return true;
        }
        if(col != mat[0].length-1){
            newRow = row;
            newCol = col + 1;
        }
        else{
            newRow = row+1;
            newCol = 0;
        }
        if(mat[row][col] != 0){
            return fillSudoku(mat, newRow, newCol);
        }
        for(int i = 1; i<=9; i++){
            if(isValid(mat, row, col, i)){
                mat[row][col] = i;
                if(fillSudoku(mat, newRow, newCol)){
                    return true;
                }
                else{
                    mat[row][col] = 0;
                }
            }
        }
        return false;
    }

    public boolean isValid(int[][] mat, int r, int c, int number){
        for(int i = 0; i < 9; i++){
            if(mat[r][i]==number){
                return false;
            }
            if(mat[i][c] == number){
                return false;
            }
        }
        int startRow = (r/3)*3;
        int startCol = (c/3)*3;
        for(int i  = startRow; i<startRow+3; i++ ){
            for(int j  = startCol; j<startCol+3; j++){
                if(mat[i][j] == number){
                    return false;
                }
            }
        }
        return true;
    }
}
