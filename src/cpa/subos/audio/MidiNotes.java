package cpa.subos.audio;

public class MidiNotes implements IMidiNotes{

	public static int sharp(int note){
		return note + 1;
	}
	public static int bsign(int note){
		return note - 1;
	}

}
