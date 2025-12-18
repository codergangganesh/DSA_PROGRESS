/*
class Node {
    int data;
    Node left, right;

    Node(int val)
    {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public static int floor(Node root, int x) {
        // code here
        int floor=-1;
        while(root!=null)
        {
            if(root.data==x)
                return x;
            else if(x<root.data)
            {
                root=root.left;
            }
            else
            {
                floor=root.data;
                root=root.right;
            }
        }
        return floor;
    }
}