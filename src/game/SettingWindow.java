package game;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class SettingWindow extends JFrame {
    static public final int WINDOW_HEIGHT = 350;
    static public final int WINDOW_WIDTH = 400;
    static public int sliderSizeValue = 3;
    static public int sliderWinValue = 3;
    static public boolean modeValue = false;
    JLabel labelMode = new JLabel("Выберите режим игры");
    JLabel emptyRow = new JLabel("\n \n");
    JRadioButton humCPUBut = new JRadioButton("Человек против ПК", false);
    JRadioButton humHumBut = new JRadioButton("Человек против Человека", true);

    ButtonGroup buttonGroup = new ButtonGroup();

    JLabel labelFieldSize = new JLabel("Выберите размеры поля");
    JLabel labelSelectedFieldSize = new JLabel(String.format("Установлен размер поля: %d", sliderSizeValue));
    JSlider sliderSize = new JSlider(3, 10, sliderSizeValue);

    JLabel labelWinLength = new JLabel("Выберите длину линии для победы");
    JLabel labelSelectedWinLength = new JLabel(String.format("Установлена длина: %d", sliderWinValue));
    JSlider sliderWin = new JSlider(3, 10, sliderWinValue);

    JButton butStart = new JButton("Начало игры");
    SettingWindow(GameWindow gameWindow){
        setTitle("Настройка игры");
        setLocation(gameWindow.getLocation().x, gameWindow.getLocation().y);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        buttonGroup.add(humCPUBut);
        buttonGroup.add(humHumBut);

        sliderSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sliderSizeValue = sliderSize.getValue();
                labelSelectedFieldSize.setText(String.format("Установлен размер поля: %d", sliderSizeValue));
            }
        });

        sliderWin.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sliderWinValue = sliderWin.getValue();
                labelSelectedWinLength.setText(String.format("Установлена длина: %d", sliderWinValue));
            }
        });
        butStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modeValue = humHumBut.isSelected();
                gameWindow.startNewGame(modeValue,sliderSizeValue,sliderSizeValue,sliderWinValue);
                setVisible(false);
            }
        });

        mainPanel.add(labelMode);
        mainPanel.add(emptyRow);
        mainPanel.add(humCPUBut);
        mainPanel.add(humHumBut);
        mainPanel.add(emptyRow);
        mainPanel.add(labelFieldSize);
        mainPanel.add(labelSelectedFieldSize);
        mainPanel.add(emptyRow);
        mainPanel.add(sliderSize);
        mainPanel.add(labelWinLength);
        mainPanel.add(labelSelectedWinLength);
        mainPanel.add(sliderWin);
        mainPanel.add(emptyRow);
        mainPanel.add(butStart);

        add(mainPanel);
    }
}
