import java.util.*;
import java.util.LinkedList;
public class queue{
    // static class Node{
    //     int data;
    //     Node next;
    //     Node(int data){
    //         this.data=data;
    //         this.next=null;
    //     }
    // }
    // static class Queue{
        // static int arr[];
        // static int size;
        // static int rear;
        // // static int front;//For circular queue
        // Queue(int n){
        //     arr=new int[n];
        //     size=n;
        //     rear=-1;
        //     // front=-1;
        // }
        // public static boolean isEmpty(){
        //     return rear==-1;
        //     // return rear==-1 && front ==-1;
        // }
        // // public static boolean isFull(){
        // //     return (rear+1)%size==front;
        // // }
        // public static void add(int data){
        //     if(rear==size-1){
        //         // if(isFull()){
        //         System.out.println("Queue is full");
        //         return;
        //     }
        //     rear=rear+1;
        //     // if(front==-1){//adding 1st element
        //     //     front=0;
        //     // }
        //     // rear=(rear+1)%size;
        //     arr[rear]=data;
        // }
        // public static int remove(){
        //     if(isEmpty()){
        //         System.out.println("Empty Queue");
        //         return -1;
        //     }
        //     int front=arr[0];
        //     for(int i=0;i<rear;i++){
        //         arr[i]=arr[i+1];
        //     }

        //     // int result= arr[front];
        //     rear=rear-1;
        //     // if(front==rear){
        //     //     rear=front=-1;
        //     // }else{
        //     //     front=(front+1)%size;
        //     // }
        //     return front;
        //     // return result;
        // }
        // public static int peek(){
        //     if(isEmpty()){
        //         System.out.println("Empty Queue");
        //         return -1;
        //     }
        //     return arr[0];
        //     // return arr[front];
        // }

        //USING LL
        // static Node head=null;
        // static Node tail=null;

        // public static boolean isEmpty(){
        //     return head==null && tail==null;
        // }
        // public static void add(int data){
        //     Node newNode= new Node(data);
        //     if(head==null){
        //         head=tail=newNode;
        //         return;
        //     }
        //     tail.next=newNode;
        //     tail=newNode;
        // }
        // public static int remove(){
        //     if(isEmpty()){
        //         System.out.println("Empty Queue");
        //         return -1;
        //     }
        //     int front=head.data;
        //     if(tail==head){//single ele
        //         tail=head=null;
        //     }else{
        //         head=head.next;
        //     }
        //     return front;
        // }
        // public static int peek(){
        //     if(isEmpty()){
        //         System.out.println("Empty Queue");
        //         return -1;
        //     }
        //     return head.data;
        // }
    // }

    //QUEUE USING TWO STACKS
    // static class Queue{
    //     static Stack<Integer>s1= new Stack<>();
    //     static Stack<Integer>s2=new Stack<>();
    //     public static boolean isEmpty(){
    //         return s1.isEmpty();
    //     }
    //     public static void add(int data){
    //         while(!s1.isEmpty()){
    //             s2.push(s1.pop());
    //         }
    //         s1.push(data);
    //         while(!s2.isEmpty()){
    //             s1.push(s2.pop());
    //         }
    //     }
    //     public static int remove(){
    //         if(isEmpty()){
    //             System.out.println("Queue empty");
    //             return -1;
    //         }
    //         return s1.pop();
    //     }
    //     public static int peek(){
    //         if(isEmpty()){
    //             System.out.println("Queue Empty");
    //             return -1;
    //         }
    //         return s1.peek();
    //     }
    // }

    // public static void findNonRepeating(String str){
    //     int freq[]= new int[26];
    //     Queue<Character> q= new LinkedList<>();
    //     for(int i=0;i<str.length();i++){
    //         char ch=str.charAt(i);
    //         q.add(ch);
    //         freq[ch-'a']++;
    //         while(!q.isEmpty()&& freq[q.peek()-'a']>1){
    //             q.remove();
    //         }
    //         if(q.isEmpty()){
    //             System.out.print(-1+" ");
    //         }else{
    //             System.out.print(q.peek()+" ");
    //         }
    //     }
    //     System.out.println();
    // }
    // public static void interLeave(Queue<Integer> q){
    //     Queue<Integer> firstHalf= new LinkedList<>();
    //     int size=q.size();
    //     for(int i=0;i<size/2;i++){
    //         firstHalf.add(q.remove());
    //     }
    //     while(!firstHalf.isEmpty()){
    //         q.add(firstHalf.remove());
    //         q.add(q.remove());
    //     }
    // }
    // public static void reverse(Queue<Integer> q){
    //     Stack<Integer> s = new Stack<>();
    //     while(!q.isEmpty()){
    //         s.push(q.remove());
    //     }
    //     while(!s.isEmpty()){
    //         q.add(s.pop());
    //     }
    // }
    
    //Queue using deque
    static class Queue{
        Deque<Integer> deque= new LinkedList<>();
        public void add(int data){
            deque.addLast(data);
        }
        public int remove(){
            return deque.removeFirst();
        }
        public int peek(){
            return deque.getFirst();
        }
    }

    public static void main(String args[]){
        Queue q= new Queue();
        // // Queue<Integer> q= new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        // System.out.println(q.peek());
        // System.out.println(q.remove());
        // System.out.println(q.remove());

        // String str="aabccxb";
        // findNonRepeating(str);

        // Queue<Integer>q = new LinkedList<>();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // q.add(5);
        // q.add(6);
        // q.add(7);
        // q.add(8);
        // q.add(9);
        // q.add(10);
        // // interLeave(q);
        // reverse(q);
        // while(!q.isEmpty()){
        //     System.out.print(q.remove()+" ");
        // }
        // System.out.println();

        // Deque<Integer> deque= new LinkedList<>();
        // deque.addFirst(1);
        // deque.addFirst(2);
        // deque.addLast(3);
        // deque.addLast(4);
        // System.out.println(deque);
        // deque.removeFirst();
        // deque.removeLast();
        // System.out.println(deque);
        // System.out.println(deque.getFirst());
        // System.out.println(deque.getLast());
    }
}