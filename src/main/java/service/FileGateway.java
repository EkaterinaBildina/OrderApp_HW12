package service;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;


/**
 * Метод позволяет записать переданные данные в указанный файл с именем filename.
 * 1. Создается сообщение с переданными данными.
 * 2. В заголовке этого сообщения устанавливается ключ FileHeaders.FILENAME
 *    со значением filename.
 * 3. Вызывается метод для отправки этого сообщения на обработку.
 *
 */
@MessagingGateway(defaultRequestChannel = "textInputChanel")
public class FileGateway {
    public void writeToFile(@Header(FileHeaders.FILENAME) String filename, String data) {

    }
}
