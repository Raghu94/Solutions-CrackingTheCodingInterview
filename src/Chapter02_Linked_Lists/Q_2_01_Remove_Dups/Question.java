package Chapter02_Linked_Lists.Q_2_01_Remove_Dups;

import java.util.Hashtable;

/**
 * Created by Raghu Mulukutla on 10/10/17.
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

        public void removeDups() {
            Node sentinel = head;
            Hashtable<Integer,Integer> hashtable = new Hashtable<Integer,Integer>();
            while(sentinel!=null) {
                if(hashtable.containsKey(sentinel.value)) {
                    sentinel.prev.next = sentinel.next;
                    sentinel.next.prev = sentinel.prev;
                }
                else {
                    hashtable.put(sentinel.value, 1);
                }
                sentinel = sentinel.next;
            }
        }

        public void removeDups_follow_up() {
            Node sentinel1 = head;
            if(sentinel1.next==null)
                return;
            Node sentinel2 = head.next;
            while(sentinel1!=null) {
                int value = sentinel1.value;
                sentinel2=sentinel1.next;
                while(sentinel2!=null) {
                    if(sentinel2.value==value) {
                        sentinel2.prev.next = sentinel2.next;
                        sentinel2.next.prev = sentinel2.prev;
                    }
                    sentinel2 = sentinel2.next;
                }
                sentinel1=sentinel1.next;
            }
        }

    }
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addNodeToTail(0);
        linkedList.addNodeToTail(1);
        linkedList.addNodeToTail(3);
        linkedList.addNodeToTail(3);
        linkedList.addNodeToTail(2);
        linkedList.addNodeToTail(6);
        linkedList.addNodeToTail(7);
        linkedList.addNodeToTail(8);
        linkedList.addNodeToTail(8);
        linkedList.addNodeToTail(9);
        linkedList.printLinkedList();
        linkedList.removeDups_follow_up();
        System.out.println("");
        linkedList.printLinkedList();
    }
}

