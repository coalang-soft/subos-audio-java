package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.sound.midi.MidiUnavailableException;
import javax.swing.JFileChooser;

import cpa.subos.audio.Clip;

public class MidiTest {

	/**
	 * @param args
	 * @throws MidiUnavailableException 
	 * @throws InterruptedException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws MidiUnavailableException, InterruptedException, FileNotFoundException {
		JFileChooser c = new JFileChooser();
		c.showOpenDialog(null);
		Clip clip = new Clip(new FileInputStream(c.getSelectedFile()));
		clip.start();
	}

}
