package com.sandeep.leetcode.personal.easy;

import java.util.ArrayList;
import java.util.List;

public class LinkedListLeetCodeEasyAntDavid {

    public static void main(String[] args) {

    }
      public class ListNode {
          int val;
         ListNode next;
         ListNode(int x) { val = x; }
      }
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;

        for (int i = 1; i <= n; i++) {
            if (first.next == null) {
                return head.next;
            }
            first = first.next;
        }

        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return head;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1 != null) {
            curr.next = l1;
        }

        if (l2 != null) {
            curr.next = l2;
        }

        return dummy.next;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.val != prev.val) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }

        return true;
    }
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0) return result;

        List<Integer> pre = new ArrayList<>();
        pre.add(1);
        result.add(pre);

        for (int i = 2; i <= numRows; i++) {
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for (int j = 1; j < i - 1; j++) {
                cur.add(pre.get(j - 1) + pre.get(j));
            }
            cur.add(1);

            result.add(cur);
            pre = cur;
        }

        return result;
    }

    public int maxProfit(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        int len = prices.length;
        for (int i = 0; i < len; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                int delta = prices[i] - min;
                if (delta > max) {
                    max = delta;
                }
            }
        }
        return max;
    }
}
