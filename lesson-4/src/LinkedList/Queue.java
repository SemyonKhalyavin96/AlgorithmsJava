package LinkedList;

public class Queue{
    private LinkedList queue;

    public Queue(){
        queue = new LinkedList();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public void insert(String name, int age){
        queue.insert(name, age);
    }

    public Link delete(){
        return queue.delete();
    }

    public void display(){
        queue.display();
    }
}
