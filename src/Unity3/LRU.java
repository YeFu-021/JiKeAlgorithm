/**
 * 运用你所掌握的数据结构，设计和实现一个LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 *
 * LRUCache(int capacity) 以正整数作为容量capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 *
 * LRU：最近最少使用（淘汰最旧数据）
 *
 * 进阶：你是否可以在O(1) 时间复杂度内完成这两种操作？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

package Unity3;

import org.w3c.dom.Node;

import java.util.HashMap;

public class LRU {

    class Node{
        public int key;
        public int value;
        Node pre;
        Node next;
    }
    private int capacity;// 双向链表容量
    private HashMap<Integer , Node> map;
    Node head;
    Node tail;

    public LRU(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!this.map.containsKey(key)){
            return -1;
        }
        // 调用里面有的元素，会使该元素重新到达链表头
        Node node = this.map.get(key);
        // 从链表和map中删除
        this.removeFromList(node);
        // 重写插入链表头和map
        this.insertToListHead(node.key,node.value);

        return node.value;

    }

    public void put(int key, int value) {
        if (this.map.containsKey(key)){
            Node node = this.map.get(key);
            // 从双向链表中删除 维护时间顺序
            removeFromList(node);
            // 重新插入到链表中
            insertToListHead(key,value);
        }else {
            Node node = insertToListHead(key,value);

        }

        if (this.map.size()>capacity){
            this.removeFromList(this.tail.pre);
        }
    }

    private Node insertToListHead(int key, int value) {
        Node node = new Node();
        node.key = key;
        node.value = value;
        // node与head下个点之间建立联系
        node.next = head.next;
        head.next.pre = node;
        // node与head建立联系
        node.pre = head;
        head.next = node;
        this.map.put(key,node);
        return node;
    }

    private void removeFromList(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        this.map.remove(node.key);
    }

}
