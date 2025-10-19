package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeperatorExtraction {
    public class SeperatorExtractor {
        private static final String DEFAULT_Seperator = "[,:]";
        private static final String CUSTOM_Seperator_PREFIX = "//";
        private static final Pattern CUSTOM_Seperator_PATTERN = Pattern.compile("^//(.)\n(.*)");

        public String extractSeperator(String input) {
            if (!input.startsWith(CUSTOM_Seperator_PREFIX)) {
                return DEFAULT_Seperator;
            }

            Matcher matcher = CUSTOM_Seperator_PATTERN.matcher(input);
            if (matcher.find()) {
                return Pattern.quote(matcher.group(1));
            }

            return DEFAULT_Seperator;
        }

        public String extractNumberString(String input) {
            if (!input.startsWith(CUSTOM_Seperator_PREFIX)) {
                return input;
            }

            Matcher matcher = CUSTOM_Seperator_PATTERN.matcher(input);
            if (matcher.find()) {
                return matcher.group(2);
            }

            return input;
        }
    }
}
