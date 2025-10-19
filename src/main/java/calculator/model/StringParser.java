package calculator.model;

public class StringParser {
    private final SeperatorExtraction seperatorExtraction;
    private final NumberValidator numberValidator;

    public StringParser() {
        this.seperatorExtraction = new SeperatorExtraction();
        this.numberValidator = new NumberValidator();
    }

    public int[] parse(String input) {
        // 빈 문자열 처리
        if (input == null || input.isEmpty()) {
            return new int[0];
        }

        // 커스텀 구분자 추출
        String separator = seperatorExtraction.extractSeparator(input);
        String numberString = seperatorExtraction.extractNumberString(input);

        // 구분자를 이용한 분리
        return parseNumbers(numberString, separator);
    }

    private int[] parseNumbers(String input, String separator) {
        if (input.isEmpty()) {
            return new int[0];
        }

        String[] tokens = input.split(separator);
        int[] numbers = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            numbers[i] = numberValidator.parseAndValidate(tokens[i]);
        }

        return numbers;
    }
}