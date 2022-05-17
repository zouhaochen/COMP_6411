package Assignment2;

public class BinarySearchTree
{
    private int numberOfAccesses;

    public int getNumberOfAccesses()
    {
        return numberOfAccesses;
    }

    public void setNumberOfAccesses(int numberOfAccesses)
    {
        this.numberOfAccesses = numberOfAccesses;
    }

    //inner class for node information
    private class Node
    {
        //left node of the node
        private Node left;

        //key value of the node
        private int key;

        //right node of the node
        private Node right;

        //constructor of a node
        public Node(int key)
        {
            this.left = null;
            this.key = key;
            this.right = null;
        }
    }

    //root node
    private Node root = null;

    //method to insert node
    public void insert(int key)
    {
        Node newNode = new Node(key);

        //check whether the root node is empty
        if (root == null)
        {
            root = newNode;
        }
        else
        {
            insertNewNode(root, newNode);
        }
    }

    private void insertNewNode(Node node, Node newNode)
    {
        if (node.key > newNode.key)
        {
            if (node.left == null)
            {
                node.left = newNode;
            }
            else
            {
                insertNewNode(node.left, newNode);
            }
        }
        else
        {
            if (node.right == null)
            {
                node.right = newNode;
            }
            else
            {
                insertNewNode(node.right, newNode);
            }
        }
    }

    //pre order traversal all the nodes
    public void preOrderTraversal()
    {
        if (root != null)
        {
            preOrderTraversalNode(root);
        }
    }

    private void preOrderTraversalNode(Node node)
    {
        printer(node.key);

        if (node.left != null)
        {
            preOrderTraversalNode(node.left);
        }

        if (node.right != null)
        {
            preOrderTraversalNode(node.right);
        }
    }

    //in order traversal all the nodes
    public void inOrderTraversal()
    {
        if (root != null)
        {
            inOrderTraversalNode(root);
        }
    }

    private void inOrderTraversalNode(Node node)
    {
        if (node.left != null)
        {
            inOrderTraversalNode(node.left);
        }

        printer(node.key);

        if (node.right != null)
        {
            inOrderTraversalNode(node.right);
        }
    }

    //post order traversal all the nodes
    public void postOrderTraversal()
    {
        if (root != null)
        {
            postOrderTraversalNode(root);
        }
    }

    private void postOrderTraversalNode(Node node)
    {
        if (node.left != null)
        {
            postOrderTraversalNode(node.left);
        }

        if (node.right != null)
        {
            postOrderTraversalNode(node.right);
        }

        printer(node.key);
    }

    //print node key value
    private void printer(int key)
    {
        System.out.print(key + " ");
    }

    //get the max value
    public int getMax()
    {
        Node node = root;

        while (node.right != null)
        {
            //find the leftmost node
            node = node.right;
        }

        return node.key;
    }

    //get the min value
    public int getMin()
    {
        Node node = root;

        while (node.left != null)
        {
            //find the rightmost node
            node = node.left;
        }

        return node.key;
    }

    //search for node
    public boolean search(int key)
    {
        return searchNode(root, key);
    }

    private boolean searchNode(Node node, int key)
    {
        if (node == null)
        {
            return false;
        }

        if (node.key > key)
        {
            numberOfAccesses ++;
            return searchNode(node.left, key);
        }
        else if (node.key < key)
        {
            numberOfAccesses ++;
            return searchNode(node.right, key);
        }
        else
        {
            numberOfAccesses ++;
            return true;
        }
    }

    //delete node
    public boolean delete(int key)
    {
        //a temporary variable that stores the node to be deleted
        Node current = root;

        //a temporary variable that stores the parent of the node to be deleted
        Node parent = root;

        //a temporary variable that stores whether the node to be deleted is
        //the left or right node of its parent
        boolean isLeftChild = true;

        //find the deleted node
        while (current.key != key)
        {
            parent = current;

            if (key < current.key)
            {
                isLeftChild = true;
                current = current.left;
            }
            else
            {
                isLeftChild = false;
                current = current.right;
            }

            if (current == null)
            {
                return false;
            }
        }

        //the deleted node is a leaf node and has no child node
        if (current.left == null && current.right == null)
        {
            if (current == root)
            {
                root = null;
            }
            else if (isLeftChild)
            {
                parent.left = null;
            }
            else
            {
                parent.right = null;
            }
        }

        //the deleted node has only one right node
        else if (current.left == null)
        {
            if (current == root)
            {
                root = current.right;
            }
            else if (isLeftChild)
            {
                parent.left = current.right;
            }
            else
            {
                parent.right = current.right;
            }
        }

        //the deleted node has only one left node
        else if (current.right == null)
        {
            if (current == root)
            {
                root = current.left;
            }
            else if (isLeftChild)
            {
                parent.left = current.left;
            }
            else
            {
                parent.right = current.left;
            }
        }

        //there are two nodes to delete
        else
        {
            Node successor = getSuccessor(current);

            if (current == root)
            {
                root = successor;
            }
            else if (isLeftChild)
            {
                parent.left = successor;
            }
            else
            {
                parent.right = successor;
            }

            //points the left node of the successor node
            //to the left node of the deleted node
            successor.left = current.left;
        }
        return true;
    }

    //when the node to be deleted has two nodes
    //it is necessary to find the precursor node or successor node
    //from the child node to replace it and
    //find the successor node of the deleted node
    private Node getSuccessor(Node node)
    {
        //a temporary variable that stores the parent of the successor node
        Node successorparent = node;

        //a temporary variable that stores a successor node
        Node successor = node;

        //a temporary variable used to determine whether the left node of a node exists
        Node current = node.right;

        while (current != null)
        {
            successorparent = successor;
            successor = current;
            current = current.left;
        }

        //if a successor node has a right node
        //point its parent's left node to its right node
        if (successor != node.right)
        {
            successorparent.left = successor.right;

            //point the right node of the successor node
            //to the right node of the deleted node
            successor.right = node.right;
        }
        return successor;
    }
}
