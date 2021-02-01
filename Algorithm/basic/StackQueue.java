import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.NoSuchElementException;

class Queue<T>{
    class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data){
            this.data = data;
        }
    }

    private Node<T> first;
    private Node<T> last;

    public void enqueue(T item){
        Node<T> t = new Node<T>(item);

        if(last!=null){ //마지막 노드가 있다면
            last.next = t;
        }
        last = t;
        if(first ==null){
            first=last;
        }
    }
    public T dequeue(){
        if(first==null){
            throw new NoSuchElementException();
        }

        //데이터 백업
        T data = first.data;
        first = first.next;

        if(first==null){
            last =null;
        }
        return data;
    }

    public T peek(){
        if(first==null){
            throw new NoSuchElementException();
        }
        return first.data;
    }

    public boolean isEmpty(){
        return first==null;
    }
}



class Graph{
    class Node{
        int data;
        LinkedList<Node> adjacent;
        boolean marked;
        Node(int data){
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<Node>();
        }
    }
    Node[] nodes;
    Graph(int size){
        nodes = new Node[size];
        for(int i=0;i<size;i++){
            nodes[i] = new Node(i);
        }
    }
    void addEdge(int i1, int i2){
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if(!n1.adjacent.contains(n2)){
            n1.adjacent.add(n2);
        }
        if(!n2.adjacent.contains(n1)){
            n2.adjacent.add(n1);
        }
    }
    void dfs(){
        dfs(0);
    }
    void dfs(int index){
        Node root = nodes[index];
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        root.marked = true;
        while(!stack.isEmpty()){
            Node r = stack.pop();
            for(Node n : r.adjacent){ //Node n과 인접한 모든 노드들을 스택에 추가
                if(n.marked == false){ //스택에 한번도 들어가지 않은 노드들만 추가하는 것.
                    n.marked=true;
                    stack.push(n);
                }
            }
            visit(r);
        }
    }
    void bfs(){
        bfs(0);
    }

    void bfs(int index){
        Node root = nodes[index];
        Queue<Node> queue = new Queue<Node>();
        queue.enqueue(root);
        root.marked = true;
        while(!queue.isEmpty()){
            Node r = queue.dequeue();
            for(Node n: r.adjacent){
                if(n.marked==false){
                    n.marked =true;
                    queue.enqueue(n);
                }
            }
            visit(r);
        }
    }

    void dfsR(Node r){
        if(r==null) return;
        r.marked = true;
        //자식들을 호출하기 전에 데이터를 먼저 출력
        visit(r);
        for(Node n: r.adjacent){
            if(n.marked==false){
                dfsR(n);
            }
        }
    }

    void dfsR(){
        dfsR(0);
    }

    void dfsR(int index){
        Node r = nodes[index];
        dfsR(r);
        //인덱스를 받으면 노드를 찾아서 해당 노드를 시작점으로 재귀호출을 진행.
    }


    void visit(Node n){
        System.out.print(n.data+" ");
    }

}

public class Practice {
    public static void main(String[] args) {
        //Depth-first Search(DFS) 끝까지 파고드는 것. Stack을 이용해서 구현
        Graph g = new Graph(9);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,4);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(3,5);
        g.addEdge(5,6);
        g.addEdge(5,7);
        g.addEdge(6,8);

        g.dfsR(3);
    }
}
