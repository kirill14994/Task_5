import java.util.Arrays;

public class Solution {

    public void combination(String input){

        int[] vector = new int[getQuestionMarksCount(input)];
        Arrays.fill(vector, 0);

        boolean found = false;
        boolean finish = false;
        while (!finish) {
            if (isValid(replaceQuestions(input, vector))) {
                System.out.println(replaceQuestions(input, vector));
                found = true;
            }
            if (!rollVector(vector)) {
                finish = true;
            }
        }
        if (!found) {
            System.out.println("Нет решений для выражения: " + input);
        }
    }

    private boolean isValid(String equation) {
        String[] parts = equation.split("\\+|=");

        int q = Integer.parseInt(parts[0]); 
        int w = Integer.parseInt(parts[1]); 
        int e = Integer.parseInt(parts[2]); 
        
        return q + w == e;
    }

    private String replaceQuestions(String input, int[] vector) {
        char[] chars = input.toCharArray();
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                chars[i] = Character.forDigit(vector[index], 10);
                index++;
            }
        }
        return new String(chars);
    }

    private boolean rollVector(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] < 9) {
                vector[i] = vector[i] + 1;
                return true;
            }
            vector[i] = 0;
        }
        return false;
    }

    private int getQuestionMarksCount(String input) {
        int count = 0;
        for (int i = 0; i < input.toCharArray().length; i++) {
            if (input.toCharArray()[i] == '?') {
                count++;
            }
        }
        return count;
    }

}

