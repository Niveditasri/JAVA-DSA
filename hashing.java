import java.util.*;
import java.util.LinkedList;
public class hashing{
    static class HashMap<K,V>{//generic
        private class Node{
            K key;
            V value;
            public Node(K key, V value){
                this.key=key;
                this.value=value;
            }
        }
        private int n;//n
        private int N;
        private LinkedList<Node> buckets[];//N

        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N=4;
            this.buckets= new LinkedList[4];
            for(int i=0;i<4;i++){
                this.buckets[i]=new LinkedList<>();
            }
        }
        private int hashFunction(K key){
            int hc= key.hashCode();
            return Math.abs(hc)%N;
        }
        private int SearchInLL(K key,int bi){
            LinkedList<Node> ll= buckets[bi];
            int di=0;
            for(int i=0;i<ll.size();i++){
                Node node=ll.get(i);
                if(node.key==key){
                    return di;
                }
                di++;
            }
            return -1;
        }
        @SuppressWarnings("unchecked")
        private void rehash(){
            LinkedList<Node> oldBuck[]=buckets;
            buckets=new LinkedList[N*2];
            N=2*N;
            for(int i=0;i<buckets.length;i++){
                buckets[i]=new LinkedList<>();
            }
            //nodes-> add in bucket
            for(int i=0;i<oldBuck.length;i++){
                LinkedList<Node> ll=oldBuck[i];
                for(int j=0;j<ll.size();j++){
                    Node node=ll.remove();
                    put(node.key,node.value);
                }
            }
        }
        public void put(K key,V value){//O(lamda)-->O(1)
            int bi=hashFunction(key);
            int di=SearchInLL(key, bi);
            if(di!=-1){
                Node node=buckets[bi].get(di);
                node.value=value;
            }else{
                buckets[bi].add(new Node(key, value));
                n++;
            }
            double lambda=(double)n/N;
            if(lambda>2.0){
                rehash();
            }   
        }
        public boolean containsKey(K key){
            int bi=hashFunction(key);
            int di=SearchInLL(key, bi);
            if(di!=-1){
                return true;
            }else{
                return false;
            }
        }
        public V get(K key){
            int bi=hashFunction(key);
            int di=SearchInLL(key, bi);
            if(di!=-1){
                Node node=buckets[bi].get(di);
                return node.value;
            }else{
                return null;
            }
        }
        public V remove(K key){
            int bi=hashFunction(key);
            int di=SearchInLL(key, bi);
            if(di!=-1){
                Node node=buckets[bi].remove(di);
                n--;
                return node.value;
            }else{
                return null;
            }
        }
        public ArrayList<K> keySet(){
            ArrayList<K> keys=new ArrayList<>();
            for(int i=0;i<buckets.length;i++){
                LinkedList<Node> ll=buckets[i];
                for(Node node:ll){
                    keys.add(node.key);
                }
            }
            return keys;
        }
        public boolean isEmpty(){
            return n==0;
        }
        public int getOrDefault(int i, int j) {
            return 0;
        }
    }
    public static void MajorityElement(int nums[]){//O(N)
        HashMap<Integer,Integer> hm= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            // if(hm.containsKey(nums[i])){
            //     hm.put(nums[i],hm.get(nums[i])+1);
            // }else{
            //     hm.put(nums[i],1);
            // }
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
            ArrayList<Integer> keySet=hm.keySet();
            for(Integer key: keySet){
            if(hm.get(key)>nums.length/3){
                System.out.println(key);
            }
        } 
    }
    public static boolean isAnagram(String s,String t){//O(N)
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character,Integer> map= new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch, 0)+1);
        }
        for(int i=0;i<t.length();i++){
        char ch=t.charAt(i);
        if(map.get(ch)!=null){
            if(map.get(ch)==1){
                map.remove(ch);
            }else{
                map.put(ch,map.get(ch)-1);
            }
        }else{
            return false;
        }
        }
        return map.isEmpty();
    }
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        // HashMap<String,Integer> hm= new HashMap<>();
        // hm.put("India",100);//insert-O(1)
        // hm.put("China",150);
        
        // System.out.println(hm);
        //get -O(1)
        // int population=hm.get("India");
        // System.out.println(population);
        // System.out.println(hm.containsKey("Indonesia"));//O(1)

        // //Iterate
        // Set<String> keys= hm.keySet();//O(1)
        // System.out.println(keys);

        // for (String k : keys) {
        //     System.out.println("key="+k+", value=" +hm.get(k)); //entryset
        // }
        
        // ArrayList<String> keys= hm.keySet();
        // for(String key:keys){
        //     System.out.println(key);
        // }

        // //insertion order is same (doubly ll)
        // LinkedHashMap<String,Integer> lhm=new LinkedHashMap<>();
        // lhm.put("India",100);
        // lhm.put("China",150);
        // System.out.println(lhm);
        // //alphabetically sorting on keys
        // TreeMap<String,Integer> thm=new TreeMap<>();
        // lhm.put("India",100);
        // lhm.put("China",150);
        // System.out.println(thm);

        // int arr[]={1,3,2,5,1,3,1,5,1};
        // MajorityElement(arr);

        // String s="race";
        // String t="care";
        // System.out.println(isAnagram(s, t));;

        HashSet<Integer> hs= new HashSet<>();
        hs.add(1);
        hs.add(2);
        hs.add(1);
        hs.remove(2);
        // if(hs.contains(2)){
        //     System.out.println("contains");
        // }else{
        //     System.out.println("not");
        // }
        // System.out.println(hs.size());
        // hs.clear();
        // System.out.println(hs.isEmpty());

        // Iterator it= hs.iterator(); METHOD 1
        // while(it.hasNext()){
        //     System.out.println(it.next());
        // }

        // for(Integer i: hs){ METHOD 2
        //     System.out.println(i);
        // }
        sc.close();
    }
}