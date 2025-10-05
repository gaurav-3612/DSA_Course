package queue;

import java.util.Deque;
import java.util.LinkedList;

public class dequeImplementation {

    public static void main(String[] args) {
        Deque<Integer> d = new LinkedList<>();
        d.addFirst(1);
        d.addLast(2);
        d.addFirst(3);
        d.removeFirst();
        d.removeLast();
        int p = d.getFirst();
        int q = d.getLast();
        System.out.println(p + "," + q);
        System.out.println(d);
    }
}
/*
 class MyCircularDeque {
    Deque<Integer> d; // if we made these variables static then it is only used for one object of MycircularDeque then same passed to other object but we need new every time
    int k;
    public MyCircularDeque(int k) { // this is constructor used to pass k by this we can use k in all other below methods
        d=new LinkedList<>();
        this.k=k;
    }
    
    public boolean insertFront(int value) { // if we made this method static then we can call it directly in main method without creating any object but now we need to first create object of class then call it by class.method();
        if(d.size()==k){
            return false;
        }
        d.addFirst(value);
        return true;
    }
    
    public boolean insertLast(int value) {
        if(d.size()==k){
            return false;
        }
        d.addLast(value);
        return true;
    }
    
    public boolean deleteFront() {
        if(d.size()==0){
            return false;
        }
        d.removeFirst();
        return true;
    }
    
    public boolean deleteLast() {
         if(d.size()==0){
            return false;
        }
        d.removeLast();
        return true;
    }
    
    public int getFront() {
         if(d.size()==0){
            return -1;
        }
        return d.getFirst();
    }
    
    public int getRear() {
        if(d.size()==0){
            return -1;
        }
        return d.getLast();
    }
    
    public boolean isEmpty() {
        return d.size()==0;
    }
    
    public boolean isFull() {
        return d.size()==k;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
*/
