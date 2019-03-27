import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.max;
import static java.util.Objects.isNull;

public class TreeBiggerUniquePath {

    public static void main(String[] args) {

        Tree root = new Tree(4);

        root.l = new Tree(5);
        root.r = new Tree(6);

        root.l.l = new Tree(4);
        root.l.l.l = new Tree(5);

        root.r.l = new Tree(1);
        root.r.r = new Tree(6);

        System.out.println(solution(root));
    }

    static int solution(Tree t) {

        Set<Integer> hash = new HashSet<>();

        return findUniquePath(t, hash);
    }


    static int findUniquePath(Tree tree, Set<Integer> hash) {

        if (isNull(tree))
            return hash.size();

        hash.add(tree.x);

        int max_path = max(findUniquePath(tree.l, hash), findUniquePath(tree.r, hash));

        hash.remove(tree.x);
        if (tree.x == 0)
            hash.remove(tree.x);

        return max_path;
    }
}


class Tree {
    public int x;
    public Tree l;
    public Tree r;

    public Tree(int x) {
        this.x = x;
    }
}
