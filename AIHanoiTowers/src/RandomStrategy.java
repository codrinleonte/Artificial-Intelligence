import java.util.Arrays;
import java.util.Random;

public class RandomStrategy extends Strategy {



    public RandomStrategy(int numberOfTowers, int numberOfPieces) {

        super(numberOfTowers, numberOfPieces);
    }


    public void randomAlgorithm() {
        Random r = new Random();
        int[] chosenState;

        while (!Arrays.equals(problemInstance.getCurrentState(), problemInstance.getFinalState())) {
            this.tower = r.nextInt(problemInstance.getNumberOfTowers()) + 1;
            this.piece = r.nextInt(problemInstance.getNumberOfPieces()) + 1;
            chosenState = ProblemInstance.trasition(problemInstance.getCurrentState(), this.piece, this.tower);
            if (ProblemInstance.validation(problemInstance.getCurrentState(), chosenState, piece - 1)) {
                solution.add(Arrays.toString(problemInstance.getCurrentState()) + " -> " + Arrays.toString(chosenState));
                this.problemInstance.setCurrentState(chosenState);
                this.numberOfSteps++;
            }
        }
    }


}
