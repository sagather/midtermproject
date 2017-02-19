import java.io.File;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by bcxtr on 2/17/2017.
 */
public class Tester {

    private static PrefixTrie entry = new PrefixTrie();
    private static Hashtable dictionary2 = new Hashtable();

    public static void main(String[] args){

        PrefixTrie dictionary = new PrefixTrie();
        File dictFile = FileIO.openFile();
        String[] toInsert = FileIO.readFile(dictFile);

        for(String s : toInsert){

            dictionary.insert(dictionary.getRoot(),s);
            dictionary2.put(s.hashCode(), s);

        }

        displayKeypad();



    }

    public static void displayKeypad() {

        String input = "";
        System.out.println("-------------------------");
        System.out.println("    1 |    2   |   3     ");
        System.out.println("      |   abc  |  def    ");
        System.out.println("-------------------------");
        System.out.println("    4 |    5   |   6     ");
        System.out.println("   ghi|   jkl  |  mno    ");
        System.out.println("-------------------------");
        System.out.println("    7 |    8   |   9     ");
        System.out.println("  pqrs|   tuv  |  wxyz   ");
        System.out.println("-------------------------");
        System.out.println("   *  |    0   |    #    ");
        System.out.println("      |        |         ");
        System.out.println("-------------------------");

        Scanner kb = new Scanner(System.in);
        try {
            input = kb.nextInt() + "";
            int size = input.length();
            int[] toTranslate = new int[size];

            int interim = Integer.parseInt(input);

            for (int i = size - 1; i >= 0; i--) {

                toTranslate[i] = interim % 10;
                interim = interim / 10;

            }

            buildTree(toTranslate);
        }
        catch(InputMismatchException e){

            System.out.println("Nice try smartass, numbers only.");
            displayKeypad();

        }

    }

    private static void buildTree(int[] toTranslate) {

        String[] str = {"abc", "def", "ghi", "jkl","mno","pqrs","tuv","wxxyz"};
        Map children = entry.getChildren();

        for(int i = 0; i< toTranslate.length; i++){

            if(toTranslate[i]<2){

            }
            else{

                entry.insert(entry.getRoot(), str[toTranslate[i]-2]);

            }

        }

    }

}
