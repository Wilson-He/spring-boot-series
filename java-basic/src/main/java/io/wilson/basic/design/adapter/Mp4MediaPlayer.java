package io.wilson.basic.design.adapter;

/**
 * @author Wilson
 */
public class Mp4MediaPlayer implements MediaPlayer{
    @Override
    public void playMp4(String fileName) {
        System.out.println("Mp4MediaPlayer is playing the mp4 file : " + fileName);
    }

    @Override
    public void playVlc(String fileName) {
        throw new RuntimeException("Mp4MediaPlayer can't play vlc file");
    }
}
