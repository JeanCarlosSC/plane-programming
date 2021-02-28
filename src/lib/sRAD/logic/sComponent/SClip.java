package lib.sRAD.logic.sComponent;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SClip {

    private Clip audioClip;
    private AudioInputStream audioStream;
    private Boolean stop = false;
    private Thread thread1, thread2;

    //clip method
    public SClip(String path) {
        //create an AudioInputStream from a given sound file
        File audioFile = new File(path);
        try {
            audioStream = AudioSystem.getAudioInputStream(audioFile);
        }
        catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }

        //acquire audio format and create a DataLine.Info object
        AudioFormat format = audioStream.getFormat();
        var info = new DataLine.Info(Clip.class, format);

        //obtain the Clip
        try {
            audioClip = AudioSystem.getClip();
            audioClip.open(audioStream);
        }
        catch (LineUnavailableException | IOException e) {
            e.printStackTrace();
        }

        //initialize threads
        thread1 = new Thread( () -> {
            stop = false;
            audioClip.setFramePosition(0);
            audioClip.start();
            while(audioClip.isActive()) {
                if(stop) {
                    audioClip.stop();
                }
            }
        }){};
        thread2 = new Thread( () -> {
            stop = false;
            audioClip.setFramePosition(0);
            audioClip.loop(Clip.LOOP_CONTINUOUSLY);
            while(audioClip.isActive()) {
                if(stop) {
                    audioClip.stop();
                }
            }
        }){};
    }

    public void play() {
        thread1.start();
    }

    public void loop() {
        thread2.start();
    }

    public void stop() {
        stop = true;
    }

}
