package test.设计;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengyue on 2018/11/27.
 */
public class LRU缓存机制 {


    public static void main(String[] args) {


        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4

    }


    static class LRUCache {

        class DLinkedNode {
            int key;
            int value;
            DLinkedNode pre;
            DLinkedNode post;
        }

        /**
         * Always add the new node right after head;
         *
         * 最开始将新node插入到head 和 tail中间
         */
        private void addNode(DLinkedNode node) {
            node.pre = head;
            node.post = head.post;

            head.post.pre = node;
            head.post = node;
        }

        /**
         * Remove an existing node from the linked list.
         */
        private void removeNode(DLinkedNode node) {
            DLinkedNode pre = node.pre;
            DLinkedNode post = node.post;

            pre.post = post;
            post.pre = pre;
        }

        /**
         * Move certain node in between to the head.
         */
        private void moveToHead(DLinkedNode node) {
            this.removeNode(node);
            this.addNode(node);
        }

        // pop the current tail.
        private DLinkedNode popTail() {
            DLinkedNode res = tail.pre;
            this.removeNode(res);
            return res;
        }

        private Map<Integer, DLinkedNode>
                cache = new HashMap<Integer, DLinkedNode>();
        private int count;
        private int capacity;
        private DLinkedNode head, tail;

        //创建一个双向列表
        //以及两个Node 并且相互指向对方
        public LRUCache(int capacity) {
            this.count = 0;
            this.capacity = capacity;

            head = new DLinkedNode();
            head.pre = null;

            tail = new DLinkedNode();
            tail.post = null;

            head.post = tail;
            tail.pre = head;
        }

        public int get(int key) {

            DLinkedNode node = cache.get(key);
            if (node == null) {
                return -1; // should raise exception here.
            }

            // move the accessed node to the head;
            this.moveToHead(node);

            return node.value;
        }


        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);

            if (node == null) {

                DLinkedNode newNode = new DLinkedNode();
                newNode.key = key;
                newNode.value = value;

                this.cache.put(key, newNode);
                this.addNode(newNode);

                ++count;

                if (count > capacity) {
                    // pop the tail
                    DLinkedNode tail = this.popTail();
                    this.cache.remove(tail.key);
                    --count;
                }
            } else {
                // update the value.
                node.value = value;
                this.moveToHead(node);
            }

        }
    }

}
