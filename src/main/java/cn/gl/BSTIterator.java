package cn.gl;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BSTIterator {
	List<Integer> list = new ArrayList<Integer>();
	int idx;
	
    public BSTIterator(TreeNode root) {
    	inOrder(root);
    }
    
    
    
    private void inOrder(TreeNode node){
    	if(node == null) 
    		return;
    	inOrder(node.left);
    	list.add(node.val);
    	inOrder(node.right);
    }
    
    /** @return the next smallest number */
    public int next() {
        return list.get(idx++);
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
    	if(idx < list.size()) {
    		return true;
    	}
        return false;
    }
}
