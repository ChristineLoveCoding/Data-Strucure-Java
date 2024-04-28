public class BST {


    TreeNode insert(TreeNode a, int value){
        if( a == null){

            return new TreeNode(value);
        }

        if (value <= a.val){
            a.left =insert(a.left, value);
        }else{
           a.right = insert(a.right, value);
        }

        return a;

    }
}
