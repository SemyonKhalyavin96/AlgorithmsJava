public class MyTreeMap<Value extends Comparable<Value>> {
    // ссылка на корневой элемент
    Node root;

    private class Node {
        Value value;
        Node left;
        Node right;

        int size;

        public Node(Value value) {
            this.value = value;
            size = 1;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private boolean isValueNotNull(Value val) {
        if (val == null) {
            throw new IllegalArgumentException("val не должен быть null");
        }
        return true;
    }

    public Value get(Value val) {
        return get(root, val);
    }

    private Value get(Node node, Value val) {
        isValueNotNull(val);
        if (node == null) {
            return null;
        }
        // если наш ключ совпал
        int cmp = val.compareTo(node.value);

        if (cmp == 0) {
            return node.value;
        } else if (cmp < 0) {
            // идем на лево
            return get(node.left, val);
        } else {
            // идем на право
            return get(node.right, val);
        }
    }

    public boolean contains(Value val) {
        return get(root, val) != null;
    }

    public void put(Value value) {
        isValueNotNull(value);
        if (value == null) {
            // delete(key);
            return;
        }
        root = put(root, value);
    }

    private Node put(Node node, Value value) {
        // новый узел
        if (node == null) {
            return new Node(value);
        }

        int cmp = value.compareTo(node.value);
        if (cmp == 0) {
            node.value = value;
        } else if (cmp < 0) {
            node.left = put(node.left, value);
        } else {
            node.right = put(node.right, value);
        }

        // пересчитать размер узла
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    public String toString() {
        return toString(root);
    }

    private String toString(Node node) {
        if (node == null) {
            return "";
        }

        return toString(node.left) + " " + node.value.toString() + " " + toString(node.right);
    }


    public Value minValue() {
        return min(root).value;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }

        return min(node.left);
    }

    public Value maxValue() {
        return max(root).value;
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        }

        return max(node.right);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }

        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void delete(Value value) {
        isValueNotNull(value);
        delete(root, value);
    }

    private Node delete(Node node, Value value) {
        if (node == null) {
            return null;
        }

        int cmp = value.compareTo(node.value);
        if (cmp < 0) {
            node.left = delete(node.left, value);
        } else  if(cmp > 0) {
            node.right = delete(node.right, value);
        } else {
            if (node.left == null) {
                return node.right;
            }

            if (node.right == null) {
                return node.left;
            }

            Node temp = node;
            node = min(node.right);

            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }

        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    // проверка на сбалансированность дерева
    public boolean isBalanced(Node node){
        return checkBalance(root) != -1;
    }

    private int checkBalance(Node node){
        if(node.value == null) return 0;
        int left = checkBalance(node.left);

        if(left == -1) return -1;

        int right = checkBalance(node.right);

        if(right == -1) return -1;

        if(Math.abs(left - right) > 1){
            return -1;
        }else{
            return 1 + Math.max(left, right);
        }
    }


}
