/**
 * 
 */
package coms362.cards.fiftytwo;

import java.io.IOException;

import coms362.cards.abstractcomp.View;
import coms362.cards.streams.Marshalls;
import coms362.cards.streams.RemoteTableGateway;

/**
 * @author Robert Ward
 *
 */
public class P52PlayerView implements View {

	private RemoteTableGateway remote;
	private Integer pos;
	private String socketId;
	
	public P52PlayerView(Integer num, String socketId, RemoteTableGateway remote) {
		this.remote = remote;
		this.socketId = socketId;
		this.pos = num;
	}
	

	@Override
	public void send(Marshalls event) throws IOException {
		remote.sendString(event.marshall(this), socketId);	
	}

	@Override
	public int getCameraPosition() {
		return pos;
	}

}
