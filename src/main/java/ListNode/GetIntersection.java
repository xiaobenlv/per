package ListNode;

public class GetIntersection {
    public ListNode get(ListNode headA, ListNode headB){
        if (headA==null||headB==null){
            return null;
        }
        int headAlength=0;
        int headBlength=0;

        ListNode p=headA;
        ListNode q=headB;

        while (headA!=null){
            headAlength++;
            headA=headA.next;
        }

        while (headB!=null){
            headBlength++;
            headB=headB.next;
        }
//        在右端对其之前，左边的多余的不要
        while (headAlength>headBlength){
            p=p.next;
            headAlength--;
        }
        while (headBlength>headAlength){
            q=q.next;
            headBlength--;
        }
        while (p != null) {
            if (p == q)
                return p;
            p = p.next;
            q = q.next;
        }

        return null;
    }
    public static void main(String[] args) {
        GetIntersection getIntersectionNode=new GetIntersection();
        ListNode head=new ListNode(1);
        head.next=new ListNode(51);
//        head.next.next=new ListNode(1);
//        head.next.next.next=new ListNode(6);
//        head.next.next.next.next=new ListNode(6);
//        head.next.next.next.next.next=new ListNode(6);
//        head.next.next.next.next.next.next=new ListNode(6);
        ListNode head1=new ListNode(2);


        head1.next=new ListNode(3);
        head1.next.next=new ListNode(4);
        head1.next.next.next=head.next;
        ListNode node=getIntersectionNode.get(head,head1);
        System.out.println(node);



    }
}
