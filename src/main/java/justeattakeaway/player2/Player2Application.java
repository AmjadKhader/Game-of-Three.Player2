package justeattakeaway.player2;

import justeattakeaway.enums.GameMode;
import justeattakeaway.player2.configuration.KafkaConsumerConfiguration;
import justeattakeaway.player2.configuration.KafkaProducerConfiguration;
import justeattakeaway.player2.utils.Constants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.Objects;

@SpringBootApplication
@EnableConfigurationProperties({KafkaConsumerConfiguration.class, KafkaProducerConfiguration.class})
public class Player2Application {

    public static void main(String[] args) {
        String mode = System.getenv("mode");
        if (Objects.nonNull(mode) &&
                (mode.equalsIgnoreCase("manual")
                        || mode.equalsIgnoreCase("automatic"))) {
            SpringApplication.run(Player2Application.class, args);

            if (mode.equalsIgnoreCase("manual")) {
                Constants.gameMode = (GameMode.MANUAL);
            } else {
                Constants.gameMode = (GameMode.AUTOMATIC);
            }
        }
    }
}

