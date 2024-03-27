
public class MinCost {

        public static int minCost(String s) {
            int n = s.length();
            int[] dp = new int[n + 1]; // Dynamic programming array to store minimum cost for each substring
            dp[0] = 0; // Base case: cost of an empty string is 0

            for (int i = 1; i <= n; i++) {
                dp[i] = dp[i - 1] + 5; // Cost of appending a character to the string

                // Check if any substring ending at the current rightmost character can be copied and appended
                for (int j = 0; j < i - 1; j++) {
                    String substring = s.substring(j, i);
                    if (s.endsWith(substring)) {
                        dp[i] = Math.min(dp[i], dp[j] + 5); // Cost of copying and appending the substring
                    }
                }
            }

            return dp[n]; // Minimum cost to obtain the target string
        }
        public static void main(String[] args) {
            String s = "abhihibhihi";
            System.out.println("Minimum cost: " + minCost(s));
        }
    }


