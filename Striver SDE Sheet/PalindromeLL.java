class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode head2 = slow.next;
        ListNode prev2 = null;
        ListNode next2 = head2;
    
        while(head2!=null){
            next2 = head2.next;
            head2.next=prev2;
            prev2=head2;
            head2=next2;
        }

        ListNode first = head;
        ListNode second = prev2;

        while(second!=null){
            if(first.val!=second.val){
                return false;
            }
            first=first.next;
            second=second.next;
        }
        return true;
    }
}
