/**
 * Solution to
 * Q1 Balanced Array —- Coding.
 */
public class BalancedSum {
    public static int balancedSum(int[] arr) {
        int n = arr.length;
        int leftSum = 0;
        int rightSum = 0;
        for (int num : arr) {
            rightSum += num;
        }
        for (int i = 0; i < n; i++) {
            rightSum -= arr[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += arr[i];
        }
        //Handling the case where no solution is present.
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6};
        int pivotIndex = balancedSum(arr);
        System.out.println("The pivot index is: " + pivotIndex);
    }
}
