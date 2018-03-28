package in.jaiprakash.chp3;

public class LinkedListReversal {
    public static void main(String[] args) {
        Node header = generateLinkedList();
        traverse(header);
        printFromEnd(header);
        System.out.println( );
    }

    static void printFromEnd(Node header){
        if(header == null)
            return;
        printFromEnd(header.getNext());
        System.out.print(header.getData()+"->");

    }
    static Node generateLinkedList(){
        int [] arr = {2,5,1,7,9,23,12};
        Node header = new Node(null, null);
        Node headerTo = new Node(arr[0], null);
        int i =0;
        while(i < arr.length){
            Node normalNode = new Node(arr[i],null);
            if(i>0){
                header.setNext(normalNode);
            }
            if(i ==1)
                headerTo = header;
            header = normalNode;

            i++;
        }

        return headerTo;
    }

    static void traverse(Node header){
        while (header !=null){
            System.out.print(header.getData()+"->");
            header = header.getNext();
        }
        System.out.println();
    }
}
