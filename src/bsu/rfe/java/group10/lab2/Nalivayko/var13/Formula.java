package bsu.rfe.java.group10.lab2.Nalivayko.var13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Formula extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 320;
    private int formulaId = 1;
    private int memId=1;
    private double memSum=0;

    Formula() {
setSize(400, 400);
        JTextField textFieldX = createTextField("0");
        JLabel labelforX= new JLabel("X:");
        JTextField textFieldY = createTextField("0");
        JLabel labelforY= new JLabel("Y:");
        JTextField textFieldZ = createTextField("0");
        JLabel labelforZ= new JLabel("Z:");
        Box textFieldBox = Box.createHorizontalBox();
        textFieldBox.add(Box.createHorizontalGlue());
        textFieldBox.add(labelforX);
        textFieldBox.add(Box.createHorizontalGlue());
        textFieldBox.add(textFieldX);
        textFieldBox.add(Box.createHorizontalGlue());
        textFieldBox.add(labelforY);
        textFieldBox.add(Box.createHorizontalGlue());
        textFieldBox.add(textFieldY);
        textFieldBox.add(Box.createHorizontalGlue());
        textFieldBox.add(labelforZ);
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

        JTextField result=createTextField("0");
        Box boxResult=Box.createHorizontalBox();
        boxResult.add(Box.createHorizontalGlue());
        boxResult.add(result);
        boxResult.add(Box.createHorizontalGlue());

        JButton buttonClean = new JButton("Очистить поле");
        buttonClean.addActionListener(actionEvent->{
            textFieldX.setText(String.valueOf("0"));
            textFieldY.setText(String.valueOf("0"));
            textFieldZ.setText(String.valueOf("0"));
            result.setText(String.valueOf("0"));
        });

        JButton buttonCalc = new JButton("Вычислить");
        buttonCalc.addActionListener(actionEvent->{
          try { double x = Double.parseDouble(textFieldX.getText());
                double y = Double.parseDouble(textFieldY.getText());
                double z = Double.parseDouble(textFieldZ.getText());
                if(formulaId==1){
                    result.setText(String.valueOf(calculate1(x,y,z)));
                }
                else{
                    result.setText(String.valueOf(calculate2(x,y,z)));}
          } catch(NumberFormatException ololo){
                JOptionPane.showMessageDialog(Formula.this, "Ошибка в " +
                            "формате записи числа с плавающей точкой", "Ошибочный формат числа",
                    JOptionPane.WARNING_MESSAGE);

                }
        });

        JRadioButton mem1=new JRadioButton("mem1");
        mem1.setSelected(true);
        mem1.addActionListener((actionEvent->{
            memSum = Double.parseDouble(result.getText());
            memId=1;
        }));
        JRadioButton mem2=new JRadioButton("mem2");
        mem2.addActionListener(actionEvent->{
            memSum = Double.parseDouble(result.getText());
            memId=2;
        });
        JRadioButton mem3=new JRadioButton("mem3");
        mem3.addActionListener(actionEvent->{
            memSum = Double.parseDouble(result.getText());
            memId=3;
        });
        ButtonGroup memGroup=new ButtonGroup();
        memGroup.add(mem1);
        memGroup.add(mem2);
        memGroup.add(mem3);
        Box memBox=Box.createHorizontalBox();
        memBox.add(Box.createHorizontalGlue());
        memBox.add(mem1);
        memBox.add(Box.createHorizontalGlue());
        memBox.add(mem2);
        memBox.add(Box.createHorizontalGlue());
        memBox.add(mem3);
        memBox.add(Box.createHorizontalGlue());

        JButton buttonM=new JButton("M+");
        buttonM.addActionListener(actionEvent->{
            double counterM= Double.parseDouble(result.getText());
            if(memId==1){
                counterM+=memSum;
                result.setText(String.valueOf(Double.valueOf(counterM)));
            }
            if(memId==2){
                counterM+=memSum;
                result.setText(String.valueOf(counterM));
            }
            if(memId==3){
                counterM+=memSum;
                result.setText(String.valueOf(counterM));
            }

        });

        JButton buttonMC=new JButton("MC");
        buttonM.addActionListener(actionEvent->{
            memSum=0;
        });

        Box bBBbox=Box.createHorizontalBox();
        bBBbox.add(Box.createHorizontalGlue());
        bBBbox.add(buttonCalc);
        bBBbox.add(Box.createHorizontalGlue());
        bBBbox.add(buttonMC);
        bBBbox.add(Box.createHorizontalGlue());
        bBBbox.add(buttonM);
        bBBbox.add(Box.createHorizontalGlue());
        bBBbox.add(buttonClean);
        bBBbox.add(Box.createHorizontalGlue());




        Box hboxFormulaType = Box.createHorizontalBox();
        hboxFormulaType.add(Box.createHorizontalGlue());
        hboxFormulaType.add(func1);
        hboxFormulaType.add(Box.createHorizontalStrut(50));
        hboxFormulaType.add(func2);
        hboxFormulaType.add(Box.createHorizontalGlue());


        Box ololo=Box.createVerticalBox();
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

    // Формула №1 для рассчѐта
    public Double calculate1(Double x, Double y,Double z) {
        return x + y + z;
    }

    // Формула №2 для рассчѐта
    public Double calculate2(Double x, Double y, Double z) {
        return x - y -z;
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
