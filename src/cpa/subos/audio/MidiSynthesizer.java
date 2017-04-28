package cpa.subos.audio;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;

public class MidiSynthesizer {
	
	private javax.sound.midi.Synthesizer synth;
	private MidiChannel[] channels;
	
	public MidiSynthesizer() throws MidiUnavailableException{
		synth = MidiSystem.getSynthesizer();
		synth.open();
		
		this.channels = synth.getChannels();
	}
	
	public MidiChannel get(int index){
		return channels[index];
	}
	
	public MidiChannel[] channels(){
		return channels;
	}

}
