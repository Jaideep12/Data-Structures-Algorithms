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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        ListNode l1 = list1;
        ListNode l2 = list2;

        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                ListNode node = new ListNode(l1.val);
                current.next=node;
                current=node;
                l1=l1.next;
            }else{
                ListNode node = new ListNode(l2.val);
                current.next=node;
                current=node;
                l2=l2.next;
            }
        }
        if(l1!=null){
            current.next=l1;
        }else if(l2!=null){
            current.next=l2;
        }
        return dummy.next;
    }
}
