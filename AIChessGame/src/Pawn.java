public abstract class Pawn extends Piece {

    public static void makeOneMove(ChessBoard chessBoard, String initialState, String finalState) {
        int col = initialState.charAt(0) - 'a' + 1;
        int row =   initialState.charAt(1) - '0';
        char pawn = chessBoard.getChessBoard()[row][col];
       // System.out.println(col + " " + row);
        chessBoard.getChessBoard()[row][col] = '\0';

         col = finalState.charAt(0) - 'a' + 1;
         row =   finalState.charAt(1) - '0';
        chessBoard.getChessBoard()[row][col] = pawn;
    }
}

