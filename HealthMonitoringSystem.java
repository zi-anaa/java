import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HealthMonitoringSystem extends JFrame {
    private JTextField heartRateField;
    private JTextField caloriesBurnedField;
    private JTextField sleepQualityField;
    private JTextField stepsWalkedField;
    private JTextArea feedbackArea;

    public HealthMonitoringSystem() {
        setTitle("Health Monitoring System");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 10, 10));

        add(new JLabel("Heart Rate (bpm):"));
        heartRateField = new JTextField();
        add(heartRateField);

        add(new JLabel("Calories Burned:"));
        caloriesBurnedField = new JTextField();
        add(caloriesBurnedField);

        add(new JLabel("Sleep Quality (1-10):"));
        sleepQualityField = new JTextField();
        add(sleepQualityField);

        add(new JLabel("Steps Walked:"));
        stepsWalkedField = new JTextField();
        add(stepsWalkedField);

        feedbackArea = new JTextArea(5, 30);
        feedbackArea.setEditable(false);
        add(new JLabel("Feedback:"));
        add(feedbackArea);

        JButton submitButton = new JButton("Submit");
        add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                provideFeedback();
            }
        });
    }

    private void provideFeedback() {
        try {
            int heartRate = Integer.parseInt(heartRateField.getText());
            int caloriesBurned = Integer.parseInt(caloriesBurnedField.getText());
            int sleepQuality = Integer.parseInt(sleepQualityField.getText());
            int stepsWalked = Integer.parseInt(stepsWalkedField.getText());

            StringBuilder feedback = new StringBuilder("Today's Feedback:\n");

            if (heartRate < 60) {
                feedback.append("Your heart rate is low. Consider consulting a healthcare professional.\n");
            } else if (heartRate > 100) {
                feedback.append("Your heart rate is high. Try to relax and monitor your heart rate regularly.\n");
            } else {
                feedback.append("Your heart rate is within a normal range.\n");
            }

            if (caloriesBurned < 200) {
                feedback.append("You burned fewer calories today. Consider increasing physical activity.\n");
            } else {
                feedback.append("Great job on burning calories!\n");
            }

            if (sleepQuality < 5) {
                feedback.append("Your sleep quality seems low. Try to get better rest tonight.\n");
            } else {
                feedback.append("You had a good sleep quality.\n");
            }

            if (stepsWalked < 5000) {
                feedback.append("Consider walking more to improve your health.\n");
            } else {
                feedback.append("Good job on reaching your step goal!\n");
            }

            feedbackArea.setText(feedback.toString());

        } catch (NumberFormatException e) {
            feedbackArea.setText("Please enter valid numbers for all fields.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HealthMonitoringSystem().setVisible(true);
            }
        });
    }
}
