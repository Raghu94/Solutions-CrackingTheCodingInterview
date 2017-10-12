package Chapter03_Stacks_and_Queues.Q_3_04_Queue_via_Stacks;

import java.util.EmptyStackException;

/**
 * Created by Raghu Mulukutla on 10/11/17.
 *
 */
public class Question {


    private static class QueueViaStacks<T> {

        public static class MyStack<T>{
            private class StackNode<T> {
                T data;
                StackNode<T> next;
                public StackNode(T data) {
                    this.data = data;
                    next = null;
                }
            }
            private StackNode<T> tos;

            public void push(T data) {
                if(tos == null)
                    tos = new StackNode<>(data);
                else {
                    StackNode<T> newNode = new StackNode<T>(data);
                    newNode.next = tos;
                    tos = newNode;
                }
            }

            public T pop() {
                if(tos==null) throw new EmptyStackException();
                T data = tos.data;
                tos = tos.next;
                return data;
            }

            public boolean isEmpty() {
                return tos==null;
            }

            public void printStack() {
                StackNode<T> sentinel = tos;
                while(sentinel!=null) {
                    System.out.print(" " + sentinel.data + " ");
                    sentinel = sentinel.next;
                }
                System.out.println();
            }

        }


        MyStack<T> myStackA;
        MyStack<T> myStackB;

        public QueueViaStacks() {
            myStackA = new MyStack<>();
            myStackB = new MyStack<>();
        }

        public void enqueue(T data) {
            myStackA.push(data);
        }

        public T dequeue() {
            while(!myStackA.isEmpty())
                myStackB.push(myStackA.pop());
            T result = myStackB.pop();
            while(!myStackB.isEmpty()) {
                myStackA.push(myStackB.pop());
            }

            return result;
        }

    }
    public static void main(String[] args) {
//        QueueViaStacks.MyStack<Integer> myStack = new QueueViaStacks.MyStack<Integer>();
//
//        myStack.push(1);
//        myStack.push(2);
//        myStack.push(24);
//        myStack.push(55);
//        myStack.push(67);
//        myStack.push(23);
//        myStack.push(57);
//
//        myStack.printStack();

        QueueViaStacks<Integer> myQVS = new QueueViaStacks<>();
        myQVS.enqueue(1);
        myQVS.enqueue(6);
        myQVS.enqueue(3);
        myQVS.enqueue(5);
        myQVS.enqueue(16);
        myQVS.enqueue(8);

        System.out.println("Result: " + myQVS.dequeue());

        for(int i=0; i< 6; i++) {
            myQVS.enqueue(17 + i);

        }



        for(int i=0; i< 11; i++) {
            System.out.println("Result: " + myQVS.dequeue());

        }





    }
}
