package in.jaiprakash.chp3;

public class NthNodeFromEndApproach1 {

    public static void main(String[] args) {

        Node header = generateLinkedList();
        Node tempHeader = header;
        int size = 0;
        while (header != null) {
            System.out.print(header.getData() + " -> ");
            header = header.getNext();
            size++;
        }
//        System.out.println("size of linked list is::"+size);
        System.out.println();
        int nthElementFromEnd = 3;
        approach2(tempHeader,nthElementFromEnd);
        int tempSize = 1;
        int positionToStop = size - nthElementFromEnd + 1;
        while (tempHeader != null) {
            tempHeader = tempHeader.getNext();
            tempSize++;
            if(tempSize == positionToStop)
            {
                System.out.println("Element is "+ tempHeader.getData());
                break;
            }
        }

    }

    static void approach2(Node header,int nthElementFromEnd){
        Node pthPointer = header;
        int ptr = 0;
        while(header != null){

            if(ptr >= nthElementFromEnd){
                pthPointer = pthPointer.getNext();
            }
            ptr++;
            header = header.getNext();
        }
        System.out.println("Element is:"+ pthPointer.getData());
    }
    static Node generateLinkedList(){
        int [] arr = {2,5,1,7,9,23,12};
        Node header = new Node(arr[0], null);
        Node headerTo = new Node(arr[0], null);
        int i =1;
        while(i < arr.length){
            Node normalNode = new Node(arr[i],null);
            header.setNext(normalNode);
            if(i ==1)
                headerTo = header;

            header = normalNode;
            i++;
        }

        return headerTo;
    }
}
