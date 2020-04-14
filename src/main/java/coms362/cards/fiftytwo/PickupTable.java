package coms362.cards.fiftytwo;

import coms362.cards.abstractcomp.Player;
import model.Card;
import model.PlayerFactory;
import model.TableBase;

public class PickupTable extends TableBase {
    private Card delayedCard;
    private Player delayedPlayer;
    
    public PickupTable(PlayerFactory pFactory) {
        super(pFactory);
    }
    
    public Card getDelayedCard() {
        return delayedCard;
    }
    public void setDelayedCard(Card delayedCard) {
        this.delayedCard = delayedCard;
    }
    public Player getDelayedPlayer() {
        return delayedPlayer;
    }
    public void setDelayedPlayer(Player delayedPlayer) {
        this.delayedPlayer = delayedPlayer;
    }
}
