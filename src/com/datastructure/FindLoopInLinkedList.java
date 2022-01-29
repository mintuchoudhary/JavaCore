package com.datastructure;

/**
 * Interview Ques: How will you detect loop in linked list
 */
public class FindLoopInLinkedList {

    private static class LinkNode {
        private int data;
        private LinkNode next;

        LinkNode(int data) {
            this.data = data;
            this.next = null;
        }

        public static void main(String[] args) {
            //1-2-3-4-5-2 ==> loop pointer 1-1,2-3,3-5,4-3,5-5
/**
 *        1 ===> 2 ===>3 ===> 4
 *              /|\           |
 *               |  =======  5
 */
            LinkNode head = new LinkNode(1);
            LinkNode node2 = new LinkNode(2);
            LinkNode node3 = new LinkNode(3);
            LinkNode node4 = new LinkNode(4);
            LinkNode node5 = new LinkNode(5);//<---------2
            //    LinkNode node2loop = new LinkNode(2);
            head.next = node2;
            node2.next = node3;
            node3.next = node4;
            node4.next = node5;
            node5.next = node2; //added loop here


            //Dont print the data it will run till infinite..
//            LinkNode head1 = head;
//            while (head1 != null) {
//                System.out.print(head1.data + "-");
//                head1 = head1.next;
//            }

            checkLoop(head);
        }

        public static LinkNode checkLoop(LinkNode head) {
            LinkNode oneStep = head;
            LinkNode twoStep = head;
            boolean loopDetectedFlag = false;
            while (oneStep != null) {
                System.out.println("oneStep data: " + oneStep.data+" 2nd :"+twoStep.data);
                oneStep = oneStep.next;
                twoStep = twoStep.next.next;
                if (oneStep.data == twoStep.data) {
                    System.out.println("loop detected at: " + oneStep.data);
                    loopDetectedFlag = true;
                    break;
                }
            }
            if (loopDetectedFlag) {
                System.out.println("loop detected ");
            } else {
                System.out.println("loop Not detected ");
            }

            return head;
        }
    }


}