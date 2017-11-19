import java.util.Arrays;
import java.util.Random;

public class BKTStrategy extends Strategy {

    public BKTStrategy(int numberOfTowers, int numberOfPieces) {
        super(numberOfTowers, numberOfPieces);
    }

    public void BKTAlgorithm() {
        int[] chosenState;
        ProblemInstance.printTransition(problemInstance.getCurrentState(), problemInstance.getFinalState());
        while (!Arrays.equals(problemInstance.getCurrentState(), problemInstance.getFinalState())) {
            for (int i = 1; i <= problemInstance.
                    getNumberOfTowers(); i++) {
                for (int j = 1; j <= problemInstance.getNumberOfPieces(); j++) {
                    chosenState = ProblemInstance.trasition(problemInstance.getCurrentState(), j, i);
                    if (ProblemInstance.validation(problemInstance.getCurrentState(), chosenState, j - 1)) {
                        ProblemInstance.printTransition(problemInstance.getCurrentState(), chosenState);
                        solution.add(Arrays.toString(problemInstance.getCurrentState()) + " -> " + Arrays.toString(chosenState));
                        this.problemInstance.setCurrentState(chosenState);
                        this.numberOfSteps++;
                    }
                }
            }
        }
    }
}
