import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static ArrayList<ArrayList<Character>> twoDMap = new ArrayList<>();
    static HashMap<ArrayList<HashMap<Integer,Integer>>,Integer> grouping = new HashMap<>();
    public static int groupNumber=1;

    public static void main(String[] args) {

        System.out.println("Hello HashCode! :D ");
        System.out.println("Test combination is" + testCombinations(5).toString());

        //import input files
        String filePath = "small.in";
        stream_input(filePath);

        System.out.println(twoDMap.toString());

        //information setup
        Scanner in = new Scanner(System.in);
        //How many Tomato&Mushroom must be in one slice of pizza
        //System.out.println();
        int tAndm = 1;

        //Max cell for one slice of pizza
        //System.out.println();
        int max = 5;

        LinkedList combs = testCombinations(max);


            //main process
            for (int i=0; i<twoDMap.size(); i++){
                for (int j=0; j<twoDMap.get(i).size(); j++){
                    Object cell = twoDMap.get(i).get(j);
                    if (cell.equals("T") || cell.equals("M")){
                        System.out.println("cell taken");
                    }else{
                        //starting testing combinations
                        ArrayList<Character> testGroup = new ArrayList();
                        for (int k=0; k<combs.size(); k++){
                            //test the combination
                            getCombination(combs.get(k),testGroup,0,0);
                        }
                    }
                }
            }
        System.out.println(twoDMap);
    }



    public static void getCombination(Object combs, ArrayList testGroup,int row, int column){
        String t = combs.toString();
        Pattern pattern = Pattern.compile("= *");
        Matcher matcher = pattern.matcher(t);
        if (matcher.find()) {
            String t1 = t.substring(0, matcher.start());
            String t2 = t.substring(matcher.end());
            System.out.println("t1: " +t1);
             row = Integer.parseInt(t1);
             column = Integer.parseInt(t2);
        }
        for (int i=0; i<row;i++){
            for (int j=0;j<column;j++){
                testGroup.add(twoDMap.get(i).get(j));
            }
        }
        if (statusCheck(1,testGroup)){
            for (int i=0; i<row;i++){
                for (int j=0;j<column;j++){
                    twoDMap.get(i).set(j, ((char) groupNumber));
                }
            }
            grouping.put(testGroup,testGroup.size());
        }

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

            System.out.println("arguments is here:  " +line1);
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
    public static boolean statusCheck (int tAndM, ArrayList<Character> testing){
        int tomatoCount=0;
        int mushroomCount=0;
        for (int i=0; i<testing.size();i++) {
            if (testing.get(i).equals("T")) {
                tomatoCount++;
            } else if (testing.get(i).equals("M")) {
                mushroomCount++;
            } else {
                System.out.println("Dude, something is wrong!");
            }
        }

        if (tomatoCount >= tAndM && mushroomCount >= tAndM){
            return true;
        }else{return false;}

    }

}
