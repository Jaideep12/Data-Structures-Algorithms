public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode curNode = q.poll();

            if (curNode == null) {
                sb.append("#,");
            } else {
                sb.append(curNode.val).append(",");
                q.offer(curNode.left);
                q.offer(curNode.right);
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }

        String arr[] = data.split(",");
        int x=0;

        String str = "";
        TreeNode root = new TreeNode(Integer.parseInt(arr[x++]));

        Queue<TreeNode> q = new LinkedList<>();
        // Start with the root node
        q.offer(root);

        while (!q.isEmpty() && x<data.length()) {
            // Get the front node in the queue
            TreeNode node = q.poll();

            str = arr[x++];
            if (!str.equals("#")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(str));
                node.left = leftNode;
                q.offer(leftNode);
            }
            
            str=arr[x++];
            if (!str.equals("#")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(str));
                node.right = rightNode;
                q.offer(rightNode);
            }
        }
        return root;
    }
}
