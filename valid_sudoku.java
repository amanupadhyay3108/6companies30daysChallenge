import java.util.*;

public class valid_sudoku {

    public static void main(String[] args) {
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(isValidSudoku(board)); // Output: true or false
    }
      public static boolean isValidSudoku(char[][] board) {
        HashSet<Character>[]row=new HashSet[9];
        HashSet<Character>[]col=new HashSet[9];
        HashSet<Character>[]box=new HashSet[9];
        for(int i=0;i<9;i++){
            row[i]=new HashSet<>();
            col[i]=new HashSet<>();
            box[i]=new HashSet<>();
        }
        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                char ch=board[r][c];
                if(ch=='.')continue;
                if(row[r].contains(ch)){
                    return false;
                }
                row[r].add(ch);
                 if(col[c].contains(ch)){
                    return false;
                }
                col[c].add(ch);
                int boxindex=(r/3)*3+c/3;
                if(box[boxindex].contains(ch)){
                    return false;
                }
                box[boxindex].add(ch);
            }
        }
        return true;
    }
}
