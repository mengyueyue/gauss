package self.search;

/**
 * Created by mengyue on 2018/9/5.
 * Union Find
 */
abstract class UFInterface {

    int[] ids;
    int count = 0;

    UFInterface(int N) {
        count = N;
        ids = new int[N];
        for (int i = 0; i < N; i++) {
            ids[i] = i;
        }
    }

    abstract void union(int p, int q);

    abstract int find(int p);

    boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    int count() {
        return count;
    }

}

public class 并差集 {

}


/**
 * 并查集：在一些有N个元素的集合应用中，我们tongche
 * <p>
 * 1. quick union
 * 2. quick find
 * 3. weighted quick union
 * 4. weighted quick union with path compression
 */
class QuickFind extends UFInterface {

    QuickFind(int N) {
        super(N);
    }

    /**
     * 时间复杂度O(n)
     *
     * @param p
     * @param q
     */
    @Override
    void union(int p, int q) {
        int pid = find(p);
        int qid = find(q);
        if (pid == qid) {
            return;
        }
        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == ids[pid]) {
                ids[i] = qid;
            }
        }
        count--;
    }

    /**
     * 时间复杂度 O(1)
     *
     * @param p
     * @return
     */
    @Override
    int find(int p) {
        return ids[p];
    }
}

/**
 * 缺点：union出来的数 有可能是单列表树
 */
class QuickUnion extends UFInterface {


    QuickUnion(int N) {
        super(N);
    }

    /**
     * 因为find的时间复杂度为O(height) 以及各个find是叠加关系 所以 时间复杂度为O(height)
     *
     * @param p
     * @param q
     */
    @Override
    void union(int p, int q) {
        if (find(p) == find(q)) return;
        ids[find(p)] = find(q);
        count--;
    }

    /**
     * 因为从一棵树的任意一个节点找到根节点 需要最多迭代树高次
     * 时间复杂度为O(height)
     *
     * @param p
     * @return
     */
    @Override
    int find(int p) {
        //迭代的从非根节点 找根节点
        while (p != ids[p]) {
            p = ids[p];
        }
        return p;
    }
}

/**
 * 对quick union的优化
 * 我们记录树的大小，并且总是将小的树连接到大的树
 * 我们需要一个额外的数组 来记录每个树的大小
 */
class WeightedQuickUnion extends UFInterface {


    int[] sz;

    WeightedQuickUnion(int N) {
        super(N);
        count = N;
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
        }
    }

    /**
     *  形成一个多叉树 时间复杂度和find一致
     *
     * @param p
     * @param q
     */
    @Override
    void union(int p, int q) {
        int pid = find(p);
        int qid = find(q);
        if (pid == qid) {
            return;
        }
        if (sz[pid] > sz[qid]) {
            ids[qid] = pid;
            sz[pid] += sz[qid];
        } else {
            ids[pid] = qid;
            sz[qid] += sz[pid];
        }
        count--;
    }

    /**
     * 时间复杂度为 O(logN)
     *
     * @param p
     * @return
     */
    @Override
    int find(int p) {
        while (p != ids[p]) {
            p = ids[p];
        }
        return p;
    }
}

class WeightedQuickUnionUFWPC extends UFInterface {

    int[] sz;

    WeightedQuickUnionUFWPC(int N) {
        super(N);
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
        }
    }

    /**
     * 这个实现和 WeightedQuickUnion的实现是一致的
     *
     * @param p
     * @param q
     */
    @Override
    void union(int p, int q) {
        int pid = find(p);
        int qid = find(q);
        if (pid == qid) {
            return;
        }
        if (sz[pid] > sz[qid]) {
            ids[qid] = pid;
            sz[pid] += sz[qid];
        } else {
            ids[pid] = qid;
            sz[qid] += sz[pid];
        }
        count--;
    }

    /**
     * 将 p的 ids[p] 在查找过程中 赋值成root
     *
     * 所以在以后的查找中接近O(1)的时间复杂度
     *
     * @param p
     * @return
     */
    @Override
    int find(int p) {
        int root = p;
        while (root != ids[root]) {
            root = ids[root];
        }
        if (p != root) {
            ids[p] = root;
        }
        return root;
    }
}