import java.util.*;
import java.util.LinkedList;
public class stack{
    // static class Node{
    //     int data;
    //     Node next;
    //     Node(int data){
    //         this.data=data;
    //         this.next=null;
    //     }
    // }
    // static class Stack{
        // static ArrayList<Integer> list= new ArrayList<>();
        // public static boolean isEmpty(){
        //     return list.size()==0;
        // }
        // public static void push(int data){
        //     list.add(data);
        // }
        // public static int pop(){
        //     if(isEmpty()){
        //         return -1;
        //     }
        //     int top=list.get(list.size()-1);
        //     list.remove(list.size()-1);
        //     return top;
        // }
        // public static int peek(){
        //     if(isEmpty()){
        //         return -1;
        //     }
        //     return list.get(list.size()-1);
        // }

        // static Node head=null;
        // public static boolean isEmpty(){
        //     return head==null;
        // }
        // public static void push(int data){
        //     Node newNode= new Node(data);
        //     if(isEmpty()){
        //         head=newNode;
        //         return;
        //     }
        //     newNode.next=head;
        //     head=newNode;
        //     return;
        // }
        // public static int pop(){
        //     if(isEmpty()){
        //         return -1;
        //     }
        //     int top=head.data;
        //     head=head.next;
        //     return top;
        // }
        // public static int peek(){
        //     if(isEmpty()){
        //         return -1;
        //     }
        //     return head.data;
        // }

    // }

    //STACK USING 2 QUEUES
    // static class Stack{
    //     static Queue<Integer> q1= new LinkedList<>();
    //     static Queue<Integer> q2= new LinkedList<>();
    //     public static boolean isEmpty(){
    //         return q1.isEmpty() && q2.isEmpty();
    //     }
    //     public static void push(int data){
    //         if(!q1.isEmpty()){
    //             q1.add(data);
    //         }else{
    //             q2.add(data);
    //         }
    //     }
    //     public static int pop(){
    //         if(isEmpty()){
    //             System.out.println("empty stack");
    //             return -1;
    //         }
    //         int top=-1;
    //         if(!q1.isEmpty()){
    //             while(!q1.isEmpty()){
    //                 top=q1.remove();
    //                 if(q1.isEmpty()){
    //                     break;
    //                 }
    //                 q2.add(top);
    //             }
    //         }else{
    //             while(!q2.isEmpty()){
    //                 top=q2.remove();
    //                 if(q2.isEmpty()){
    //                     break;
    //                 }
    //                 q1.add(top);
    //             }
    //         }
    //         return top;
    //     }
    //     public static int peek(){
    //         if(isEmpty()){
    //             System.out.println("empty stack");
    //             return -1;
    //         }
    //         int top=-1;
    //         if(!q1.isEmpty()){
    //             while(!q1.isEmpty()){
    //                 top=q1.remove();
    //                 q2.add(top);
    //             }
    //         }else{
    //             while(!q2.isEmpty()){
    //                 top=q2.remove();
    //                 q1.add(top);
    //             }
    //         }
    //         return top;
    //     }
    // }


    // public static void pushAtBottom(Stack<Integer> s, int data){
    //     if(s.isEmpty()){
    //         s.push(data);
    //         return;
    //     }
    //     int top=s.pop();
    //     pushAtBottom(s,data);
    //     s.push(top);
    // }
    // public static String reverseString(String str){
    //     Stack<Character>s= new Stack<>();
    //     int idx=0;
    //     while(idx<str.length()){
    //         s.push(str.charAt(idx));
    //         idx++;
    //     }
    //     StringBuilder result= new StringBuilder("");
    //     while(!s.isEmpty()){
    //         char curr=s.pop();
    //         result.append(curr);
    //     }
    //     str=result.toString();
    //     return str;
    // }
    // public static void reverseStack(Stack<Integer>s){
    //     if(s.isEmpty()){
    //         return;
    //     }
    //     int top=s.pop();
    //     reverseStack(s);
    //     pushAtBottom(s, top);
    // }
    // public static void printStack(Stack<Integer>s){
    //     while(!s.isEmpty()){
    //         System.out.println(s.pop());
    //     }
    // }
    // public static void stockSpan(int stocks[],int span[]){
    //     Stack<Integer>s=new Stack<>();
    //     span[0]=1;
    //     s.push(0);
    //     for(int i=0;i<span.length;i++){
    //         int currPrice=stocks[i];
    //         while(!s.isEmpty() && currPrice>stocks[s.peek()]){
    //             s.pop();
    //         }
    //         if(s.isEmpty()){
    //             span[i]=i+1;
    //         }else{
    //             int prevHigh=s.peek();
    //             span[i]=i-prevHigh;
    //         }
    //         s.push(i);
    //     }
    // }
    // public static boolean isValid(String str){
    //     Stack<Character>s =new Stack<>();
    //     for(int i=0;i<str.length();i++){
    //         char ch=str.charAt(i);
    //         //opening
    //         if(ch=='('|| ch=='{'||ch=='['){
    //             s.push(ch);
    //         }else{
    //             //closing
    //             if(s.isEmpty()){
    //                 return false;
    //             }
    //             if((s.peek()=='(' && ch==')')||(s.peek()=='{' && ch=='}')
    //             || (s.peek()=='[' && ch==']')){
    //                 s.pop();
    //             }else{
    //                 return false;
    //             }
    //         }
    //     }
    //     if(s.isEmpty())
    //     {
    //         return true;
    //     }else{
    //         return false;
    //     }
    // }
    // public static boolean isDuplicate(String str){
    //     Stack<Character> s= new Stack<>();
    //     for(int i=0;i<str.length();i++){
    //         char ch=str.charAt(i);
    //         if(ch==')'){
    //             int count=0;
    //             while(s.peek()=='('){
    //                 s.pop();
    //                 count++;
    //             }
    //             if(count<1){
    //                 return true;
    //             }else{
    //                 s.pop();
    //             }
    //         }else{
    //             s.push(ch);
    //         }
    //     }
    //     return false;
    // }
    // public static void maxArea(int arr[]){
    //     int maxArea=0;
    //     int nxtSmallRight[]= new int[arr.length];
    //     int nxtSmallLeft[]= new int[arr.length];
    //     Stack<Integer> s= new Stack<>();
    //     for(int i=arr.length-1;i>=0;i--){
    //         while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
    //             s.pop();
    //         }
    //         if(s.isEmpty()){
    //             nxtSmallRight[i]=arr.length;
    //         }else{
    //             nxtSmallRight[i]=s.peek();
    //         }
    //         s.push(i);
    //     }
    //     s=new Stack<>();
    //     for(int i=0;i<arr.length;i++){
    //         while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
    //             s.pop();
    //         }
    //         if(s.isEmpty()){
    //             nxtSmallLeft[i]=-1;
    //         }else{
    //             nxtSmallLeft[i]=arr[s.peek()];
    //         }
    //         s.push(i);
    //     }
    //     //current area
    //     for(int i=0;i<arr.length;i++){
    //         int height= arr[i];
    //         int width=nxtSmallRight[i]-nxtSmallLeft[i]-1;
    //         int currArea=height*width;
    //         maxArea= Math.max(maxArea, currArea);
    //     }
    //     System.out.println(maxArea);
    // }
    
    //STACK USING DEQUE
    static class Stack{
        Deque<Integer> deque= new LinkedList<>();
        public void push(int data){
            deque.addLast(data);
        }
        public int pop(){
            return deque.removeLast();
        }
        public int peek(){
            return deque.getLast();
        }
    }

    //PALINDROME LL
    // static boolean isPalindrome(Node head){
    //     Node slow=head;
    //     boolean isPalin =true;
    //     Stack<Integer> s= new Stack<>();
    //     while(slow!=null){
    //         s.push(slow.data);
    //         slow=slow.next;
    //     }
    //     while(head!=null){
    //         int i=s.pop();
    //         if(head.data==i){
    //             isPalin=true;
    //         }else{
    //             isPalin =false;
    //             break;
    //         }
    //         head=head.next;
    //     }
    //     return isPalin;
    // }

    //SIMPLIFY PATH
    // static String simplify(String A){
    //     Stack<String> st=new Stack<>();
    //     String res="";
    //     res+="/";
    //     int lenA=A.length();
    //     for(int i=0;i<lenA;i++){
    //         String dir="";
    //         while(i<lenA && A.charAt(i)=='/'){
    //             i++;
    //         }
    //         while(i<lenA && A.charAt(i)!='/'){
    //             dir+=A.charAt(i);
    //             i++;
    //         }
    //         if(dir.equals("..")==true){
    //             if(!st.isEmpty()){
    //                 st.pop();
    //             }
    //         }
    //         else if(dir.equals(".")==true){
    //             continue;
    //         }
    //         else if(dir.length()!=0){
    //             st.push(dir);
    //         }
    //         Stack<String>s1=new Stack<>();
    //         while(!s1.isEmpty()){
    //             s1.push(st.pop());
    //         }
    //         while(!s1.isEmpty()){
    //             if(s1.size()!=1){
    //                 res+=(s1.pop()+"/");
    //             }else{
    //                 res+=s1.pop();
    //             }
    //         }
    //         return res;
    //     }
    // }

    //DECODE A STRING
    // static String decode(String str){
    //     Stack<Integer> intStack=new Stack<>();
    //     Stack<Character> stringst=new Stack<>();
    //     String temp=" ",result=" ";
    //     for(int i=0;i<str.length();i++){
    //         int count=0;
    //         if(Character.isDigit(str.charAt(i))){
    //             while(Character.isDigit(str.charAt(i))){
    //                 count=count*10+str.charAt(i)-'0';
    //                 i++;
    //             }
    //             i--;
    //             intStack.push(count);
    //         }
    //         else if(str.charAt(i)==']'){
    //             temp=" ";
    //             count=0;
    //             if(!intStack.isEmpty()){
    //                 count=intStack.peek();
    //                 intStack.pop();
    //             }
    //             while(!stringst.isEmpty() && stringst.peek()!='['){
    //                 temp=stringst.peek()+temp;
    //                 stringst.pop();
    //             }
    //             if(!stringst.isEmpty() && stringst.peek()=='['){
    //                 stringst.pop();
    //             }
    //             for(int j=0;j<count;j++){
    //                 result+=temp;
    //             }
    //             for(int j=0;j<result.length();j++){
    //                 stringst.push(result.charAt(j));
    //                 result=" ";
    //             }
    //         }
    //         else if(str.charAt(i)=='['){
    //             if(Character.isDigit(str.charAt(i-1))){
    //                 stringst.push(str.charAt(i));
    //             }else{
    //                 stringst.push(str.charAt(i));
    //                 intStack.push(1);
    //             }
    //         }
    //         else{
    //             stringst.push(str.charAt(i));
    //         }
    //     }
    //     while(!stringst.isEmpty()){
    //         result+=stringst.peek();
    //         stringst.pop();
    //     }
    //     return result;
    // }

    //TRAPPING RAINWATER
    // public static int maxWater(int height[]){
    //     Stack<Integer> st=new Stack<>();
    //     int n=height.length;
    //     int ans=0;
    //     for(int i=0;i<n;i++){
    //         while(!st.isEmpty() && height[st.peek()]<height[i]){
    //             int pop_height=height[st.peek()];
    //             st.pop();
    //             if(st.isEmpty()){
    //                 break;
    //             }
    //             int distance=i-st.peek()-1;
    //             int min_height=Math.min(height[st.peek()],height[i])-pop_height;
    //             ans+=distance*min_height;
    //         }
    //         st.push(i);
    //     }
    //     return ans;
    // }

    public static void main(String args[]){
        // Stack<Integer> s= new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // printStack(s);
        // reverseStack(s);
        // printStack(s);
        // pushAtBottom(s,4);
        
        // String str="abc";
        // String result=reverseString(str);
        // System.out.println(result);
        // int stocks[]={100,80,60,70,60,85,100};
        // int span[]= new int[stocks.length];
        // stockSpan(stocks, span);
        // for(int i=0;i<span.length;i++){
        //     System.out.println(span[i]+" ");
        // }
        
        // NEXT GREATER
        // int arr[]={6,8,0,1,3};
        // Stack<Integer> s= new Stack<>();
        // int nxtGreater[]= new int[arr.length];
        // for(int i=arr.length-1;i>=0;i--){
        //     while(!s.isEmpty() && arr[s.peek()]<=arr[i]){
        //         s.pop();
        //     }
        //     if(s.isEmpty()){
        //         nxtGreater[i]=-1;
        //     }else{
        //         nxtGreater[i]=arr[s.peek()];
        //     }
        //     s.push(i);
        // }
        // for(int i=0;i<nxtGreater.length;i++){
        //     System.out.print(nxtGreater[i]+" ");
        // }
        // System.out.println();
        
        //VALID PARENTHESES
        // String str="({})[]";
        // System.out.println(isValid(str));

        //DUPLICATE PARENTHESES
        // String str1="((a+b))";
        // System.out.println(isDuplicate(str1));
        //MAX AREA IN HISTOGRAN
        // int arr[]={2,1,5,6,2,3};
        // maxArea(arr);
        Stack s= new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        // while(!s.isEmpty()){
            System.out.println(s.peek());
        //     s.pop();
        // }
    }
}