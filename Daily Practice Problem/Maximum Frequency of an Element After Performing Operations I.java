class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>(n * 2);
        List<int[]> events = new ArrayList<>(2 * n);
        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
            int L = x - k;
            int R = x + k;
            events.add(new int[]{L, +1});
            events.add(new int[]{R + 1, -1});
        }
        events.sort((a, b) -> (a[0] == b[0]) ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        int m = freq.size();
        int[] uniqueVals = new int[m];
        int idx = 0;
        for (int v : freq.keySet()) uniqueVals[idx++] = v;
        Arrays.sort(uniqueVals);
        int e = 0, E = events.size();
        int cover = 0, maxCover = 0;
        int[] coverAtVal = new int[m];
        for (int i = 0; i < m; i++) {
            int v = uniqueVals[i];
            while (e < E && events.get(e)[0] <= v) {
                cover += events.get(e)[1];
                maxCover = Math.max(maxCover, cover);
                e++;
            }
            coverAtVal[i] = cover;
        }
        while (e < E) {
            cover += events.get(e)[1];
            maxCover = Math.max(maxCover, cover);
            e++;
        }
        int best = Math.min(maxCover, numOperations);
        for (int i = 0; i < m; i++) {
            int v = uniqueVals[i];
            int f = freq.get(v);
            int c = coverAtVal[i];
            int cand = Math.min(c, f + numOperations);
            if (cand > best) best = cand;
        }
        return best;
    }
}
