class Solution {
    public Node connect(Node root) {
        if (root == null)  return root;
        Node orgroot = root;
        while (root.left != null) {
            Node n = root;
            while (n != null) {
                n.left.next = n.right;
                if (n.next != null) n.right.next = n.next.left;
                n = n.next;
            }
            root = root.left;
        }
        return orgroot;
    }
}
