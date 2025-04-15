package org.consistent.practice.assessment.peopletech;

public class Test {
    /**
     * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
     *
     * Input: nums = [2,2,1]
     * [2 1 ,3,3]
     * left = 1
     * right = 2
     * Output: 1
     */

    /**
     * Input: head = [1,2,3,4,5]Output: [5,4,3,2,1]
     * public class ListNode {
     *
     *      int val;
     *      ListNode next;
     *      ListNode() {}
     *       ListNode(int val) { this.val = val; }
     *       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     *       tempnode = 4
     *
     * @param args
     */

    /**
     * arr[] = {1, 2, 5, 7, -1,4}
     * target = 6
     * count = ?
     * (1, 5), (7, -1) (2,4)
     * count = 3
     * @param args
     */
    public static void main(String[] args) {


//        ListNode listNode1 = new ListNode(3);
//        ListNode listNode2 = new ListNode(2,listNode1);
//        ListNode listNode3 = new ListNode(1,listNode2);
//
//        ListNode reverse = reverse(listNode3);
//        System.out.println(reverse);
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode tempNode = current.next;
            current.next = prev;

            prev = current;
            current = tempNode;
        }
        head = prev;
        return head;
    }
}

