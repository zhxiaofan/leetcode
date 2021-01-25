import java.util.LinkedList;

public class ListNodeTest {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode vir = new ListNode(0);
            ListNode cur = vir;


            while (true) {
                ListNode bigger = getBiggerListNode(lists);
                if (bigger == null) break;
                cur.next = bigger;
                cur = bigger;
            }


            return vir.next;

        }


        ListNode getBiggerListNode(ListNode[] lists) {
            ListNode smaller = null;

            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (smaller == null) {
                        smaller = lists[i];
                    } else {
                        smaller = smaller.val <= lists[i].val ? smaller : lists[i];
                    }

                }
            }

            for (int j = 0; j < lists.length; j++) {
                if (lists[j] != null && smaller.val == lists[j].val) {
                    lists[j] = lists[j].next;
                    break;
                }

            }

            return smaller;

        }

    }


    public static void main(String[] args) throws Exception {

        int[] nums = {1, 4, 5};
        ListNode head = new ListNode(nums);

        int[] nums2 = {1, 3, 4};
        ListNode head2 = new ListNode(nums2);

        int[] nums3 = {2, 6};
        ListNode head3 = new ListNode(nums3);

        ListNode res = (new Solution()).mergeKLists(new ListNode[]{head, head2, head3});
        System.out.println(res);

    }


}
