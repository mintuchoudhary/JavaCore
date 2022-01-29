package com.datastructure;

import java.util.Hashtable;

/**
 * Remove duplicates from the linked list
 * Output: 1 4 3
 */
public class LinkedListRemoveDuplicateDemo {

    private static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node n2 = new Node(4);
        Node n3 = new Node(3);
        Node n4 = new Node(1);
        Node n5 = new Node(1);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        printNodes(deleteDups(head));
    }

    public static Node deleteDups(Node head) {
        Hashtable hashtable = new Hashtable();
        Node temp = head;
        Node previous = null;
        Node result = null;
        while (temp != null) {
            if (hashtable.containsKey(temp.data))

                previous.next = temp.next;
            else {
                hashtable.put(temp.data, true);
                if (previous == null)
                    result = previous = temp;
                else {
                    previous.next = temp;
                    previous = previous.next;

                }
            }
            temp = temp.next;
        }

        return result;
    }



    private static void printNodes(Node head) {
        while (head != null) {
            System.out.print(" " + head.data);
            head = head.next;
        }
    }
}
