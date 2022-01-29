package com.datastructure;

import java.util.LinkedList;

/**
 * Interview Ques: How will you reverse given linked list
 * @author - Mintu
 */
public class ReverseSinglyLinkedList {

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

    public static void main(String args[]){
        ListNode head = new ListNode(2);
        ListNode second = new ListNode(4);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(16);
        head.next = second;
        second.next = third;
        third.next = fourth;
      //  fourth.next= null;

        printNodes(head);
          System.out.println("Invoked reverse link list");
        ListNode res = reverseLinkedList(head);
        printNodes(res);


    }

    public static ListNode reverseLinkedList(ListNode head) {


     ListNode headRes=head;
     ListNode prevNode =null;
     ListNode currentNode =head;
     ListNode nextNode = null;
     while (currentNode != null) {
          nextNode = currentNode.next; //move ahead of current node
          currentNode.next =prevNode; //map current node to previous node
          prevNode = currentNode; //move previous node to current node
          currentNode =nextNode; //move current node to next
      }
      headRes=prevNode;
      return headRes;
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




}