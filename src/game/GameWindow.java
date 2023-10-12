package game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    static public final int WINDOW_HEIGHT = 650;
    static public final int WINDOW_WIDTH = 750;
    static public final int WINDOW_POSX = 300;
    static public final int WINDOW_POSY = 200;
    static public final String WINDOW_NAME = "Крестики-нолики";

    Map map;
    SettingWindow settings;
    GameWindow() {
        //настройка окна
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(WINDOW_POSX, WINDOW_POSY, WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        setTitle(WINDOW_NAME);

        //элементы
        settings = new SettingWindow(this);
        map = new Map(settings.sliderSizeValue, settings.sliderSizeValue);


        //нижняя часть
        JButton btnStart = new JButton("Новая игра");
        JButton btnExit = new JButton("Выход");
        JPanel panBottom = new JPanel(new GridLayout(1,2));



        //действия кнопок
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });

        //окно
        panBottom.add(btnStart);
        panBottom.add(btnExit);
        add(panBottom, BorderLayout.PAGE_END);
        add(map);
        map.setVisible(false);
        setVisible(true);
    }

    //новая игра
    void startNewGame(boolean mode, int size_x, int size_y, int win_len) {
        map.setVisible(true);
        map.startNewGame(mode, size_x, size_y, win_len);
    }
}
