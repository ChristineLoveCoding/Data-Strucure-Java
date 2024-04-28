public class BST {
    //BST


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

    int findMin(TreeNode root){
        if(root == null){
            return  -1;//does not exist
        }
        //BST : the left-most node's value is the smallest value in a BST

        if(root.left ==null){
            return root.val;
        }
        int res = findMin(root.left);

        return res;
    }

    //iterative : space O(1)
    int findMin2(TreeNode root){
        if(root == null){
            return -1;
        }

        while(root.left !=null){
            root = root.left;
        }

        return root.val;
    }

    int findMax(TreeNode root){
        if(root == null){
            return -1; //does not exist
        }

        if(root.right == null){
            return root.val;
        }

        int res = findMax(root.right);

        return res;
    }

    //iterative
    int findMax2(TreeNode root){
        if(root == null){
            return -1;
        }

        while(root.right !=null){
            root = root.right;
        }

        return root.val;
    }


    int findHeight(TreeNode root) {
        //root to deepest node
        //height vs depth
        if(root == null){
            return -1;
        }

        int left = findHeight(root.left);
        int right = findHeight(root.right);

        return Math.max(left,right)+1;



    }
}
