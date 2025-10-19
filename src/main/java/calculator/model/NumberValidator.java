package calculator.model;

public class NumberValidator {
    public int parseAndValidate(String token) {
        int number = parseNumber(token);
        validatePositive(number);
        return number;
    }

    private int parseNumber(String token) {
        try {
            return Integer.parseInt(token.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형식이 올바르지 않습니다.");
        }
    }

    private void validatePositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }
}