package design_patterns.structural;

public class AdapterPattern {

    public static void main(String[] args) {
        MediaPlayerAdapter adapter = new MediaPlayerAdapter();
        adapter.playSong(PlayerType.OLD, "Memories.mp3");
        adapter.playSong(PlayerType.NEW, "Sugar.mp3");

    }
}


class OldMediaPlayer {
    public void playSong(String songName) {
        System.out.println("OldMediaPlayer : Playing..." + songName);
    }
}

class NewMediaPlayer {
    public void playSong(String songName) {
        System.out.println("NewMediaPlayer : Playing..." + songName);
    }

}


interface IAdapter {
    void playSong(PlayerType type, String songName);
}

class MediaPlayerAdapter implements IAdapter {
    private final OldMediaPlayer oldMediaPlayer;
    private final NewMediaPlayer newMediaPlayer;

    public MediaPlayerAdapter() {
        this.oldMediaPlayer = new OldMediaPlayer();
        this.newMediaPlayer = new NewMediaPlayer();
    }

    @Override
    public void playSong(PlayerType type, String songName) {
        if (type == PlayerType.OLD) {
            oldMediaPlayer.playSong(songName);
        } else if (type == PlayerType.NEW) {
            newMediaPlayer.playSong(songName);
        }
    }
}

enum PlayerType {
    OLD,
    NEW
}

