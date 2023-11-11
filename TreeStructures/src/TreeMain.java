
public class TreeMain {
    public static void main(String[] args){

        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(new Node(9));
        tree.insert(new Node(4));
        tree.insert(new Node(8));
        tree.insert(new Node(2));
        tree.insert(new Node(3));

        tree.display();

        System.out.println(tree.search(5));

    }
}

