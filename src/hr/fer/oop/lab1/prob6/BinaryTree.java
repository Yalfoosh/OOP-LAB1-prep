package hr.fer.oop.lab1.prob6;

/**
 * @author Ljac
 */

public class BinaryTree 
{
    TreeNode root;
    
    public BinaryTree()
    {
        root = new TreeNode();
    }
 
    public void insert(String data) 
    {
        TreeNode curr = root;
        
        if(root.data.isEmpty())
        {
            curr.data = data;
            return;
        }
        
        while(true)
        {
            int res = data.compareTo(curr.data);
            
            if(res <= 0)
            {
                if(curr.left == null)
                {
                    curr.left = new TreeNode(data);
                    break;
                }
                else
                    curr = curr.left;
            }
            else
            {
                if(curr.right == null)
                {
                    curr.right = new TreeNode(data);
                    break;
                }
                else
                    curr = curr.right;
            }
        }
    }
    
    private boolean subTreeContainsData(TreeNode node, String data) 
    {
        int res = (data).compareTo(node.data);
        
        if(node.left != null)
            res *= node.left.data.compareTo(node.data) <= 0 ? 1 : -1;
        else if(node.right != null)
            res *= node.right.data.compareTo(node.data) > 0 ? 1 : -1;
        
        if(res == 0)
            return true;
        else if(res < 0)
        {
            if(node.left == null)
                return false;
            else
                return subTreeContainsData(node.left, data);
        }
        else if(res > 0)
        {
            if(node.right == null)
                return false;
            else
                return subTreeContainsData(node.right, data);
        }
        else
            return false;
    }
    
    public boolean containsData(String data) 
    {
        return subTreeContainsData(root, data);
    }
    
    public boolean containsData2(String data)
    {
        return cD2(root, data);
    }
    
    private boolean cD2(TreeNode node, String data)
    {
        if(node.data.equals(data))
            return true;
        else
        {
            boolean l = false, r = false;
            
            if(node.left != null)
                l = cD2(node.left, data);
            
            if(node.right != null)
                r = cD2(node.right, data);
            
            return (l || r);
        }
    }
    
    private int sizeOfSubTree(TreeNode node) 
    {
        int l = (node.left != null) ? sizeOfSubTree(node.left) : 0;
        int r = (node.right != null) ? sizeOfSubTree(node.right) : 0;
        
        return l + r + 1;
    }

    public int sizeOfTree() 
    {
        return sizeOfSubTree(root);
    }

    private void writeSubTree(TreeNode node) 
    {
        if(node.left != null)
            writeSubTree(node.left);
        
        System.out.println(node.data);
        
        if(node.right != null)
            writeSubTree(node.right);
    }

    public void writeTree() 
    {
        writeSubTree(root);
    }
    
    private void reverseSubTreeOrder(TreeNode node) 
    {
        TreeNode t = node.left;
        
        node.left = node.right; node.right = t;
        
        if(node.left != null && ((node.left).left != null || (node.left).right != null))
            reverseSubTreeOrder(node.left);
        
        if(node.right != null && ((node.right).left != null || (node.right).right != null))
            reverseSubTreeOrder(node.right);
    }

    public void reverseTreeOrder() 
    {
        reverseSubTreeOrder(root);
    }
    
    public static void main(String[] args) 
    {
        BinaryTree tree = new BinaryTree();
        
        tree.insert("Jasna");
        tree.insert("Ana");
        tree.insert("Ivana");
        tree.insert("Anamarija");
        tree.insert("Vesna");
        tree.insert("Kristina");
        
        System.out.println("Writing tree inorder:");
        tree.writeTree();
        
        tree.reverseTreeOrder();
        System.out.println("Writing reversed tree inorder:");
        tree.writeTree();
        
        int size = tree.sizeOfTree();
        System.out.println("Number of nodes in tree is " + size + ".");
        
        boolean found = tree.containsData2("Ivana");
        System.out.println("Searched element is found: " + found);
    }
}