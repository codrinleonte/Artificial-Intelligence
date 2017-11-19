import java.util.Arrays;

public class ProblemInstance {


    private int numberOfTowers;
    private int numberOfPieces;
    private int[] currentState;
    private int[] initialState;
    private int[] finalState;


    public ProblemInstance(int numberOfTowers, int numberOfPieces) {
        this.numberOfPieces = numberOfPieces;
        this.numberOfTowers = numberOfTowers;
        this.initialState = new int[numberOfPieces];
        this.finalState = new int[numberOfPieces];
        settingInitialAndCurrentStates();
        this.currentState = initialState;
    }


    public int getNumberOfTowers() {
        return numberOfTowers;
    }

    public void setNumberOfTowers(int numberOfTowers) {
        this.numberOfTowers = numberOfTowers;
    }

    public int getNumberOfPieces() {
        return numberOfPieces;
    }

    public void setNumberOfPieces(int numberOfPieces) {
        this.numberOfPieces = numberOfPieces;
    }

    public void settingInitialAndCurrentStates() {
        for (int i = 0; i < numberOfPieces; i++) {
            initialState[i] = 1;
            finalState[i] = numberOfTowers;
        }

    }

    public int[] getCurrentState() {
        return currentState;
    }

    public void setCurrentState(int[] currentState) {
        this.currentState = currentState;
    }

    public int[] getInitialState() {
        return initialState;
    }

    public void setInitialState(int[] initialState) {
        this.initialState = initialState;
    }

    public int[] getFinalState() {
        return finalState;
    }

    public void setFinalState(int[] finalState) {
        this.finalState = finalState;
    }

    public static int[] trasition(int[] currentState, int piece, int tower) {
        int[] auxArr= new int[currentState.length];
        copyArrayValues(currentState,auxArr);
        auxArr[piece-1] = tower;
        return auxArr;
    }

    public static boolean validation(int[] currentState, int[] chosenState, int piece) {
        if(Arrays.equals(currentState,chosenState)){
            return false;
        }
        for (int i = 0; i < piece ; i++) {
            if (currentState[piece] == chosenState[i]) {
                return false;
            }
            if (chosenState[piece] == chosenState[i]) {
                return false;
            }
        }
        return true;
    }

    public static void printTransition(int[] initialState, int[] finalState) {
        System.out.println(Arrays.toString(initialState) + " -> " + Arrays.toString(finalState));
    }

    public static void copyArrayValues(int[] sourceArray, int[] destinationArray) {
        if (sourceArray.length == destinationArray.length) {

            for (int i = 0; i < sourceArray.length; i++) {
                destinationArray[i] = sourceArray[i];
            }
        }
    }


}
