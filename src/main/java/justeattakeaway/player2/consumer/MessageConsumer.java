package justeattakeaway.player2.consumer;

import justeattakeaway.player2.producer.MessageProducer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static justeattakeaway.player2.Player2Application.game;

@Component
public class MessageConsumer {

    private final MessageProducer producer;

    public MessageConsumer(MessageProducer producer) {
        this.producer = producer;
    }

    @KafkaListener(topics = "game.p2", groupId = "player2")
    public void listen(ConsumerRecord<String, Integer> consumerRecord) {
        int receivedNumber = consumerRecord.value();
        System.out.println("----------------------");
        System.out.println("[GAME-OF-THREE][Player 2] receives :" + receivedNumber);

        game.playTurn(receivedNumber);
        if (game.isGameOver()) {
            System.out.println("[GAME-OF-THREE] Player 2 WINS!!");
        } else {
            producer.send(game.getCurrentNumber());
        }
    }

}
