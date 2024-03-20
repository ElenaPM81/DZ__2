package gb.lesson1.server.server;

import gb.lesson1.server.server.server.ServerController;
import gb.lesson1.server.server.server.ServerGUI;
import gb.lesson1.server.server.client.ClientGUI;
import gb.lesson1.server.server.client.ClientController;



public class Main {
    private static ClientController clientController;

    public static void main(String[] args) {

        //создание объектов сервера и создание связи между ними
        ServerGUI serverGUI = new ServerGUI();
        ServerController serverController = new ServerController();
        serverController(serverGUI);
        serverGUI.setServerController(serverController);

        //создание объектов клиента1 и создание связи между ними
        ClientGUI clientGUI1 = new ClientGUI(clientController);
        ClientController clientController1 = new ClientController();
        clientController1.setClientView(clientGUI1);
        clientGUI1.setClient(clientController1);
        clientController1.setServer(serverController);

        //создание объектов клиента2 и создание связи между ними
        ClientGUI clientGUI2 = new ClientGUI(clientController);
        ClientController clientController2 = new ClientController();
        clientController2.setClientView(clientGUI2);
        clientGUI2.setClient(clientController2);
        clientController2.setServer(serverController);
    }

    private static void serverController(ServerGUI serverGUI) {
    }
}
