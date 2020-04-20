package coms362.cards.fiftytwo.moves;

import java.util.Map;
import java.util.Random;

import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Table;
import coms362.cards.app.ViewFacade;
import coms362.cards.fiftytwo.DealButton;
import events.inbound.DealEvent;
import events.remote.CreateButtonRemote;
import events.remote.CreatePile;
import events.remote.SetBottomPlayerTextRemote;
import events.remote.SetGameTitleRemote;
import events.remote.SetupTable;
import events.remote.view.xform.CameraAtOwnerVis;
import model.Button;
import model.Card;
import model.Location;
import model.Pile;

public class PickupInitCmd implements Move {
	private int nextId;
	private Map<Integer, Player> players ;
	private String title = "52 Card Pickup";

	public PickupInitCmd( Map<Integer, Player> players, String title) {
	    this(players);
	    this.title = title;
	}
	
	public PickupInitCmd( Map<Integer, Player> players) {
		this.players = players;
	}

	public void apply(Table table){
		Pile discard = new Pile("discardPile", new Location(500,359));
		Random random = table.getRandom();
        try {
            for (String suit : Card.suits) {
                for (int i = 1; i <= 13; i++) {
                    Card card = new Card();
                    card.setSuit(suit);
                    card.setNumber(i);
                    card.setX(random.nextInt(200) + 100);
                    card.setY(random.nextInt(200) + 100);
                    card.setRotate(random.nextInt(360));
                    card.setFaceUp(random.nextBoolean());
                    discard.cards.put(card.getId(), card);
                }
            }
            table.addPile( discard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public void apply(ViewFacade view) {
		view.send(new SetupTable());
		view.send(new SetGameTitleRemote(title));
		
		for (Player p : players.values()){
			String role = (p.getPlayerNum() == 1) ? "Dealer" : "Player "+p.getPlayerNum();
			view.send(new CameraAtOwnerVis(new SetBottomPlayerTextRemote(role, p)));
		}
		view.send(new CreatePile(new Pile("discardPile", new Location(500,359))));
		String id = ""; 
		DealButton dealButton = new DealButton("DEAL", new Location(0, 0));
		view.register(dealButton); //so we can find it later. 
		view.send(new CreateButtonRemote(dealButton));
		//view.send(new CreateButtonRemote(Integer.toString(getNextId()), "reset", "RestartGame", "Reset", new Location(500,0)));
		//view.send(new CreateButtonRemote(Integer.toString(getNextId()), "clear", "ClearTable", "Clear Table", new Location(500,0)));
	}
	
	private int getNextId() {
	    return nextId++;
	}
}