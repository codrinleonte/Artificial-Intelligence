


import java.io.*;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWorker {

    private static String delimitators = "[-\\t,;?!:@\\[\\](){}_*/\n ]";
    private static char[] definitionDelimitatorsAsChars = {'.', '?', ';', '!'};
    private static String definedWord = new String();
    private static String definition = new String();


    public static String getTextAsAString(String fileName) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            return everything;
        } finally {
            br.close();
        }
    }


    public static List<String> getTextFileAsAStringList(String fileName) throws FileNotFoundException, IOException {
        List<String> result = new ArrayList<String>();

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                result.add(line);
                line = br.readLine();
            }

            return result;
        } finally {
            br.close();
        }
    }

    public static List<String> getTextFileAsAStringListWithoutEdges(String fileName) throws IOException {
        List<String> result = new ArrayList<String>();

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            StringBuilder sb = new StringBuilder();
            String finalPatternSb = new String();
            String line = br.readLine();

            // System.out.println(parts[1]);
            while (line != null) {
                String[] parts = line.split(delimitators);
                for (int i = 1; i < parts.length - 1; i++) {

                    //
                    finalPatternSb += parts[i];
                    finalPatternSb += " ";
                }

                result.add(finalPatternSb.toString());
                line = br.readLine();
                finalPatternSb = "";
                // System.out.println(line);

            }
            return result;
        } finally {
            br.close();
        }
    }

    public static List<String> definitionsCreator(String plainText, List<String> definitionsPatterns, String fileName) throws IOException {
        List<String> definitionsList = new ArrayList<>();
        List<String> definedExpresion = new ArrayList<>();
        String [] tokens ;
        //System.out.println( sentences[1]);
        //for (int k = 0; k < sentences.length; k++) {
            for (String s : definitionsPatterns) {
                Pattern p = Pattern.compile(s);   // the pattern to search for
                Matcher m = p.matcher(plainText);
                // now try to find at least one match
                while (m.find() && s != "") {
                    /* firstPart = sentences[k].substring(0, m.start());
                    String secondPart = sentences[k].substring(m.end(), sentences[k].length() - 1);
                    String parts[] = firstPart.split(" ");

                    for (int i = parts.length - 1; i >= 0; i--) {

                    if (parts[i].charAt(0) != '.') {
                        definedExpresion.add(parts[i]);

                    } else {
                        break;
                    }

                    }

                Collections.reverse(definedExpresion);
                for (int i = 0; i < definedExpresion.size(); i++) {
                    definedWord += definedExpresion.get(i);
                    definedWord+=" ";
                }

                    for (int i = 0; i < secondPart.length(); i++) {
                        if ((new String(definitionDelimitatorsAsChars).contains(secondPart.charAt(i) + ""))) {
                            break;
                        } else {
                            definition += secondPart.charAt(i);
                        }
                    }
               */
                    String finalDefinition = plainText.substring(m.start(),m.end());
                    String plm= s.substring(s.indexOf("+")+1,s.indexOf("."));
                    System.out.println(plm);
                    tokens=finalDefinition.split(plm);
                    definedWord = "";
                    definition = "";
                    //System.out.println("finalDefinition "+finalDefinition+"----");
                    List<Integer> offsets = FileWorker.getOffSet(finalDefinition, fileName);
                    String def = "";

                    if (offsets.size() >= 2) {
                        def = tokens[0] + " = " + tokens[1] + " [ " + offsets.get(0) + " , " + offsets.get(1) + " ] ";
                    }
                    definitionsList.add(def);
                }
            }
       // }
        return definitionsList;
    }


    public static List<String> getDefinitionsList() {
        return null;
    }


    public static void writeInFile(String fileName, String content) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter((new FileOutputStream(
                new File(fileName),
                true /* append = true */)));
        writer.println(content);
        writer.close();
    }


    public static int outputCreator(List<String> definitionsList,String fileName) { // primeste ca parametru o
        // lista de definitii, trebuie sa creeze un
        //fisier text in care apar definitiie scrise pe cate un rand
        try {
            for (String string : definitionsList) {

                FileWorker.writeInFile(fileName, string);
            }
        } catch (FileNotFoundException e) {
            return 0;
        } catch (UnsupportedEncodingException e) {
            return 0;
        }

        return 1;
    }

    public static List<Integer> getOffSet(String definition, String fileName) throws FileNotFoundException, IOException {  // primeste un string ca parametru,
        // cauta in fisier linia si coloana unde este
        //gasita definitia si le returneaza intr-o
        // lista de int de dimensiune 2
        List<Integer> result = new ArrayList<Integer>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();

            int lineCount = 1;
            while (line != null) {
                // System.out.println(line);
                if (line.contains(definition)) {
                    result.add(lineCount);
                    result.add(line.indexOf(definition)+1);
                    break;
                }
                lineCount++;
                line = br.readLine();
            }
            return result;
        }

    }


    public static Object reverse(String[] arr) {
        List<String> list = Arrays.asList(arr);
        Collections.reverse(list);
        return list.toArray();
    }
}
