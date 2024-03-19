package justeattakeaway.player2.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import static justeattakeaway.player2.Player2Application.game;

@Component
public class MessageProducer {

    private final KafkaTemplate<String, Integer> kafkaTemplate;

    public MessageProducer(KafkaTemplate<String, Integer> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(Integer message) {
        System.out.println("[GAME-OF-THREE][Player 2] sends :" + game.getCurrentNumber());
        kafkaTemplate.send("game.p1", message);
    }
}
