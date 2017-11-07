package org.academiadecodigo;

/**
 * Created by codecadet on 07/11/2017.
 */
public class Brain {

    private Calculator calculator;

    private int operand1 = 0;
    private int operand2 = 0;

    private String operator;

    private double result;

    public Brain(Calculator calculator) {
        this.calculator = calculator;
    }

    public void handleButton(String buttonID) {

        if (isNum(buttonID)) {

            handleNum(buttonID);
        } else {

            handleOperator(buttonID);
        }
    }

    private void handleOperator(String buttonID) {

        switch (buttonID) {

            case "DEL":
                resetCalculator();
                break;

            case "=":
                doOperation();
                System.out.println(result);
                resetCalculator();
                break;

            default:
                setOperator(buttonID);

        }
                System.out.println(operator);
    }

    private void handleNum(String buttonID) {

        int buttonNumber = Integer.parseInt(buttonID);

        if (operator == null) {

            operand1 = operand1 + buttonNumber;

            System.out.println("Operand 1: " + operand1);
        } else {

            operand2 = operand2 + buttonNumber;
            System.out.println("Operand 2: " + operand2);
        }
    }

    private boolean isNum(String buttonID) {
        return buttonID.matches("\\d");
    }

    private void setOperator(String operator) {
        this.operator = operator;
    }

    public void setOperand1(int operand1) {
        this.operand1 = operand1;
    }

    public void setOperand2(int operand2) {
        this.operand2 = operand2;
    }

    private void resetCalculator() {

        setOperand1(0);
        setOperand2(0);
        setOperator(null);
    }

    private void doOperation() {

        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                result = operand1 / operand2;
                break;

            default:
                result = 0;
        }
        calculator.getScreen().setText(String.valueOf(result));
    }
}
