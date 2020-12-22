​
class Solution {
    public Node connect(Node root) {
        Node head = root, dummy = new Node();
        while (head != null) {
            Node cur = dummy;
                while (head != null) {
                    
                    if (head.left != null) {
                        cur.next = head.left;
                        cur = cur.next;
                    }
                    if (head.right != null) {
                        cur.next = head.right;
                        cur = cur.next;
                    }
                    head = head.next;
                }
            head = dummy.next;
            dummy.next = null;
        }
        return root;
    }
}
