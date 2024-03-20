package gb.lesson1.server.server.client;

/**
 * Интерфейс описывающий абстракцию GUI
 */
public interface ClientView {
    /**
     * Метод для отображения сообщения в GUI
     * @param message текст сообщения
     */
    void showMessage(String message);

    /**
     * Метод отключения от сервера со стороны сервера
     */
    void disconnectedFromServer();

    void connectToServer(String name);
}