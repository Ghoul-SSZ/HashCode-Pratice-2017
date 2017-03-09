import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static ArrayList<ArrayList<Character>> twoDMap = new ArrayList<>();
    public static void main(String[] args) {

        System.out.println("Hello HashCode!  :D ");
        System.out.println("Test combination is" + testCombinations(5).toString());

        //import input files
        String filePath = "small.in";
        stream_input(filePath);

        System.out.println(twoDMap.toString());

        //information setup
        Scanner in = new Scanner(System.in);
        //How many Tomato must be in one slice of pizza
        //System.out.println();
        int t = 1;

        //How many Mushroom must be in one slice of pizza
        //System.out.println();
        int m = 1;

        //main process
        HashMap<Integer,Integer> request = new HashMap<>();
        System.out.println(request.isEmpty());

    }

    //starting with half row number
    public static LinkedList testCombinations(int max){
        LinkedList<AbstractMap.SimpleEntry> sliceSize = new LinkedList<AbstractMap.SimpleEntry>();
        for(int i = 1; i<=max ;i++) {
            if (i != 1){
                sliceSize.add(new AbstractMap.SimpleEntry<Integer, Integer>(1, i));
            }

        }
        for (int j = 2; j <= max; j++) {
            sliceSize.add(new AbstractMap.SimpleEntry<Integer, Integer>(j, 1));
        }

        for(int i = 1; i<=max;i++)
            for (int j = 2; j < max; j++)
                if(i*j <= max && i==j) sliceSize.add(new AbstractMap.SimpleEntry<Integer, Integer>(i,j));

        return sliceSize;
    }

    public static void stream_input(String file_path){
        try{
            BufferedReader br = new BufferedReader(new FileReader(file_path));
            String line;
            String line1 = br.readLine(); //reading the first line

            // Get four arguments (int)
            int[] Arguments = Arrays.asList(line1.split(" ")).stream().mapToInt(Integer::parseInt).toArray();

            System.out.println("line1 is here  " +line1);
            while((line = br.readLine()) != null){
                char [] charTemp =line.toCharArray();
                ArrayList<Character> cAlist = new ArrayList<Character>() ;
                for(char c : charTemp) {
                    cAlist.add(c);
                }
                    twoDMap.add(cAlist);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Checking if the pizza slice already fulfilled the requirement
    public boolean statusCheck (int tomato, int mushroom, ArrayList<Character> testing){
        int tomatoCount=0;
        int mushroomCount=0;
        for (int i=0; i<testing.size();i++) {
            if (testing.get(i).toString() == "T") {
                tomatoCount++;
            } else if (testing.get(i).toString() == "M") {
                mushroomCount++;
            } else {
                System.out.println("Dude, something is wrong!");
            }
        }

        if (tomatoCount >= tomato && mushroom >= mushroomCount){
            return true;
        }else{return false;}

    }

}
