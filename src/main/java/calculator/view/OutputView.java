package calculator.view;

public class OutputView {
    private static final String OUTPUT_PROMPT = "결과 : %d";

    public void printResult(int result) {
        System.out.println(String.format(OUTPUT_PROMPT, result));
    }
}
