package coms362.cards.WAR;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Table;
import model.Card;
import model.Pile;
import model.PlayerFactory;
import model.Quorum;
import model.TableBase;


/**
 * This class never gets used unfortunately, although after 
 * completing what we have, this could've been very useful.
 * 
 * Everything here can be ignored for the most part. 
 * 
 * 
 * @author Jeremy and Madison
 *
 */
public class WarTable extends TableBase implements Table{
	
	public WarTable(PlayerFactory pFactory) {
		super(pFactory);
		
	}

	private Map<String,Pile> piles = new HashMap<String,Pile>();



	public void setPlayerHand(Player p, Pile pile) {
		Pile x = piles.get(p.getSocketId());
		
	}
	
	public Pile getPlayerHand(Player p) {
		
		return piles.get(p.getSocketId());
	}
	
	
	public boolean hasFirstShow() {
		if(piles.get("p1Show").cards.size() > 0) {
			return true;
		}
		
		return false;
	}
	
	public void updateShow1(Card c, Player p) {
		
	}
	
	public boolean hasSecondShow() {
		if(piles.get("p2Show").cards.size() > 0) {
			return true;
		}
		
		return false;
	}
	
	public void updateShow2(Card c, Player p) {
		Pile x = piles.get(p.getSocketId());
		
	}
	
	public void setRoundWinner(Player p) {
		
	
	}
	
	public void awardPot() {
		
	}
	
	
	

}
