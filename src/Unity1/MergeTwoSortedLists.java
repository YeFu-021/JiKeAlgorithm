/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */

package Unity1;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode a=new ListNode();
        ListNode head = a;
        while(l1!=null||l2!=null){
            if(l1==null){
                a.next=new ListNode(l2.val);
                l2=l2.next;
            }
            else if(l2==null){
                a.next=new ListNode(l1.val);
                l1=l1.next;
            }
            else if(l1.val>l2.val){
                a.next=new ListNode(l2.val);
                l2=l2.next;
            }else{
                a.next=new ListNode(l1.val);
                l1=l1.next;
            }
            a=a.next;
        }

        return head.next;
    }
}
