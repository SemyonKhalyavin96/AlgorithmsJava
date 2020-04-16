import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(pow(3,4));

        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("Книга", 1, 600));
        items.add(new Item("Бинокль", 2, 5000));
        items.add(new Item("Аптечка", 4, 1500));
        items.add(new Item("Ноутбук", 2, 40000));
        items.add(new Item("Котелок", 1, 500));

        Backpack bag = new Backpack(10);
        bag.MakeAllSets(items);
        for(Item i : bag.GetBestSet()){
            System.out.println(i.name);
        }
    }

    public static int pow(int a, int degree){
        if(degree == 0){
            return 1;
        }
        if(degree == 1){
            return a;
        }
        return a * pow(a, degree - 1);
    }
}
