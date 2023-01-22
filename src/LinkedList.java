public class LinkedList {
    int size=0;
    Node head;
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public void addFirst(int data){
        size++;
        Node nn=new Node(data);
        if(head==null){
            head=nn;
            return;
        }
        nn.next=head;
        head=nn;
    }

    public void addLast(int data){
        size++;
        Node nn=new Node(data);
        if(head==null){
            head=nn;
            return;
        }
        Node curr=head;
        while(curr.next!=null) curr=curr.next;
        curr.next=nn;
    }

    public void deleteFirst(){
        if(head!=null) size--;
        if(head==null){
            System.out.println("List is already empty");
            return;
        }
        head=head.next;
    }

    public void deleteLast(){
        if(head!=null) size--;
        if(head==null){
            System.out.println("List is already empty");
            return;
        }
        else if(head.next==null){
            head=null;
            return;
        }
        Node curr=head;
        while(curr.next.next!=null) curr=curr.next;
        curr.next=null;
    }

    public void reverse(){
        if(head==null || head.next==null){
            return;
        }
        Node prev=head;
        Node curr=head.next;
        while(curr!=null){
            Node nxn=curr.next;
            curr.next=prev;

            prev=curr;
            curr=nxn;
        }
        head.next=null;
        head=prev;
    }

    public Node recreverse(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node newhead=recreverse(head.next);
        head.next.next=head;
        head.next=null;
        return newhead;
    }
    public int size(){
        return size;
    }

    public void display(){
        Node curr=head;
        while(curr!=null) {
            System.out.print(curr.data + " ");
            curr=curr.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        LinkedList ll=new LinkedList();
        ll.addFirst(1);
        ll.addFirst(5);
        ll.addFirst(13);
        ll.addLast(10);
        ll.addLast(17);

        ll.display();
        System.out.println(ll.size);
        ll.deleteFirst();
        ll.deleteLast();
        ll.display();
        System.out.println(ll.size);
        ll.reverse();
        ll.display();
    }
}
