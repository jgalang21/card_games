package coms362.cards.streams;

import coms362.cards.abstractcomp.View;

public interface Marshalls {

	public String marshall(View view);

	/**
	 * @return A characteristic message, typically to support test instrumentation. 
	 */
	public String stringify();
}
