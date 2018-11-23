package ListNode;

public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode orhead = head;
        ListNode newhead=head;
        while (head != null && head.next != null) {
            if (head.val == val) {
                head.val = head.next.val;
                head.next = head.next.next;
            }else {
                newhead = head;
                head = head.next;
            }

        }
//        单链表删除尾节点---把之前那个值存起来
        if (head.next==null){
            if (head.val==val){
                if (newhead.val!=val){
                    newhead.next=null;
                    return orhead;
                }else {
                    return null;
                }

            }
        }
        if (head==null){
            return null;
        }

        return orhead;

    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(1);
        head.next.next=new ListNode(1);
        head.next.next.next=new ListNode(6);
        head.next.next.next.next=new ListNode(6);
        head.next.next.next.next.next=new ListNode(6);
        head.next.next.next.next.next.next=new ListNode(6);

        ListNode node=new RemoveElements().removeElements(head,6);
        System.out.println(head+" "+head.next+" "+head.next.next+" "+head.next.next.next+" ");




        }
    }


