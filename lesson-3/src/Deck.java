public class Deck {
    private int maxSize;
    private int size;
    private int head, end;
    private int[] data;

    public Deck(int capacity){
        data = new int[capacity];
        head = 0;
        end = 0;
        size = 0;
    }

    public Deck()
    {
        data = new int[maxSize];
        head = 0;
        end = 0;
        size = 0;
    }

    public void insertLeft(int e){
        if (size == maxSize)
        {
            System.out.println("Deque is full.");
            return;
        }
        else if (size==0)
        {
            end = head;
            data[head] = e;
            size++;
        }
        else
        {
            head++;
            if (head >= maxSize)
                head = 0;
            data[head] = e;
            size++;
        }
    }

    public void insertRigth(int e){
        if (size == maxSize)
        {
            System.out.println("Deque is full.");
            return;
        }
        else if (size==0)
        {
            head = end;
            data[end] = e;
            size++;
        }
        else
        {
            end--;
            if (end<0)
                end = maxSize-1;
            data[end] = e;
            size++;
        }
    }

    public int removeLeft(){
        if (size!=0)
        {
            int tmp = data[head];
            head--;
            if (head<0)
                head = maxSize - 1;
            size --;
            return tmp;
        }
        else
            return -1;
    }

    public int removeRight(){
        if (size!=0)
        {
            int tmp = data[end];
            end++;
            if (end>=maxSize)
                end = 0;
            size --;
            return tmp;
        }
        else
            return -1;
    }
}
