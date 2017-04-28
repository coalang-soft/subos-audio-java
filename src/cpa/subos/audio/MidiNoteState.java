package cpa.subos.audio;

public class MidiNoteState {

	private final MidiNoteType type;
	private final int note;
	private final int extra;

	public MidiNoteState(MidiNoteType type, int note, int extra){
		this.type = type;
		this.note = note;
		this.extra = extra;
	}

	public MidiNoteType getType() {
		return type;
	}

	public int getNote() {
		return note;
	}

	public int getExtra() {
		return extra;
	}
	
}
