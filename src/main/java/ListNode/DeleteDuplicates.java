package ListNode;

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
// 最后要返回head节点，保存
        ListNode orhead=head;
//因为下面用到了head.val，如果head是空的话 就会出现空指针错误
//            if (head!=null){
//                ListNode listNode=new ListNode(head.val);
//                while (head.next!=null){
//                    listNode.val=head.val;
//
//                    if (head.val!=head.next.val){
//                        head=head.next;
//                    }else {
////                        如果head.next.next为空，只是将空赋给head.next
////                      （只要不对空的对象进行操作，取属性，用方法）
//                        head.next=head.next.next;
//                    }
//
//                    if (head==null){
//                        break;
//                    }
//            }
//            }

        while (head!=null&&head.next!=null){
            if (head.val!=head.next.val){
                head=head.next;
            }else {
                head.next=head.next.next;
//              问题：orhead中的next，如果在head操作中已经被删除了怎么办？？？？
            }
        }

        return orhead;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(1);
        head.next.next=new ListNode(2);
        head.next.next.next=new ListNode(3);
        head.next.next.next.next=new ListNode(3);
        ListNode listNode=new DeleteDuplicates().deleteDuplicates(head);
        System.out.print(listNode);
    }


}

//    public ListNode deleteDuplicates(ListNode head) {
//        ListNode current = head;
//        while (current != null && current.next != null) {
//            if (current.next.val == current.val) {
//                current.next = current.next.next;
//            } else {
//                current = current.next;
//            }
//        }
//        return head;
//    }
