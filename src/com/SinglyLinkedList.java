package com;

/**
 * @author - Mintu
 */
public class SinglyLinkedList {

    private ListNode node;
    private int size;
    private boolean isEmpty;

    private static class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static int getSize(ListNode head){
        int count = 0;
        if(head == null)
            return 0;
        ListNode current  = head;
        while(current != null){
            count++;
            current =  current.next;
        }
        return count;
    }

    public static void printNodes(ListNode head){
        ListNode current  = head;
        if(getSize(head) == 0){
            System.out.println("Empty List");
            return;
        }
        while(current != null){
            System.out.print("-"+current.data);
            current = current.next;
        }
        System.out.println("");
    }

    public static ListNode insertNodeAtBeginning(ListNode head, int data){
        ListNode newNode = new ListNode(data);
        if(head == null){
            return newNode;
        }
        newNode.next = head;
        head = newNode;

        return head;
    }

    public static ListNode insertNodeAtEnd(ListNode head, int data){
        ListNode newNode = new ListNode(data);
        if(head == null){
            return newNode;
        }
        ListNode current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
        return head;
    }

    public static void insertAfter(ListNode previous, int data){
        if(previous == null){
            System.out.println("Previous node can't be null");
        }
        ListNode newNode = new ListNode(data);
        newNode.next = previous.next;
        previous.next = newNode;
    }

    public static ListNode insertAtPosition(ListNode head, int position, int data){
        ListNode newNode = new ListNode(data);
        ListNode currentNode =  head;
        int count =  1;
        while(count<position-1){
            currentNode =  currentNode.next;
            count++;
        }
        newNode.next = currentNode.next;
        currentNode.next = newNode;
        return head;
    }

    public static ListNode deleteFirstNode(ListNode head){
        if(head == null){
            System.out.println("Empty List");
            return head;
        }
        ListNode currentNode =  head;
        head = head.next;
        currentNode.next = null;
        return head;
    }

    public static ListNode deleteLastNode(ListNode head){
        if(head == null){
            System.out.println("Empty List");
            return head;
        }
        ListNode currentNode = head;
        while(currentNode.next.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = null;
        return head;
    }

    public static ListNode deleteAtN(ListNode head, int n){
        if(head == null){
            System.out.println("Empty List");
            return head;
        }
        ListNode currentNode = head;
        ListNode previousNode = null;
        int count = 1;
        while(count < n){
            previousNode = currentNode;
            currentNode = currentNode.next;
            count++;
        }
        previousNode.next = currentNode.next;
        currentNode.next = null;
        return head;
    }

    public static void main(String args[]){
        ListNode head = new ListNode(2);
        ListNode second = new ListNode(4);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(16);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next= null;

        printNodes(head);
       // System.out.println("Size of Linked List is: "+getSize(head));

        System.out.println("Inserting at beginning: 1");
        ListNode newNode = insertNodeAtBeginning(head, 1);
        printNodes(newNode);
      //  System.out.println("Size of Linked List is: "+getSize(newNode));

        System.out.println("Inserting at end: 32");
        ListNode newNodeEnd = insertNodeAtEnd(head, 32);
        printNodes(newNodeEnd);
     //   System.out.println("Size of Linked List is: "+getSize(newNodeEnd));

        System.out.println("Inserting node 8 after 6");
        insertAfter(second, 6);
        printNodes(head);
     //   System.out.println("Size of Linked List is: "+getSize(newNodeEnd));

        System.out.println("Inserting node at position 4 with data 7");
        ListNode newNodeAt = insertAtPosition(head, 4, 7);
        printNodes(newNodeAt);
     //   System.out.println("Size of Linked List is: "+getSize(newNodeAt));
        System.out.println("Deleting first node");
        ListNode afterFirstNode = deleteFirstNode(head);
        printNodes(afterFirstNode);
   //     System.out.println("Size of Linked List is: "+getSize(afterFirstNode));
        System.out.println("Deleting last node");
        ListNode afterLastNode = deleteLastNode(afterFirstNode);
        printNodes(afterLastNode);
     //   System.out.println("Size of Linked List is: "+getSize(afterLastNode));
        System.out.println("Deleting at given position: 3");
        ListNode afterDeleteN = deleteAtN(afterFirstNode, 3);
        printNodes(afterDeleteN);
   //     System.out.println("Size of Linked List is: "+getSize(afterDeleteN));
    }
}
/**
 -2-4-8-16
 Inserting at beginning: 1
 -1-2-4-8-16
 Inserting at end: 32
 -2-4-8-16-32
 Inserting node 8 after 6
 -2-4-6-8-16-32
 Inserting node at position 4 with data 7
 -2-4-6-7-8-16-32
 Deleting first node
 -4-6-7-8-16-32
 Deleting last node
 -4-6-7-8-16
 Deleting at given position: 3
 -4-6-8-16
 */