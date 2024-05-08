// Import necessary classes from javax.sound.sampled and java.io packages
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

// Class declaration for Music
public class Music {
    // Method to play music
    public static void playMusic() {
        // Get the current file path
        Path currentFilePath = Paths.get("");
        // Construct the file path for the audio file
        String filepath = currentFilePath.toAbsolutePath().toString() + "/src/ring.wav";

        // Declare an AudioInputStream variable
        AudioInputStream audioStream = null;
        try {
            // Create a File object with the specified file path
            File file = new File(filepath);
            // Get the audio input stream from the file
            audioStream = AudioSystem.getAudioInputStream(file);
            // Get a Clip instance
            Clip clip = AudioSystem.getClip();

            // Open the clip with the audio stream
            clip.open(audioStream);
            // Set the clip to loop continuously
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        // Catch any exceptions that may occur during audio processing
        catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            // Print the exception to standard error
            System.err.println(ex);
        }
        // Finally block to ensure resources are properly closed
        finally {
            try {
                // If the audio stream is not null, close it
                if(audioStream != null) {
                    audioStream.close();
                }
            }
            // Catch any IO exceptions that may occur during stream closing
            catch (IOException ex) {
                // Print the exception to standard error
                System.err.println(ex);
            }
        }
    }
}