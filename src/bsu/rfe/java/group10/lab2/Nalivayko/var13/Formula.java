package bsu.rfe.java.group10.lab2.Nalivayko.var13;

import javax.swing.*;
import java.awt.*;

import static java.lang.Math.exp;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.Math.cos;
import static java.lang.Math.log;

public class Formula extends JFrame {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 420;
    private int formulaId = 1;
    private int memId = 1;
    private double memSum1 = 0;
    private double memSum2 = 0;
    private double memSum3 = 0;


    Formula() {
        setSize(WIDTH, HEIGHT);
        JTextField textFieldX = createTextField();
        JLabel labelforX = new JLabel("X:");
        JTextField textFieldY = createTextField();
        JLabel labelforY = new JLabel("Y:");
        JTextField textFieldZ = createTextField();
        JLabel labelforZ = new JLabel("Z:");
        Box textFieldBox = Box.createHorizontalBox();
        textFieldBox.add(Box.createHorizontalGlue());
        textFieldBox.add(labelforX);
        textFieldBox.add(Box.createHorizontalStrut(10));
        textFieldBox.add(textFieldX);
        textFieldBox.add(Box.createHorizontalStrut(30));
        textFieldBox.add(labelforY);
        textFieldBox.add(Box.createHorizontalStrut(10));;
        textFieldBox.add(textFieldY);
        textFieldBox.add(Box.createHorizontalStrut(30));
        textFieldBox.add(labelforZ);
        textFieldBox.add(Box.createHorizontalStrut(10));
        textFieldBox.add(textFieldZ);
        textFieldBox.add(Box.createHorizontalGlue());
        JRadioButton func1 = new JRadioButton("Formula 1");
        func1.setSelected(true);
        JRadioButton func2 = new JRadioButton("Formula 2");
        ButtonGroup radioButtons = new ButtonGroup();
        radioButtons.add(func1);
        func1.addActionListener(actionEvent -> formulaId = 1);
        radioButtons.add(func2);
        func2.addActionListener(actionEvent -> formulaId = 2);

        JTextField result = createTextField();
        Box boxResult = Box.createHorizontalBox();
        boxResult.add(Box.createHorizontalGlue());
        boxResult.add(result);
        boxResult.add(Box.createHorizontalGlue());

        JButton buttonClean = new JButton("Очистить поле");
        buttonClean.addActionListener(actionEvent -> {
            textFieldX.setText("0");
            textFieldY.setText("0");
            textFieldZ.setText("0");
            result.setText("0");
        });

        JButton buttonCalc = new JButton("Вычислить");
        buttonCalc.addActionListener(actionEvent -> {
            try {
                double x = Double.parseDouble(textFieldX.getText());
                double y = Double.parseDouble(textFieldY.getText());
                double z = Double.parseDouble(textFieldZ.getText());
                if (formulaId == 1) {
                    result.setText(String.valueOf(calculate1(x, y, z)));
                } else {
                    result.setText(String.valueOf(calculate2(x, y, z)));
                }
            } catch (NumberFormatException ololo) {
                JOptionPane.showMessageDialog(Formula.this, "Ошибка в " +
                                "формате записи числа с плавающей точкой", "Ошибочный формат числа",
                        JOptionPane.WARNING_MESSAGE);

            }
        });

        JRadioButton mem1 = new JRadioButton("mem1");
        mem1.setSelected(true);
        memId = 1;
        mem1.addActionListener((actionEvent -> memId = 1));
        JRadioButton mem2 = new JRadioButton("mem2");
        mem2.addActionListener(actionEvent -> memId = 2);
        JRadioButton mem3 = new JRadioButton("mem3");
        mem3.addActionListener(actionEvent -> memId = 3);
        ButtonGroup memGroup = new ButtonGroup();
        memGroup.add(mem1);
        memGroup.add(mem2);
        memGroup.add(mem3);
        Box memBox = Box.createHorizontalBox();
        memBox.add(Box.createHorizontalGlue());
        memBox.add(mem1);
        memBox.add(Box.createHorizontalStrut(40));
        memBox.add(mem2);
        memBox.add(Box.createHorizontalStrut(40));
        memBox.add(mem3);
        memBox.add(Box.createHorizontalGlue());

        JButton buttonM = new JButton("M+");
        buttonM.addActionListener(actionEvent -> {
            double counterM = Double.parseDouble(result.getText());
            if (memId == 1) {
                memSum1 += counterM;
                System.out.println(memSum1);
                result.setText(String.valueOf(Double.valueOf(memSum1)));
            }
            if (memId == 2) {
                memSum2 += counterM;
                result.setText(String.valueOf(memSum2));
            }
            if (memId == 3) {
                memSum3 += counterM;
                result.setText(String.valueOf(memSum3));
            }
        });

        JButton buttonMC = new JButton("MC");
        buttonMC.addActionListener(actionEvent -> {
            if (memId == 1) {
                memSum1 = 0;
            }
            if (memId == 2) {
                memSum2 = 0;
            }
            if (memId == 3) {
                memSum3 = 0;
            }
            result.setText("0");
        });

        Box bBBbox = Box.createHorizontalBox();
        bBBbox.add(Box.createHorizontalGlue());
        bBBbox.add(buttonCalc);
        bBBbox.add(Box.createHorizontalStrut(30));  //!!
        bBBbox.add(buttonMC);
        bBBbox.add(Box.createHorizontalStrut(30));
        bBBbox.add(buttonM);
        bBBbox.add(Box.createHorizontalStrut(30));
        bBBbox.add(buttonClean);
        bBBbox.add(Box.createHorizontalGlue());


        Box hboxFormulaType = Box.createHorizontalBox();
        hboxFormulaType.add(Box.createHorizontalGlue());
        hboxFormulaType.add(func1);
        hboxFormulaType.add(Box.createHorizontalStrut(50));
        hboxFormulaType.add(func2);
        hboxFormulaType.add(Box.createHorizontalGlue());


        Box ololo = Box.createVerticalBox();
        ololo.add(Box.createVerticalGlue());
        ololo.add(textFieldBox);
        ololo.add(Box.createHorizontalStrut(50));
        ololo.add(hboxFormulaType);
        ololo.add(Box.createHorizontalStrut(50));
        ololo.add(memBox);
        ololo.add(Box.createHorizontalStrut(50));
        ololo.add(bBBbox);
        ololo.add(Box.createHorizontalStrut(50));
        ololo.add(boxResult);
        ololo.add(Box.createVerticalGlue());
        this.getContentPane().add(ololo);
    }

    public Double calculate1(Double x, Double y, Double z) {
        double first = cos(exp(x)) + log(1 + y) * log(1 + y);
        double second = pow(exp(cos(x)) + sin(Math.PI * z) * sin(Math.PI * z), 0.5);
        double third = pow(1 / x, 0.5) + cos(y * y);
        return pow(first + second + third, sin(z));
    }

    public Double calculate2(Double x, Double y, Double z) {
        return (pow((1 + x * x), 1 / y)) / exp(sin(z) + x);
    }

    private JTextField createTextField() {
        JTextField field = new JTextField("0");
        Dimension dimension = new Dimension(10 * field.getPreferredSize().width, field.getPreferredSize().height);
        field.setMaximumSize(dimension);
        field.setMinimumSize(dimension);
        field.setPreferredSize(dimension);
        return field;
    }

}
