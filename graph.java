import java.sql.Array;
import java.util.*;
import java.util.Stack;
public class graph{
    static class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int wt;
        public Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
        @Override
        public int compareTo(Edge e2){
            return this.wt-e2.wt;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        //0-vertex
        graph[0].add(new Edge(0,1,5));
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,3));
        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2,4,4));
        graph[3].add(new Edge(3,1,3));
        graph[3].add(new Edge(3,2,1));
        graph[4].add(new Edge(4,2,2));

        //USING EDGES
        // edges.add(new Edge(0, 1, 10));
        // edges.add(new Edge(0, 2, 15));
        // edges.add(new Edge(0, 3, 30));
        // edges.add(new Edge(1, 3, 40));
        // edges.add(new Edge(2, 3, 50));
    }
    public static void bfs(ArrayList<Edge> graph[]){
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                bfsUtil(graph,vis);
            }
        }
    }
    public static void bfsUtil(ArrayList<Edge> graph[],boolean vis[]){//O(V+E)
        Queue<Integer> q= new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int curr=q.remove();
            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr]=true;
                for(int i=0;i<graph[curr].size();i++){
                    Edge e= graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    public static void dfs(ArrayList<Edge> graph[]){
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            dfsUtil(graph, i, vis);
        }
    }
    public static void dfsUtil(ArrayList<Edge> graph[],int curr,boolean vis[]){
        System.out.print(curr+" ");
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            if(!vis[e.dest]){
                dfsUtil(graph,e.dest,vis);
            }
        }
    }
    public static boolean hasPath(ArrayList<Edge>[] graph,int src,int dest,boolean vis[]){
        if(src==dest){
            return true;
        }
        vis[src]=true;
        for(int i=0;i<graph[src].size();i++){
            Edge e= graph[src].get(i);
            //e.dest=neighbour
            if(!vis[e.dest]&&hasPath(graph, e.dest, dest, vis)){
                return true;
            }
        }
        return false;
    }
    public static boolean detectCycle(ArrayList<Edge> graph[]){//o(v+e)
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(detectCycleUtil(graph,vis,i,-1)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean detectCycleUtil(ArrayList<Edge>graph[],boolean vis[],int curr,int par){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                if(detectCycleUtil(graph,vis,e.dest,curr))
                return true;
            }
            else if(!vis[e.dest] && e.dest!=par){
                return true;
            }
        }
        return false;
    }
    public static boolean isBarpatite(ArrayList<Edge>graph[]){
        int col[]=new int[graph.length];
        for(int i=0;i<col.length;i++){
            col[i]=-1;//no color
        }
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            if(col[i]==-1){
                q.add(i);
                col[i]=0;//yellow
                while(!q.isEmpty()){
                    int curr=q.remove();
                    for(int j=0;j<graph[curr].size();j++){
                        Edge e=graph[curr].get(j);//e.dest
                        if(col[e.dest]==-1){
                            int nextCol=col[curr]==0 ? 1:0;
                            col[e.dest]=nextCol;
                            q.add(e.dest);
                        }else if(col[e.dest]==col[curr]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    public static boolean isCycleDir(ArrayList<Edge>graph[]){
        boolean vis[]= new boolean[graph.length];
        boolean stack[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(isCycleDirUtil(graph,i,vis,stack)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isCycleDirUtil(ArrayList<Edge>graph[],int curr,boolean vis[],boolean stack[]){
        vis[curr]=true;
        stack[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(stack[e.dest]){
                return true;
            }
            if(!vis[e.dest] && isCycleDirUtil(graph,e.dest, vis, stack)){
                return true;
            }
        }
        stack[curr]=false;
        return false;
    }
    public static void topologicalSort(ArrayList<Edge> graph[]){
        boolean vis[]= new boolean[graph.length];
        Stack<Integer> s= new Stack<>();
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                topSortUtil(graph,i,vis,s);
            }
        }
        while(!s.isEmpty()){
            System.out.println(s.pop()+" ");
        }
    }
    public static void topSortUtil(ArrayList<Edge>graph[],int curr,boolean vis[],Stack<Integer> s){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                topSortUtil(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }
    public static void calcIndeg(ArrayList<Edge> graph[],int indeg[]){
        for(int i=0;i<graph.length;i++){
            int v=i;
            for(int j=0;j<graph[v].size();j++){
                Edge e=graph[v].get(j);
                indeg[e.dest]++;
            }
        }
    }
    public static void topSortbfs(ArrayList<Edge> graph[]){
        int indeg[]=new int[graph.length];
        calcIndeg(graph, indeg);
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){//bfs
            int curr=q.remove();
            System.out.print(curr+" ");
            for(int i=0;i<graph[curr].size();i++){
                Edge e=graph[curr].get(i);
                if(indeg[e.dest]==0){
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }
    public static void printAllPath(ArrayList<Edge>graph[],int src,int dest,String path){
        if(src==dest){//exponential complexity
            System.out.println(path+dest);
            return;
        }
        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
            printAllPath(graph, e.dest, dest, path+src);
        }
    }
    static class Pair implements Comparable<Pair>{
        int n;
        int path;
        public Pair(int n,int path){
            this.n=n;
            this.path=path;
        }
        @Override
        public int compareTo(Pair p2){
            return this.path-p2.path;
        }
    }
    public static void dijsktra(ArrayList<Edge> graph[],int src){//O(V+E LOG V)
        int dist[]=new int[graph.length];//dist[i]->src to i
        for(int i=0;i<graph.length;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        boolean vis[]= new boolean[graph.length];
        PriorityQueue<Pair> pq= new PriorityQueue<>();
        pq.add(new Pair(src,0));
        while(!pq.isEmpty()){
            Pair curr=pq.remove();//shortest distance
            if(!vis[curr.n]){
                vis[curr.n]=true;
                for(int i=0;i<graph[curr.n].size();i++){
                    Edge e=graph[curr.n].get(i);
                    int u=e.src;
                    int v=e.dest;
                    int wt=e.wt;
                    if(dist[u]+wt<dist[v]){
                        dist[v]=dist[u]+wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }
    static void createGraph2(ArrayList<Edge> edges){
        // USING EDGES
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3 , 50));
    }
    public static void bellmanFord(ArrayList<Edge>graph[],int src){//O(V*E)
        int dist[]=new int[graph.length];
        for(int i=0;i<dist.length;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        int V=graph.length;
        for(int i=0;i<V-1;i++){ 
            for(int j=0;j<graph.length;j++){//vertex
                for(int k=0;k<graph[j].size();k++){//edge of particular vertex
                    // for(int j=0;j<edges.size();j++){
                    //     Edge e=edges.get(j);
                    // }
                    Edge e=graph[j].get(k);
                    int u=e.src;
                    int v=e.dest;
                    int wt=e.wt;
                    if(dist[u] !=Integer.MAX_VALUE && dist[u]+wt<dist[v]){
                        dist[v]=dist[u]+wt;
                    }
                }
            }
        }
        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }
    // static class Pair implements Comparable<Pair>{
    //     int v;
    //     int cost;
    //     public Pair(int v,int c){
    //         this.v=v; 
    //         this.cost=c;
    //     }
    //     @Override
    //     public int compareTo(Pair p2){
    //         return this.cost-p2.cost;//ascending order
    //     }
    // }
    // public static void prims(ArrayList<Edge> graph[]){
    //     boolean vis[]= new boolean[graph.length];
    //     PriorityQueue<Pair> pq= new PriorityQueue<>();
    //     pq.add(new Pair(0, 0));
    //     int finalCost=0;
    //     while(!pq.isEmpty()){
    //         Pair curr=pq.remove();
    //         if(!vis[curr.v]){
    //             vis[curr.v]=true;
    //             finalCost+=curr.cost;
    //             for(int i=0;i<graph[curr.v].size();i++){
    //                 Edge e=graph[curr.v].get(i);
    //                 pq.add(new Pair(e.dest,e.wt));
    //             }
    //         }
    //     }
    //     System.out.println(finalCost);
    // }
    static class Info{
        int v;
        int cost;
        int stops;
        public Info(int v,int c,int s){
            this.v=v;
            this.cost=c;
            this.stops=s;
        }
    }
    public static void createGraph3(int flights[][],ArrayList<Edge>graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<flights.length;i++){
            int src=flights[i][0];
            int dest=flights[i][1];
            int wt=flights[i][2];
            Edge e=new Edge(src,dest,wt);
            graph[src].add(e);
        }
    }
    public static int cheapestFlight(int n,int flights[][],int src,int dest,int k){
        ArrayList<Edge> graph[]= new ArrayList[n];
        createGraph3(flights,graph);
        int dist[]=new int[n];
        for(int i=0;i<n;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        Queue<Info>q=new LinkedList<>();
        q.add(new Info(src, 0, 0));
        while(!q.isEmpty()){
            Info curr=q.remove();
            if(curr.stops>k){
                break;
            }
            for(int i=0;i<graph[curr.v].size();i++){
                Edge e=graph[curr.v].get(i);
                int u=e.src;
                int v=e.dest;
                int wt=e.wt;
                if(curr.cost+wt<dist[v]&&curr.stops<=k){
                    dist[v]=curr.cost+wt;
                    q.add(new Info(v, dist[v],curr.stops+1));
                }
            }
        }
        if(dist[dest]==Integer.MAX_VALUE){
            return -1;
        }else{
            return dist[dest];
        }
    }
    // static class Edge implements Comparable<Edge>{ //USING PRIMS
    //     int dest;
    //     int cost;
    //     public Edge(int d,int c){
    //         this.dest=d;
    //         this.cost=c;
    //     }
    //     @Override
    //     public int compareTo(Edge e2){
    //         return this.cost-e2.cost;
    //     }
    // }
    // public static int connectCities(int cities[][]){
    //     PriorityQueue<Edge>pq= new PriorityQueue<>();
    //     boolean vis[]= new boolean[cities.length];
    //     pq.add(new Edge(0, 0));
    //     int finalCost=0;
    //     while(!pq.isEmpty()){
    //         Edge curr=pq.remove();
    //         if(!vis[curr.dest]){
    //             vis[curr.dest]=true;
    //             finalCost+=curr.cost;
    //             for(int i=0;i<cities[curr.dest].length;i++){
    //                 if(cities[curr.dest][i]!=0){
    //                     pq.add(new Edge(i, cities[curr.dest][i]));
    //                 }
    //             }
    //         }
    //     }
    //     return finalCost;
    // }
    
    //DISJOINT SET
    static int n=7;//vertices
    static int par[]=new int[n];
    static int rank[]=new int[n];

    public static void init(){
        for(int i=0;i<n;i++){
            par[i]=i;
        }
    }
    public static int find(int x){//O(1)
        if(x==par[x]){
            return x;
        }
        return par[x]=find(par[x]);//path compression
    }
    public static void union(int a,int b){//O(1)
        int parA=find(a);
        int parB=find(b);
        if(rank[parA]==rank[parB]){//cycle condition
            par[parB]=parA;
            rank[parA]++;
        }else if(rank[parA]<rank[parB]){
            par[parA]=parB;
        }else{
            par[parB]=parA;
        }
    }
    public static void kruskals(ArrayList<Edge> edges,int v){//O(V+ELOGE)
        init();
        Collections.sort(edges);//O(ELOG E)
        int mstCost=0;
        int count=0;
        for(int i=0;count<v-1;i++){//O(V)
            Edge e=edges.get(i);
            int parA=find(e.src);
            int parB=find(e.dest);
            if(parA!=parB){
                union(e.src,e.dest);
                mstCost+=e.wt;
                count++;
            }
        }
        System.out.println(mstCost);   
    }
    //O(M*N)
    public void helper(int image[][],int sr,int sc,int color,boolean vis[][],int orgCol){
        if(sr<0||sc<0||sr>=image.length||sc>=image[0].length||vis[sr][sc]||image[sr][sc]!=orgCol){
            return;
        }
        image[sr][sc]=color;
        //left
        helper(image, sr, sc-1, color, vis, orgCol);
        //right
        helper(image, sr, sc+1, color, vis, orgCol);
        //up
        helper(image, sr-1, sc, color, vis, orgCol);
        //down
        helper(image, sr+1, sc, color, vis, orgCol);

    }
    //O(1)
    public int[][] floodfill(int image[][],int sr,int sc,int color){
        boolean vis[][]=new boolean[image.length][image[0].length];
        helper(image,sr,sc,color,vis,image[sr][sc]);
        return image;
    }

    //KOSARAJU'S ALGO O(V+E)
    public static void kosaraju(ArrayList<Edge> graph[],int V){
        Stack<Integer> s= new Stack<>();
        boolean vis[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                topSortUtil(graph, i, vis, s);
            }
        }
        //step 2
        ArrayList<Edge> transpose[]= new ArrayList[V];
        for(int i=0;i<graph.length;i++){
            vis[i]=false;
            transpose[i]=new ArrayList<Edge>();
        }
        for(int i=0;i<V;i++){
            for(int j=0;i<graph[i].size();j++){
                Edge e=graph[i].get(j);
                // transpose[e.dest].add(new Edge(e.dest,e.src));
            }
        }
        //step3
        while(!s.isEmpty()){
            int curr=s.pop();
            if(!vis[curr]){
                System.out.println("Strongly Connected Components --> ");
                dfsUtil(transpose, curr, vis);
                System.out.println();
            }
        }
    }


    //TARJAN'S ALGORITHM
    // public static void dfs(ArrayList<Edge> graph,int curr,int par,int dt[],
    //                         int low[],boolean vis[],int time){
    //     vis[curr]=true;
    //     dt[curr]=low[curr]=++time;
    //     for(int i=0;i<graph[curr].size();i++){
    //         Edge e=graph[curr].get(i);//e.src----e.dest
    //         int neigh=e.dest;
    //         if(neigh==par){
    //             continue;
    //         }else if(!vis[neigh]){
    //             dfs(graph,neigh,curr,dt,low,vis,time);
    //             low[curr]=Math.min(low[curr],low[neigh]);
    //             if(dt[curr]<low[neigh]){
    //                 System.out.println("Bridge: "+curr+"------"+neigh);
    //             }
    //         }else{
    //             low[curr]=Math.min(low[curr], dt[neigh]);
    //         }
    //     }
                            
    // }
    // public static void tarjanBridge(ArrayList<Edge> graph[],int v){
    //     int dt[]=new int[v];
    //     int low[]=new int[v];
    //     int time=0;
    //     boolean vis[]=new boolean[v];
    //     for(int i=0;i<v;i++){
    //         if(!vis[i]){
    //             dfs(graph,i,-1,dt,low,vis,time);
    //         }
    //     }
    // }


    
    // //ARTICULATION POINT -O(V+E)
    // public static void dfs(ArrayList<Edge> graph[],int curr,int par,int dt[],
    //                         int low[],int time,boolean vis[],boolean ap[]){
    //     vis[curr]=true;
    //     dt[curr]=low[curr]=++time;
    //     int children =0;
    //     for(int i=0;i<graph[curr].size();i++){
    //         Edge e= graph[curr].get(i);
    //         int neigh=e.dest;
    //         if(par==neigh){
    //             continue;
    //         }else if(vis[neigh]){
    //             low[curr]=Math.min(low[curr],dt[neigh]);
    //         }else{
    //             dfs(graph,neigh,curr,dt,low,time,vis);
    //             low[curr]=Math.min(low[curr],low[neigh]);
    //             if(par!=-1 && dt[curr]<=low[neigh]){
    //                 ap[curr]=true;
    //             }
    //             children++;
    //         }
    //     }
    //     if(par==-1 && children >1){
    //         ap[curr]=true;
    //     }
    // }

    // public static getArticulationPoint(ArrayList<Edge> graph[],int v){
    //     int dt[]=new int[v];
    //     int low[]=new int[v];
    //     int time=0;
    //     boolean vis[]=new boolean[v];
    //     boolean ap[]=new boolean[v];
    //     for(int i=0;i<v;i++){
    //         if(!vis[i]){
    //             dfs(graph,i,-1,dt,low,time,vis,ap);
    //         }
    //     }
    //     //print APs
    //     for(int i=0;i<v;i++){
    //         if(!ap[i]){
    //             System.out.println("AP: "+i);
    //         }
    //     }
    // }
    public static void main(String args[]){
        /* 0-----1
                / \
               /   \
              2-----3
              |
              |
              4
        */
        int v=5;
        ArrayList<Edge> graph[]= new ArrayList[v];
        createGraph(graph);
        // bfs(graph);
        // dfs(graph, 0, new boolean[v]);
        // prims(graph);
        // System.out.println(hasPath(graph, 0, 5, new boolean[v]));
        // System.out.println(isBarpatite(graph));
        // topSortbfs(graph);
        // int src=0;
        // dijsktra(graph, src);
        // bellmanFord(graph, src);
        // ArrayList<Edge> edges= new ArrayList<>();
        // createGraph2(edges);

        //CHEAPEST FLIGHT
        // int n=4;
        // int flights[][]={{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        // int src=0,dst=3,k=1;
        // ArrayList<Edge>graph[]=new ArrayList[n];
        // createGraph3(flights,graph);
        // System.out.println(cheapestFlight(n, flights, src, dst, k));

        //CONNECTING CITIES
        // int cities[][]={{0,1,2,3,4},{1,0,5,0,7},{2,5,0,6,0},{3,0,6,0,0},{4,7,0,0,0}};
        // System.out.println(connectCities(cities));

        //DISJOINT SET
        // init();
        // union(1,3);
        // System.out.println(find(3));
        // union(2,4);
        // union(3, 6);
        // union(1, 4);
        // System.out.println(find(3));
        // System.out.println(find(4));
        // union(1, 5);

        // kosaraju(graph, v);
        // tarjanBridge(graph, v);
        // getArticulationPoint(graph,v);
    }
}