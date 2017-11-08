package org.academiadecodigo;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by codecadet on 07/11/2017.
 */
public class Brain {

    private UserInterface userInterface;

    private String operand1 = "";
    private String operand2 = "";
    private String operator;

    private double result;


    public Brain(UserInterface userInterface) {
        this.userInterface = userInterface;
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

            case "AC":
                resetCalculator();
                clearMemory();
                changeScreenLabel("0");
                break;

            case "=":
                if (hasMemory()) {
                    operand1 = String.valueOf(result);
                }

                doOperation();
                resetCalculator();
                break;

            default:
                if (operator != null) {
                    doOperation();
                    resetCalculator();
                    operand1 = String.valueOf(result);
                    setOperator(buttonID);
                    return;
                }
                setOperator(buttonID);
        }

    }

    private void handleNum(String buttonID) {

        if (operator == null) {

            operand1 = operand1 + buttonID;

            changeScreenLabel(operand1);

        } else {

            operand2 = operand2 + buttonID;

            changeScreenLabel(operand2);
        }
    }

    private void doOperation() {
        if (hasOperands()) {

            operand1 = "0";
            operand2 = "0";
        }

        if (divideBy0()) {

            changeScreenLabel("err");
            resetCalculator();
            clearMemory();
            return;

        }

        double num1 = Double.parseDouble(operand1);
        double num2 = Double.parseDouble(operand2);

        switch (operator)

        {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;

            default:
                result = 0;
        }

        changeScreenLabel(changeNumFormat(result));


        if ( isAcademia(result)) {
            changeScreenLabel("<Academia de Código>");
            userInterface.getScreen().setFont(Font.font(Configs.CALCULATOR_FONT, Configs.CALCULATOR_FONT_WEIGHT, 20));
            userInterface.getScreen().setTextFill(Color.RED);
        }

    }

    private boolean isNum(String buttonID) {

        return buttonID.matches("\\d");
    }

    private boolean hasOperands() {

        return operand1.equals("") || operand2.equals("");
    }

    private boolean hasMemory() {
        return result != 0;
    }

    private boolean isAcademia(double result) {

        return result == 127;
    }

    private void resetCalculator() {

        setOperand1("");
        setOperand2("");
        setOperator(null);
    }

    private void clearMemory() {
        setResult(0);
    }

    private boolean divideBy0() {
        return operand2.equals("0");
    }

    private void changeScreenLabel(String num) {

        userInterface.getScreen().setText(num);
    }

    private String changeNumFormat(double num) {

        NumberFormat formatResult = new DecimalFormat("#.#####");
        return formatResult.format(num);
    }


    private void setOperator(String operator) {
        this.operator = operator;
    }

    private void setOperand1(String operand1) {
        this.operand1 = operand1;
    }

    private void setOperand2(String operand2) {
        this.operand2 = operand2;
    }

    private void setResult(double result) {
        this.result = result;
    }
}
