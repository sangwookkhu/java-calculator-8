package calculator.controller;

import calculator.model.Calculator;
import calculator.model.StringParser;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;
    private final StringParser stringParser;
    private final Calculator calculator;

    public CalculatorController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.stringParser = new StringParser();
        this.calculator = new Calculator();
    }

    public void run() {
        try {
            String input = inputView.readInput();
            int[] numbers = stringParser.parse(input);
            int result = calculator.sum(numbers);
            outputView.printResult(result);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}