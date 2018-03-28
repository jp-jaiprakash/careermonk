package in.jaiprakash.chp3;

public class FloydCycle {

    public static void main(String[] args) {
        Node header = getHeaderOfCyclic();
        Node tempHeader = header;
        boolean b = DoesLinkedListContainsLoop(header);
        System.out.println("cyclic::" +b);
        Node slowNode = startOfLoop(header);
        System.out.println("Meet at "+ slowNode.getData());
        int cnt = lengthOfLoop(header);
        System.out.println("Length of loop is "+cnt);
    }

    static  int lengthOfLoop(Node header){
        int cnt = 0;

        Node slowNode = header;
        Node fastNode = header;
        boolean loop = false;
        while(fastNode.getNext() != null && fastNode.getNext().getNext() != null){
            slowNode = slowNode.getNext();
            fastNode = fastNode.getNext().getNext();

            if(slowNode == fastNode){
                loop = true;
                cnt = 1; // as we will move fastnode by one link in frst step only
                break;
            }
        }
        // now fastnode and slownode must be pointing at same point
        // so keep slow pointer at same place and move fastnode
        fastNode = fastNode.getNext();
        while (fastNode != slowNode){
            fastNode = fastNode.getNext();
            cnt++;
        }
        return cnt;
    }
    static  Node startOfLoop(Node header){
        Node fastNode = header;
        Node slowNode = header;

        boolean isLoop = false;
        while(fastNode.getNext() != null && fastNode.getNext().getNext()!= null){
            slowNode = slowNode.getNext();
            fastNode = fastNode.getNext().getNext();

//            System.out.println("slownode::"+slowNode.getData()+"  fastnode::"+fastNode.getData());
            if(fastNode == slowNode){
                isLoop = true;
//                System.out.println("meet at"+ fastNode.getData());
                break;
            }
        }

        if(isLoop){
            slowNode = header;
            while (slowNode != fastNode){
                fastNode = fastNode.getNext();
                slowNode = slowNode.getNext();
            }
        }
        return slowNode;
    }
    static boolean DoesLinkedListContainsLoop(Node header){
        if(header.getData() == null)
            return false;

        Node fastNode = header;
        Node slowNode = header;

        while(fastNode.getNext() != null && fastNode.getNext().getNext()!= null){
            slowNode = slowNode.getNext();
            fastNode = fastNode.getNext().getNext();

            if(fastNode == slowNode)
                return true;
        }
        return false;
    }

    static Node getHeaderOfCyclic(){
        int [] arr = {2,5,1,7,9,23,12,56,78};
        int j = 0;
        Node head = new Node(null, null);
        Node cyclicPoint = new Node(arr[3], null);
        Node header = new Node(arr[0], null);
        while (j < arr.length){
            Node nd = new Node(arr[j], null);
            if(j > 0) {
                head.setNext(nd);
                if(j == 1)
                    header = head;
            }
            head = nd;
            if(j == 3)
                cyclicPoint =head;

            j++;

        }
        head.setNext(cyclicPoint);
//        System.out.println("last ele is" + head.getData());
//        System.out.println("first element is" + header.getData());
//        System.out.println("cyclic element is" + cyclicPoint.getData());

return header;
    }
}
