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
                setResult(0);
                changeScreenLabel("0");
                break;

            case "=":
                if (result != 0) {
                    operand1 = String.valueOf(result);
                    System.out.println("Operand 1: " + operand1);
                }

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

        if (operator == null) {

            operand1 = operand1 + buttonID;

            changeScreenLabel(operand1);

        } else {

            operand2 = operand2 + buttonID;

            changeScreenLabel(operand2);
        }
    }

    private void doOperation() {

        double num1 = Double.parseDouble(operand1);
        double num2 = Double.parseDouble(operand2);

        switch (operator) {
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
                if(num2 == 0){
                    changeScreenLabel("err");
                    resetCalculator();
                    setResult(0);
                    return;
                }
                result = num1 / num2;
                break;

            default:
                result = 0;
        }

        changeScreenLabel(changeNumFormat(result));


        if(isAcademia(result)){
            changeScreenLabel("<Academia de Código>");
            userInterface.getScreen().setFont(Font.font(Configs.calculatorFont, Configs.calculatorFontWeight,20));
            userInterface.getScreen().setTextFill(Color.RED);
        }

    }

    private boolean isNum(String buttonID) {
        return buttonID.matches("\\d");
    }

    private boolean isAcademia(double result){

        return result==127;
    }

    private void resetCalculator() {

        setOperand1("");
        setOperand2("");
        setOperator(null);
    }

    public void changeScreenLabel(String num) {

        userInterface.getScreen().setText(num);
    }

    public String changeNumFormat(double num) {

        NumberFormat formatResult = new DecimalFormat("#.#####");
        return formatResult.format(num);
    }


    private void setOperator(String operator) {
        this.operator = operator;
    }

    public void setOperand1(String operand1) {
        this.operand1 = operand1;
    }

    public void setOperand2(String operand2) {
        this.operand2 = operand2;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
