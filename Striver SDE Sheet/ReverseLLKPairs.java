//25. Reverse Nodes in k-Group
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head== null || head.next==null){
            return head;
        }
        List<ListNode> lists = new ArrayList<>();
        ListNode current = head;
        while(current!=null){
            int start = 1;
            ListNode tempHead = current;
            //We will move current to the Kth node
            while(current!=null && start < k){
                current = current.next;
                start++;
            }
            //If current is null that means we have not found a pair with k nodes hence no reversal
            if(current==null){
                lists.add(tempHead);
                break;
            }

            //We will disconnect the list and move on to the next and reverse current list
            ListNode nextNode = current.next;
            current.next=null;
            current=nextNode;
            lists.add(reverse(tempHead));
        }
        ListNode dummy = new ListNode(-1);
        ListNode tempPtr = dummy;
        for(ListNode node : lists){
            tempPtr.next = node;
            while(tempPtr.next!=null){
                tempPtr=tempPtr.next;
            }
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode next = head;

        while(next!=null){
            next = head.next;
            head.next = prev;
            prev=head;
            head=next;
        }
        return prev;
    }
}
