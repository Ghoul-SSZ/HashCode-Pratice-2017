import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello Google!");

        String file_path = "small.in";
        stream_input(file_path);

    }

    public static void stream_input(String file_path){
        try{
            BufferedReader br = new BufferedReader(new FileReader(file_path));
            String line;
            String line1 = br.readLine(); //reading the first line

            // Get four arguments (int)
            int[] Arguments = Arrays.asList(line1.split("")).stream().mapToInt(Integer::parseInt).toArray();

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
