package bsu.rfe.java.group10.lab2.Nalivayko.var13;

import javax.swing.*;
import java.awt.*;

public class Formula extends JFrame {
    // Размеры окна приложения в виде констант
    private static final int WIDTH = 400;
    private static final int HEIGHT = 320;
    // Текстовые поля для считывания значений переменных X и Y,
// как компоненты, совместно используемые в различных методах
    private JTextField textFieldX;
    private JTextField textFieldY;
    // как компонент, совместно используемый в различных методах
    private JTextField textFieldResult;
    // Группа радио-кнопок для обеспечения уникальности выделения в группе
    private ButtonGroup radioButtons = new ButtonGroup();
    // Контейнер для отображения радио-кнопок
    private Box hboxFormulaType = Box.createHorizontalBox();
    // Идентификатор выбранной формулы
    private int formulaId = 1;
    Formula(){
        textFieldX = new JTextField("ololo");
        textFieldX.setMaximumSize(new Dimension(100*textFieldX.getPreferredSize().width, textFieldX.getPreferredSize().height));
        textFieldY = new JTextField("kek");
        Box textFieldBox = Box.createHorizontalBox();
        textFieldBox.add(Box.createHorizontalGlue());
        textFieldBox.add(textFieldX);
        textFieldBox.add(Box.createHorizontalStrut(20));
        textFieldBox.add(textFieldY);
        textFieldBox.add(Box.createHorizontalGlue());
        this.getContentPane().add(textFieldBox);
    }
    // Формула №1 для рассчѐта
    public Double calculate1(Double x, Double y) {
        return x*x + y*y;
    }
    // Формула №2 для рассчѐта
    public Double calculate2(Double x, Double y) {
        return x*x*x + 1/y;
    }

}
