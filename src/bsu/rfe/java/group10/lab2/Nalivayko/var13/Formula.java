package bsu.rfe.java.group10.lab2.Nalivayko.var13;

import javax.swing.*;
import java.awt.*;

public class Formula extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 320;
    private int formulaId = 1;

    Formula() {
setSize(400, 400);
        JTextField textFieldX = createTextField("0");
        JTextField textFieldY = createTextField("0");
        JTextField textFieldZ = createTextField("0");
        Box textFieldBox = Box.createHorizontalBox();
        textFieldBox.add(Box.createHorizontalGlue());
        textFieldBox.add(textFieldX);
        textFieldBox.add(Box.createHorizontalGlue());
        textFieldBox.add(textFieldY);
        textFieldBox.add(Box.createHorizontalGlue());
        textFieldBox.add(textFieldZ);
        textFieldBox.add(Box.createHorizontalGlue());
        JRadioButton func1=new JRadioButton("Formula 1");
        func1.setSelected(true);
        JRadioButton func2=new JRadioButton("Formula 2");
        ButtonGroup radioButtons = new ButtonGroup();
        radioButtons.add(func1);
        func1.addActionListener(actionEvent->{
            formulaId=1;
        });
        radioButtons.add(func2);
        func2.addActionListener(actionEvent->{
            formulaId=2;
        });

        JButton buttonCalc = new JButton("Вычислить");

        Box hboxFormulaType = Box.createHorizontalBox();
        hboxFormulaType.add(Box.createHorizontalGlue());
        hboxFormulaType.add(func1);
        hboxFormulaType.add(Box.createHorizontalGlue());
        hboxFormulaType.add(func2);
        hboxFormulaType.add(Box.createHorizontalGlue());


        Box ololo=Box.createVerticalBox();
        ololo.add(textFieldBox);
        ololo.add(hboxFormulaType);
        this.getContentPane().add(ololo);
    }

    // Формула №1 для рассчѐта
    public Double calculate1(Double x, Double y) {
        return x * x + y * y;
    }

    // Формула №2 для рассчѐта
    public Double calculate2(Double x, Double y) {
        return x * x * x + 1 / y;
    }

    private JTextField createTextField(String name){
        JTextField field = new JTextField(name);
        Dimension dimension = new Dimension(10*field.getPreferredSize().width, field.getPreferredSize().height);
        field.setMaximumSize(dimension);
        field.setMinimumSize(dimension);
        field.setPreferredSize(dimension);
        return field;
    }

}
