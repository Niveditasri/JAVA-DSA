import java.lang.reflect.Array;
import java.util.*;
public class binarySearchTrees {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }
    public static Node insert(Node root,int val){
        if(root==null){
            root=new Node(val);
            return root;
        }
        if(root.data>val){
            root.left=insert(root.left, val);
        }else{
            root.right=insert(root.right, val);
        }
        return root;
    }
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static boolean search(Node root, int key){//O(H)
        if(root==null){
            return false;
        }
        if(root.data==key){
            return true;
        }
        if(root.data>key){
            return search(root.left, key);
        }
        else{
            return search(root.right, key);
        }
    }
    public static Node findInorderSuccessor(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
    public static Node delete(Node root,int val){
        if(root.data< val){
            root.right=delete(root.right, val);
        }
        else if(root.data>val){
            root.left=delete(root.left, val);
        }
        else{//voila
            //case 1-leaf node
            if(root.left==null && root.right==null){
                return null;
            }
            //case 2-single child
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            //case 3- both child
            Node IS= findInorderSuccessor(root.right);
            root.data=IS.data;
            root.right=delete(root.right,IS.data);
        }
        return root;
    }
    public static void printInRange(Node root, int k1,int k2){
        if(root==null){
            return;
        }
        if(root.data>=k1 && root.data<=k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        }
        else if(root.data<k1){
            printInRange(root.left, k1, k2);
        }
        else{
            printInRange(root.right, k1, k2);
        }
    }
    public static void printPath(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+"-->");
        }
        System.out.println("Null");
    }
    public static void printRoot2leaf(Node root,ArrayList<Integer> path){
        if(root==null){
            return;
        }
        path.add(root.data);
        if(root.left==null && root.right==null){
            printPath(path);
        }
        printRoot2leaf(root.left, path);
        printRoot2leaf(root.right, path);
        path.remove(path.size()-1);
    }
    public static boolean isValidBST(Node root,Node min,Node max){// sorted inorder tranveral
        if(root==null){
            return true;
        }
        if(min!=null && root.data<=min.data){
            return false;
        }
        else if(max!=null && root.data >= max.data){
            return false;
        }
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
    public static Node mirrorBST(Node root){//O(N)
        if(root==null){
            return null;
        }
        Node leftS=mirrorBST(root.left);
        Node rightS=mirrorBST(root.right);
        root.left=rightS;
        root.right=leftS;
        return root;
    }
    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static Node BalancedBST(int arr[],int st,int end){
        if(st>end){
            return null;
        }
        int mid=(st+end)/2;
        Node root=new Node(arr[mid]);
        root.left=BalancedBST(arr,st,mid-1);
        root.right=BalancedBST(arr,mid+1,end);
        return root;
    }
    public static void getInOrder(Node root,ArrayList<Integer> inorder){
        if(root==null){
            return;
        }
        getInOrder(root.left, inorder);
        inorder.add(root.data);
        getInOrder(root.right, inorder);
    }
    public static Node BalancedBST2(ArrayList<Integer> inorder,int st,int end){
        if(st>end){
            return null;
        }
        int mid=(st+end)/2;
        Node root=new Node(inorder.get(mid));
        root.left=BalancedBST2(inorder,st,mid-1);
        root.right=BalancedBST2(inorder,mid+1,end);
        return root;
    }
    public static Node toBalBST(Node root){//O(N)
        //inorder seq
        ArrayList<Integer> inorder = new ArrayList<>();
        getInOrder(root, inorder);
        //sorted inorder--> balanced BST
        root=BalancedBST2(inorder,0,inorder.size()-1);
        return root;
    }
    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;
        public Info(boolean isBST,int size,int min,int max){
            this.isBST=isBST;
            this.size=size;
            this.min=min;
            this.max=max;
        }
    }
    public static int maxBST=0;
    public static Info largestBST(Node root){
        if(root==null){
            return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        Info leftInfo =largestBST(root.left);
        Info rightInfo=largestBST(root.right);
        int size=leftInfo.size+rightInfo.size+1;
        int min=Math.min(root.data,Math.min(leftInfo.min, rightInfo.min));
        int max=Math.max(root.data,Math.max(leftInfo.max, rightInfo.max));
        if(root.data<=leftInfo.max || root.data>=rightInfo.min){
            return new Info(false,size,min,max);
        }
        if(leftInfo.isBST && rightInfo.isBST){
            maxBST=Math.max(maxBST,size);
            return new Info(true,size,min,max);
        }
        return new Info(false, size, min, max);
    }
    // public static Node mergeBSTs(Node root1, Node root2){
    //     ArrayList<Integer> arr1= new ArrayList<>();
    //     getInOrder(root1, arr1);
    //     ArrayList<Integer> arr2= new ArrayList<>();
    //     getInOrder(root2, arr2);
    //     //merge
    //     int i=0,j=0;
    //     ArrayList<Integer> finalArr= new ArrayList<>();
    //     while(i<arr1.size() && j<arr2.size()){
    //         if(arr1.get(i)<=arr2.get(j)){
    //             finalArr.add(arr1.get(i));
    //             i++;
    //         }else{
    //             finalArr.add(arr2.get(j));
    //             j++;
    //         }
    //     }
    //     while(i<arr1.size()){
    //         finalArr.add(arr1.get(i));
    //         i++;
    //     }
    //     while(j<arr2.size()){
    //         finalArr.add(arr2.get(j));
    //         j++;
    //     }
    //     BalancedBST2(finalArr,0,finalArr.size()-1);
    // }
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int values[]={8,5,10,3,6,11};
        Node root=null;
        for(int i=0;i<values.length;i++){
            root=insert(root, values[i]);
        }
        inorder(root);
        System.out.println();
        sc.close();
        // if(search(root, 1)){
        //     System.out.println("Found");
        // }else{
        //     System.out.println("Not found");
        // }
        // root=delete(root, 1);
        // System.out.println();
        // inorder(root);
        // printInRange(root, 5, 2);
        // printRoot2leaf(root, new ArrayList<>());
        // if(isValidBST(root, null, null)){
        //     System.out.println("Valid");
        // }else{
        //     System.out.println("Not valid");
        // }
        // System.out.println(mirrorBST(root));
        // preorder(root);
        // System.out.println(BalancedBST(values, 0, values.length-1));
        // root=toBalBST(root);
        // preorder(root);
        // Info info=largestBST(root);
        // System.out.println(maxBST);
    }
}