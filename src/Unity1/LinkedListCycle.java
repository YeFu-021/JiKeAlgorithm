
package Unity1;

public class LinkedListCycle {
    /**
     * 给定一个链表，判断链表中是否有环。
     *
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
     * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     *
     * 如果链表中存在环，则返回 true 。 否则，返回 false 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/linked-list-cycle
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean hasCycle(ListNode head) {
        // 判断是否为空 或 只有一个节点
        if(head==null||head.next==null){
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast!=slow){
            if(fast==null||fast.next==null){
                return false;
            }
            fast = fast.next.next;// 快指针每次走两步
            slow = slow.next;// 慢指针每次走一步
        }
        return true;
    }

    /**
     * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     *
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
     * 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
     *
     * 说明：不允许修改给定的链表。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode detectCycle(ListNode head) {
        // 链表为空时不能成环
        if(head==null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null){
            if(fast.next==null||fast.next.next==null) return null;
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                // 由递推公式可得 环长 r - 环内相遇距离 d = 入环点到表头的距离 a
                while(head!=null){
                    if(head==slow) return head;
                    head=head.next;
                    slow=slow.next;
                }
            }
        }
        return null;
    }


}
