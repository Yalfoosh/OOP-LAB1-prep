package hr.fer.oop.lab1.prob6;

/**
 * @author Miljenko
 */
public class TreeNode 
{
    TreeNode left;
    TreeNode right;
    String data;
    
    public TreeNode(String data) 
    {
        this.data = data;
    }
    
    public TreeNode()
    {
        this.data = new String();
    }
}
