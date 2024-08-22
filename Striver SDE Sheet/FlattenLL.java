class Solution {
    // Function to flatten a linked list
    Node flatten(Node root) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        Node current = root;
        while(current!=null){
            Node temp = current;
            queue.offer(temp.data);
            temp=temp.bottom;
            while(temp!=null){
                queue.offer(temp.data);
                temp=temp.bottom;
            }
            current=current.next;
        }
        Node result = new Node (-1);
        Node t = result;
        while(!queue.isEmpty()){
            int value = queue.poll();
            Node temp = new Node(value);
            t.next = temp;
            t = temp;
        }
        return result;
    }
}
