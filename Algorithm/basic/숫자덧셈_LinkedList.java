//어떤 숫자를 자리수 별로 한개씩 linkedList에 담았다.
// 그런데 1의 자리가 헤더에 오도록 거꾸로 담았다.
// 이런 식의 LinkedList 두 개를 받아서 합산하고 같은식으로 LinkedList에 담아서 반환하라.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        LinkedList l1 = new LinkedList();

        l1.append(9);
        l1.append(1);
        l1.append(4);
        l1.retrieve();

        LinkedList l2 = new LinkedList();
        l2.append(6);
        l2.append(4);
        l2.append(3);
        l2.retrieve();

        LinkedList.Node n = sumLists(l1.get(1), l2.get(1), 0);
        while(n.next!=null){
            System.out.print(n.data+"-> ");
            n = n.next;
        }
        System.out.print(n.data);
    }

    private static LinkedList.Node sumLists(LinkedList.Node l1,LinkedList.Node l2, int carry ){
        if(l1 == null && l2 == null && carry ==0){
            return null;
        }

        LinkedList.Node result = new LinkedList.Node();
        int value = carry;

        if(l1 != null){
            value +=l1.data;
        }
        if(l2 != null){
            value +=l2.data;
        }
        result.data = value%10;

        if(l1!=null||l2!=null){
            LinkedList.Node next = sumLists(l1==null?null : l1.next,
                                            l2==null?null:l2.next,
                                            value >= 10 ? 1:0);
            result.next = next;
        }
        return result;
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

