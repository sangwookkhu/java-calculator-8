package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeperatorExtraction {
    private static final String DEFAULT_SEPARATOR = "[,:]";
    private static final String CUSTOM_SEPARATOR_PREFIX = "//";
    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("^//(.)\\n(.*)");

    public String extractSeparator(String input) {
        if (!input.startsWith(CUSTOM_SEPARATOR_PREFIX)) {
            return DEFAULT_SEPARATOR;
        }

        Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(input);
        if (matcher.find()) {
            return Pattern.quote(matcher.group(1));
        }

        return DEFAULT_SEPARATOR;
    }

    public String extractNumberString(String input) {
        if (!input.startsWith(CUSTOM_SEPARATOR_PREFIX)) {
            return input;
        }

        Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(input);
        if (matcher.find()) {
            return matcher.group(2);
        }

        return input;
    }
}