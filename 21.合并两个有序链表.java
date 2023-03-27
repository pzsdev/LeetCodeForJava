/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 先判断边界条件
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        // 定义一个值为 0 的，充当返回有序链表的临时起始元素
        ListNode dummy = new ListNode(0);
        // 定义运行中临时链表，设置链表的第一个元素为 dummy，同时也是新链表最后一个元素的引用变量
        ListNode curr = dummy; // 

        // 后续逻辑中会从当前链表中删除已经排序的元素，当一个链表中没有元素了，剩下的就直接插入新链表
        while (list1 != null && list2 != null) {
            // 比较，都依次从链表中获取一个元素，小的先放到新链表中
            if (list1.val <= list2.val) {
                curr.next = list1; // 这里链表指代的变量，同时也指代链表第一个元素
                list1 = list1.next; // 把链表指代变量（同时也成第一个元素）指至链表下一个元素，则第一个元素就从链表中删除了
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            // 把 curr 变量指至新链表最后一个元素，方便下次新元素拼接到这个元素的后面
            curr = curr.next;
        }

        // 把剩下的不为空的链表直接连接到新链表上
        curr.next = list1 == null ? list2 : list1;
        
        // 删除第一个临时起始元素，返回剩余排好序的元素
        return dummy.next;
    }

    // public class ListNode {
    //     int val;
    //     ListNode next;
    //     ListNode() {}
    //     ListNode(int val) { this.val = val; }
    //     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    // }
}
// @lc code=end

