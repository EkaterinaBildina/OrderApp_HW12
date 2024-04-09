package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;

import java.io.File;

@Configuration
public class IntegrationConfig {

    @Bean
    public MessageChannel textInputChanel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel fileWriterChanel() {
        return new DirectChannel();
    }

    /**
     *  метод принимает строку текста и возвращает эту строку
     *  в обратном порядке. Для этого создается новый объект StringBuilder,
     *  в который помещается исходный текст,
     *  затем текст переворачивается с помощью метода reverse()
     *  и преобразуется обратно в строку с помощью метода toString().
     *  @return Полученная перевернутая строка .
     */
    @Bean
    @Transformer(inputChannel = "textInputChanel", outputChannel = "fileWriterChanel")
    public GenericTransformer<String, String> mainTransformer() {
           return text -> {
            String reversedText = new StringBuilder(text).reverse().toString();
            return reversedText;
        };
    }

    /**
     *  метод создает и настраивает обработчик сообщений для записи в файл.
     *  Внутри метода создается новый объект FileWritingMessageHandler,
     *  который указывает путь к файлу, в который будут записываться сообщения.
     *
     * 1. ExpectReply установлен в false, что означает, что данному обработчику не требуется ожидать ответа после записи сообщения в файл.
     * 2. FileExistsMode установлен в APPEND, что означает, что при записи новые данные будут добавляться в конец существующего файла.
     * 3. AppendNewLine установлен в true, что означает, что после каждой записи будет добавлена новая строка.
     *
     *
     * @return сконфигурированный обработчик сообщения для записи в файл
     */
    @Bean
    @ServiceActivator(inputChannel = "fileWriterChanel")
    public FileWritingMessageHandler messageHandler() {
        FileWritingMessageHandler handler =
                new FileWritingMessageHandler(new File(
                        "D:/ДИПЛОМ/OrderApp_HW12/files"));
        handler.setExpectReply(false);
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setAppendNewLine(true);

        return handler;
    }
}
