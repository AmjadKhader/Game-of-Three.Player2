package justeattakeaway.player2.gameplay;

import justeattakeaway.enums.GameMode;
import justeattakeaway.player2.producer.GameProducer;
import justeattakeaway.scan.ScanInput;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

import static justeattakeaway.player2.utils.Constants.game;
import static justeattakeaway.player2.utils.Constants.gameMode;


@Component
public class Play {
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    private final GameProducer gameProducer;

    public Play(GameProducer gameProducer) {
        this.gameProducer = gameProducer;
    }

    public void myTurn(int receivedNumber) {
        game.playTurn(receivedNumber); // divide number over 3
        if (game.isGameOver()) {
            logger.info("[GAME-OF-THREE] Player 2 WINS!!");
        } else {
            if (gameMode.equals(GameMode.MANUAL)) {
                game.setCurrentNumber(ScanInput.getInstance().scanInt());
            }

            gameProducer.send(game.getCurrentNumber());
        }
    }
}
