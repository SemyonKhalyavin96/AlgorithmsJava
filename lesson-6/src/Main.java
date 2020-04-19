import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        ArrayList<MyTreeMap<Integer>> forest = new ArrayList<>();
        int capacity;
        for(int i = 0; i < 20; i++) {
            forest.add(new MyTreeMap<Integer>());
            capacity = rnd(6, 63);
            for (int j = 0; j < capacity; j++) {
                forest.get(i).put(rnd(-100, 100));
            }
            System.out.println(forest.get(i).toString());
        }

    }

    public static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
