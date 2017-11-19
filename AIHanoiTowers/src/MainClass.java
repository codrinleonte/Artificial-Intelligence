import java.util.ArrayList;
import java.util.List;

public class MainClass {


    public static void main(String args[]) {

        //-----------------------Random  Strategy Test -----------------------------------

        RandomStrategy randomStrategy = new RandomStrategy(3, 3);
        randomStrategy.randomAlgorithm();
        randomStrategy.printSolution();


        //-----------------------HillClimb  Strategy Test -----------------------------------
       /* BKTStrategy bktStrategy= new BKTStrategy(3,3);
        bktStrategy.BKTAlgorithm();
        bktStrategy.printSolution();
        System.out.println(bktStrategy.getSolution().getTransitionsList().size());
        */
    }

}
