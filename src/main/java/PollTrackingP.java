import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PollTrackingP {
    //JPanel labelPanel = new JPanel();

    public static int actionVotes = 0;
    public static int horrorVotes = 0;

    public static ArrayList<String>titles = new ArrayList<>();
    public static ArrayList<Integer>votes = new ArrayList<>();

    public static void main(String[] args) {

        JFrame frame = new JFrame("What's your favorite movie genre?");
        frame.setSize(600, 500);

        JPanel mainPanel = new JPanel();

        JPanel votingPanel = new JPanel();

        JPanel labelPanel = new JPanel();

        JPanel createGraphPanel = new JPanel();

        JButton action_button = new JButton("Action");
        votingPanel.add(action_button);
        action_button.setSize(128,32);

        JButton horror_button = new JButton("Horror");
        votingPanel.add(horror_button);
        horror_button.setSize(128,32);

        JButton button_3 = new JButton("Submit another genre");
        votingPanel.add(button_3);
        votingPanel.setSize(150,150);

        votingPanel.setLocation(50,250);

        JButton button_4 = new JButton("Display graph");
        createGraphPanel.add(button_4);

        JTextField text = new JTextField();
        text.setColumns(8);
        votingPanel.add(text);

        JLabel pollOption1label = new JLabel("Votes for Horror: 0");
        labelPanel.add(pollOption1label);

        JLabel pollOption2label = new JLabel("Votes for Action: 0");
        labelPanel.add(pollOption2label);

        JLabel pollOtherlabel = new JLabel();
        labelPanel.add(pollOtherlabel);

        labelPanel.setSize(500, 500);
        labelPanel.setLocation(300,250);
        class HorrorListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                horrorVotes += 1;
                pollOption1label.setText("Votes for Horror: " + horrorVotes);
            }

        }

        class AActionListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                actionVotes += 1;
                pollOption2label.setText("Votes for Action: " + actionVotes);
            }

        }

        class OtherListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                if (titles.contains(text.getText())) {
                    votes.set(titles.indexOf(text.getText()), votes.get(titles.indexOf(text.getText())) + 1);
                }
                else {
                    titles.add(text.getText());
                    votes.add(1);
                }
                String empty = "";

                for (int n = 0; n < votes.size(); n++) {
                    if (n > 0) {
                        empty += ", ";
                    }
                    empty += ("Votes for " + titles.get(n) + ": " + votes.get(n));

                }
                pollOtherlabel.setText(empty);
                labelPanel.updateUI();
                text.setText("");

            }


        }

        class GraphActionListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> newTitles = new ArrayList<>();
                newTitles.addAll(titles);
                newTitles.add("Action");
                newTitles.add("Horror");
                ArrayList<Integer> newVotes = new ArrayList<>();
                newVotes.addAll(votes);
                newVotes.add(actionVotes);
                newVotes.add(horrorVotes);
                System.out.println(newTitles);
                System.out.println(newVotes);
                StackedChartDisplay.display("Favorite movie genre data", newTitles, newVotes);
                button_3.setEnabled(false);
            }
        }

        ActionListener action_button_1 = new HorrorListener();
        ActionListener action_button_2 = new AActionListener();
        ActionListener action_button_3 = new OtherListener();
        ActionListener display_graph = new GraphActionListener();

        horror_button.addActionListener(action_button_1);
        action_button.addActionListener(action_button_2);
        button_3.addActionListener(action_button_3);
        button_4.addActionListener(display_graph);

        mainPanel.add(labelPanel);
        mainPanel.add(votingPanel);
        frame.add(mainPanel);
        mainPanel.add(createGraphPanel);
        frame.setVisible(true);


    }
}

