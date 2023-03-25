package bj;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_1991_트리순회_김건현 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Tree root = new Tree('A', null, null);


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char alphabet = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            add(root, alphabet, left, right);
        }
        InOrder(root);
        System.out.println(sb.toString());
        sb = new StringBuilder();
        preOrder(root);
        System.out.println(sb.toString());
        sb = new StringBuilder();
        postOrder(root);
        System.out.println(sb.toString());
    }

    static class Tree {
        char alphabet;
        Tree left;
        Tree right;

        public Tree() {
        }

        public Tree(char alphabet, Tree left, Tree right) {
            this.alphabet = alphabet;
            this.left = left;
            this.right = right;
        }

        public Tree(char alphabet) {
            this.alphabet = alphabet;
        }
    }

    static void add(Tree tree, char alphabet, char left, char right) {
        //지금 노드가 해당노드이면
        if(tree.alphabet == alphabet){
            //.이면 null
            if(left == '.'){
                tree.left = null;
            }else{
                tree.left = new Tree(left, null, null);
            }
            if(right == '.'){
                tree.right = null;
            }else{
                tree.right = new Tree(right, null, null);
            }
        }else{
            if(tree.left != null) add(tree.left, alphabet, left, right);
            if(tree.right != null) add(tree.right, alphabet, left, right);
        }
    }
    static void preOrder(Tree tree){
        if(tree==null) return;//null이면 끝이니까 그냥 리턴 (종료조건)
        preOrder(tree.left);//왼쪽
        sb.append(tree.alphabet); //가운데
        preOrder(tree.right); //오른쪽

    }

    static void InOrder(Tree tree){
        if(tree==null) return;//null이면 끝이니까 그냥 리턴 (종료조건)
        sb.append(tree.alphabet); //가운데
        InOrder(tree.left);//왼쪽
        InOrder(tree.right); //오른쪽
    }
    static void postOrder(Tree tree){
        if(tree==null) return;//null이면 끝이니까 그냥 리턴 (종료조건)
        postOrder(tree.left);//왼쪽
        postOrder(tree.right); //오른쪽
        sb.append(tree.alphabet); //가운데
    }

}
