import java.util.ArrayList;
import java.util.List;

public class backtracking {
    //bk == DFS
    List< TreeNode> res = new ArrayList<>();

    void preOrder(TreeNode root){
        if(root == null){
            return;
        }

        if(root.val == 7){
            res.add(root);
        }

        preOrder(root.left);
        preOrder(root.right);
    }
}
