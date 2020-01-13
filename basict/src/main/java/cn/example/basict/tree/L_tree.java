package cn.example.basict.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Author：created by SugarT
 * Time：2019/11/8 14
 */
public class L_tree {
    public static void main(String args[]) {

//        TreeNode treeNode3 = new TreeNode(3);
//        TreeNode treeNode9 = new TreeNode(9);
////        TreeNode treeNode8 = new TreeNode(8);
//        TreeNode treeNode20 = new TreeNode(20);
//        TreeNode treeNode15 = new TreeNode(15);
//        TreeNode treeNode7 = new TreeNode(7);
//        treeNode3.left = treeNode9;
//        treeNode3.right = treeNode20;
////        treeNode9.left = treeNode8;
//
//        treeNode20.left = treeNode15;
//        treeNode20.right = treeNode7;
////        levelOrder(treeNode3);
//        System.out.print("二叉树的最大深度: " + getMaxHeight(treeNode3));
////        System.out.print("二叉树的最小深度: " + getLowHeight(treeNode3));
//
////        System.out.print("二叉树的最小深度: " + numberOfLeafs(treeNode3));


        BinaryTree binaryTree = new BinaryTree();

        binaryTree.insert(10);
        binaryTree.insert(8);
        binaryTree.insert(15);
        binaryTree.insert(4);
        binaryTree.insert(9);
        binaryTree.insert(11);
        binaryTree.insert(20);
//
//        binaryTree.insert(5);
//        binaryTree.insert(2);
//        binaryTree.insert(13);


//        System.out.println("二叉树的最大深度: " + binaryTree.getMaxHeight(binaryTree.root));
//
//        binaryTree.insert(4);
//        binaryTree.insert(2);
//        binaryTree.insert(6);
//        binaryTree.insert(1);
//        binaryTree.insert(3);

//        binaryTree.preOrder(binaryTree.root);
//        binaryTree.afterOrder(binaryTree.root);

//
        System.out.println("--------------------前序遍历--------------------");
        binaryTree.preOrder(binaryTree.root);

        System.out.println("--------------------中序遍历--------------------");
        binaryTree.minOrder(binaryTree.root);

        System.out.println("--------------------后序遍历--------------------");
        binaryTree.afterOrder(binaryTree.root);

        System.out.println("--------------------help--------------------");
        System.out.println(binaryTree.help(binaryTree.root));


//
//
//        System.out.println("--------------------累加--------------------");
//        binaryTree.preOrder(binaryTree.convertBST(binaryTree.root));

//        flatten(binaryTree.root);


//        TreeNode treeNode1 = new TreeNode(1);
//        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode5 = new TreeNode(5);
//
//        TreeNode treeNode3 = new TreeNode(3);
//        TreeNode treeNode4 = new TreeNode(4);
//        TreeNode treeNode6 = new TreeNode(6);
//
//        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode5;
//
//        treeNode2.left = treeNode3;
//        treeNode2.right = treeNode4;
//
//        treeNode5.right = treeNode6;

//        flatten22(treeNode1);
//        BinaryTree binaryTree = new BinaryTree();
//
//        binaryTree.root = treeNode1;


//        System.out.println("--------------------前序遍历--------------------");
//        binaryTree.preOrder(binaryTree.root);
//
//        System.out.println("--------------------中序遍历--------------------");
//        binaryTree.minOrder(binaryTree.root);
//
//        System.out.println("--------------------后序遍历--------------------");
//        binaryTree.afterOrder(binaryTree.root);


//        flatten22(treeNode1);


//        flatten(treeNode1);
//
//        TreeNode header = beforeList.poll();
//
//        TreeNode current = header;
//
//        while (!beforeList.isEmpty()){
//            TreeNode temp =  beforeList.poll();
//            current.left = null;
//            current.right = temp;
//            current = temp;
//        }
//        while (header != null){
//            System.out.println(header.val);
//            header = header.right;
//        }

    }













    int minValue = -1;

    public int minDiffInBST(TreeNode root) {

        if(root != null){
            minDiffInBST(root.left);
            if(root.val>minValue){
                minValue = root.val;
            }
            minDiffInBST(root.right);
        }
     return  minValue;
    }

    private static TreeNode prev = null;

    /**
     * 给定一个二叉树，原地将它展开为链表。
     * <p>
     * 例如，给定二叉树
     * <p>
     * 1
     * / \
     * 2   5
     * / \   \
     * 3   4   6
     * 将其展开为：
     * <p>
     * 1
     * \
     * 2
     * \
     * 3
     * \
     * 4
     * \
     * 5
     * \
     * 6
     *
     * @param root
     */
    public static void flatten22(TreeNode root) {

        if (root == null) {
            return;
        }

        flatten22(root.right);
        flatten22(root.left);

        root.left = null;
        root.right = prev;
        prev = root;
//        if (root == null)
//            return;
//        flatten22(root.right);
//        flatten22(root.left);
//        System.out.println(root.val);
//        root.right = prev;
//        root.left = null;
//        prev = root;
    }

    /**
     * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     * <p>
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回其自底向上的层次遍历为：
     * <p>
     * [
     * [15,7],
     * [9,20],
     * [3]
     * ]
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> modules = new ArrayList<>();

        if (root == null) {
            return new ArrayList<>();
        }

        LinkedList<TreeNode> queen = new LinkedList<>();
        queen.offer(root);
        while (!queen.isEmpty()) {
            List<Integer> datas = new ArrayList<>();
            int count = queen.size();
            while (count > 0) {
                TreeNode data = queen.poll();
                datas.add(data.val);
                if (data.left != null) {
                    queen.offer(data.left);
                }
                if (data.right != null) {
                    queen.offer(data.right);
                }
                --count;
            }

            modules.add(0,datas);
//            modules.add(datas);
        }
        return modules;
    }


    /**
     * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
     * <p>
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回其层次遍历结果：
     * <p>
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> list = new LinkedList<>();
            while (count > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
//                System.out.println(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                count--;
            }
            res.add(list);
        }

        System.out.println(Arrays.toString(res.toArray()));

        return res;
    }


    /**
     * 给定一个二叉树，检查它是否是镜像对称的。
     * <p>
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     * <p>
     * 1
     * / \
     * 2   2
     * / \ / \
     * 3  4 4  3
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     * <p>
     * 1
     * / \
     * 2   2
     * \   \
     * 3    3
     *
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);

    }

    private static boolean isSymmetric(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
    }


    static class BinaryTree {

        static TreeNode root;

        /**
         * 根据值发现节点
         *
         * @param val
         * @return
         */
        public TreeNode find(int val) {
            TreeNode current = root;
            while (current != null) {
                if (current.val < val) {
                    current = current.right;
                } else if (current.val > val) {
                    current = current.left;
                } else {
                    return current;
                }
            }
            return null;
        }

        /**
         * 插入节点
         *
         * @param val
         * @return
         */
        public boolean insert(int val) {

            TreeNode newNode = new TreeNode(val);
            if (root == null) {
                root = newNode;
                return true;
            }

            TreeNode current = root;
            while (current != null) {
                if (current.val < val) {
                    if (current.right == null) {
                        current.right = newNode;
                        return true;
                    }
                    current = current.right;
                } else if (current.val > val) {
                    if (current.left == null) {
                        current.left = newNode;
                        return true;
                    }
                    current = current.left;
                } else {
                    return false;
                }
            }
            return false;
        }

        /**
         * 树的最大深度
         *
         * @param root
         * @return
         */
        public int getMaxHeight(TreeNode root) {

            if (root == null) {
//                System.out.println("null");
                return 0;
            }

//            System.out.println(root.val);

            int height = Math.max(getMaxHeight(root.left), getMaxHeight(root.right)) + 1;

//            System.out.println("深度计算" + height);

            return height;
        }


        /**
         * 树的最小深度
         *
         * @param root
         * @return
         */
        public int getLowHeight(TreeNode root) {

            if (root == null) {
                System.out.println("null");
                return Integer.MAX_VALUE;
            }
            if (root.left == null && root.right == null) {
                System.out.println(root.val);
                return 1;
            }
            System.out.println(root.val);
            int lowHeight = Math.min(getLowHeight(root.left), getLowHeight(root.right)) + 1;

            System.out.println("最小深度计算" + lowHeight);

            return lowHeight;

        }


        /**
         * 计算节点个数
         *
         * @param root
         * @return
         */
        static int count = 0;

        public int numberOfLeafs(TreeNode root) {

//        else if (note.left == null && note.right == null)
//            return 1;
            int nodes = 0;

            if (root == null) {
                return 0;
            } else {
                nodes = numberOfLeafs(root.left) + numberOfLeafs(root.right) + 1;
            }
            return nodes;

//        if(root == null){
//            return 0;
//        }
//        if(root != null){
//            ++count;
//        }
//        numberOfLeafs(root.left);
//        numberOfLeafs(root.right);
//        return count;
        }

        /**
         * 前序遍历:根节点——》左子树——》右子树
         *
         * @param current
         */
        public void preOrder(TreeNode current) {

            if (current == null) {
                return;
            }
            System.out.println(current.val);
            preOrder(current.left);
            preOrder(current.right);

        }


        /**
         * 后序遍历:根节点——》左子树——》右子树
         *
         * @param current
         */
        public void afterOrder(TreeNode current) {

            if (current == null) {
                return;
            }
            afterOrder(current.right);
            afterOrder(current.left);
            System.out.println(current.val);
        }


        /**
         * 中序遍历:根节点——》左子树——》右子树
         *
         * @param current
         */
        public void minOrder(TreeNode current) {

            if (current == null) {
                return;
            }
            minOrder(current.left);
            System.out.println(current.val);
            minOrder(current.right);
        }


        /**
         * 求二叉数右子树的深度
         *
         * @param root
         * @return
         */
        public int help(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return help(root.right) + 1;
        }


        /**
         * 累加树
         *
         * @param root
         * @return
         */
        int add = 0;

        public TreeNode convertBST(TreeNode root) {


            if (root == null) {
                return root;
            }
            convertBST(root.right);
            root.val += add;
            add = root.val;
            convertBST(root.left);
            return root;
        }

    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
