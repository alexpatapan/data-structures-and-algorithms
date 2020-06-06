/**
 *
 * Below Solution beats 100% of other submissions in both memory and space complexity at time of commit.
 *
 * Leetcode 82 - Remove Duplicates from Sorted List II
 *
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
    public ListNode deleteDuplicates(ListNode head) {
        
        if (head == null) return null;
        if (head.next == null) return head;
        // get the first proper head
        boolean flag = false;
        while (head.next != null && head.val == head.next.val) {
            flag = true;
            head = head.next;
        }
        if (flag) head = head.next;
        
        if (head != null && head.next != null && head.val == head.next.val) {
            return deleteDuplicates(head);
        }
        
        // now deal with the rest of the nodes
        ListNode node = head;
        
        while (node != null && node.next != null && node.next.next != null) {
            flag = false;
            ListNode temp = node.next;
            while (temp != null && temp.next != null && temp.val == temp.next.val) {
                flag = true;
                temp = temp.next;
            }
            
            if (flag) temp = temp.next;
            node.next = temp;
            if (!flag) node = node.next;
        }
        
        return head;
    }
}
