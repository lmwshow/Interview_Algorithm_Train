package Top_Interview_Questions.链表;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gracecoder on 2017/10/12.
 *
 * 最近最久未使用 缓存机制
 * 要在O（1）内完成，必然要用到hashmap，如何做到给元素根据使用情况，就想到了用链表，要想在常量内完成链表操作，这里就是用了双向链表，同时带头尾节点
 *
 * 这里还可以优化，令头结点尾节点都指向一个假节点，避免对空指针的判断 ，使得代码更加简洁清晰
 */



public class LRUCache {

    private static int capacity;

    private static Map<Integer,LinkNode> map;

    private static LinkNodeList linkNodeList ;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        this.map = new HashMap<>();
        this.linkNodeList = new LinkNodeList();
    }

    public static int get(int key) {

        if (!map.containsKey(key))
            return -1;
        else {
            linkNodeList.swapToHead(map.get(key));
            return map.get(key).val;
        }
    }

    public static void put(int key, int value) {

        if (map.containsKey(key))
        {
            map.get(key).val = value;
            linkNodeList.swapToHead(map.get(key));
        }else if (map.size() < capacity)
        {
            LinkNode node = new LinkNode(key,value);
            linkNodeList.insertFirst(node);
            map.put(key,node);
        }else
        {
            LinkNode rmnode = linkNodeList.deleteLast();
            map.remove(rmnode.key);

            LinkNode node = new LinkNode(key,value);
            linkNodeList.insertFirst(node);
            map.put(key,node);

        }

    }

    private static class LinkNode {

        int key;
        int val;
        LinkNode prev = null;
        LinkNode next = null;

        public LinkNode(int key,int val) {
            this.key = key;
            this.val = val;
        }
    }

    private static class LinkNodeList{

        LinkNode head = null;
        LinkNode tail = null;

        private void insertFirst(LinkNode node)
        {
            if (head == null) {
                head = node;
                tail = node;
            }
            else {
                node.next = head;
                head.prev = node;
                head = node;
            }
        }

        private LinkNode deleteLast()
        {
            LinkNode last = tail;

            if (last == head)
            {
                head = null;
                tail = null;
                return last;
            }

            tail = tail.prev;
            tail.next = null;
            return last;
        }

        private void swapToHead(LinkNode node)
        {
            if (head == null)
                return;
            if (node == head)
                return;
            if (node == tail)
            {
                tail = node.prev;
            }

            node.prev.next = node.next;
            if (node.next != null)
                node.next.prev = node.prev;
            node.prev = null;
            node.next = head;
            head.prev = node;
            head = node;
        }

    }


    public static void main(String[] args){

        LRUCache cache = new LRUCache(1);
        cache.put(2,1);
//        cache.put(2, 2);
        System.out.println(cache.get(2));

//        cache.get(1);       // returns 1
        cache.put(3, 2);    // evicts key 2
        System.out.println(cache.get(2));

//        cache.get(2);       // returns -1 (not found)
//        cache.put(4, 4);    // evicts key 1
//        System.out.println(cache.get(1));

        System.out.println(cache.get(3));

//        System.out.println(cache.get(4));

//        cache.get(1);       // returns -1 (not found)
//        cache.get(3);       // returns 3
//        cache.get(4);       // returns 4
    }
}
