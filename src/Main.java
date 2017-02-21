import java.util.AbstractMap;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");
        System.out.println("Run for me you bitch");
        System.out.println("Test combination is" + testCombinations(5).toString());
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
}
