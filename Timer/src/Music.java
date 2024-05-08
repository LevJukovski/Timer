

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Music {
    public static void playMusic() {
        Path currentFilePath = Paths.get("");
        String filepath = currentFilePath.toAbsolutePath().toString() + "/src/ring.wav";

        AudioInputStream audioStream = null;
        try {
            File file = new File(filepath);
            audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();

            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.err.println(ex);
        }
        finally {
            try {
                if(audioStream != null) {
                    audioStream.close();
                }
            }
            catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }
}