package gb.lesson1.server.server.server;

import gb.lesson1.server.server.client.ClientController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ServerGUI extends JFrame implements Repository {

    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    List<ClientController> clientControllerList;
    JButton btnStart, btnStop;
    JTextArea log;
    boolean work;

    public ServerGUI() {
        clientControllerList = new ArrayList<>();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setLocationRelativeTo(null);

        createPanel();
        setVisible(true);


    }

    private void createPanel() {
        log = new JTextArea();
        add(log);
        add(createButtons(), BorderLayout.SOUTH);


    }

    private Component createButtons() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (work) {
                    appendLog("Сервер уже был запущен");
                } else {
                    work = true;
                    appendLog("Сервер запущен!");
                }
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!work) {
                    appendLog("Сервер уже был остановлен");
                } else {
                    work = false;
                    while (!clientControllerList.isEmpty()) {
                        ServerController.disconnectUser(clientControllerList.get(clientControllerList.size() - 1));
                    }
                    appendLog("Сервер остановлен!");
                }
            }
        });
        panel.add(btnStart);
        panel.add(btnStop);
        return panel;
    }



    @Override
    public void appendLog(String text) {

    }

    @Override
    public void setServerController(ServerController serverController) {

    }

    @Override
    public void saveInLog(String text) {

    }
}

