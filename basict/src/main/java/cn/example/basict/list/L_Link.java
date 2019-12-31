package cn.example.basict.list;

import java.util.HashSet;
import java.util.NoSuchElementException;

/**
 * Author：created by SugarT
 * Time：2019/11/14 13
 */
public class L_Link {

    public static void main(String args[]) {

        SingleLinkedList singleLinkedList = new SingleLinkedList();

//        System.out.println(singleLinkedList.findMidNode().data);

        singleLinkedList.addFooter(1);
        singleLinkedList.addFooter(1);
        singleLinkedList.addFooter(1);
        singleLinkedList.addFooter(2);
        singleLinkedList.addFooter(3);

//        singleLinkedList.display();

//        singleLinkedList.addHead(0);

//        singleLinkedList.deleteFooter();
//        singleLinkedList.deleteFooter();
//        singleLinkedList.deleteFooter();
//        singleLinkedList.display();


//        singleLinkedList.deleteHead();
//        singleLinkedList.deleteHead();
//        singleLinkedList.deleteHead();

//        singleLinkedList.display();
//
//        System.out.println("---发现节点----");
//
//        System.out.println(singleLinkedList.delete(3).data);
//        System.out.println(singleLinkedList.delete(2).data);
////        System.out.println(singleLinkedList.delete(1).data);
////        System.out.println(singleLinkedList.delete(0).data);
//
//        singleLinkedList.display();



//        singleLinkedList.display();

        detectCycle(singleLinkedList.header);

    }


    public static Node detectCycle(Node head) {

        if (head == null || head.next == null) {
            return head;
        }
        Node res = new Node(-1);
        Node node = res;
        while (head != null) {
            boolean dup = false;
            while (head != null && head.next != null && (Integer)head.data == (Integer) head.next.data) {
                head = head.next;
                dup = true;
            }
            if (!dup) {
                res.next = head;
                res = res.next;

            }
            head = head.next;
        }
        res.next = null;  //防止res后面还有重复的节点
        return node.next;


//        if(head == null || head.next == null){
//            return null;
//        }
//        HashSet<Node> hashSet = new HashSet<>();
//        Node current = head;
//        while (current!=null){
//            if(!hashSet.add(current)){
//                return current;
//            }
//            current = current.next;
//        }
//        return null;
    }


    /**
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(Node head) {

        /**
         * 解法1
         */
//        if(head == null || head.next == null){
//            return false;
//        }
//        Node first = head;
//        Node second = head;
//
//        while(second!= null && second.next != null ){
//            first = first.next;
//            second = second.next.next;
//            if(first == second){
//                return true;
//            }
//        }
//        return false;

        /**
         * 解法2
         */
        if (head == null || head.next == null) {
            return false;
        }

        HashSet<Node> hashSet = new HashSet();
        Node current = head;
        while (current != null) {
            if (!hashSet.add(current)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }


    public static Node oddEvenList(Node head) {

        Node odd = new Node(-1);
        Node even = new Node(-1);

        Node first = head;

        Node oddHeader = odd;
        Node evenHeader = even;

        int count = 0;
        while (first != null) {
            if (count % 2 == 0) {
                oddHeader.next = first;
                oddHeader = first;
            } else {
                evenHeader.next = first;
                evenHeader = first;
            }
            ++count;
            first = first.next;
        }
        evenHeader.next = null;
        oddHeader.next = even.next;
        return odd.next;
    }


    public static Node removeElements(Node head, int val) {


//        Node current = head;
//
//        while (current.next != null) {
//
//            if (current.next.data == val) {
//                current.next = current.next.next;
//            } else {
//                current = current.next;
//            }
//        }

        return head;


//        while(head!=null&&head.data==val){
//            head=head.next;
//        }
//        Node current = head;
//        Node parent = head;
//        while(current != null){
//            if(current.data == val){
//                parent.next = current.next;
//                current = current.next;
//            }else {
//                parent = current;
//                current = current.next;
//            }
//
//        }
//        return head;
    }


    static class Node {
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
        }
    }


    /*-----------------------------------------------------todo 单向链表-------------------------------------------*/
    static class SingleLinkedList {

        private int size = 0;
        private Node header;  //头结点


        /**
         * 查找中间节点
         *
         * @return
         */
        public Node findMidNode() {

            Node first = header;
            Node second = header;

            while (second != null && second.next != null) {
                first = first.next;
                second = second.next.next;
            }
            return first;

        }


        /**
         * 添加头
         *
         * @param obj
         * @return
         */
        public Object addHead(Object obj) {
            Node newNode = new Node(obj);
            newNode.next = header;
            header = newNode;
            ++size;
            return newNode;
        }

        /**
         * 删除头
         *
         * @return
         */
        public boolean deleteHead() {

            if (!isEmpty()) {
                header = header.next;
                --size;
                return true;
            }
            return false;
        }


        /**
         * 单链表尾部添加数据
         *
         * @param obj
         * @return
         */
        public Object addFooter(Object obj) {
            Node newNode = new Node(obj);
            if (isEmpty()) {
                header = newNode;
            } else {
                Node currentFooter = header;
                while (currentFooter.next != null) {
                    currentFooter = currentFooter.next;
                }
                currentFooter.next = newNode;
            }
            ++size;
            return newNode;
        }

        /**
         * 单链表尾部删除数据
         *
         * @return
         */
        public boolean deleteFooter() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }
            //todo 需要处理临界点
            if (size == 1) {
                header = null;
                --size;
                return true;
            }
            /* 写法1 */
//            Node current = header;
//            while (current.next != null && current.next.next != null) {
//                current = current.next;
//            }
//            current.next = null;

            /* 写法2 */
            Node now = header;
            Node before = header;
            while (now.next != null) {
                before = now;
                now = now.next;
            }
            before.next = null;

            --size;
            return true;
        }


        /**
         * 发现对象所在的位置
         *
         * @param obj
         * @return
         */
        public Node find(Object obj) {
            if (isEmpty()) {
                return null;
            }
            Node current = header;
            while (current.data != obj) {
                if (current.next == null) {
                    return null;
                }
                current = current.next;
            }
            return current;
        }


        public Node delete(Object obj) {
            if (isEmpty()) {
                return null;
            }

            /**
             *   1 找到删除的节点和删除的节点前一个节点
             *   2 如果节点等于header 那么直接header后移[细节]
             *
             */
            Node current = header;
            Node before = header;
            while (current.data != obj) {
                if (current.next == null) {
                    return null;
                } else {
                    before = current;
                    current = current.next;
                }
            }
            if (current == header) {
                header = header.next;
            } else {
                before.next = current.next;
            }
            --size;
            return current;
        }


        public boolean isEmpty() {

            return size == 0;
        }


        public void display() {
            Node current = header;
            while (current != null) {
                System.out.println(current.data);
                current = current.next;
            }
        }


    }

}
