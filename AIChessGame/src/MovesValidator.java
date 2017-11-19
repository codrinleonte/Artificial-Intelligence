public class MovesValidator {

    public boolean isAValidMove(ChessBoard chessBoard, ChessBoard previousChessBoard,
                                String initialState, String finalState, String[] opponentPreviousMoves, String playerColor) {

        if (!verifyIfStatesAreValid(chessBoard, initialState, finalState, playerColor)) {
            //System.out.println("Coordonatele pieselor sunt invalide");
            return false;
        }
        if (verifyTwoSpacesRule(chessBoard, initialState, finalState, playerColor)) {
            //System.out.println("Mutarea respecta regula cu doua spatii");
            return true;
        }
        if (verifyOneSpacesRule(chessBoard, initialState, finalState, playerColor)) {
            //System.out.println("Mutarea respecta regula cu un spatiu");
            return true;

        }
        if (verifyCapturingOponentPawnRule(chessBoard, initialState, finalState, playerColor)) {
            //System.out.println("Mutarea respecta regula capturarii");
            return true;

        }
      /*  if (verifyEnPasantRule(chessBoard, previousChessBoard, initialState, finalState, opponentPreviousMoves, playerColor)) {
            System.out.println("Mutarea respecta regula enPassantului");
            return true;
        }
*/
        return false;
    }

    private boolean verifyIfStatesAreValid(ChessBoard chessBoard, String initialState, String finalState, String color) {
        if (initialState.length() != 2 || finalState.length() != 2) {
            return false;
        }
        int initialRow = initialState.charAt(1) - '0';
        int initialCol = initialState.charAt(0) - 'a' + 1;
        int finalRow = finalState.charAt(1) - '0';
        int finalCol = finalState.charAt(0) - 'a' + 1;

        if (finalRow > 8 || initialRow > 7) {
            return false;
        }
        if (finalCol > 8 || initialCol > 8) {
            return false;
        }
        if (chessBoard.getChessBoard()[initialRow][initialCol] != '@' && color.equals("white")) {
            return false;
        }
        if (chessBoard.getChessBoard()[initialRow][initialCol] != '#' && color.equals("black")) {
            return false;
        }
        return true;
    }

    private boolean verifyTwoSpacesRule(ChessBoard chessBoard, String initialState, String finalState, String color) {
        int initialRow = initialState.charAt(1) - '0';
        int initialCol = initialState.charAt(0) - 'a' + 1;
        int finalRow = finalState.charAt(1) - '0';
        int finalCol = finalState.charAt(0) - 'a' + 1;
        if (!(initialCol == finalCol)) {
            return false;
        }
        if (initialRow - finalRow != 2 && color.equals("black")) {
            return false;
        }
        if (finalRow - initialRow != 2 && color.equals("white")) {
            return false;
        }
        if ((initialRow == 2 && chessBoard.getChessBoard()[initialRow][initialCol] == '@' && color.equals("white"))) {
            return true;
        }
        if ((initialRow == 7 && chessBoard.getChessBoard()[initialRow][initialCol] == '#' && color.equals("black"))) {
            return true;
        }

        return false;
    }

    private boolean verifyOneSpacesRule(ChessBoard chessBoard, String initialState, String finalState, String color) {
        int initialRow = initialState.charAt(1) - '0';
        int initialCol = initialState.charAt(0) - 'a' + 1;
        int finalRow = finalState.charAt(1) - '0';
        int finalCol = finalState.charAt(0) - 'a' + 1;
        if (!(initialCol == finalCol)) {
            return false;
        }
        if (initialRow - finalRow != 1 && color.equals("black")) {
            return false;
        }
        if (finalRow - initialRow != 1 && color.equals("white")) {
            return false;
        }
        return true;
    }

    private boolean verifyCapturingOponentPawnRule(ChessBoard chessBoard, String initialState, String finalState, String color) {
        int initialRow = initialState.charAt(1) - '0';
        int initialCol = initialState.charAt(0) - 'a' + 1;
        int finalRow = finalState.charAt(1) - '0';
        int finalCol = finalState.charAt(0) - 'a' + 1;
        if (initialCol == finalCol) {
            return false;
        }
        if (initialRow - finalRow != 1 && color.equals("black")) {
            return false;
        }
        if (finalRow - initialRow != 1 && color.equals("white")) {
            return false;
        }
        if (Math.abs(initialCol - finalCol) != 1) {
            return false;
        }
        if (color.equals("white") && chessBoard.getChessBoard()[finalRow][finalCol] != '#') {
            return false;
        }
        if (color.equals("black") && chessBoard.getChessBoard()[finalRow][finalCol] != '@') {
            return false;
        }
        return true;
    }

    private boolean verifyEnPasantRule(ChessBoard chessBoard, ChessBoard previousChessBoard, String initialState, String finalState, String[] opponentPreviousMoves, String color) {

        int oppnentFinalRow = opponentPreviousMoves[1].charAt(1) - '0';
        int oppnentFinalCol = opponentPreviousMoves[1].charAt(0) - 'a' + 1;
        DrawsClass.drawChessBoard(previousChessBoard);
        System.out.println("PreviousMoves 0 : "+opponentPreviousMoves[0]);
        System.out.println("PreviousMoves 1 : "+opponentPreviousMoves[1]);
        System.out.println("color : "+getOpponentColor(color));
        if (verifyTwoSpacesRule(previousChessBoard, opponentPreviousMoves[0], opponentPreviousMoves[1], getOpponentColor(color))) {
            char newc = (char) (opponentPreviousMoves[1].charAt(1) - 1);

            String modifiedFinalState = opponentPreviousMoves[1].charAt(0) + "" + newc;
            System.out.println("modified state : " + modifiedFinalState);

            Pawn.makeOneMove(previousChessBoard, opponentPreviousMoves[0], modifiedFinalState);
            if (verifyCapturingOponentPawnRule(previousChessBoard, initialState, finalState, color)) {
                chessBoard.getChessBoard()[oppnentFinalRow][oppnentFinalCol]= ' ';
                return true;
            }
        }
        return false;
    }

    public String getOpponentColor(String color) {
        if (color.equals("white")) {
            return "black";
        } else
            return "white";
    }
}

