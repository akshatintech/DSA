package StackandQueue;

public class CustomStack {
    public static void main(String[] args) {

    }

    int ptr = -1;

    protected int[] data;
    private static final int DEFAULT_SIZE= 10;

    public CustomStack(){
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size){
        this.data  =new int[size];

    }

    public boolean push(int item){
        if(isFull()){
            System.out.println("Stack is full");
            return false;
        }

        ptr++;
        data[ptr]  = item;
        return true;

    }


    private boolean isFull(){
        return ptr == data.length-1;        //ptr is at last indexx
    }

    private boolean isEmpty(){
        return false;
    }
}
