class SegmentTree {
    int n;
    int[] tree;

    // Build from input array
    public SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[4 * n];    // safe upper bound for storage
        build(arr, 0, n - 1, 1);  // initial node index = 1
    }

    private void build(int[] arr, int start, int end, int node) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        build(arr, start, mid, 2 * node);
        build(arr, mid + 1, end, 2 * node + 1);
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    // Query sum in [l, r]
    public int query(int l, int r) {
        return queryUtil(0, n - 1, l, r, 1);
    }

    private int queryUtil(int start, int end, int l, int r, int node) {
        // No overlap
        if (r < start || end < l)
            return 0;
        // Full overlap
        if (l <= start && end <= r)
            return tree[node];
        // Partial overlap
        int mid = (start + end) / 2;
        return queryUtil(start, mid, l, r, 2 * node)
             + queryUtil(mid + 1, end, l, r, 2 * node + 1);
    }

    // Update single element arr[idx] -> val
    public void update(int idx, int val) {
        updateUtil(0, n - 1, idx, val, 1);
    }

    private void updateUtil(int start, int end, int idx, int val, int node) {
        if (start == end) {
            tree[node] = val;
            return;
        }
        int mid = (start + end) / 2;
        if (idx <= mid)
            updateUtil(start, mid, idx, val, 2 * node);
        else
            updateUtil(mid + 1, end, idx, val, 2 * node + 1);

        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }
}