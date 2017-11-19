import java.util.Scanner;

public class ChessGame {
    private ChessBoard chessBoard;
    private ChessBoard previousChessBoard;
    private String firstPlayerName;
    private String secondPlayerName;
    private String firstPlayerColor;
    private String secondPlayerColor;
    private String move;
    private String initialAndFinalStates[];
    private String previousMoves[];
    private int turnCount;
    private String turnColor;
    private String playerThisTurn;
    private MovesValidator movesValidator;
    private String score;
    private String blackPlayer;
    private String whitePlayer;

    public ChessGame(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
        previousChessBoard=chessBoard;
        movesValidator = new MovesValidator();
        previousMoves=new String[2];
    }

    public void startChessGame() {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("First player name : ");
        firstPlayerName = keyboard.nextLine();
        System.out.println("Second player name : ");
        secondPlayerName = keyboard.nextLine();

        int rand = 1 + (int) (Math.random() * 2);

        if (rand == 1) {
            System.out.println("First player has white pieces ");
            firstPlayerColor = "white";
            secondPlayerColor = "black";
            playerThisTurn = firstPlayerName;
            whitePlayer = firstPlayerName;
            blackPlayer = secondPlayerName;
        } else {
            System.out.println("Second player has white pieces ");
            firstPlayerColor = "black";
            secondPlayerColor = "white";
            playerThisTurn = secondPlayerName;
            whitePlayer = secondPlayerName;
            blackPlayer = firstPlayerName;
        }
        //score=firstPlayerName + " : " + chessBoard.getNumberOfWhitePawns() + " vs. " + secondPlayerName + " : " + chessBoard.getNumberOfBlackPawns();

        while (true) {

            score = whitePlayer + " : " + chessBoard.getNumberOfWhitePawns() + " vs. " + blackPlayer + " : " + chessBoard.getNumberOfBlackPawns();

            turnCount++;
            if (turnCount % 2 == 0) {
                turnColor = "black";
            } else {
                turnColor = "white";
            }


            DrawsClass.drawChessBoard(chessBoard);
            System.out.println(score);
            System.out.println("Enter your move, " + playerThisTurn + " : ");
            move = keyboard.nextLine();
            initialAndFinalStates = move.split("->");

            while(initialAndFinalStates.length!=2){
                System.out.println("Mutarea este invaida! Incercati din nou : ");
                System.out.println("Enter your move, " + playerThisTurn + " : ");
                initialAndFinalStates = move.split("->");
                move = keyboard.nextLine();
            }
            ChessBoard.copyValues(chessBoard,previousChessBoard);
            while (!movesValidator.isAValidMove(chessBoard,previousChessBoard, initialAndFinalStates[0],initialAndFinalStates[1], previousMoves, turnColor)) {
                System.out.println("Mutarea este invaida! Incercati din nou : ");
                System.out.println("Enter your move, " + playerThisTurn + " : ");
                move = keyboard.nextLine();
                initialAndFinalStates = move.split("->");
            }

            Pawn.makeOneMove(chessBoard, initialAndFinalStates[0], initialAndFinalStates[1]);

            previousMoves[0]=initialAndFinalStates[0];
            previousMoves[1]=initialAndFinalStates[1];

            if (victoryConditionBlackPlayer()) {
                System.out.println("Felicitari, " + blackPlayer + " ! Ai castigat aceasta partida !");
                break;
            } else if (victoryConditionWhitePlayer()) {
                System.out.println("Felicitari, " + whitePlayer + " ! Ai castigat aceasta partida !");
                break;
            }
            if (playerThisTurn.equals(firstPlayerName)) {
                playerThisTurn = secondPlayerName;
            } else {
                playerThisTurn = firstPlayerName;
            }
        }
    }

    public boolean victoryConditionBlackPlayer() {
        if (chessBoard.getNumberOfWhitePawns() == 0) {
            return true;
        }
        for (int i = 0; i <= chessBoard.getRows(); i++) {
            if (chessBoard.getChessBoard()[1][i] == '#') {
                return true;
            }
        }

        return false;
    }

    public boolean victoryConditionWhitePlayer() {
        if (chessBoard.getNumberOfBlackPawns() == 0) {
            return true;
        }
        for (int i = 0; i <= chessBoard.getRows(); i++) {
            if (chessBoard.getChessBoard()[8][i] == '@') {
                return true;
            }
        }

        return false;
    }
}

