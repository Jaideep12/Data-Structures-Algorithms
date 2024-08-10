// Given a binary tree having n nodes. Check whether all of its nodes have the value equal to the sum of their child nodes. Return 1 if all the nodes in the tree satisfy the given properties, else it return 0.

// For every node, data value must be equal to the sum of data values in left and right children. Consider data value as 0 for NULL child.  Also, leaves are considered to follow the property.

class Solution
{
    //Function to check whether all nodes of a tree have the value 
    //equal to the sum of their child nodes.
    public static int isSumProperty(Node root)
    {
        if (root == null || (root.left == null && root.right == null)) {
            return 1;
        }

        // Initialize sum of children to 0
        int leftValue = 0, rightValue = 0;

        // If left child is not null, get its value
        if (root.left != null) {
            leftValue = root.left.data;
        }

        // If right child is not null, get its value
        if (root.right != null) {
            rightValue = root.right.data;
        }

        // Check if the current node's value is equal to the sum of its children
        if (root.data == leftValue + rightValue) {
            // Recursively check the same property for left and right subtrees
            if (isSumProperty(root.left) == 1 && isSumProperty(root.right) == 1) {
                return 1;
            }
        }

        // If any node does not satisfy the property, return 0
        return 0;
    }
}
