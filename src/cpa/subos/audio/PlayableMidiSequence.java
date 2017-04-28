package cpa.subos.audio;

import java.util.ArrayList;

import javax.sound.midi.MidiChannel;

public class PlayableMidiSequence implements IMidiSequence {
	
	{
		noteStates = new ArrayList<>();
	}
	
	private ArrayList<MidiNoteState> noteStates;
	
	public void noteOn(int note, int loud) {
		noteStates.add(new MidiNoteState(MidiNoteType.ON, note, loud));
	}

	public void noteOff(int note) {
		noteStates.add(new MidiNoteState(MidiNoteType.OFF, note, 0));
	}

	public void pause(int ticks) {
		noteStates.add(new MidiNoteState(MidiNoteType.PAUSE, 0, ticks));
	}
	
	public void program(int prog){
		noteStates.add(new MidiNoteState(MidiNoteType.CHANGE, 0, prog));
	}
	
	public void allOff() {
		noteStates.add(null);
	}
	
	public void play(MidiChannel c, long tickMillis) throws InterruptedException{
		for(int i = 0; i < noteStates.size(); i++){
			MidiNoteState s = noteStates.get(i);
			if(s == null){
				c.allNotesOff();
				continue;
			}
			switch(s.getType()){
			case CHANGE:
				c.programChange(s.getExtra());
				break;
			case OFF:
				c.noteOff(s.getNote());
				break;
			case ON:
				c.noteOn(s.getNote(), s.getExtra());
				break;
			case PAUSE:
				Thread.sleep(tickMillis * s.getExtra());
				break;
			default:
				throw new RuntimeException("Unexpected state " + s.getType());
			}
		}
	}

}
