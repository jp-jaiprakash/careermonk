package in.jaiprakash.chp4;

public class DynArrayStack {
    private int top;
    private int capacity;
    private int[] array;

    public DynArrayStack(){
        capacity = 1;
        array = new int[capacity];
        top = -1;
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public boolean isStackFull(){
        return (top == (capacity -1));
    }

    public void push(int data){
        if(isStackFull())
            doubleStack();

        array[++top] = data;
    }

    public void doubleStack() {
        int [] newArray = new int[capacity *2];
        System.arraycopy(array, 0, newArray, 0, capacity);
        System.out.println("Doubling the array size from :"+capacity);
        capacity = capacity *2;
        System.out.print(" to new capacity :" + capacity);
        array = newArray;
    }

    public int pop(){
        if(isEmpty())
        {System.out.println("Stack overflow");
        return Integer.parseInt(null);
        }
        else
            return array[top--];
    }
    public void printStack(){
        int tempTop = top;
        int i =0;
        while(tempTop >= 0){
            System.out.print(array[i] + " ");
            i++;
            tempTop--;
        }
        System.out.println();
    }
}
