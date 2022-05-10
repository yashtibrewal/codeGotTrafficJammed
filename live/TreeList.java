class TreeList {

    // Definition for a binary tree node.
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }

        @Override
        public String toString() {
            return "[" + this.val + "]";
        }

    }

    private int size;
    private TreeNode root;
    private boolean nodeAdded;

    TreeList() {
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // supporting function for contains
    private boolean findElement(TreeNode root, int number) {
        if (root != null) {
            if (root.val == number) {
                return true;
            }
            boolean result = false;
            findElement(root.left, number);
            if (result)
                return true;
            findElement(root.right, number);
            if (result)
                return true;
        }
        return false;
    }

    public boolean contains(Object o) {
        if (size == 0) {
            return false;
        }
        if (o == null) {
            return false;
        }
        if (o.getClass() != Integer.class) {
            return false;
        }
        int num = (int) o;
        return findElement(root, num);
    }

    // supporting function for add
    private void add(TreeNode root, int num) {
        if (root.val >= num) {
            if (root.left != null) {
                add(root.left, num);
            } else {
                root.left = new TreeNode(num);
                nodeAdded = true;
            }
        } else {
            if (root.right != null) {
                add(root.right, num);
            } else {
                root.right = new TreeNode(num);
                nodeAdded = true;
            }
        }
    }

    public boolean add(Integer num) {
        try {
            this.nodeAdded = false;
            if (this.root == null) {
                root = new TreeNode(num);
                nodeAdded = true;
            } else {
                add(root, num);
            }
        } catch (Exception e) {
            return false;
        }
        if (nodeAdded)
            size++;
        return nodeAdded;
    }

    // print ascending
    private void printAsc(TreeNode root) {
        if (root == null)
            return;
        printAsc(root.left);
        System.out.print(root);
        printAsc(root.right);
    }

    // print descending
    private void printDsc(TreeNode root) {
        if (root == null)
            return;
        printDsc(root.right);
        System.out.print(root);
        printDsc(root.left);
    }

    public void print(OrderType type) {
        if (type == OrderType.ASCENDING) {
            System.out.println();
            if (this.size > 0)
                printAsc(root);
        } else {
            System.out.println();
            if (this.size > 0)
                printDsc(root);
        }
    }
}
