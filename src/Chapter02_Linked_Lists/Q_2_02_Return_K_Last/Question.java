package Chapter02_Linked_Lists.Q_2_02_Return_K_Last;

import java.util.Hashtable;

/**
 * Created by Raghu Mulukutla on 10/11/17.
 *
 */
public class Question {
    private static class LinkedList {
        private class Node {
            Node next;
            Node prev;
            int value;
            public Node(int value) {
                this.value = value;
            }
        }

        Node head;
        public LinkedList() {
            Node head = null;
        }

        public void addNodeToTail(int value) {
            Node newNode = new Node(value);
            if(head==null) { //beginning of the LinkedList
                head = newNode;
            }
            else {
                Node sentinel = head;
                while(sentinel.next!=null)
                    sentinel = sentinel.next;
                sentinel.next = newNode;
                newNode.prev = sentinel;
            }
        }

        public void printLinkedList() {
            Node sentinel = head;
            while(sentinel!=null) {
                System.out.print(" " + sentinel.value + " ");
                sentinel = sentinel.next;
            }
        }

        public int K_To_Last(int k) {
            Node sentinel1 = head;
            Node sentinel2 = head;
            int c = 0;
            while(sentinel1!=null) {
                c++;
                sentinel1=sentinel1.next;
                if(c>k) {
                    sentinel2=sentinel2.next;
                }
            }

            if(k>c)
                return -1;

            return sentinel2.value;
        }



    }
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addNodeToTail(0);
        linkedList.addNodeToTail(1);
        linkedList.addNodeToTail(3);
        linkedList.addNodeToTail(3);
        linkedList.addNodeToTail(2);
        linkedList.addNodeToTail(67);
        linkedList.addNodeToTail(7);
        linkedList.addNodeToTail(2);
        linkedList.addNodeToTail(8);
        linkedList.addNodeToTail(9);
        linkedList.printLinkedList();
        System.out.println("Result:" + linkedList.K_To_Last(11));

    }
}
