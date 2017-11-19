public class ChessBoard {

    private int rows;
    private int columns;
    private char chessBoard[][];

    public ChessBoard(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        chessBoard = new char[rows + 2][columns + 2];
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public char[][] getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(char[][] chessBoard) {
        this.chessBoard = chessBoard;
    }


    public void constructInitialChessBoard(String initialPiecesOnBoard) {
        if (initialPiecesOnBoard.equals("allPieces") || initialPiecesOnBoard == null) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (i == 0) {
                        chessBoard[i][j + 1] = (char) (j + 97);
                    }
                    if (j == 0) {
                        chessBoard[i + 1][j] = (char) (i + 49);
                    }
                    if (i == 2) {
                        chessBoard[i][j + 1] = WhitePawn.draw();
                    }
                    if (i == rows - 2) {
                        chessBoard[i + 1][j + 1] = BlackPawn.draw();
                    }
                }
            }
        }
    }

    public int getNumberOfWhitePawns() {
        int score = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                if (chessBoard[i][j] == '@')
                    score++;
            }
        }
        return score;
    }

    public int getNumberOfBlackPawns() {
        int score = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                if (chessBoard[i][j] == '#')
                    score++;
            }
        }
        return score;
    }

    public static void copyValues(ChessBoard source,  ChessBoard destination) {
        for (int i = 0; i < source.getChessBoard()[0].length; i++) {
            for (int j = 0; j < destination.getChessBoard()[0].length; j++) {
                destination.getChessBoard()[i][j]=source.getChessBoard()[i][j];
            }
        }
    }
}
