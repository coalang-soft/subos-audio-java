package cpa.subos.audio;

public interface IMidiSequence {

	void noteOn(int note, int loud);
	void noteOff(int note);
	void pause(int ticks);
	void allOff();

}
