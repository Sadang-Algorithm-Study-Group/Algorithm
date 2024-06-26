package week01.boj17413;

import java.io.*;
import java.util.*;

/**
 * 문제: 단어 뒤집기 2 (실버 3)
 * 메모리 23484 kb
 * 시간 240 ms
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        System.out.print(solution(s));
    }

    public static StringBuilder solution(String s) {
        Stack<Character> stack = new Stack<>();
        boolean tagOpenFlag = false;
        StringBuilder result = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == '<') {
                popAll(stack, result);
                tagOpenFlag = true;
                result.append(ch);
                continue;
            }
            else if (ch == '>') {
                tagOpenFlag = false;
                result.append(ch);
                continue;
            }

            if (ch == ' ' & !tagOpenFlag) {
                popAll(stack, result);
                result.append(ch);
                continue;
            }

            if (tagOpenFlag) {
                result.append(ch);
                continue;
            }
            stack.push(ch);
        }
        popAll(stack, result);
        return result;
    }

    private static void popAll(Stack<Character> stack, StringBuilder result) {
        while (!stack.empty()) {
            result.append(stack.pop());
        }
    }
}
