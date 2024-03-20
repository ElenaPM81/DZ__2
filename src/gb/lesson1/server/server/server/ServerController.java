package gb.lesson1.server.server.server;

import gb.lesson1.server.server.client.ClientController;
import gb.lesson1.server.server.client.ClientGUI;
import gb.lesson1.server.server.client.ClientView;


import javax.swing.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class ServerController extends JFrame implements ClientView, Repository {

    static boolean work;
    static JTextArea log;
     static List<ClientController> clientControllerList = new ArrayList<ClientController>();
    public static final String LOG_PATH = "src/gb/lesson1/server/server/log.txt";



    public static void disconnectFromServer() {
    }

    public static boolean connectUser(ClientController clientController) {
        if (!work) {
            return false;
        } else {

            clientControllerList.add(clientController);
            clientController.showOnWindow(clientController.getName() + "Подключился к серверу");
            return true;
        }

    }

    public String getLog() {
        return readLog();
    }

    public static void disconnectUser(ClientController clientController){
        clientControllerList.remove(clientController);
        if (clientController != null){
            clientController.disconnectFromServer();
            ShowOnWindow(clientController.getName() + "Отключился от сервера");
        }
    }

    private static void ShowOnWindow(String s) {
        log.append(s + "\n");
    }

    public void message(String text){
        if (!work){
            return;
        }
        appendLog(text);
        answerAll(text);
        saveInLog(text);
    }

    private void answerAll(String text){
        for (ClientController clientController: clientControllerList){
            clientController.answer(text);
        }
    }

    public void saveInLog(String text){
        try (FileWriter writer = new FileWriter(LOG_PATH, true)){
            writer.write(text);
            writer.write("\n");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private String readLog(){
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(LOG_PATH)){
            int c;
            while ((c = reader.read()) != -1){
                stringBuilder.append((char) c);
            }
            stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
            return stringBuilder.toString();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void appendLog(String text){
        log.append(text + "\n");
    }

    @Override
    public void setServerController(ServerController serverController) {

    }


    public String getHistory() {
        return readLog();
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void disconnectedFromServer() {

    }

    @Override
    public void connectToServer(String name) {

    }
}