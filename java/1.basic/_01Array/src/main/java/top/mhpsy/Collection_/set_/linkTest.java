package top.mhpsy.Collection_.set_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class linkTest {
    public static void main(String[] args) {
        ListNode ln = new ListNode(1);
        ln.next = new ListNode(2);
        ln.next.next = new ListNode(3);
        ln.next.next.next = new ListNode(4);
        ln.next.next.next.next = new ListNode(5);
        System.out.println(ln);
        Solution solution = new Solution();
        ListNode ans = solution.reverseList(ln);
        System.out.println(ans);
    }
}


class ListNode {
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

class Solution {
    public ListNode reverseList(ListNode head) {
        List<Integer> list = new ArrayList();
        ListNode ln = new ListNode(-1, head);
        ln = ln.next;
        while (ln != null && ln.next != null) {
            list.add(ln.val);
            ln = ln.next;
        }
        if (ln.next == null)
            list.add(ln.val);

        ListNode ans = new ListNode(-1, ln);
        for (int v : list) {
            ln.next = new ListNode(v);
            ln = ln.next;
        }

        return ans.next;
    }
}