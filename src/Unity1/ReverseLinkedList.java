/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
package Unity1;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode a = null;// 尾节点
        while(head!=null){//这里要访问n个节点 所以是head!=null
            ListNode temp=head.next;// 储存head的下一个节点
            head.next=a;// 当前head节点指向尾节点
            a=head;//使尾节点a成为反转链表的头节点
            head=temp;//head到达下一个节点
        }
        return a;// 不是返回head节点 ， 通过画图理解
    }
}
