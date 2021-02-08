package io.wilson.basic.design.adapter;

/**
 * @author Wilson
 */
public class PlayerAdapter {

    private final MediaPlayer mediaPlayer;

    public PlayerAdapter(String mediaType) {
        switch (mediaType) {
            case "Mp4MediaPlayer":
                this.mediaPlayer = new Mp4MediaPlayer();
                break;
            case "VlcMediaPlayer":
                this.mediaPlayer = new VlcMediaPlayer();
                break;
            default:
                throw new IllegalArgumentException("Unknown media type");
        }
    }

    public void play(String filename, String mediaType) {
        switch (mediaType) {
            case "Mp4MediaPlayer":
                mediaPlayer.playMp4(filename);
                break;
            case "VlcMediaPlayer":
                mediaPlayer.playVlc(filename);
                break;
            default:
                throw new IllegalArgumentException("Unknown media type");
        }
    }
}
