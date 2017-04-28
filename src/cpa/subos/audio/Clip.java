package cpa.subos.audio;

import java.io.InputStream;

import static sun.audio.AudioPlayer.player;

public class Clip {

	private InputStream source;

	public Clip(InputStream source){
		this.source = source;
	}
	
	public void start(){
		player.start(source);
	}
	
	public void stop(){
		player.stop(source);
	}
	
}
