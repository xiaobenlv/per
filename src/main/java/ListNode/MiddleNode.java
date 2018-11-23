package ListNode;

public class MiddleNode {
    public ListNode middleNode(ListNode head){


        ListNode p=head;
        ListNode q=head;

        if (p==null||p.next==null){
            return p;
        }

        while (p.next!=null){
            p=p.next.next;
            q=q.next;
            if (p==null){
                return q;
            }
        }
        return q;
    }
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next=new ListNode(6);

        ListNode node=new MiddleNode().middleNode(head);
        System.out.println(head+" "+head.next+" "+head.next.next+" "+head.next.next.next+" "+head.next.next.next.next+"" +
                " "+head.next.next.next.next.next);
        System.out.println(node);
    }

}
