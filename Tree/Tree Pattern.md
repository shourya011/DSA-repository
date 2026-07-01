1. *PreOrder*
	**DFS Traversal** – Follow the Root → Left → Right recursion pattern.
	Iterative:- 
		1. Stack put right then left
	
2. *postOrder*
   **DFS Traversal** – Follow the Left → Right → Root recursion pattern.
   iterative:-
		1. Two Stack 
		2. the time at which the element is pop from stack1, push it to stack2 
   
3. *Inorder*
   **DFS Traversal** – Follow the Left → Root → Right recursion pattern.
   iterative:- 
		1. one Stack.
		   if(node!=null) move left
		   else pop and move right

4. *LevelOrderTraversal*
   **Level Order (BFS)** – Use a queue to visit nodes level by level.

5. *MaxHeight*
   **Tree Height Recursion** – Height = 1 + max(left height, right height).
	note:- 
		if lvl 0,1,2 return -1
		else lvl 1,2,3, return 0

6. *SameTree*
   **Parallel DFS** – Compare corresponding nodes of both trees recursively.(left with left and right with right)
   base cond;- r1 && r2 true
			 r1 || r2 false
	check;- l && r && val. 
	
		or 
		traverse and store in stack and check each element
	
7.  *Invert Binary Tree*
   **Recursive Tree Modification** – Swap left and right children at every node.
	   1. store root.left
	   2.   root.left = recursive(root.left)
	   3. root.right = recursive(step 1)
	4. return root   
		
8. *balance binary Tree*
   **Bottom-Up DFS** – Compute height while simultaneously checking balance.
   
9. *Diameter of binary Tree*
   **Single-Pass DFS** – Compute height while updating the longest path globally.
   Note:-
   height + maxDia = Math.max(l+r,maxDia);
   
10. *PathSum*
    **Root-to-Leaf DFS** – Carry the remaining/accumulated sum while traversing down.
    
11.* Symmetric Tree*
	 **Mirror DFS** – Compare left and right subtrees in mirrored order.
	 Note:- 
	 base cond;- r1 && r2 true
			 r1 || r2 false
			 n1.val with n2.val
	 compare n1.left to n2.right;
	 compare n1.right to n2.left
	 
12.* RightSideView*
    **Level Order + Last Node** – Process each level and keep the last visible node.
	    hint:- 
	    `if(lvl==i){ list.add(q.peek().val) }`
	    
13.. *LowestCommonAncestor bst*
    **Recursive Divide & Conquer** – Search both subtrees and return the node where paths split.
	```
	if(root.data<n1.data && root.data<n2.data){
            temp = LCA(root.right,n1,n2);
        }
        else if(root.data>n1.data && root.data>n2.data)
            temp = LCA(root.left,n1,n2);
        else
            return root;
    ```
            
 14.  *AverageLevel*
     **Level Order (BFS)** – Traverse level by level using a queue and process each level independently.

15. *Level Order Traversal 2*
	 **Reverse Level Order (BFS)** – Perform a normal level-order traversal and reverse the collected levels at the end (or prepend each level during traversal).
		*Note*; - just add all sublist on 0 index-
			cuz there is an property of List<> that it slides the element from 0 to 1 if there is an element which is being added at 0 index.

  16. *Validate BST*
      **BST Range Validation** – Ensure every node stays within valid min/max bounds. 
	  `check(TreeNode root,long min,long max)`
  
  17. *minDepth*
      **Minimum Depth DFS/BFS** – Find the shortest path from root to any leaf.
      algo:-1. if left is null return 1 + go right
		  2.  if right is null return 1 + go left
		 3. go both side and min of both + 1
18. kthsmallest in bst
	**BST Inorder Pattern** – Use inorder traversal since BST visits nodes in sorted order.
		list.add + inorder;

19.  *Lowest Common Ancestor in a Binary Tree*
		case:- 1.  `if(n1=root.data || n2=root.data) return root`
			recursion
		2.` if(p!=null && q!=null) return root`
		3. `if(p!=null) return p`
		   4. `return q`
	
20. *zigzagtraverse*
		`while(!s1.isEmpty() || !s2.isEmpty())
			`while(!s1.isEmpty())
				`left and right
			`while(!s2.isEmpty())
				`right to left`
				or
		lvl order and count%2=0 + reverse
				
21.* binarytreepath*
	**Backtracking DFS** – Maintain the current path and record it upon reaching leaves.
	Note:- check notes or github for this cuz it's important

22. *Sum of Left Leaf Nodes*
	**Conditional DFS** – Traverse all nodes while checking if a child is a left leaf.
		make two function l and r 
			in l if its leaf node then do sum else traverse normal
	
23. *SumRootToLeaf*
    **Path Accumulation DFS** – Build the path value during recursion and add it at leaf nodes.
	    `curr = curr * 10 + root.data;`

24. *Maximum path sum*
	**Tree DP (Postorder DFS)** – Compute the maximum gain from each subtree while updating the global maximum path sum at every node.
		`int l = Math.max(0,summ(root.left));
        `int r = Math.max(0,summ(root.right));
        `maxSum = Math.max(maxSum,l+r+root.data);
        `return root.data + Math.max(l,r);`

25. *FlatternBTtoLL*
    **n-Place Tree Modification (Reverse Postorder)** – Flatten the tree by recursively processing subtrees and rewiring pointers into a preorder-linked list.
	    ```// 1. Store nodes in preorder
		preorder(root);
		// 2. Rewire pointers
		for(TreeNode node : list){
	    node.left = null;
	    curr.right = node;
	    curr = node;
		}
		```
		
26.*Search In a BST*
	 **BST Search** – Use the BST property to move left or right based on the target value until the node is found or becomes `null`.
		Code:- ```
			if(root.val=val) return root
			condition
			l = searchinBST(root.left,val)	
			condition
			r = searchinBST(root.left,val)	
			condition 
			return l
			return r
			```
25. *Path2Sum*
	**DFS + Backtracking** – Traverse every root-to-leaf path, maintain the current path and remaining sum, and backtrack after exploring each branch.
		code :- 
		path.add(root.val);
		target -= root.val;

		if(isLeaf && target == 0)
		    ans.add(new ArrayList<>(path));
	
			path.remove(path.size() - 1) // n
			return 
		dfs(root.left, target);
		dfs(root.right, target);
		path.remove(path.size() - 1);   // Backtrack
				
26. BSTInsertation
	**Recursive BST Insertion** – Compare the value with the current node, move left or right using the BST property, and insert when a `null` position is reached.
		code:- 
		```if(root == null)
	    return new TreeNode(val);
		if(val < root.val)
		    root.left = insertIntoBST(root.left, val);
		else
		    root.right = insertIntoBST(root.right, val);
		return root;```