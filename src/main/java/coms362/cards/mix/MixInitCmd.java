package coms362.cards.mix;

import java.util.Map;

import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Table;
import coms362.cards.app.ViewFacade;
import coms362.cards.fiftytwo.DealButton;
import events.remote.CreateButtonRemote;
import events.remote.CreateRemote;
import events.remote.SetBottomPlayerTextRemote;
import events.remote.SetGameTitleRemote;
import events.remote.SetupTable;
import events.remote.UpdateRemote;
import events.remote.view.xform.CameraAtOwnerVis;
import events.remote.view.xform.TableRelativePos;
import model.Card;
import model.Location;
import model.Pile;

public class MixInitCmd implements Move {

	private Map<Integer, Player> players;
	Pile markers = null;
	Pile pointers = null; 
	
	public MixInitCmd(Map<Integer, Player> players, String title ) {
		this.players = players;
		markers = new Pile("markers", new Location(50,50));
		initCards(markers, "h", new Location(50,50) );
		pointers = new Pile("pointers", new Location(50,50));
		initCards(pointers, "s", new Location(299, 150));		
	}
	
	private void initCards(Pile pile, String suit, Location loc){
		for (Player p : players.values() ){
			Card c = new Card();; 
			c.setFaceUp(true);
			c.setNumber(p.getPlayerNum());
			c.setSuit(suit);
			c = setQuadrantRelative(c,p.getPlayerNum(), loc.getX(), loc.getY() );
			pile.addCard(c);
		}
	}

	@Override
	public void apply(Table table) {
		table.addPile(markers);
		table.addPile(pointers);
	}

	private Card setQuadrantRelative(Card c, int quadrant, int x, int y){
		int ymax = 600;
		int xmax = 600; 
		switch (quadrant){
		case 2: 
			c.setX(x);
			c.setY(y);
			break;
		case 3: 
			c.setX(xmax - x);
			c.setY(y);
			break;
		case 4: 
			c.setX(xmax - x);
			c.setY(ymax - y);
			break;
		case 1: 
			c.setX(x);
			c.setY(ymax - y );
		}
		return c;
	}
	
	public void apply(ViewFacade view) {
		view.send(new SetupTable());
		view.send(new SetGameTitleRemote("Mix of Tests"));
		DealButton dealButton = new DealButton("DEAL", new Location(0, 0));
		view.register(dealButton); //so we can find it later. 
		view.send(new CreateButtonRemote(dealButton));
		for (Player p : players.values()){
			String role = (p.getPlayerNum() == 1) ? "Dealer" : "Player "+p.getPlayerNum();
			view.send(new CameraAtOwnerVis(new SetBottomPlayerTextRemote(role, p)));
		}
		for (Integer p: players.keySet()){
			view.send(new CreateRemote(markers.cards.get(p)));
			view.send(new TableRelativePos(new UpdateRemote(markers.cards.get(p))));
		}
		for (Card c : pointers.cards.values()){		
			view.send(new CreateRemote(c));
			view.send(new OrientToTableCenter(new UpdateRemote(c)));
		}
	}

}
