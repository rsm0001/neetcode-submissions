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
    public ListNode reverseList(ListNode head) {
        ListNode prev = head, next = null;
        if (head != null) {
            next = head.next; head.next = null;
        }
        while (head != null) {
            head = next;
            if (head != null) {
                next = head.next; head.next = prev; prev = head;
            }
        }
        return prev;
    }
}
