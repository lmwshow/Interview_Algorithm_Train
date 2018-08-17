package again;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

class LRU_time_Cache {

    //熟练使用数据结构
    private static int capacity;

    private static ConcurrentHashMap<Integer,LinkNode> map;

    private static LinkNodeList linkNodeList ;

    //首先我们可以认为LRU 本身已经按照时间排序，尾部是最迟的, 对linkNode操作加锁
    private static ReentrantLock lock = new ReentrantLock();
    //设置失效时间
    private final static Long EXPIRE_TIME = 1 * 1000L ;
    //标识超时线程是否开启
    private static boolean flag = true;


    //检查是否超时线程
    private static ExecutorService checktimePool ;

    public LRU_time_Cache(int capacity) {

        this.capacity = capacity;
        this.map = new ConcurrentHashMap<>();
        this.linkNodeList = new LinkNodeList();

        executeChecktime();

    }

    private void executeChecktime() {

        System.out.println("启动线程");

        new Thread(new checkTimeThread()).start();

    }


    public static int get(int key) {

        if (!map.containsKey(key))
            return -1;
        else {
            synchronized (linkNodeList) {
                linkNodeList.swapToHead(map.get(key));
                map.get(key).updateTime = System.currentTimeMillis();
                return map.get(key).val;
            }
        }


    }

    public static void put(int key, int value) {

        synchronized (linkNodeList) {
            if (map.containsKey(key)) {
                map.get(key).val = value;
                map.get(key).updateTime = System.currentTimeMillis();
                linkNodeList.swapToHead(map.get(key));
            } else if (map.size() < capacity) {
                LinkNode node = new LinkNode(key, value);
                linkNodeList.insertFirst(node);

                map.put(key, node);
            } else {
                LinkNode rmnode = linkNodeList.deleteLast();
                map.remove(rmnode.key);

                LinkNode node = new LinkNode(key, value);
                linkNodeList.insertFirst(node);
                map.put(key, node);
            }
        }


    }


    private static class LinkNode {

        int key;
        int val;
        LinkNode prev = null;
        LinkNode next = null;

        Long updateTime;

        public LinkNode(int key,int val) {
            this.key = key;
            this.val = val;

            updateTime = System.currentTimeMillis();
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


    private static class checkTimeThread implements Runnable{

        @Override
        public void run() {

            while (flag)
            {
                synchronized (linkNodeList) {
                    LinkNode node = linkNodeList.tail;
                    if (node == null)
                        continue;

                    Long updateTime = node.updateTime;
                    Long rest = EXPIRE_TIME - (System.currentTimeMillis() - updateTime);
                    System.out.println(rest);
                    if (rest <= 0) {
                        linkNodeList.deleteLast();
                        map.remove(node.key);
                    } else {
                        LockSupport.parkNanos(rest*1000);
                    }
                }

            }
        }
    }






    public static void main(String[] args) throws InterruptedException {

        LRU_time_Cache cache = new LRU_time_Cache(3);

        cache.put('1',2);
        cache.put('2',3);

        Thread.sleep(10 * 1000L);

        System.out.println(get('1'));

        flag = false;

    }
}


