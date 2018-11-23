package ListNode;

public class DeleteNode {
    //
    public void deleteNode(ListNode node){
        if(node!=null&&node.next!=null){
            node.val=node.next.val;
            node.next=node.next.next;
            System.out.println("success");
        }
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(4);
        head.next=new ListNode(5);
        head.next.next=new ListNode(9);
        head.next.next.next=new ListNode(1);
        new DeleteNode().deleteNode(head.next);

    }

}
