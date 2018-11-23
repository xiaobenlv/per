package ListNode;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val=x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}


public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode=null;
        if (l1!=null&&l2!=null){
            listNode=l1.val<l2.val?l1:l2;
            ListNode l3=l1.val<l2.val?l1.next:l2.next;
            ListNode l4=l1.val<l2.val?l2:l1;
            listNode.next=mergeTwoLists(l3,l4);

            return listNode;
        }else if (l1==null){
            return l2;
        }else if (l2==null){
            return l1;
        }
        return listNode;

    }


    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(1);
        l1.next=new ListNode(2);
        l2.next=new ListNode(3);

        ListNode listNode= new MergeTwoLists().mergeTwoLists(l1,l2);
        System.out.print(listNode);


    }
}
