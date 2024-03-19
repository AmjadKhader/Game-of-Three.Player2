package justeattakeaway.player2;

import justeattakeaway.Game;
import justeattakeaway.player2.configuration.KafkaConsumerConfiguration;
import justeattakeaway.player2.configuration.KafkaProducerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({KafkaConsumerConfiguration.class, KafkaProducerConfiguration.class})
public class Player2Application {

    public static Game game = new Game();

    public static void main(String[] args) {
        SpringApplication.run(Player2Application.class, args);
    }
}
