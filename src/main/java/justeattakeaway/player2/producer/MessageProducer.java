package justeattakeaway.player2.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

import static justeattakeaway.player2.Player2Application.game;

@Component
public class MessageProducer {
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    private final KafkaTemplate<String, Integer> kafkaTemplate;

    public MessageProducer(KafkaTemplate<String, Integer> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(Integer message) {
        logger.info("[GAME-OF-THREE][Player 2] sends :" + game.getCurrentNumber());
        kafkaTemplate.send("game.p1", message);
    }
}
