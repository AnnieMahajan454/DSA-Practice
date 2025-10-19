//19 October 2025
/*
This is a classic state-space search problem, the key is to treat each string configuration as a node in a graph, where edges represent the two allowed operations. Your goal is to explore all reachable states and return the lexicographically smallest one.
Core Idea: Breadth-First Search (BFS)
- We treat each string as a state and apply:
- Add operation: increment digits at odd indices by a (modulo 10)
- Rotate operation: rotate the string right by b positions
- We use BFS to explore all reachable states and track the smallest string seen.
*/
class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        String min = s;
        queue.offer(s);
        visited.add(s);
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (curr.compareTo(min) < 0) {
                min = curr;
            }
            char[] chars = curr.toCharArray();
            for (int i = 1; i < chars.length; i += 2) {
                chars[i] = (char) ((chars[i] - '0' + a) % 10 + '0');
            }
            String added = new String(chars);
            if (visited.add(added)) {
                queue.offer(added);
            }
            String rotated = curr.substring(curr.length() - b) + curr.substring(0, curr.length() - b);
            if (visited.add(rotated)) {
                queue.offer(rotated);
            }
        }
        return min;
    }
}

// Time Complexity: O(N^2)
