package Arrays;

import java.util.HashMap;
import java.util.HashSet;

//You are given a a 9 x 9 Sudoku board board. A Sudoku board is valid if the following rules are followed:
//
//Each row must contain the digits 1-9 without duplicates.
//Each column must contain the digits 1-9 without duplicates.
//Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without duplicates.
//Return true if the Sudoku board is valid, otherwise return false
//
//Note: A board does not need to be full or be solvable to be valid.
//
//Example 1:
//
//
//
//Input: board = 
//[["1","2",".",".","3",".",".",".","."],
// ["4",".",".","5",".",".",".",".","."],
// [".","9","8",".",".",".",".",".","3"],
// ["5",".",".",".","6",".",".",".","4"],
// [".",".",".","8",".","3",".",".","5"],
// ["7",".",".",".","2",".",".",".","6"],
// [".",".",".",".",".",".","2",".","."],
// [".",".",".","4","1","9",".",".","8"],
// [".",".",".",".","8",".",".","7","9"]]
//
//Output: true
//Example 2:
//
//Input: board = 
//[["1","2",".",".","3",".",".",".","."],
// ["4",".",".","5",".",".",".",".","."],
// [".","9","1",".",".",".",".",".","3"],
// ["5",".",".",".","6",".",".",".","4"],
// [".",".",".","8",".","3",".",".","5"],
// ["7",".",".",".","2",".",".",".","6"],
// [".",".",".",".",".",".","2",".","."],
// [".",".",".","4","1","9",".",".","8"],
// [".",".",".",".","8",".",".","7","9"]]
//
//Output: false
public class ValidSudoku {
	  public boolean isValidSudoku(char[][] board) {
          HashMap<Integer, HashSet<Character>> rows = new HashMap(); 
          HashMap<Integer, HashSet<Character>> cols = new HashMap(); 
         HashMap<String, HashSet<Character>> squares = new HashMap(); 
         for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j< board.length ; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                String keyForSquare = i/3 + "," + j/3;  
               if(rows.computeIfAbsent(i, k-> new HashSet<>() ).contains(board[i][j]) 
               || cols.computeIfAbsent(j, k-> new HashSet<>() ).contains(board[i][j])
               || squares.computeIfAbsent(keyForSquare, k-> new HashSet<>() ).contains(board[i][j])){
                return false;
               } 
               rows.get(i).add(board[i][j]); 
                cols.get(j).add(board[i][j]); 
                squares.get(keyForSquare).add(board[i][j]); 

            }
         }
         return true;
    }
}
