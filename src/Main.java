import easy.Soluutions;
import hard.Solutions;

import java.util.*;

import static easy.Soluutions.leafSimilar;


public class Main {
    public static void main(String[] args) {
        Soluutions.TreeNode root1 = new Soluutions.TreeNode(
                1,
                new Soluutions.TreeNode(3),
                new Soluutions.TreeNode(2) );



        Soluutions.TreeNode root2 = new Soluutions.TreeNode(
                1,
                new Soluutions.TreeNode(2),
                new Soluutions.TreeNode(3) );

        boolean similar = leafSimilar(root1,root2);
        System.out.println(similar);

    }
}