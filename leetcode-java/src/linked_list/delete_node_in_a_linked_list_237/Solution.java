/**
 * Write a function to delete a node (except the tail) in a singly linked list,
 *
 * given only access to that node. Given linked list -- head = [4,5,1,9], which looks like following:
 *
 *
 * Example 1:
 *
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 * Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
 * Example 2:
 *
 * Input: head = [4,5,1,9], node = 1
 * Output: [4,5,9]
 * Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
 *
 *
 * Note:
 *
 * The linked list will have at least two elements.
 * All of the nodes' values will be unique.
 * The given node will not be the tail and it will always be a valid node of the linked list.
 * Do not return anything from your function.
 * */
package linked_list.delete_node_in_a_linked_list_237;

import linked_list.ListNode;

public class Solution {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Delete Node in a Linked List.
     * Memory Usage: 36.3 MB, less than 99.98% of Java online submissions for Delete Node in a Linked List.
     *
     * 有点弄明白了，链表删除是如何操作的。
     * */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
