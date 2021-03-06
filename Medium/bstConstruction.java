class Program {
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST (int value) {
            this.value = value;
        }
    }

    // create BST insert method
    public BST insert (int value) {
        // if the input value is less than the initial value from the constructor
        if (value < this.value) {
            if (left == null) {
                BST newBst = new BST(value);
                left = newBst;
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                BST newBst = new BST(value);
                right = newBst;
            } else {
                right.insert(value);
            }
        }

        return this;
    }

    // create a boolean contains method
    public boolean contains(int value) {
        if (value < this.value) {
            if (left == null) {
                return false;
            } else {
                return left.contains(value);
            }
        } else if (value > this.value) {
            if (right == null) {
                return false;
            } else {
                return right.contains(value);
            }
        } else {
            return true;
        }
    }

    // create BST remove method
    public BST remove(int value, BST parent) {
        remove(value, null);
        return this;
    }

    public void remove(int value, BST parent) {
        if (value < this.value) {
            if (left != null) {
                left.remove(value);
            }
        } else if (value > this.value) {
            if (right != null) {
                right.remove(value);
            }
        } else {
            if (left != null && right != null) {
                this.value = right.getMinVal();
                right.remove(this.value, this);
            } else if (parent == null) {
                if (left != null) {
                    this.value = left.value;
                    right = left.right;
                    left = left.left;
                } else if (right != null) {
                    this.value = right.value;
                    left = right.left;
                    right = right.right;
                } else {
                    // in this case, the tree only has a single node.
                    // therefore, do nothing -> blank statement
                }
            } else if (parent.left == this) {
                parent.left = left != null ? left : right;
            } else if (parent.right == this) {
                parent.right = left != null ? left : right;
            }
        }
    }

    // create a method to get the min value
    public int getMinVal() {
        if (left == null) {
            return this.value;
        } else {
            return left.getMinVal();
        }
    }
}