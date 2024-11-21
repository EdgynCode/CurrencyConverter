public class MissingNumber {
    public static int findMissingNumber(int[] numbers, int n) {
        int expectedSum = n * (n + 1) / 2; // sum of first n natural numbers
        int actualSum = 0;
        for (int number : numbers) {
            actualSum += number;
        }
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] numbers = { 1, 2, 4, 5, 6 };
        int n = numbers.length + 1;
        int missingNumber = findMissingNumber(numbers, n);
        System.out.println("The missing number is: " + missingNumber);
    }
}
