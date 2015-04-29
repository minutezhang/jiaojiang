package jiaojiang.leetcode.practice1.onlinejudge;

import utils.Utils;

import java.util.*;

/**
 * @author: zhang
 * @since: Nov 10, 2013 8:35:27 PM
 */
public class LRUCache {
    /*
    Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following
    operations: get and set.

    get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
    set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it
    should invalidate the least recently used item before inserting a new item.
    */

////     it is not synchronized
//    private LinkedHashMap<Integer, Integer> cache;

//    public LRUCache(int capacity) {
//        final int cap = capacity;
//        cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
//            protected boolean removeEldestEntry(Map.Entry entry) {
//                return size() > cap;
//            }
//        };
//    }
//
//    public int get(int key) {
//        if (cache.containsKey(key)) {
//            return cache.get(key);
//        }
//
//        return -1;
//    }
//
//    public void set(int key, int value) {
//        cache.put(key, value);
//    }


    private Map<Integer, ListNode> map = new HashMap<Integer, ListNode>();
    private ListNode head;
    private int capacity;
    private int size;

    private static class ListNode {
        int key;
        int value;
        ListNode pre;
        ListNode next;

        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
            pre = null;
            next = null;
        }
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new ListNode(0, 0);
        head.next = head;
        head.pre = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            if (size > 1) {
                node.pre.next = node.next;
                node.next.pre = node.pre;

                node.next = head.next;
                head.next.pre = node;
                head.next = node;
                node.pre = head;
            }

            return node.value;
        }

        return -1;
    }

    public void set(int key, int value) {
        ListNode node;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
            node.pre.next = node.next;
            node.next.pre = node.pre;
        } else {
            if (size < capacity){
                node = new ListNode(key, value);
                size++;
            } else {
                node = head.pre;
                node.pre.next = node.next;
                node.next.pre = node.pre;
                map.remove(node.key);
                node.key = key;
                node.value = value;
            }
            map.put(key, node);
        }

        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
        if (size == 1) {
            head.pre = node;
        }
    }

    public static void test() {
        LRUCache cache = new LRUCache(2);
        cache.set(1, 1);
        cache.set(2, 2);
        cache.set(3, 3);
        Utils.printTestln(cache.get(1), -1);
        Utils.printTestln(cache.get(2), 2);
        cache.set(4, 4);
        Utils.printTestln(cache.get(3), -1);
        Utils.printTestln(cache.get(2), 2);
        Utils.printTestln(cache.get(4), 4);
        cache.set(4, 3);
        Utils.printTestln(cache.get(4), 3);
    }

    public static void main(String[] args) {
        test();
    }
}
