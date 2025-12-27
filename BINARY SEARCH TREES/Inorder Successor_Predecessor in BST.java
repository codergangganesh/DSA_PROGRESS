/*
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    Node succ = null;
    Node prede = null;

    public Node getSuccessor(Node root, int key) {
        while (root != null) {
            if (key >= root.data)
                root = root.right;
            else {
                succ = root;
                root = root.left;
            }
        }
        return succ;
    }

    public Node getPredessor(Node root, int key) {
        while (root != null) {
            if (key <= root.data)
                root = root.left;
            else {
                prede = root;
                root = root.right;
            }
        }
        return prede;
    }

    public ArrayList<Node> findPreSuc(Node root, int key) {
        succ = null;
        prede = null;

        ArrayList<Node> ans = new ArrayList<>();
        getSuccessor(root, key);
        getPredessor(root, key);

        ans.add(prede);
        ans.add(succ);
        return ans;
    }
}
