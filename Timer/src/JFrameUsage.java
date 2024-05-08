// Import necessary classes from javax.swing and java.awt packages
import javax.swing.*;
import java.awt.*;

// Class declaration for JFrameUsage extending JFrame
public class JFrameUsage extends JFrame {
    // Static JLabel to display the time string
    static JLabel label = new JLabel(Main.timeString);

    // Method to set up the JFrame
    public static void setFrame() {
        // Create a new JFrame object
        JFrame frame = new JFrame();
        // Set preferred size of the frame
        frame.setPreferredSize(new Dimension(450, 150));
        // Disable frame resizing
        frame.setResizable(false);

        // Get the content pane of the frame
        Container container = frame.getContentPane();
        // Set the layout of the container to FlowLayout
        container.setLayout(new FlowLayout());

        // Set properties for the JLabel
        label.setPreferredSize(new Dimension(180, 100)); // Set preferred size
        label.setForeground(Color.WHITE); // Set foreground color to white
        label.setFont(new Font(label.getFont().getName(), Font.BOLD, 40)); // Set font and style

        // Add the label to the container
        container.add(label);

        // Set background color of the content pane to blue
        frame.getContentPane().setBackground(Color.BLUE);
        // Set default close operation to exit on close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Pack the components in the frame
        frame.pack();
        // Set the frame to be visible
        frame.setVisible(true);
    }
}