package in.jaiprakash.chp3;

import java.util.Scanner;

public class SingleLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userchoice = 0;
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        ListNode header = new ListNode(null, null);
        int sizeOflinkedList = 0;
        do {
            System.out.println("1. Insert into Linked List at Beginning");
            System.out.println("2. Insert into Linked List in middle");
            System.out.println("3. Insert into Linked List at ENd");
            System.out.println("4. Traverse a Linked List");
            System.out.println("5. Delete a Record");
            System.out.println("6. Exit");
            System.out.println("Enter your choice");
            userchoice = sc.nextInt();
            switch (userchoice) {
                case 1:
                    System.out.println("Enter the data");
                    int userInput = sc.nextInt();
                    ListNode newNode = new ListNode(userInput, null);
                    header = singleLinkedList.insertAtBeginning(header, newNode);
                    sizeOflinkedList = singleLinkedList.traverseLinkedList(header);
                    break;
                case 2:
                    System.out.println("Enter the data");
                    userInput = sc.nextInt();
                    System.out.println("Enter thr position where you want to insert the data");
                    int position = sc.nextInt();
                    if (position < sizeOflinkedList) {
                        newNode = new ListNode(userInput, null);
                        header = singleLinkedList.insertInMiddle(header, newNode, position);
                        sizeOflinkedList = singleLinkedList.traverseLinkedList(header);
                    } else {
                        System.out.println("This position isinked list");
                    }

                    break;
                case 3:
                    System.out.println("Enter the data");
                    userInput = sc.nextInt();
                    newNode = new ListNode(userInput, null);
                    header = singleLinkedList.insertAtEnd(header, newNode);
                    sizeOflinkedList = singleLinkedList.traverseLinkedList(header);
                    break;
            }
        } while (userchoice < 6);


    }

    ListNode insertAtBeginning(ListNode node, ListNode newNode) {
        if (node == null) { // case when it is an empty linked list
            newNode.setNext(null);
        } else {
            newNode.setNext(node);
        }
        return newNode;
    }

    ListNode insertAtEnd(ListNode node, ListNode newNode) {
        ListNode tempNode = node; // store the header
        while (node.getNext() != null) {
            node = node.getNext();
        }

        node.setNext(newNode);
        node.setData(newNode.getData());

        return tempNode;
    }

    ListNode insertInMiddle(ListNode node, ListNode newNode, int position) {
        ListNode tempNode = node; // store the header
        int pos = 0;
        while (node.getNext() != null && pos < 6) {
            pos++;
            if (pos == position) {
//                    tempNode = node;
                break;
            }
            node = node.getNext();
        }
        newNode.setNext(node.getNext());
        node.setNext(newNode);
        return tempNode;
    }

    int traverseLinkedList(ListNode header) {
        int size = 0;
        while (header.getNext() != null) {
            System.out.print(header.getData() + " -> ");
            header = header.getNext();
            size++;
        }
        System.out.println();
        return size;
    }
}

class ListNode {
    private Integer data;
    private ListNode next;

    public ListNode(Integer data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}

// psvm + Tab
// sout