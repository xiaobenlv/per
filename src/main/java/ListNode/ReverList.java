package ListNode;

public class ReverList {
    public ListNode reverList(ListNode head){

        if (head==null||head.next==null){
            return head;
        }
        ListNode p=head;
        ListNode q=head.next;
        ListNode r=head.next.next;
        p.next=null;
        if (r==null){
            q.next=p;
            p.next=null;
            return q;
        }
        while (r!=null){
            q.next=p;
            p=q;
            q=r;

            r=r.next;
        }
        q.next=p;
        return q;

    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(1);
        head.next.next=new ListNode(1);
        head.next.next.next=new ListNode(6);


        ListNode node=new ReverList().reverList(head);
        System.out.println(node+" "+node.next+" "+node.next.next+" "+node.next.next.next+" ");
    }
}
