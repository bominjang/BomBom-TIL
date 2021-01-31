import java.util.EmptyStackException;

class Stack<T>{
    class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data){
            this.data = data;
        }
    }

    //스택은 맨 위에 올라와있는 노드의 주소만 알면 됨.
    private Node<T> top;
    public T pop(){
        if(top==null){
            throw new EmptyStackException();
        }

        T item = top.data;
        //다음 노드를 top으로 만들어 줌.
        top = top.next;
        return item;
    }

    public void push(T item){
        Node<T> t = new Node<T>(item);
        //top 앞에 해당 노드를 위치시킴.
        t.next = top;
        //top에 t를 위치시킴.
        top = t;
    }
    public T peek(){
        if(top==null){
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty(){
        return top==null;
    }
}

public class Practice {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
        
    }
}
