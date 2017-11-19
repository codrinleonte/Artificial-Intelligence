public class Strategy {

    protected ProblemInstance problemInstance;
    protected int piece;
    protected int tower;
    protected int numberOfSteps;
    protected Solution solution;

    public int getNumberOfSteps() {
        return numberOfSteps;

    }

    public Solution getSolution() {
        return solution;
    }


    protected Strategy(int numberOfTowers, int numberPieces){
        this.problemInstance = new ProblemInstance(numberOfTowers, numberPieces);
        solution=new Solution();
        numberOfSteps = 0;
    }


    public void printSolution() {
        for(String transition : solution.getTransitionsList()){
            System.out.println(transition);
        }
    }
}
