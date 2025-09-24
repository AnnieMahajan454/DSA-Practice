import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  // number of test cases
        while (T-- > 0) {
            int N = sc.nextInt();   // size of array
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            List<Integer> leaders = new ArrayList<>();
            int maxFromRight = arr[N - 1]; // last element is always a leader
            leaders.add(maxFromRight);
            
            // Traverse from right to left
            for (int i = N - 2; i >= 0; i--) {
                if (arr[i] >= maxFromRight) {
                    leaders.add(arr[i]);
                    maxFromRight = arr[i];
                }
            }
            // Reverse list to restore left-to-right order
            Collections.reverse(leaders);
            // Print leaders
            for (int x : leaders) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}

//Time Complexity: O(N)
