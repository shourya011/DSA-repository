---
author: Shourya Sharma
description: A progressive guide to binary tree and BST problems, from
  traversals and recursion to backtracking and tree DP.
tags:
- DSA
- Binary Trees
- Trees
- Java
title: "Binary Trees: A Pattern-Based DSA Roadmap"
---

# Binary Trees: A Pattern-Based DSA Roadmap

A progressive collection of binary-tree problems, arranged from
beginner-friendly foundations to advanced patterns. The order is
intentional: later problems reuse ideas introduced earlier.

The goal is not to memorize separate solutions. Learn to recognize these
reusable patterns:

-   **DFS:** choose when to process the current node.
-   **BFS:** process nodes level by level.
-   **Recursion:** solve the left and right subtrees, then combine their
    results.
-   **Backtracking:** maintain a path while exploring branches.
-   **BST properties:** eliminate subtrees using sorted order.
-   **Tree DP:** combine information returned by child subtrees.

The examples use Java-style code. Adapt `val` or `data` to the node
definition used by your platform.

## Learning roadmap

  -----------------------------------------------------------------------
  Stage                   Focus                   Problems
  ----------------------- ----------------------- -----------------------
  1                       Traversal foundations   Preorder, Inorder,
                                                  Postorder, Level Order

  2                       Recursion and tree      Height, Same Tree,
                          properties              Invert Tree, Symmetric
                                                  Tree

  3                       Level-order BFS         Minimum Depth, Right
                                                  Side View, Average
                                                  Levels, Level Order II,
                                                  Zigzag

  4                       Root-to-leaf paths      Path Sum, Binary Tree
                                                  Paths, Path Sum II, Sum
                                                  Root to Leaf

  5                       Binary Search Trees     Search, Validate, Kth
                                                  Smallest, Insert, LCA
                                                  in BST

  6                       Advanced DFS and tree   Balanced Tree,
                          DP                      Diameter, Sum of Left
                                                  Leaves, LCA, Maximum
                                                  Path Sum, Flatten
  -----------------------------------------------------------------------

------------------------------------------------------------------------

# Stage 1 --- Traversal foundations

Learn how to visit every node and understand the difference between DFS
and BFS. These traversals are the foundation of almost every tree
problem.

## 1. Preorder Traversal

**Pattern:** DFS --- Root → Left → Right

Visit the current node first, then its left subtree, then its right
subtree.

### Recursive idea

1.  If the node is `null`, stop.
2.  Visit or store `node.val`.
3.  Traverse `node.left`.
4.  Traverse `node.right`.

### Iterative idea --- one stack

A stack is Last In, First Out. To visit the left child first, push the
**right child first**, then the **left child**.

``` java
Stack<TreeNode> stack = new Stack<>();
stack.push(root);

while (!stack.isEmpty()) {
    TreeNode node = stack.pop();
    result.add(node.val);

    if (node.right != null) stack.push(node.right);
    if (node.left != null) stack.push(node.left);
}
```

**Remember:** Push right, then left --- so left is popped first.

**Complexity:** `O(n)` time and up to `O(n)` auxiliary space.

## 2. Inorder Traversal

**Pattern:** DFS --- Left → Root → Right

In a Binary Search Tree, inorder traversal visits values in sorted
ascending order.

### Iterative idea --- one stack

1.  Keep moving left, pushing each node onto the stack.
2.  When the current node becomes `null`, pop and visit a node.
3.  Move to its right child.
4.  Repeat until the current node is `null` and the stack is empty.

``` java
Stack<TreeNode> stack = new Stack<>();
TreeNode curr = root;

while (curr != null || !stack.isEmpty()) {
    while (curr != null) {
        stack.push(curr);
        curr = curr.left;
    }

    curr = stack.pop();
    result.add(curr.val);
    curr = curr.right;
}
```

**Remember:** Go left while possible; otherwise pop, visit, and go
right.

**Complexity:** `O(n)` time and `O(h)` auxiliary space, where `h` is
tree height.

## 3. Postorder Traversal

**Pattern:** DFS --- Left → Right → Root

Process a node only after both of its subtrees have been processed.

### Iterative idea --- two stacks

1.  Push the root into `stack1`.
2.  Pop a node from `stack1` and push it into `stack2`.
3.  Push its children into `stack1`.
4.  When `stack1` is empty, pop `stack2` to obtain postorder.

``` java
Stack<TreeNode> stack1 = new Stack<>();
Stack<TreeNode> stack2 = new Stack<>();

if (root != null) stack1.push(root);

while (!stack1.isEmpty()) {
    TreeNode node = stack1.pop();
    stack2.push(node);

    if (node.left != null) stack1.push(node.left);
    if (node.right != null) stack1.push(node.right);
}

while (!stack2.isEmpty()) {
    result.add(stack2.pop().val);
}
```

**Remember:** Every node popped from `stack1` is pushed into `stack2`.
Popping `stack2` gives Left → Right → Root.

**Complexity:** `O(n)` time and `O(n)` auxiliary space.

## 4. Level Order Traversal

**Pattern:** BFS --- visit nodes level by level using a queue.

BFS finishes the current level before moving to the next one.

### Algorithm

1.  If the root is `null`, return an empty result.
2.  Add the root to a queue.
3.  While the queue is not empty:
    -   Save the queue size. This is the number of nodes in the current
        level.
    -   Remove exactly that many nodes.
    -   Visit each node and add its non-null children to the queue.

``` java
Queue<TreeNode> queue = new LinkedList<>();
queue.offer(root);

while (!queue.isEmpty()) {
    int size = queue.size();
    List<Integer> level = new ArrayList<>();

    for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        level.add(node.val);

        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
    }

    result.add(level);
}
```

**Remember:** Save `queue.size()` before processing a level. Newly added
children belong to the next level.

**Complexity:** `O(n)` time and `O(w)` queue space, where `w` is maximum
tree width.

------------------------------------------------------------------------

# Stage 2 --- Basic recursion and tree properties

These problems teach you to solve a tree by handling its left subtree,
right subtree, and current node.

## 5. Maximum Height / Maximum Depth

**Pattern:** Tree Height Recursion

The height of a node is determined by the heights of its left and right
subtrees.

\[ height(node) = 1 + `\max`{=tex}(height(node.left),
height(node.right)) \]

``` java
int maxDepth(TreeNode root) {
    if (root == null) return 0;

    int left = maxDepth(root.left);
    int right = maxDepth(root.right);

    return 1 + Math.max(left, right);
}
```

### Important: choose one height convention

Both conventions are valid, but do not mix them:

-   **Height measured in nodes:** empty tree = `0`, leaf = `1`. Use
    `null -> 0`.
-   **Height measured in edges:** empty tree = `-1`, leaf = `0`. Use
    `null -> -1`.

For the common Maximum Depth problem, use the **node-count convention**
(`null -> 0`).

**Complexity:** `O(n)` time and `O(h)` recursion stack space.

## 6. Same Tree

**Pattern:** Parallel DFS

Compare two trees node by node. The left child of one tree must match
the left child of the other, and the same applies to the right children.

### Base cases

-   Both nodes are `null`: return `true`.
-   Exactly one node is `null`: return `false`.
-   Values differ: return `false`.

``` java
boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (p == null || q == null) return false;
    if (p.val != q.val) return false;

    return isSameTree(p.left, q.left)
        && isSameTree(p.right, q.right);
}
```

**Remember:** Both corresponding subtrees and the current values must
match. An iterative solution using a queue or stack of node pairs is
also possible.

**Complexity:** `O(n)` time and `O(h)` recursive space.

## 7. Invert Binary Tree

**Pattern:** Recursive Tree Modification

Swap the left and right children at every node.

1.  If the node is `null`, return `null`.
2.  Save the original left child.
3.  Set the left child to the inverted right subtree.
4.  Set the right child to the inverted saved left subtree.
5.  Return the current node.

``` java
TreeNode invertTree(TreeNode root) {
    if (root == null) return null;

    TreeNode temp = root.left;
    root.left = invertTree(root.right);
    root.right = invertTree(temp);

    return root;
}
```

**Remember:** Save the original left child before overwriting it.

**Complexity:** `O(n)` time and `O(h)` recursion stack space.

## 8. Symmetric Tree

**Pattern:** Mirror DFS

A tree is symmetric when its left and right subtrees are mirror images.

Compare:

-   `left.left` with `right.right`
-   `left.right` with `right.left`

``` java
boolean isMirror(TreeNode left, TreeNode right) {
    if (left == null && right == null) return true;
    if (left == null || right == null) return false;
    if (left.val != right.val) return false;

    return isMirror(left.left, right.right)
        && isMirror(left.right, right.left);
}

boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    return isMirror(root.left, root.right);
}
```

**Remember:** Same Tree compares left with left; Symmetric Tree compares
opposite sides.

**Complexity:** `O(n)` time and `O(h)` recursion stack space.

------------------------------------------------------------------------

# Stage 3 --- Level-by-level BFS patterns

These problems build on Level Order Traversal. The key technique is to
process a fixed number of queue elements for each level.

## 9. Minimum Depth of Binary Tree

**Pattern:** Minimum Depth DFS / BFS

Find the shortest path from the root to a **leaf**. A leaf has no left
or right child.

A missing child must not be treated as a shorter path to a leaf.

``` java
int minDepth(TreeNode root) {
    if (root == null) return 0;

    if (root.left == null)
        return 1 + minDepth(root.right);

    if (root.right == null)
        return 1 + minDepth(root.left);

    return 1 + Math.min(
        minDepth(root.left),
        minDepth(root.right)
    );
}
```

**Remember:** If one child is missing, you must follow the other child.
If both exist, take the smaller depth. BFS can also return as soon as it
reaches the first leaf.

**Complexity:** `O(n)` worst-case time and `O(h)` recursive space.

## 10. Binary Tree Right Side View

**Pattern:** Level Order + Last Node

Return the node visible from the right side at each level.

Process one level at a time. The last node processed at that level is
the rightmost node.

``` java
for (int i = 0; i < size; i++) {
    TreeNode node = queue.poll();

    if (i == size - 1) {
        result.add(node.val);
    }

    if (node.left != null) queue.offer(node.left);
    if (node.right != null) queue.offer(node.right);
}
```

**Remember:** Compare the loop index with `size - 1`, not the changing
queue size.

**Complexity:** `O(n)` time and `O(w)` queue space.

## 11. Average of Levels in Binary Tree

**Pattern:** Level Order BFS + Level Sum

Calculate the average value of all nodes at each level.

1.  Use a queue for BFS.
2.  Save the current level's queue size.
3.  Process exactly that many nodes.
4.  Add their values to a `double` sum.
5.  Append `sum / size` to the result.

``` java
while (!queue.isEmpty()) {
    int size = queue.size();
    double sum = 0;

    for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        sum += node.val;

        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
    }

    result.add(sum / size);
}
```

**Remember:** Use `double` so the average is not truncated by integer
division.

**Complexity:** `O(n)` time and `O(w)` queue space.

## 12. Binary Tree Level Order Traversal II

**Pattern:** Reverse Level Order

Return the levels from bottom to top.

### Approach 1 --- collect, then reverse

1.  Perform normal level-order traversal.
2.  Store each level in the result.
3.  Reverse the list of levels at the end.

### Approach 2 --- insert each level at index zero

``` java
result.add(0, level);
```

Each new level is inserted before the previous levels, producing
bottom-up order.

**Remember:** Java's `List.add(0, element)` shifts existing elements to
the right. It is simple, but repeated front insertion can be less
efficient than collecting and reversing.

**Complexity:** `O(n)` traversal time, plus the cost of reversing or
shifting the level list.

## 13. Binary Tree Zigzag Level Order Traversal

**Pattern:** BFS + Alternating Level Direction

Visit one level from left to right, the next from right to left, and
continue alternating.

### Approach 1 --- BFS and reverse alternate levels

``` java
if (level % 2 == 1) {
    Collections.reverse(currentLevel);
}
result.add(currentLevel);
level++;
```

### Approach 2 --- two stacks

-   While processing `stack1`, push left then right into `stack2`.
-   While processing `stack2`, push right then left into `stack1`.

**Remember:** The order in which children are pushed determines the next
level's traversal direction.

**Complexity:** `O(n)` time and `O(w)` auxiliary space.

------------------------------------------------------------------------

# Stage 4 --- Root-to-leaf paths and backtracking

Maintain a path or remaining sum as recursion moves down the tree. When
returning from a branch, undo changes where necessary.

## 14. Path Sum

**Pattern:** Root-to-Leaf DFS

Determine whether a root-to-leaf path has the target sum.

``` java
boolean hasPathSum(TreeNode root, int target) {
    if (root == null) return false;

    if (root.left == null && root.right == null) {
        return target == root.val;
    }

    int remaining = target - root.val;

    return hasPathSum(root.left, remaining)
        || hasPathSum(root.right, remaining);
}
```

**Remember:** The path must end at a leaf. Reaching a node with the
target sum is not enough if that node has children.

**Complexity:** `O(n)` time and `O(h)` recursion space.

## 15. Binary Tree Paths

**Pattern:** Backtracking DFS

Return every root-to-leaf path as a string.

1.  Add the current node to the path.
2.  If it is a leaf, convert the path into the required string and store
    it.
3.  Otherwise, explore the left and right children.
4.  Remove the current node when returning if using a shared mutable
    path.

``` java
void dfs(TreeNode root, List<Integer> path) {
    if (root == null) return;

    path.add(root.val);

    if (root.left == null && root.right == null) {
        // Convert path into a string and add it to the answer.
    } else {
        dfs(root.left, path);
        dfs(root.right, path);
    }

    path.remove(path.size() - 1); // Backtrack
}
```

**Remember:** Backtracking means undoing the current choice before
returning to the parent.

**Practice note:** Revisit your original notes or implementation for
this problem, especially how the path is converted into the required
output format.

**Complexity:** `O(n)` traversal work, plus output construction.

## 16. Path Sum II

**Pattern:** DFS + Backtracking

Return every root-to-leaf path whose sum equals the target.

1.  Add the current node's value to the path.
2.  Subtract it from the remaining target.
3.  If the node is a leaf and the remaining target is zero, save a
    **copy** of the path.
4.  Explore the left and right subtrees.
5.  Remove the current node before returning.

``` java
void dfs(TreeNode root, int target,
         List<Integer> path,
         List<List<Integer>> answer) {

    if (root == null) return;

    path.add(root.val);
    target -= root.val;

    if (root.left == null && root.right == null && target == 0) {
        answer.add(new ArrayList<>(path));
    } else {
        dfs(root.left, target, path, answer);
        dfs(root.right, target, path, answer);
    }

    path.remove(path.size() - 1); // Backtrack
}
```

**Remember:** Store `new ArrayList<>(path)`, not `path` itself.
Otherwise, later backtracking changes the saved answer.

**Complexity:** `O(n)` traversal work, excluding the total size of
returned paths.

## 17. Sum Root to Leaf Numbers

**Pattern:** Path Accumulation DFS

Each root-to-leaf path represents a number. For example, `1 → 2 → 3`
represents `123`.

**Key formula:**

``` java
current = current * 10 + root.val;
```

At a leaf, add `current` to the total.

``` java
int sumNumbers(TreeNode root, int current) {
    if (root == null) return 0;

    current = current * 10 + root.val;

    if (root.left == null && root.right == null) {
        return current;
    }

    return sumNumbers(root.left, current)
         + sumNumbers(root.right, current);
}
```

**Remember:** Multiplying by ten shifts previous digits left before
appending the current digit.

**Complexity:** `O(n)` time and `O(h)` recursion space.

------------------------------------------------------------------------

# Stage 5 --- Binary Search Tree patterns

A Binary Search Tree has an ordering property:

-   Values in the left subtree are smaller than the current node.
-   Values in the right subtree are greater than the current node.

Follow the duplicate-value policy specified by the problem.

## 18. Search in a BST

**Pattern:** BST Search

Use the BST property to choose only one subtree at each step.

``` java
TreeNode searchBST(TreeNode root, int target) {
    if (root == null || root.val == target) {
        return root;
    }

    if (target < root.val) {
        return searchBST(root.left, target);
    }

    return searchBST(root.right, target);
}
```

**Remember:** You do not need to search both subtrees. The BST ordering
tells you where the target can be.

**Complexity:** `O(h)` time and `O(h)` recursive space; average
`O(log n)` for a balanced BST, worst-case `O(n)`.

## 19. Validate Binary Search Tree

**Pattern:** BST Range Validation

Every node must satisfy constraints imposed by **all its ancestors**,
not just its immediate parent.

Pass a valid minimum and maximum range down the tree.

``` java
boolean isValidBST(TreeNode root, long min, long max) {
    if (root == null) return true;

    if (root.val <= min || root.val >= max) {
        return false;
    }

    return isValidBST(root.left, min, root.val)
        && isValidBST(root.right, root.val, max);
}
```

Start with:

``` java
isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
```

**Remember:** Use `long` bounds to handle integer boundary values
correctly.

**Complexity:** `O(n)` time and `O(h)` recursion space.

## 20. Kth Smallest Element in a BST

**Pattern:** BST Inorder Traversal

Inorder traversal visits BST values in sorted ascending order.

1.  Perform inorder traversal.
2.  Count each visited node.
3.  The kth visited node is the kth smallest.

You can store all values and return index `k - 1`, or stop traversal as
soon as the kth node is reached.

**Remember:** Inorder = sorted order for a valid BST.

**Complexity:** `O(n)` worst-case time and `O(h)` recursion space. Early
stopping may visit fewer nodes.

## 21. Insert into a BST

**Pattern:** Recursive BST Insertion

Compare the value with the current node and move left or right until a
`null` position is found.

``` java
TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) {
        return new TreeNode(val);
    }

    if (val < root.val) {
        root.left = insertIntoBST(root.left, val);
    } else if (val > root.val) {
        root.right = insertIntoBST(root.right, val);
    }

    return root;
}
```

**Remember:** Return the current root after updating the appropriate
child. Follow the problem's duplicate-value policy if duplicates are
allowed.

**Complexity:** `O(h)` time and `O(h)` recursive space.

## 22. Lowest Common Ancestor of a BST

**Pattern:** BST Property + Divide and Conquer

The Lowest Common Ancestor (LCA) is the lowest node that has both target
nodes as descendants. A node can be a descendant of itself.

Use BST ordering to find where the paths split.

``` java
TreeNode lowestCommonAncestor(
    TreeNode root, TreeNode p, TreeNode q) {

    if (root.val < p.val && root.val < q.val) {
        return lowestCommonAncestor(root.right, p, q);
    }

    if (root.val > p.val && root.val > q.val) {
        return lowestCommonAncestor(root.left, p, q);
    }

    return root;
}
```

**Remember:**

-   If both target values are greater, move right.
-   If both are smaller, move left.
-   Otherwise, the current node is the split point and therefore the
    LCA.

**Complexity:** `O(h)` time and `O(h)` recursive space.

------------------------------------------------------------------------

# Stage 6 --- Tree DP, advanced recursion, and transformations

These problems combine information from subtrees, maintain a global
answer, or modify tree structure. They become easier once height and DFS
recursion feel natural.

## 23. Balanced Binary Tree

**Pattern:** Bottom-Up DFS

A binary tree is height-balanced if, at every node, the heights of its
left and right subtrees differ by no more than one.

Calculate height while checking balance. Avoid repeatedly calculating
height in a separate function, which can lead to `O(n²)` time on a
skewed tree.

Return a special value such as `-1` when an unbalanced subtree is found.

``` java
int checkHeight(TreeNode root) {
    if (root == null) return 0;

    int left = checkHeight(root.left);
    if (left == -1) return -1;

    int right = checkHeight(root.right);
    if (right == -1) return -1;

    if (Math.abs(left - right) > 1) return -1;

    return 1 + Math.max(left, right);
}

boolean isBalanced(TreeNode root) {
    return checkHeight(root) != -1;
}
```

**Remember:** Return height when balanced; return `-1` as soon as an
unbalanced subtree is found.

**Complexity:** `O(n)` time and `O(h)` recursion space.

## 24. Diameter of Binary Tree

**Pattern:** Single-Pass DFS + Global Maximum

The diameter is the length of the longest path between any two nodes. It
does not have to pass through the root.

At each node:

-   Get the left subtree height.
-   Get the right subtree height.
-   The longest path passing through this node is `left + right` when
    using the node-height convention below.
-   Update the global maximum.
-   Return the node's height to its parent.

``` java
int diameter = 0;

int height(TreeNode root) {
    if (root == null) return 0;

    int left = height(root.left);
    int right = height(root.right);

    diameter = Math.max(diameter, left + right);

    return 1 + Math.max(left, right);
}
```

**Remember:** With `null -> 0`, `left + right` gives the diameter in
edges.

**Complexity:** `O(n)` time and `O(h)` recursion space.

## 25. Sum of Left Leaves

**Pattern:** Conditional DFS

Add the values of all leaf nodes that are left children.

A leaf has no left or right child.

``` java
int sumOfLeftLeaves(TreeNode root) {
    if (root == null) return 0;

    int sum = 0;

    if (root.left != null) {
        if (root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        } else {
            sum += sumOfLeftLeaves(root.left);
        }
    }

    sum += sumOfLeftLeaves(root.right);

    return sum;
}
```

**Remember:** A right leaf does not count. A left child counts only when
it is a leaf.

**Complexity:** `O(n)` time and `O(h)` recursion space.

## 26. Lowest Common Ancestor of a Binary Tree

**Pattern:** Recursive Divide and Conquer

Unlike the BST version, a normal binary tree has no ordering property.
Search both subtrees.

### Base cases

1.  If `root` is `null`, return `null`.
2.  If `root` is either target node, return `root`.

``` java
TreeNode lowestCommonAncestor(
    TreeNode root, TreeNode p, TreeNode q) {

    if (root == null || root == p || root == q) {
        return root;
    }

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    if (left != null && right != null) {
        return root;
    }

    return left != null ? left : right;
}
```

**Remember:**

-   If both recursive calls return non-null, the targets are on
    different sides. Return the current root.
-   If only one returns non-null, pass that result upward.
-   If neither returns a node, return `null`.

**Complexity:** `O(n)` time and `O(h)` recursion space.

## 27. Maximum Path Sum

**Pattern:** Tree DP --- Postorder DFS + Global Maximum

Find the maximum sum of any path in the tree. A path can start and end
at any nodes, but it must follow connected parent-child edges and cannot
branch.

At each node:

1.  Calculate the best gain from the left subtree.
2.  Calculate the best gain from the right subtree.
3.  Ignore negative gains using `max(0, gain)`.
4.  Update the global answer using a path through the current node.
5.  Return the best one-sided gain to the parent.

``` java
int maxSum = Integer.MIN_VALUE;

int maxGain(TreeNode root) {
    if (root == null) return 0;

    int left = Math.max(0, maxGain(root.left));
    int right = Math.max(0, maxGain(root.right));

    maxSum = Math.max(maxSum, left + right + root.val);

    return root.val + Math.max(left, right);
}
```

**Remember:**

-   `left + right + root.val` updates the best complete path through
    this node.
-   A parent can use only one child branch, so return
    `root.val + max(left, right)`.
-   Initialize the global answer to `Integer.MIN_VALUE` so all-negative
    trees work.

**Complexity:** `O(n)` time and `O(h)` recursion space.

## 28. Flatten Binary Tree to Linked List

**Pattern:** In-Place Tree Modification

Flatten the tree into a linked list following preorder:

**Root → Left → Right**

Every node's `left` pointer must become `null`, and its `right` pointer
must point to the next node in preorder.

### Approach 1 --- Store preorder nodes, then rewire

1.  Collect nodes in preorder.
2.  Iterate through the collected nodes.
3.  Set each node's left pointer to `null`.
4.  Connect the current node's right pointer to the next node.

``` java
List<TreeNode> nodes = new ArrayList<>();
preorder(root, nodes);

for (int i = 0; i < nodes.size(); i++) {
    TreeNode node = nodes.get(i);

    node.left = null;
    node.right = (i + 1 < nodes.size())
        ? nodes.get(i + 1)
        : null;
}
```

**Important:** Set the final node's `right` pointer to `null`.

### Approach 2 --- Reverse preorder with a previous pointer

Process nodes in reverse preorder:

**Right → Left → Root**

``` java
TreeNode previous = null;

void flatten(TreeNode root) {
    if (root == null) return;

    flatten(root.right);
    flatten(root.left);

    root.right = previous;
    root.left = null;
    previous = root;
}
```

**Remember:** Reverse preorder flattens the tree in place without
storing every node in a list.

**Complexity:** - Preorder list approach: `O(n)` time and `O(n)` extra
space. - Reverse preorder approach: `O(n)` time and `O(h)` recursion
space.

------------------------------------------------------------------------

# Quick pattern revision

  ------------------------------------------------------------------------
  Problem                 Main pattern            Key reminder
  ----------------------- ----------------------- ------------------------
  Preorder                DFS                     Root → Left → Right;
                                                  push right before left

  Inorder                 DFS                     Left → Root → Right;
                                                  sorted order in a BST

  Postorder               DFS                     Left → Right → Root; two
                                                  stacks are one iterative
                                                  option

  Level Order             BFS                     Queue; process a fixed
                                                  level size

  Maximum Height          Recursion               `1 + max(left, right)`

  Same Tree               Parallel DFS            Compare matching
                                                  positions

  Invert Tree             Tree modification       Swap left and right
                                                  recursively

  Symmetric Tree          Mirror DFS              Compare opposite sides

  Minimum Depth           DFS / BFS               Do not treat a missing
                                                  child as a leaf path

  Right Side View         BFS                     Last node of each level

  Average of Levels       BFS                     Sum and divide by level
                                                  size

  Level Order II          BFS                     Reverse the levels

  Zigzag                  BFS                     Alternate direction per
                                                  level

  Path Sum                Root-to-leaf DFS        Carry remaining sum

  Binary Tree Paths       Backtracking            Add, explore, remove

  Path Sum II             Backtracking            Copy a matching path
                                                  before backtracking

  Sum Root to Leaf        Path accumulation       `current * 10 + digit`

  Search in BST           BST search              Choose one side using
                                                  ordering

  Validate BST            Range validation        Carry ancestor min/max
                                                  bounds

  Kth Smallest            Inorder                 kth visited node

  Insert into BST         BST recursion           Insert at a null
                                                  position

  LCA in BST              BST property            Find where paths split

  Balanced Tree           Bottom-up DFS           Return height or an
                                                  unbalanced marker

  Diameter                Single-pass DFS         Update `left + right`

  Sum of Left Leaves      Conditional DFS         Count only left children
                                                  that are leaves

  LCA in Binary Tree      Divide and conquer      Combine left and right
                                                  results

  Maximum Path Sum        Tree DP                 Update global answer;
                                                  return one branch

  Flatten Tree            Reverse preorder        Right → Left → Root
  ------------------------------------------------------------------------

------------------------------------------------------------------------

# How to practice this roadmap

1.  **Understand traversal first.** Write recursive preorder, inorder,
    postorder, and level order without looking at notes.
2.  **Trace recursion by hand.** For each call, identify what it
    receives, what it returns, and when it processes the current node.
3.  **Learn the base cases.** Many tree bugs come from incorrect
    handling of `null`, leaves, or a missing child.
4.  **Recognize the pattern before coding.** Ask: Is this DFS, BFS, a
    root-to-leaf path, a BST search, backtracking, or tree DP?
5.  **Dry-run edge cases.** Test an empty tree, a single node, a skewed
    tree, and negative values where relevant.
6.  **Revisit earlier problems.** Later problems reuse earlier ideas.
    Diameter and balance depend on height; Path Sum II builds on
    root-to-leaf DFS and backtracking.

The goal is to understand why each pattern works. Once the pattern
becomes familiar, a new problem often feels like a variation of
something you have already solved.
