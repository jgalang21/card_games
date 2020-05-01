package coms362.cards.WAR;

import java.util.Map;
import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Table;
import coms362.cards.app.ViewFacade;
import coms362.cards.fiftytwo.DealButton;
import events.remote.CreateButtonRemote;
import events.remote.CreatePile;
import events.remote.SetBottomPlayerTextRemote;
import events.remote.SetGameTitleRemote;
import events.remote.SetupTable;
import model.Card;
import model.Location;
import model.Pile;

public class WarInitCmd implements Move {
	
	
	private Map<Integer, Player> players;
	private String title;
	
	
	//player 1's pile
	private Pile p1 = new Pile("p1", new Location(300, 510));
	private Pile p1Show = new Pile("p1Show", new Location(300, 400));
	
	//player 2's pile
	private Pile p2 = new Pile("p2", new Location(300, 100));
	private Pile p2Show = new Pile("p2Show", new Location(300, 200));
	
	
	public WarInitCmd(Map<Integer, Player> players, String title) {
		this.players = players;
		this.title = title;
	}

	@Override
	public void apply(Table table) {

		
		try {
			for (String suit : Card.suits) {
                for (int i = 1; i <= 13; i++) {
                    Card card = new Card();
                    card.setSuit(suit);
                    card.setNumber(i);
                    card.setFaceUp(false);
                    card.setRotate(0);	
                  
                
                    //fill the first player's pile first
                    if(p1.cards.size() != 26) {
                    	 card.setX(p1.getLocation().getX());
                    	 card.setY(p1.getLocation().getY());
                    	 p1.cards.put(card.getId(), card);
                    }
                    else { //put the rest in the other player's pile
                    	
                    	 card.setX(p2.getLocation().getX());
                    	 card.setY(p2.getLocation().getY());
                    	 p2.cards.put(card.getId(), card);
                    }
                    
                    
                   
                }
            }
			
            table.addPile(p1);
            table.addPile(p2);
            table.addPile(p1Show);
            table.addPile(p2Show);
            p1Show.setFaceUp(true);
            p2Show.setFaceUp(true);
            //not shuffled yet
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		

	}

	@Override
	public void apply(ViewFacade view) {
		view.send(new SetupTable());
		view.send(new SetGameTitleRemote(title));

		for (Player p : players.values()){
			String text = "Player " +  p.getPlayerNum();
			view.send(new SetBottomPlayerTextRemote(text, p));
		}
		
		view.send(new CreatePile(p1));
		view.send(new CreatePile(p2));
		view.send(new CreatePile(p1Show));
		view.send(new CreatePile(p2Show));
		String id = ""; 
		DealButton dealButton = new DealButton("DEAL", new Location(0, 0));
		view.register(dealButton); //so we can find it later. 
		view.send(new CreateButtonRemote(dealButton));
		
	}

}
