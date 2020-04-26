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
		
	}
	
	public Pile getPlayerHand(Player p) {
		
		return null;
	}
	
	
	public boolean hasFirstShow() {
		
		
		return false;
	}
	
	public void updateShow1(Card c, Player p) {
		
	}
	
	public boolean hasSecondShow() {
		return false;
	}
	
	public void updateShow2(Card c, Player p) {
		
	}
	
	public void setRoundWinnder(Player p) {
		
		
	}
	
	public void awardPot() {
		
	}
	
	

}
