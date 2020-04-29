package pokreader.ol.objects.game;

import lombok.Data;

@Data
public class Partie {
	
	private PreFlop preflop;
	private Flop flop;
	private Turn turn;
	private River river;

	public Partie() {
		super();
		this.preflop = new PreFlop();
		this.flop = new Flop();
		this.turn = new Turn();
		this.river = new River();
	}

}
