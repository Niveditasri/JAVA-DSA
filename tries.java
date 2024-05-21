public class tries {
    static class Node{
        Node[] children;
        boolean endOfWord = false;
        // int freq;
        Node(){
            this.children=new Node[26];
            for(int i=0;i<26;i++){
                children[i]=null;
            }
            // freq=1;
        }
    }
    public static Node root=new Node();
    public static void insert(String word){//O(L)
        Node curr=root;
        for(int level=0;level<word.length();level++){
            int idx=word.charAt(level)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            // }else{
            //     // curr.children[idx].freq++;
            // }
            curr=curr.children[idx];
        }
        curr.endOfWord=true;
    }
    public static boolean search(String key){//O(L)
        Node curr=root;
        for(int level=0;level<key.length();level++){
            int idx=key.charAt(level)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return curr.endOfWord=true;
    }
    public static boolean wordBreak(String key){
        if(key.length()==0){
            return true;
        }
        for(int i=1;i<=key.length();i++){
            if(search(key.substring(0,i))&& wordBreak(key.substring(i))){
                return true;
            }
        }
        return false;
    }
    // public static void findPrefix(Node root,String ans){//O(L)
    //     if(root==null){
    //         return;
    //     }
    //     if(root.freq==1){
    //         System.out.println(ans);
    //         return;
    //     }
    //     for(int i=0;i<root.children.length;i++){
    //         if(root.children[i]!=null){
    //             findPrefix(root.children[i], ans+(char)(i+'a'));
    //         }
    //     }
    // }
    public static boolean startsWith(String prefix){
        Node curr=root;
        for(int i=0;i<prefix.length();i++){
            int idx=prefix.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return true;
    }
    public static int countNodes(Node root){
        if(root==null){
            return 0;
        }
        int count=0;
        for(int i=0;i<26;i++){
            if(root.children[i]!=null){
                count+=countNodes(root.children[i]);
            }
        }
        return count+1;
    }
    public static String ans="";
    public static void longestWord(Node root,StringBuilder temp){
        if(root==null){
            return;
        }
        for(int i=0;i<26;i++){
            if(root.children[i]!=null && root.children[i].endOfWord==true){
                char ch=(char)(i+'a');
                temp.append(ch);
                if(temp.length()>ans.length()){
                    ans=temp.toString();
                }
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1);//backtrack
            }
        }
    }
    public static void main(String args[]){
        // String words[]={"the","a","there","their","any","thee"};
        // for(int i=0;i<words.length;i++){
        //     insert(words[i]);
        // }

        // System.out.println(search("thee"));
        // String key="ilikesung";
        // System.out.println(wordBreak(key));

        //PREFIX PROBLEM
        // String arr[]={"zebra","dog","duck","dove"};
        // for(int i=0;i<arr.length;i++){
        //     insert(arr[i]);
        // }
        // root.freq=-1;
        // findPrefix(root, "");

        //STARTS WITH
        // String words[]={"apple","app","mango","man","woman"};
        // String prefix1="app";
        // String prefix2="moon";
        // for(int i=0;i<words.length;i++){
        //     insert(words[i]);
        // }
        // System.out.println(startsWith(prefix1));
        // System.out.println(startsWith(prefix2));

        //COUNT UNIQUE SUBSTRING
        // String str="ababa";
        // //suffix-> insert in trie
        // for(int i=0;i<str.length();i++){
        //     String suffix=str.substring(i);
        //     insert(suffix);
        // }
        // System.out.println(countNodes(root));

        //LONGEST WORD WITH ALL PREFIXES
        String words[]={"a","banana","app","appl","ap","apply","apple"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        longestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }
}
