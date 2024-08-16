// You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

// Merge all the linked-lists into one sorted linked-list and return it

// Input: lists = [[1,4,5],[1,3,4],[2,6]]
// Output: [1,1,2,3,4,4,5,6]
// Explanation: The linked-lists are:
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// merging them into one sorted list:
// 1->1->2->3->4->4->5->6

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(ListNode head : lists){
            while(head!=null){
                q.add(head.val);
                head=head.next;
            }
        }
        
        ListNode dummy = new ListNode();
        ListNode temp = dummy;

        while(!q.isEmpty()){
            ListNode next = new ListNode(q.poll());
            temp.next = next;
            temp=temp.next;
        }
        return dummy.next;
        
    }
}
