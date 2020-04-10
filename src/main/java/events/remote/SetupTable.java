package events.remote;

import coms362.cards.streams.Marshalls;
import events.remote.view.xform.DisplayAttrs;
import events.remote.view.xform.RemoteEvent;

public class SetupTable extends RemoteEventBase
implements RemoteEvent, Marshalls {

	private String id = "#card-table";
	private String url = "js/3rdparty/einaregilsson-cards-js/img/cards.png";
	
	public SetupTable(){
		
	}
	
	public SetupTable(String id, String cardsUrl){
		this.id = id;
		this.url = cardsUrl;		
	}
		
	@Override
	public String marshall(DisplayAttrs attrs) {
    	return String.format(
    		"cards.init({table:'%s', cardsUrl:'%s'})",
    		id, url
    	);
	}

	@Override
	public String stringify() {
		return "SetupTable";
	}

}
