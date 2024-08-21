/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return head;

        if(head.next==null && n==1){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        //We first take fast to the nth node from start
        for(int i=0;i<n;i++){
            fast=fast.next;
        }

        if(fast==null) return head.next;

        //Then we move fast and slow together since fast is starting from n when it reaches end slow will reach n-1
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }

        slow.next=slow.next.next;
        return head;
    }
}
