package Test;

import Unity2.MyCircularDeque;

public class TestDeque {
    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);

        myCircularDeque.insertFront(1);    	     // 返回 true
        myCircularDeque.insertLast(2);	            // 返回 true
        myCircularDeque.insertFront(3);			    // 返回 true
        myCircularDeque.insertFront(4);			    // 已经满了，返回 false
        myCircularDeque.getRear();  				    // 返回 2
        myCircularDeque.isFull();				        // 返回 true
        myCircularDeque.deleteLast();			        // 返回 true
        myCircularDeque.insertFront(4);			    // 返回 true
        myCircularDeque.getFront();				    // 返回 4
    }



}
