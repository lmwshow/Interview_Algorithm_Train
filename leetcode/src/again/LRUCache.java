package again;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    //熟练使用数据结构
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
}


