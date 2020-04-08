public class Stack <Obj>{
    private int maxSize;
    private Obj[] stack;
    private int top;

    public Stack(int size){
        this.maxSize = size;
        this.stack = (Obj[])new Object[this.maxSize];
        this.top = -1;
    }

    public void push(Obj i){
        this.stack[++this.top] = i;
    }

    public Obj pop(){
        return this.stack[this.top--];
    }

    public Obj peek(){
        return this.stack[this.top];
    }

    public boolean isEmpty(){
        return (this.top == -1);
    }

    public boolean isFull(){
        return (this.top == this.maxSize-1);
    }
}
