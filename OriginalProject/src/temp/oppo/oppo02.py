def min_deletions_to_make_multiple(n_str, k):
    n_len = len(n_str)

    dp = [[float("inf")] * k for _ in range(n_len + 1)]
    dp[0][0] = 0

    for i in range(n_len):
        current_digit = int(n_str[i])

        for j in range(k):
            if dp[i][j] != float("inf"):
                # Case 1: Don't delete the current digit
                new_mod = (j * 10 + current_digit) % k
                dp[i + 1][new_mod] = min(dp[i + 1][new_mod], dp[i][j])

                # Case 2: Delete the current digit
                dp[i + 1][j] = min(dp[i + 1][j], dp[i][j] + 1)
    print(dp)
    return dp[n_len][0] if dp[n_len][0] != float("inf") else -1


n_str = "1345"
k = 3
print(min_deletions_to_make_multiple(n_str, k))


def min_deletions_to_make_multiple(n_str, k):
    n_len = len(n_str)

    # 1D dp array for current state and next state
    dp_prev = {}
    dp_curr = {}
    dp_prev[0] = 0

    for i in range(n_len):
        current_digit = int(n_str[i])

        # Reset dp_curr for the current digit
        dp_curr = {}

        for j in range(k):
            if dp_prev.get(j) != None:
                # Case 1: Don't delete the current digit
                new_mod = (j * 10 + current_digit) % k
                dp_curr[new_mod] = min(
                    dp_curr.get(new_mod, float("inf")), dp_prev.get(j, float("inf"))
                )

                # Case 2: Delete the current digit
                dp_curr[j] = min(
                    dp_curr.get(j, float("inf")), dp_prev.get(j, float("inf")) + 1
                )

        # Move dp_curr to dp_prev for the next iteration
        dp_prev = dp_curr

    return dp_prev.get(0, n_len)


# Example usage
n_str = str(1231241241241)
k = 7
print(min_deletions_to_make_multiple(n_str, k))


# Example usage
n_str = "1345"
k = 3
print(min_deletions_to_make_multiple(n_str, k))
