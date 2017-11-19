import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            String plainText = FileWorker.getTextAsAString("resources/context.txt");
            List<String> patterns = FileWorker.getTextFileAsAStringList("resources/regex.txt");
            List<String> definitionsList = FileWorker.definitionsCreator(plainText,patterns,"resources/context.txt");
            //System.out.println(definitionsList.size());
            FileWorker.outputCreator(definitionsList,"resources/definitions.txt");

            for(String s : definitionsList ){
                System.out.println(s);
            }
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }

    }
}
