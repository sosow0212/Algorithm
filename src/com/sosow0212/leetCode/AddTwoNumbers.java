package com.sosow0212.leetCode;

public class AddTwoNumbers {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode fin = temp;
        int bit = 0;

        while (l1 != null
                || l2 != null
                || bit != 0
        ) {
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            int sum = digit1 + digit2 + bit;
            int digit = sum % 10;
            bit = sum / 10;

            fin.next = new ListNode(digit);
            fin = fin.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        ListNode result = temp.next;
        temp.next = null;

        return result;
    }
}
