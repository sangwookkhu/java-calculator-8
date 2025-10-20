package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeperatorExtraction {
    private static final String DEFAULT_SEPARATOR = "[,:]";
    private static final String CUSTOM_SEPARATOR_PREFIX = "//";
    // ⭐ 백슬래시 + n 도 처리하도록 수정
    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("^//(.)(\\\\n|\\n)(.*)");

    public String extractSeparator(String input) {
        if (!input.startsWith(CUSTOM_SEPARATOR_PREFIX)) {
            return DEFAULT_SEPARATOR;
        }

        Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(input);
        if (matcher.find()) {
            String customSep = matcher.group(1);
            return Pattern.quote(customSep);
        }

        throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
    }

    public String extractNumberString(String input) {
        if (!input.startsWith(CUSTOM_SEPARATOR_PREFIX)) {
            return input;
        }

        Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(input);
        if (matcher.find()) {
            return matcher.group(3);
        }

        throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
    }
}