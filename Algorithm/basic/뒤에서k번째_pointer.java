import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        LinkedList ll = new LinkedList();

        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.retrieve();


        int k=2;
        Reference r = new Reference();
        LinkedList.Node found = KthToLast(ll.getFirst(),k);
        System.out.println(found.data);

    }

    public static class Reference{
        public int count = 0;
    }

    private static LinkedList.Node KthToLast(LinkedList.Node first, int k){
        LinkedList.Node p1 = first;
        LinkedList.Node p2 = first;

        for(int i=0;i<k;i++){
            if(p1==null) return null;
            p1 = p1.next;
        }
        while(p1!=null){ //마지막 노드까지!
            p1=p1.next;
            p2=p2.next;
        }
        return p2;

    }

    static class LinkedList{
        Node header;

        static class Node{
            int data;
            Node next=null;
        }

        LinkedList(){
            header = new Node();
        }

        void append(int d){
            Node end = new Node();
            end.data = d;
            Node n = header;
            while(n.next!=null){
                n=n.next;
            }
            n.next = end;
        }
        void delete(int d){
            Node n = header;
            while(n.next!=null){
                if(n.next.data==d){
                    n.next = n.next.next;
                }
                else{
                    n=n.next;
                }
            }
        }
        void retrieve(){
            Node n = header.next;
            while(n.next !=null){
                System.out.print(n.data+"-> ");
                n=n.next;
            }
            System.out.println(n.data);
        }

        void removeDups(){
            Node n = header;
            while(n != null && n.next!=null){ //마지막 노드까지 잘 비교할 수 있도록.
                Node r = n; //runner
                while(r.next!=null){
                    if(n.data==r.next.data){ //runner는 n과 같은 위치에서 시작함. 그러고 앞의 노드를 내다보는 것.
                        //전에 애가 갖고있는 다음 주소를, 다다음 주소로 바꿈.
                        r.next = r.next.next;
                    }else{
                        r = r.next;
                    }
                }
                n=n.next;
            }
        }

        Node getFirst(){
            return this.header;
        }
    }


}

