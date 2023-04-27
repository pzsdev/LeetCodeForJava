/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] 移除链表元素
 */

// @lc code=start
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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        // 因为删除可能涉及到头节点，所以设置 dummy 节点，统一操作
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy; // 当前比较节点的前一个节点，初始时为第一个虚节点
        ListNode cur = head; // 当前比较的节点，初始时为头节点

        while (cur != null) {
            if (cur.val == val) {
                // 相等时，删除当前节点
                pre.next = cur.next;
            } else {
                // 移向下一个节点前，先更新当前节点的前一个节点为当前节点
                pre = cur;
            }
            // 更新当前要比较的节点为下一个节点
            cur = cur.next;
        }
        return dummy.next;
    }
}
// @lc code=end

