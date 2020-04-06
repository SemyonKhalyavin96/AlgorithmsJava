import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Array arr = new Array(4);
        arr.replace(0,1);
        arr.replace(1,2);
        arr.replace(2,3);
        arr.replace(3,4);
        arr.replace(3,5);
        /*arr.printArray();
        arr.insert(2,6);
        arr.printArray();
        arr.delete(arr.getSize() - 1);
        arr.printArray();
        arr.delete(1);
        arr.printArray();*/
        Array million = new Array(1000000); // создали массив с миллионом элементов
        Date start = new Date();
        for(int i = 0; i < million.getSize(); i++){
            int rand = (int)(Math.random()*1000);
            million.replace(i, rand);
        }
        Date end = new Date();
        System.out.println(end.getTime() - start.getTime());

        Array sortArrayBubble = new Array(1000); // создали массив на 1000 элементов
        for(int i = 0; i < sortArrayBubble.getSize(); i++){
            int rand = (int)(Math.random()*1000);
            sortArrayBubble.replace(i, rand);
        }

        start = new Date();
        sortArrayBubble.sortBubble();
        end = new Date();
        System.out.println("Сортировка пузырьком, время:" + (end.getTime() - start.getTime()));

        Array sortArrayInsert = new Array(1000); // создали массив на 1000 элементов
        for(int i = 0; i < sortArrayInsert.getSize(); i++){
            int rand = (int)(Math.random()*1000);
            sortArrayInsert.replace(i, rand);
        }

        start = new Date();
        sortArrayInsert.sortInsert();
        end = new Date();
        System.out.println("Сортировка вставкой, время:" + (end.getTime() - start.getTime()));

        Array sortArraySelect = new Array(1000); // создали массив на 1000 элементов
        for(int i = 0; i < sortArraySelect.getSize(); i++){
            int rand = (int)(Math.random()*1000);
            sortArrayInsert.replace(i, rand);
        }

        start = new Date();
        sortArraySelect.sortSelect();
        end = new Date();
        System.out.println("Сортировка выбором, время:" + (end.getTime() - start.getTime()));

    }
}
