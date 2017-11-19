public class Main {

    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard(8,8);
        chessBoard.constructInitialChessBoard("allPieces");
       ChessGame chessGame = new ChessGame(chessBoard);
       chessGame.startChessGame();

/*
        if(movesValidator.isAValidMove(chessBoard,"b7","b4","black")){
            Pawn.makeOneMove(chessBoard,"b7","b4");
        }
        if(movesValidator.isAValidMove(chessBoard,"b7","b6","black")){
            Pawn.makeOneMove(chessBoard,"b7","b4");
        }
        if(movesValidator.isAValidMove(chessBoard,"d7","d5","black")){
            Pawn.makeOneMove(chessBoard,"d7","d5");
        }

        if(movesValidator.isAValidMove(chessBoard,"e5","e7","black")){
            Pawn.makeOneMove(chessBoard,"e5","e7");
        }
        if(movesValidator.isAValidMove(chessBoard,"e7","e5","while")){
            Pawn.makeOneMove(chessBoard,"e7","e5");
        }

*/

        //WhitePawn.makeOneMove(chessBoard,"a5","b5");
    //    DrawsClass.drawChessBoard(chessBoard);
    }
}
