package week04.pgs42839;

import java.util.HashSet;
import java.util.Set;

/**
 * 문제명: 소수 찾기 https://school.programmers.co.kr/learn/courses/30/lessons/42839
 */

public class Main {

    private static final Set<Integer> newNumbers = new HashSet<>();

    public static void main(String[] args) {
        String numbers = "121";
        System.out.println(solution(numbers));
    }

    public static int solution(String numbers) {
        char[] nums = numbers.toCharArray();
        boolean[] visited = new boolean[nums.length];

        permutation(visited, 0, nums, "");

        return (int) newNumbers.stream()
                .filter(Main::isPrimeNumber)
                .count();
    }

    private static void permutation(boolean[] visited, int depth, char[] nums, String currentNumber) {
        if (depth >= nums.length) {
            // 종료 조건
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                String newNumber = currentNumber + nums[i];

                newNumbers.add(Integer.parseInt(newNumber));

                permutation(visited, depth + 1, nums, newNumber);
                visited[i] = false;
            }
        }
    }

    private static boolean isPrimeNumber(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= (int) Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
