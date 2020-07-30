package com.zcw.data.bst;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName : BST
 * @Description :二分搜索树
 * @Author : Zhaocunwei
 * @Date: 2020-07-28 18:37
 */
public class BST<E extends Comparable<E>> {

    private class Node{
        public E e;
        public Node left,right;

        public Node(E e){
            this.e = e;
            left = null;
            right =null;
        }
    }
    private Node root;
    private int size;

    public BST(){
        root =null;
        size =0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    /**
     * 向二分搜索树中添加新的元素e
     */
    public void add(E e){
//        if(root == null){
//            root = new Node(e);
//            size ++;
//        }else{
//            add(root,e);
//        }
        root = add(root,e);
    }
    /**
     *向以node为根的二分搜索树中插入元素E，递归算法
     */
//    private void add(Node node ,E e){
//        if(e.equals(node.e)){
//            return;
//        }else if(e.compareTo(node.e) <0  && node.left ==null){
//            node.left = new Node(e);
//            size++;
//            return;
//        }else if(e.compareTo(node.e) >0 && node.right ==null){
//            node.right = new Node(e);
//            size++;
//            return;
//        }
//
//        if(e.compareTo(node.e)<0){
//            add(node.left,e);
//        }else{
//            add(node.right,e);
//        }
//    }

    /**
     * 改进添加操作： 深入理解递归终止条件
     * 返回出入新节点后二分搜索树的根
     * @param node
     * @param e
     * @return
     */
    private Node add(Node node ,E e){
        if(node == null){
            size++;
            return new Node(e);
        }
        if(e.compareTo(node.e)<0){
            node.left = add(node.left,e);
        }else if(e.compareTo(node.e) >0){
           node.right = add(node.right,e);
        }
        return node;
    }
    /**
     * 看二分搜索树中是否包含元素e
     */
    public boolean contains(E e){
        return contains(root,e);
    }

    /**
     * 看以node为根的二分搜索树中是否包含元素e,递归算法
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node ,E e){
        if(node == null){
            return  false;
        }
        if(e.compareTo(node.e) == 0){
            return  true;
        }else  if(e.compareTo(node.e) < 0){
            return contains(node.left,e);
        }else{
            return contains(node.right,e);
        }
    }
    /**
     * 二分搜索树的前序遍历
     */
    public void preOrder(){
        preOrder(root);
    }

    /**
     * 前序遍历以node为根的二分搜索树，递归算法
     * @param node
     */
    private void preOrder(Node node){
        //递归终止条件
        if(node == null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     *二分搜索树的非递归前序遍历
     */
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);

            if(cur.right !=null){
                stack.push(cur.right);
            }
            if(cur.left !=null){
                stack.push(cur.left);
            }
        }
    }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();

    }
    //生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node,int depth,StringBuilder res){
        if(node == null){
            res.append(generateDepthString(depth) +"null\n");
            return;
        }
        res.append(generateDepthString(depth)+node.e+"\n");
        generateBSTString(node.left,depth+1,res);
        generateBSTString(node.right,depth+1,res);
    }
    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i=0; i<depth;i++){
            res.append("--");
        }
        return res.toString();
    }

    /**
     *二分搜索树的中序遍历
     */
    public void inOrder(){
        inOrder(root);
    }

    /**
     *中序遍历以node为根的二分搜索树，递归算法
     */
    private void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 二分搜索树的后序遍历
     */
    public void postOrder(){
        preOrder(root);
    }

    /**
     * 后序遍历以node为根的二分搜索树，递归算法
     */
    private void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 二分搜索树的层序遍历
     */
    public void levelOrder(){
        Queue<Node>  q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node cur = q.remove();
            System.out.println(cur.e);

            if(cur.left !=null){
                q.add(cur.left);
            }
            if(cur.right !=null){
                q.add(cur.right);
            }
        }
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums ={5,3,6,8,4,2};
        for(int num : nums){
            bst.add(num);
        }
        //////////////////////////////
        //             5            //
        //            / \           //
        //           3   6          //
        //          / \   \         //
        //         2  4    8        //
        //////////////////////////////
        bst.preOrder();
        System.out.println();

//        System.out.println(bst);
        bst.inOrder();
        System.out.println();


        bst.preOrder();
        System.out.println();
    }
}
