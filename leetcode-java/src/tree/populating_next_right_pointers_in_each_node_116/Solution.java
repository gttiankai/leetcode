/***
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

 

Example:



Input: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}

Output: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}

Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B.
 

Note:

You may only use constant extra space.
Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 * 
 */

package tree.populating_next_right_pointers_in_each_node_116;

import java.util.LinkedList;
import java.util.Queue;

class Solution{
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Populating
     *
     * Next Right Pointers in Each Node.
     *
     * Memory Usage: 36.3 MB, less than 28.62% of Java online submissions for Populating
     *
     * Next Right Pointers in Each Node.
     *
     * 时间复杂度还可以，但是空间复杂度不符合要求
     * */
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(queue.size() > 0) {
            int levelNumber = queue.size();
            for(int i = 0; i < levelNumber; i++) {
                Node item = queue.poll();
                if (i == levelNumber -1) {
                    item.next = null;
                } else {
                    item.next = queue.peek();
                }
                if (item.left != null) {
                    queue.add(item.left);
                }
                if(item.right != null) {
                    queue.add(item.right);
                }
            }
        }
        return root;
    }
}