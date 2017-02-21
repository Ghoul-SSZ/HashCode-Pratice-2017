import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello Google!");
        System.out.println("Test combination is" + testCombinations(5).toString());

        String filePath = "small.in";
        stream_input(filePath);
    }

    //starting with half row number
    public static LinkedList testCombinations(int max){
        LinkedList<AbstractMap.SimpleEntry> sliceSize = new LinkedList<AbstractMap.SimpleEntry>();
        for(int i = 1; i<=max;i++) {
            sliceSize.add(new AbstractMap.SimpleEntry<Integer, Integer>(1, i));

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

                for (int i = 0; i<charTemp.length; i++){

                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
