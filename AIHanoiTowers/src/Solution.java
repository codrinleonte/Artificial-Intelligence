import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<String> transitionsList;

    public Solution() {
        transitionsList = new ArrayList<String>();
    }

    public List<String> getTransitionsList() {
        return transitionsList;
    }

    public void setTransitionsList(List<String> transitionsList) {
        this.transitionsList = transitionsList;
    }

    public void add(String transition){
        transitionsList.add(transition);
    }

}
