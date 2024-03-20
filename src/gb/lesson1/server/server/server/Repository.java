package gb.lesson1.server.server.server;


public  interface Repository {

    void appendLog(String text);

    void setServerController(ServerController serverController);
    void saveInLog(String text);

}