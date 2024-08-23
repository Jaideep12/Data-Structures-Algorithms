//This is the most optimal solution
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int length = 1;
        ListNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
            length++;
        }

        //we will basically make a cycle in the list first by connecting last to first
        temp.next = head;
        k = k % length;
        k = length - k;

        //Then we move by n-k places and disconnect the cycle after setting new head
        while (k-- > 0) {
            temp = temp.next;
        }

        head = temp.next;
        temp.next = null;

        return head;
    }
}
