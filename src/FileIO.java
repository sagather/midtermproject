import java.io.*;
import java.util.Scanner;


/**
 * Created by bcxtr on 2/17/2017.
 */
public class FileIO {

    public static File openFile(){

            File dictFile = new File("C:/Users/bcxtr/IdeaProjects/midtermproject/src/dictionary.txt");
            return dictFile;

    }

    public static String[] readFile(File dictFile){

        try {
            Scanner fin = new Scanner(dictFile);
            String dictString = "";
            while(fin.hasNextLine()){
                dictString += fin.nextLine();
            }

            return parseNumbersOut(dictString);

        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }

        return null;

    }

    private static String[] parseWords(String toParse){

        String[] parsed = toParse.split(",");
        return parsed;

    }

    private static String[] parseNumbersOut(String toParse){

        toParse = toParse.replaceAll("[0-9]", "");

        return parseWords(toParse);

    }


}
