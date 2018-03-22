package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by bethunebtj on 2015/10/4.
 * 强连通分量的Kosaraju算法的完整实现，包括一个图的数据结构。
 * 未加入检测是否为环的代码
 */

public class Connect {
    private boolean [] marked;
    private int[] id;//每个节点的连通分量标识符
    private LinkedList<Integer> reverseStack;
    private Graph g;
    private int count;//强连通分量的数目
    public Connect(){
        count=0;
        System.out.println("输入要判断的图的节点数");
        int v=(new Scanner(System.in)).nextInt();
        g=new Graph(v);

        marked=new boolean[v];
        id=new int[v];
        while (!reverseStack.isEmpty()){
            int k=reverseStack.getFirst();
            reverseStack.removeFirst();
            if (!marked[k]){
                dfs(k);
                count++;
            }
        }
    }
    private void dfs(int v){
        marked[v]=true;
        id[v]=count;
        for (int w:g.adj(v)){
            if (!marked[w]){
                dfs(w);
            }
        }
    }
    public boolean stronglyConnected(int v,int w){
        return id[v]==id[w];
    }

    public int getCount() {
        return count;
    }
    public static void main(String...args) throws Exception{
    	Connect a = new Connect();
        System.out.println(a.getCount());
        //System.out.println(a.g.toString());
        System.out.println(a.stronglyConnected(6,0));
        //System.in.read();
    }
}




class Graph{
    private int V;//顶点数
    private int E;//边数
    private HashSet<Integer>[]  Adj;//邻接表
    public LinkedList<Integer> stack;//逆后序排列的栈
    private boolean[] marked;//判断dfs用的数组
    private int[] attach;

    //手动输入所有对连接的构造函数
    public Graph(int v){
        this(v, 0);
        System.out.println("输入成对的数值，在0-V之间，不然报错");
        Scanner s=new Scanner(System.in);
        while (s.hasNextInt()){
            int v1=s.nextInt();
            int v2=s.nextInt();
            addEdge(v1,v2);
        }
    }
    public Graph(int v,int e){
        this.V=v;
        this.E=0;
        Adj=(HashSet<Integer>[])new HashSet[v];//不允许泛型数组
        stack=new LinkedList<Integer>();
        attach=new int[v];
        marked=new boolean[v];
        for (int i=0;i<v;i++){
            Adj[i]=new HashSet<Integer>();
        }
    }
    private void addEdge(int v,int w){
        Adj[v].add(w);
        E++;
    }
    //返回某个顶点的所有邻接点
    public Iterable<Integer> adj(int v){
        return  Adj[v];
    }
    public int v(){
        return  V;
    }
    public int e(){
        return E;
    }
    //求反向图,返回一个已经计算好的反向图
    public Graph reverse(){
        Graph r=new Graph(this.V,this.E);
        for (int i=0;i<V;i++){
            for (int x:Adj[i]){
                r.addEdge(x,i);
            }
        }
        for (int i=0;i<V;i++){
            if (!r.marked[i]){
                r.dfs(r,i);
            }
        }
        return r;
    }
    public void dfs(Graph r,int v){
        r.marked[v]=true;
        for (int j:r.Adj[v]){
            if (!r.marked[j]){
                r.attach[j]=v;
                r.dfs(r,j);
            }
        }
        r.stack.addFirst(v);//求逆后序排列
    }
    public String toString(){
        StringBuilder s= new StringBuilder("V:"+V+" E:"+E+"\n");
        for (int i=0;i<V;i++){
            s.append(i + " has these links: \n");
            for (int j:Adj[i]){
                s.append(j+" ");
            }
            s.append("\n");
        }
        return s.toString();
    }
}