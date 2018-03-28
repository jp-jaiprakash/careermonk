package in.jaiprakash.chp3;

public class JosephusCircle {
    public static void main(String[] args) {
        Node header = NthNodeFromEndApproach1.generateLinkedList();
        Node forCircular= header;
        int n =0;
        // first make it a circular linked list
        while(header != null){
            n++;
            header = header.getNext();
        }
        header.setNext(forCircular);

        int m = 2;
        // Eliminate every M-th player as long as more than one player remains

    }
}
