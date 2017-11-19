public class DrawsClass {

    public static void drawChessBoard(ChessBoard chessBoard) {
        for (int i = 0; i <= chessBoard.getRows(); i++) {
            for (int j = 0; j <= chessBoard.getRows(); j++) {
                System.out.print(" ");
                System.out.print(chessBoard.getChessBoard()[i][j]);

                if (chessBoard.getChessBoard()[i][j] == '\0') {
                    System.out.print(" ");
                }
                if (i != 0) {
                    System.out.print(" |");
                } else {
                    System.out.print("  ");
                }
            }

            System.out.println();
        }
    }
}
