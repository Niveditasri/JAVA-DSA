class linkedList{
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }
    public void addLast(int data){
        Node newNode= new Node(data);
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }
    public void print(){
        Node temp=head;
        if(head==null){
            System.out.println("LL is empty");
            return;
        }
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public void addInMiddle(int idx,int data){
        if(idx==0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp=head;
        int i=0;
        while(i<idx-1){
            temp=temp.next;
            i++;
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }
    public int size(){
        Node temp=head;
        int size=0;
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        return size;
    }
    public int removeFirst(){
        int size= size();
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val=head.data;
            head=tail=null;
            return val;
        }
        int val=head.data;
        head=head.next;
        return val;
    }
    public int removeLast(){
        int size= size();
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val=head.data;
            head=tail=null;
            return val;
        }
        //prev = i=size-2
        Node prev= head;
        for(int i=0;i<size-2;i++){
            prev=prev.next;
        }
        int val=prev.next.data;
        prev.next=null;
        tail=prev;
        return val;
    }
    public int itrSearch(int key){//o(n)
        Node temp=head;
        int i=0;
        while(temp!=null){
            if(temp.data==key){
                return i;
            }
            temp=temp.next;
            i++;
        }
        return -1;
    }
    public int helper(Node head,int key){//0(n)
        if(head==null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }
        int idx=helper(head.next,key);
        if(idx==-1){
            return -1;
        }
        return idx+1;
    }
    public int recSearch(int key){
        return helper(head,key);
    }
    public void reverse(){
        Node prev=null;
        Node curr=head;
        Node next=curr.next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }
    public void deleteNthFromEnd(int n){
        int size=size();
        if(n==size){
            head=head.next;
            return;
        }
        int i=1;
        int iToFind=size-n;
        Node prev=head;
        while(i<iToFind){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return;
    }
    public Node findMid(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public boolean checkPalin(){
        if(head==null || head.next==null){
            return true;
        }
        Node midNode= findMid(head);
        Node prev=null;
        Node curr=midNode;
        Node next=curr.next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node right=prev;
        Node left=head;

        while(right!=null){
            if(left.data!=right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }
    public boolean isCycle(){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    public static void removeCycle(){
        Node slow=head;
        Node fast=head;
        boolean cycle=false;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                cycle=true;
                break;
            }
        }
        
        if(cycle==false){
            return;
        }
        slow=head;
        Node prev=null;
        while(slow!=fast){
            prev=fast;
            slow=slow.next;
            fast=fast.next;
        }
        prev.next=null;
    }
    public Node merge(Node head1,Node head2){
        Node mergedLL= new Node(-1);
        Node temp=mergedLL;
        while(head1!=null && head2!=null){
            if(head1.data<=head2.data){
                temp.next=head1;
                temp=temp.next;
                head1=head1.next;
            }else{
                temp.next=head2;
                temp=temp.next;
                head2=head2.next;
            }
        }
        while(head1!=null){
            temp.next=head1;
            temp=temp.next;
            head1=head1.next;
        }
        while(head2!=null){
            temp.next=head1;
            temp=temp.next;
            head1=head2.next;
        }
        return mergedLL.next;
    }
    public Node mergeSort(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node mid=findMid(head);
        Node rightHead=mid.next;
        mid.next=null;
        Node newLeft=mergeSort(head);
        Node newRight=mergeSort(rightHead);
        return merge(newLeft,newRight);
    }
    public void zigzag(){
        Node mid=findMid(head);
        Node prev=null;
        Node curr=mid.next;
        mid.next=null;
        Node next=curr.next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node left=head;
        Node right=prev;
        Node nextL,nextR;
        while(left!=null && right!=null){
            nextL=left.next;
            left.next=right;
            nextR=right.next;
            right.next=nextL;

            left=nextL;
            right=nextR;
        }
    }

    public static void main(String args[]){
        linkedList ll= new linkedList();
        // ll.print();
        // ll.addFirst(1);
        // ll.addFirst(2);
        // ll.print();
        // ll.addInMiddle(2,9);
        // ll.print();
        // ll.size();

        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);
        ll.addLast(5);
        ll.addInMiddle(2,3 );
        System.out.println(ll.size());
        // ll.print();
        // ll.removeFirst();
        // ll.print();
        // System.out.println(ll.recSearch(3));
        // ll.reverse();
        // ll.print();
        // ll.deleteNthFromEnd(3);
        ll.print();
        // System.out.println(ll.checkPalin());
        // ll.head=ll.mergeSort(head);
        // ll.print();
        ll.zigzag();
        ll.print();
    }
}
//     public class DoubleLL{
//     public class Node{
//         int data;
//         Node next;
//         Node prev;

//         public Node(int data){
//             this.data=data;
//             this.next=null;
//             this.prev=null;
//         }
//     }
//     public static Node head;
//     public static Node tail;
//     public static int size;

//     public void addFirst(int data){
//         Node newNode= new Node(data);
//         size++;
//         if(head==null){
//             head=tail=newNode;
//             return;
//         }
//         newNode.next=head;
//         head.prev=newNode;
//         head=newNode;
//     }

//     public int removeFirst(){
//         if(head==null){
//             return Integer.MIN_VALUE;
//         }
//         if(size==1){
//             int val= head.data;
//             head=tail=null;
//             size--;
//             return val;
//         }
//         int val=head.data;
//         head=head.next;
//         head.prev=null;
//         size--;
//         return val;
//     }
//     public void reverse(){
//         Node curr=head;
//         Node prev=null;
//         Node next;
//         while(curr!=null){
//             next=curr.next;
//             curr.next=prev;
//             curr.prev=next;
//             prev=curr;
//             curr=next;
//         }
//         head=prev;
//     }
//     public static void main(String args[]){
//         DoubleLL dll= new DoubleLL();

//     }
// }