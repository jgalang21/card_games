package coms362.cards.fiftytwoSP;

import java.util.Map;

import coms362.cards.abstractcomp.Player;
import coms362.cards.app.ViewFacade;
import coms362.cards.fiftytwo.DealButton;
import coms362.cards.fiftytwo.PickupInitCmd;
import events.remote.CreateButtonRemote;
import events.remote.CreatePile;
import events.remote.SetBottomPlayerTextRemote;
import events.remote.SetGameTitleRemote;
import events.remote.SetupTable;
import model.Location;
import model.Pile;

public class PickupInitCmdSP extends PickupInitCmd{

	Map<Integer, Player> players;
	String title = "52 Card Pickup Singleplayer";
	
	public PickupInitCmdSP(Map<Integer, Player> players) {
		super(players);
		this.players = players;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void apply(ViewFacade view) {
		view.send(new SetupTable());
		view.send(new SetGameTitleRemote("52 Card Pickup SinglePlayer"));

		for (Player p : players.values()){
			String role = (p.getPlayerNum() == 1) ? "Dealer" : "Player "+p.getPlayerNum();
			view.send(new SetBottomPlayerTextRemote(role, p));
		}

		view.send(new CreatePile(new Pile("discardPile", new Location(500,359))));
		String id = ""; 
		DealButton dealButton = new DealButton("DEAL", new Location(0, 0));
		view.register(dealButton); //so we can find it later. 
		view.send(new CreateButtonRemote(dealButton));
		//view.send(new CreateButtonRemote(Integer.toString(getNextId()), "reset", "RestartGame", "Reset", new Location(500,0)));
		//view.send(new CreateButtonRemote(Integer.toString(getNextId()), "clear", "ClearTable", "Clear Table", new Location(500,0)));
	}
	

}
