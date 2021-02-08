package io.wilson.basic.design.adapter;

/**
 * VLC多媒体播放器
 *
 * @author Wilson
 */
public class VlcMediaPlayer implements MediaPlayer {
    @Override
    public void playMp4(String fileName) {
        throw new RuntimeException("VlcMediaPlayer can't play mp4 file");
    }

    @Override
    public void playVlc(String fileName) {
        System.out.println("Mp4MediaPlayer is playing the vlc file : " + fileName);
    }
}
