package justeattakeaway.player2.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

import static justeattakeaway.player2.utils.Constants.game;

@Component
public class GameProducer {
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    private final KafkaTemplate<String, Integer> kafkaTemplate;

    public GameProducer(KafkaTemplate<String, Integer> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(Integer message) {
        logger.info("[GAME-OF-THREE][Player 2] sends :" + game.getCurrentNumber());
        kafkaTemplate.send("game.p1", message);
    }
}
