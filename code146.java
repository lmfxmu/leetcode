// 纯记忆，一个是有标准库，一个是自己手写实现

// 1.标准库
class LRUCache {

    private final int capacity;
    private final Map<Integer, Integer> cache = new LinkedHashMap<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Integer value = cache.remove(key);
        if (value != null) {
            cache.put(key, value);
            return value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.get(key) != null) {
            cache.remove(key);
        } else if (cache.size() == capacity) {
            Integer older = cache.keySet().iterator().next();
            cache.remove(older);
        }

        cache.put(key, value);
    }
}


// 手写双向链表+哈希表
class LRUCache {
    private static class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private final int capacity;
    private final Node dummy = new Node(-1, -1);
    private final Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy.next = dummy;
        dummy.prev = dummy;
    }
    
    public int get(int key) {
        Node tmp = getNode(key);
        if (tmp != null) {
            return tmp.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node tmp = map.get(key);
            tmp.value = value;
            removeNode(tmp);
            updateFirst(tmp);
            return ;
        } else if (map.size() == capacity) {

            // 注意map中也要删除
            map.remove(dummy.prev.key);

            removeNode(dummy.prev);
            
        }
        
        Node newOne = new Node(key, value);
        map.put(key, newOne);
        updateFirst(newOne);
    }

    // 在哈希表中找到节点
    
    private Node getNode(int key) {
        if (map.containsKey(key)) {
            Node tmp = map.get(key);
            // 移动到最上面
            removeNode(tmp);
            updateFirst(tmp);
            return tmp;
        }
        return null;
    }
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void updateFirst(Node node) {
        
        node.next = dummy.next;
        node.prev = dummy;
        node.next.prev =node;
        dummy.next = node;
        
        
    }


}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */