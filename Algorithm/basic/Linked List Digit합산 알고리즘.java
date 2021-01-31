import java.io.IOException;

class Storage{
    int carry = 0;
    Main.LinkedList.Node result = null;
}


public class Main {
    public static void main(String[] args) throws IOException {
        LinkedList l1 = new LinkedList();

        l1.append(9);
        l1.append(1);
        l1.retrieve();

        LinkedList l2 = new LinkedList();
        l2.append(1);
        l2.append(1);
        l2.retrieve();

        LinkedList.Node n = sumLists(l1.get(1), l2.get(1));
        while(n.next!=null){
            System.out.print(n.data+"-> ");
            n = n.next;
        }
        System.out.print(n.data);
    }

    public static class Reference{
        public int count = 0;
    }

    private static LinkedList.Node sumLists(LinkedList.Node l1,LinkedList.Node l2){
        int len1 = getListLength(l1);
        int len2 = getListLength(l2);

        if(len1<len2){
            l1=LPadList(l1,len2-len1);
        }else {
            l2=LPadList(l2,len1-len2);
        }

        //길이를 맞춘 리스트 전
        Storage storage = addLists(l1, l2);
        if(storage.carry == 0){
            return storage.result;
        }else{
            storage.result = insertBefore(storage.result, storage.carry);
            return storage.result;
        }
    }

    private static Storage addLists(LinkedList.Node l1, LinkedList.Node l2){
        if(l1==null && l2==null){
            Storage storage = new Storage();
            return storage;
        }
        Storage storage = addLists(l1.next, l2.next);
        int value = storage.carry + l1.data + l2.data;
        int data = value%10;
        storage.result = insertBefore(storage.result, data);
        storage.carry = value/10;
        return storage;
    }
    private static int getListLength(LinkedList.Node l){
        int total = 0;
        while(l!=null){
            total++;
            l = l.next;
        }
        return total;
    }
    private static LinkedList.Node insertBefore(LinkedList.Node node, int data){
        LinkedList.Node before = new LinkedList.Node(data);
        if(node!=null){
            before.next = node;
        }
        return before;
    }

    private static LinkedList.Node LPadList(LinkedList.Node l, int length){
        LinkedList.Node head = l;
        //노드를 하나 복사해서 헤드에 붙여줌.
        for(int i=0; i<length;i++){
            head = insertBefore(head,0);
        }
        return head;
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

            public Node(int d){
                this.data=d;
            }

            public Node() {

            }
        }

        LinkedList(){
            header = new Node();
        }

        Node get(int d){
            int count=1;
            Node n = header;
            while(n.next!=null){
                if(count == d){
                    break;
                }
                count++;
                n=n.next;
            }
            return n.next;
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
        

        Node getFirst(){
            return this.header;
        }
    }


}

