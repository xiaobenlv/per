package ListNode;

public class HasCycle {
    public boolean hasCycle(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (fast==slow){
                return true;
            }
            if (fast==null){
                return false;
            }
        }

        return false;
    }

    public ListNode getEntrance(ListNode head){
        ListNode prehead=head;
        ListNode fast=head;
        ListNode slow=head;
        ListNode meet=null;

        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (fast==slow){
                meet=fast;
                break;
            }
        }
        while (meet!=prehead){
            meet=meet.next;
            prehead=prehead.next;
        }

        return meet;
    }
    public int getCycleLength(ListNode head){
        ListNode getlength=getEntrance(head);
        ListNode node=getlength;
        int length=1;
        while (getlength.next!=node){
            getlength=getlength.next;
            length++;

        }
        return length;

    }

//    https://blog.csdn.net/sinat_35261315/article/details/79205157


    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(1);
        head.next.next=new ListNode(1);
        head.next.next.next=new ListNode(6);
        head.next.next.next.next=new ListNode(6);
        head.next.next.next.next.next=head.next;


        Boolean b=new HasCycle().hasCycle(head);
        System.out.println(b);


    }
}
