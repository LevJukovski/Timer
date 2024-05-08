import javax.swing.*;
import java.awt.*;

public class JFrameUsage extends JFrame {
    static JLabel label = new JLabel(Main.timeString);

    public static void setFrame() {
        JFrame frame = new JFrame();
        frame.setPreferredSize(new Dimension(450, 150));
        frame.setResizable(false);

        Container container = frame.getContentPane();
        container.setLayout(new FlowLayout());

        label.setPreferredSize(new Dimension(180, 100));
        label.setForeground(Color.WHITE);
        label.setFont(new Font(label.getFont().getName(), Font.BOLD, 40));

        container.add(label);

        frame.getContentPane().setBackground(Color.BLUE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
