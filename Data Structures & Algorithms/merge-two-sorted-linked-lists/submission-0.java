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
        if (null == list1) { return list2; }
        if (null == list2) { return list1; }
        ListNode head = (list1.val <= list2.val) ? list1 : list2;
        ListNode ptr = null;
        while ((list1 != null) && (list2 != null)) {
            while (list1.val <= list2.val) {
                if (null != ptr) { ptr.next = list1; }
                ptr = list1;
                if (null == list1.next) {
                    list1.next = list2; list1 = null; break;
                }
                list1 = list1.next;
            }

            if (list1 != null) {
                while (list2.val <= list1.val) {
                    if (null != ptr) { ptr.next = list2; }
                    ptr = list2;
                    if (null == list2.next) {
                        list2.next = list1; list2 = null; break;
                    }
                    list2 = list2.next;
                }
            }
        }
        return head;
    }
}