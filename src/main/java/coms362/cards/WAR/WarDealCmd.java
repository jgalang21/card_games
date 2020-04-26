package coms362.cards.WAR;

import java.util.HashMap;
import java.util.Map;

import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Table;
import coms362.cards.app.ViewFacade;
import coms362.cards.fiftytwo.DealButton;
import coms362.cards.fiftytwo.HideButtonRemote;
import events.remote.CreateRemote;
import events.remote.UpdateRemote;
import model.Card;
import model.Pile;

public class WarDealCmd implements Move {

	private Table table;
	private Player player;

	public WarDealCmd(Table table, Player player) {
		this.table = table;
		this.player = player;
	}

	@Override
	public void apply(Table table) {
			
	
		
	}

	@Override
	public void apply(ViewFacade views) {
		try {
			String remoteId = views.getRemoteId(DealButton.kSelector);
			views.send(new HideButtonRemote(remoteId));
			Pile p1 = table.getPile("p1");
			Pile p2 = table.getPile("p2");

			if (p1 == null || p2 == null) {
				return;
			}
			for (Card c : p1.cards.values()) {
            	String outVal="";
            	
            	views.send(new CreateRemote(c));
            	views.send(new UpdateRemote(c));
                System.out.println(outVal);	            
	        }
			
			for (Card c2 : p2.cards.values()) {
            	String outVal2="";
            	
            	views.send(new CreateRemote(c2));
            	views.send(new UpdateRemote(c2));
                System.out.println(outVal2);	            
	        }
			
//	            
//			for (Card c : local.cards.values()) {
//	            	String outVal="";
//	            	views.send(new CreateRemote(c));
//	            	views.send(new UpdateRemote(c));
//	                System.out.println(outVal);	            
//		        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
