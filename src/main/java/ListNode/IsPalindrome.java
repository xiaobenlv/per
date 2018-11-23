package ListNode;

public class IsPalindrome {
    public boolean idPalindrome(ListNode head){
        if (head==null||head.next==null){
            return true;

        }
        if (head.next.next==null){
            if (head.val!=head.next.val){
                return false;
            }
        }
        ListNode prehead=head;

        ListNode middle=middleNode(head);
        System.out.println(middle);

        ListNode after=reverList(middle);
        middle.next=null;
        System.out.println(after);
        while (after!=null&&prehead!=null){
            if (after.val!=prehead.val){
                return false;
            }
            after=after.next;
            prehead=prehead.next;
            if (after==null||prehead==null){
                return true;
            }

        }
        return true;

    }
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
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(2);
        head.next.next.next.next=new ListNode(1);
//        head.next.next.next.next.next=new ListNode(1);

        Boolean b=new IsPalindrome().idPalindrome(head);
        System.out.println(b);

    }
}
