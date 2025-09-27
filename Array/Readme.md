# Techniques for solving Array problems:

## 1. Brute Force

- Try all possibilities, usually nested loops.
- Works for small constraints but often too slow.

Example:
Find two numbers that sum to a target.
Brute force → check all pairs with two loops → O(n^2).

## 2. Sorting + Two Pointers

- Sort the array, then use two pointers (left, right) moving inward/outward.
- Often used for pair-sum, triplet, or subarray problems.

Example:
Two Sum (sorted array):
left = 0, right = n-1.
If arr[left] + arr[right] > target → move right--.
Else if < target → move left++.
Time: O(n log n) (due to sorting) or O(n) if already sorted.

## 3. Sliding Window

- Used for subarray problems (max sum, smallest subarray, etc.).
M- aintain a "window" of elements, expand/shrink based on condition.

Example:
Max sum subarray of size k:
Add elements until window size = k.
Slide window forward by removing left element and adding right element.
Time: O(n).

## 4. Prefix Sum / Cumulative Sum

- Precompute sums so you can query subarray sums in O(1).
- Often combined with hash maps for subarray-sum problems.

Example:
Count subarrays with sum = k.
Keep running sum, check if (currentSum - k) has appeared before.
Time: O(n) with HashMap.

## 5. Hashing / Hash Map

- Use hash sets or maps for fast lookups.
- Great for "has this element appeared?" type problems.

Example:
Two Sum (unsorted):
Store seen numbers in HashSet.
For each x, check if target - x is in set.
Time: O(n).

## 6. Binary Search

- Works if array is sorted (or can be sorted).
- Often used in searching problems, or optimizing range queries.

Example:
Find first occurrence of a number → Binary Search in O(log n).

## 7. Kadane’s Algorithm

- Dynamic Programming technique for maximum subarray sum.
- Keep track of currentSum = max(arr[i], arr[i] + currentSum).
Time: O(n).

## 8. Divide and Conquer

- Break problem into halves (like Merge Sort).
- Used in range queries, max subarray, etc.

Example:
Maximum Subarray → solved by divide & conquer in O(n log n).

## 9. Greedy

- Make the best choice at each step.
- Used in interval problems, minimizing/maximizing cost, etc.

Example:
Jump Game (minimum jumps to reach end).
Track farthest reachable index, jump when needed.
Time: O(n).

## 10. Monotonic Stack / Deque

- Used for "next greater element" / "sliding window max".
- Keep a stack (or deque) in increasing/decreasing order.

Example:
Next Greater Element:
Traverse array from right to left, pop smaller elements.
Stack top = next greater.
Time: O(n).
