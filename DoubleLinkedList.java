class ListNode {
    public int val;
    public ListNode prev;//前驱
    public ListNode next;//后驱

    /*public ListNode(ListNode prev, ListNode next) {
        this.prev = prev;
        this.next = next;
    }*/

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode() {

    }
}

//无头双向链表实现
public class DoubleLinkedList {
    public ListNode head;//头
    public ListNode last;//尾巴

    //头插法
    public void addFirst(int val) {
        ListNode node = new ListNode(val);
        if(this.head == null) {
            this.head = node;
            this.last = node;
            return;
        }
        node.next = this.head;
        this.head.prev = node;
        this.head = node;
    }
    //尾插法
    public void addLast(int val) {
        ListNode node = new ListNode(val);
        if(this.last == null) {
            this.head = node;
            this.last = node;
        }else {
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index, int val) {
        if(index < 0 || index > size()) {
            throw new RuntimeException("index位置不合法");
        }
        if(index == 0) {
            addFirst(val);
            return;
        }
        if(index == size()) {
            addLast(val);
            return;
        }
        ListNode node = new ListNode(val);
        ListNode cur = this.head;
        while(index > 0) {
            cur = cur.next;
            index--;
        }
        node.next = cur;
        node.prev = cur.prev;
        cur.prev = node;
        node.prev.next = node;
    }
    
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if(cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if(cur.val == key) {
                //判断当前cur是否为头节点
                if(cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                } else if(cur == this.last) {
                    this.last = this.last.prev;
                    this.last.next = null;
                }else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
                return;
            }else {
                cur = cur.next;
            }
        }
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if(cur.val == key) {
                //判断当前cur是否为头节点
                if(cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                } else if(cur == this.last) {
                    this.last = this.last.prev;
                    this.last.next = null;
                }else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
            }
            cur = cur.next;
        }
    }

    public void clear() {
        //将节点全部回收
        this.head = null;
        this.last = null;
    }

    public void display() {
        ListNode cur = this.head;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //得到单链表的长度
    public int size() {
        int len = 0;
        ListNode cur = this.head;
        while (cur != null) {
            len ++;
            cur = cur.next;
        }
        return len;
    }
}
