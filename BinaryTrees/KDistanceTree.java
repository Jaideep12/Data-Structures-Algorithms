// Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.

// You can return the answer in any order.

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parents = new HashMap<>();
        trackParents(root,parents);
        Map<TreeNode,Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        int curr=0;
        q.add(target);
        visited.put(target,true);

        while(!q.isEmpty()){
            int size = q.size();
            if(curr==k) break;
            curr++;
            for(int i=0;i<size;i++){
                TreeNode temp = q.poll();
                if(temp.left!=null && !visited.containsKey(temp.left)){
                    visited.put(temp.left,true);
                    q.add(temp.left);
                }
                if(temp.right!=null && !visited.containsKey(temp.right)){
                    visited.put(temp.right,true);
                    q.add(temp.right);
                }
                if(parents.get(temp)!=null && !visited.containsKey(parents.get(temp))){
                    visited.put(parents.get(temp),true);
                    q.add(parents.get(temp));
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()){
            result.add(q.poll().val);
        }
        return result;
    }

    public void trackParents(TreeNode root, Map<TreeNode,TreeNode>parents){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp.left!=null){
                parents.put(temp.left,temp);
                q.add(temp.left);
            }
            if(temp.right!=null){
                parents.put(temp.right,temp);
                q.add(temp.right);
            }
        }
    }
}
