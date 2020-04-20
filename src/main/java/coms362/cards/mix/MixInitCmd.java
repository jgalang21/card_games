package coms362.cards.mix;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Table;
import coms362.cards.app.ViewFacade;
import coms362.cards.coordinates.DevicePoint;
import coms362.cards.coordinates.TablePoint;
import coms362.cards.fiftytwo.DealButton;
import events.remote.CreateButtonRemote;
import events.remote.CreateRemote;
import events.remote.SetBottomPlayerTextRemote;
import events.remote.SetGameTitleRemote;
import events.remote.SetupTable;
import events.remote.UpdateRemote;
import events.remote.view.xform.CameraAtOwnerVis;
import events.remote.view.xform.OrientToPlayer;
import events.remote.view.xform.OrientToTableCenter;
import events.remote.view.xform.PlayerPrivate;
import events.remote.view.xform.TableRelativePos;
import model.Card;
import model.Location;
import model.Pile;

public class MixInitCmd implements Move {
	
	

	private Map<Integer, Player> players;
	private List<Player> orderedP = new ArrayList<Player>(); 
	Pile markers = null;
	Pile pointers = null; 
	Pile[] hands = new Pile[4];
	private TablePoint handPattern[] = new TablePoint[3];
	
	public MixInitCmd(Map<Integer, Player> players, String title ) {
		// TODO: register piles with table. 
		this.players = players;
		orderedP = new ArrayList<Player>(players.values());
		orderedP.sort(new OnPlayerNum<Player>());
		handPattern[0] = new TablePoint(-25, -275);
		handPattern[1] = new TablePoint( 0, -260);
		handPattern[2] = new TablePoint(25, -275);
		
		Location markerPos = new Location(100,50);
		markers = new Pile("markers", markerPos );
		initCards(markers, "h", markerPos);
		Location pointerPos = new Location(300,150); 
		pointers = new Pile("pointers", pointerPos);
		initCards(pointers, "s", pointerPos);
		for (int p = 1 ; p <= 4; p++ ){ //p = player hand/suit
			hands[p-1] = initHand (p);
		}
		
	}
	
	
	private Pile initHand(int p) {
		Pile hand = new Pile("hand"+p, new Location(0,0));
 
		for ( int i = 0; i < 3; i++ ){
			Card c = new Card();
			c.setNumber(11+i);
			c.setSuit(Card.suits[p-1]);
//			c.setRotate( rot );
//			rot += 15;
			TablePoint tPos = handPattern[i].copyToPos(p);
			System.err.format("initHand.tp: pos=%d, i=%d, (%d,%d)%n",p, i, tPos.x, tPos.y );
			DevicePoint dPos = new DevicePoint(tPos);
			System.err.format("initHand.dp: pos=%d, i=%d, (%d,%d)%n",p, i, dPos.x, dPos.y );
			
			c.setPosition(dPos);
			System.err.format("intHand.c: pos=%d id=%d, %s%d, (%d,%d)%n", p,
					c.getId(), c.getSuit(), c.getNumber(), c.getX(), c.getY());
			hand.addCard(c);
		}
		return hand;
	}

	private void initCards(Pile pile, String suit, Location loc){
		List<Player> sortedP = new ArrayList<Player>(players.values());
		sortedP.sort(new OnPlayerNum<Player>());
		for (Player p : sortedP ){
			Card c = new Card();; 
			c.setFaceUp(true);
			c.setNumber(p.getPlayerNum());
			c.setSuit(suit);
			c = setQuadrantRelative(c, p.getPlayerNum(), loc  );
			pile.addCard(c);
		}
	}
	

	@Override
	public void apply(Table table) {
		table.addPile(markers);
		table.addPile(pointers);
	}

	private Card setQuadrantRelative(Card c, int quadrant, Location loc){
		// inbound coordinates are relative to upper left corner
		// (positive down and right), but are reflected to 
		// first quadrant (positive up and right ) and then rotated relative to the center
		// to the dealer position. 
		// inbound 'quadrant' is relative to dealer position, each greater 
		// than one is a rotation of -90 == 270 (or 3*90). 
		
		int offset = Table.kWidth/2;
		System.out.format("SQR.inbound: q=%d x=%d, y=%d%n", quadrant, loc.getX(), loc.getY());
		Location rval = new Location(offset - loc.getX(), offset - loc.getY());
		System.out.format("SQR.normalized: q=%d x=%d, y=%d%n", quadrant, rval.getX(), rval.getY());
		
		int rotations =  quadrant + 2 ; // takes 2 rotations to get from 1st to player 1. 
		System.out.println("SQR.rotations = "+rotations);
		for (int i = 1; i < rotations; i++){
			rval = rval.rotate90();
		}
		System.out.format("SQR.rotated: q=%d x=%d, y=%d%n", quadrant, rval.getX(), rval.getY());
		rval = new Location( rval.getX() + offset, -rval.getY() + offset);
		System.out.format("SQR.dnormalized: q=%d x=%d, y=%d%n", quadrant, rval.getX(), rval.getY());
		c.setPosition(rval);
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
		System.out.println("markers = " + markers.cards.toString());
		System.out.println("pointers = " + pointers.cards.toString());
		for (Player p: orderedP) {
			Integer index = (Integer) p.getPlayerNum();
			view.send(new CreateRemote(markers.cards.get(index)));
			view.send(new OrientToTableCenter(new TableRelativePos(new UpdateRemote(markers.cards.get(index)))));
		}	
		for (Card c: pointers.cards.values()){
			System.out.println("MixInitCmd pointers "+c.toString());
			Player p = players.get((Integer) c.getNumber());
			view.send(new CreateRemote(c));
			view.send(new TableRelativePos( new UpdateRemote(c)));
		}
		for (Player p: orderedP ){
			int currentPos = p.getPlayerNum();
			Pile hand = hands[currentPos-1];
			System.out.println(hand.cards.values().toString());
			List<Card> hCards = new ArrayList<Card>(hand.cards.values());
			hCards.sort(new ByRank<Card>());

			for (Card c : hCards) {
				System.out.println("HandCards= "+hCards.toString());
				view.send(new CreateRemote(c));
				view.send( new PlayerPrivate(p, new TableRelativePos(new UpdateRemote(c))));
			}
		}
				
	}
}
