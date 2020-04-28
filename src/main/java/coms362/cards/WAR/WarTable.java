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

public class WarTable extends TableBase implements Table{
	private Map<String,Pile> piles = new HashMap<String,Pile>();
	// following is indexed by player position (playernum)
	private Map<Integer, Player> players = new HashMap<Integer, Player>();
	private Random rng = new Random();
	private boolean matchOver = false;
	private Quorum quorum = null; 
	private Integer currentPlayer = -1;
	private PlayerFactory playerFactory;
	// following is indexed by socketId
	private Map<String, Player> playerIndex = new HashMap<String,Player>();

	public WarTable(PlayerFactory pFactory) {
		super(pFactory);
	
		this.playerFactory = pFactory;
	}
	
	public void setPlayerHand(Player p, Pile pile) {
		Pile x = piles.get(p.getSocketId());
		
	}
	
	public Pile getPlayerHand(Player p) {
		
		return piles.get(p.getSocketId());
	}
	
	
	public boolean hasFirstShow() {
		
		if(!piles.get("p1Show").equals(null)) {
			return false;
		}
		
		return true;
	}
	
	public void updateShow1(Card c, Player p) {
		
	}
	
	public boolean hasSecondShow() {
		if(!piles.get("p2Show").equals(null)) {
			return false;
		}
		
		return true;
	}
	
	public void updateShow2(Card c, Player p) {
		
	}
	
	public void setRoundWinnder(Player p) {
		
	
	}
	
	public void awardPot() {
		
	}
	
	
	

}
