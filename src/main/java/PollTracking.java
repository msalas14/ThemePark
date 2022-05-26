import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PollTracking {
    public static int votes = 0;
    public static ArrayList<String> otherOptions = new ArrayList<>();
    public static ArrayList<Integer> otherOpVotes = new ArrayList<>();
    public static int elementCt = 0;
    public static void main(String[] args) {
        JFrame frame = new JFrame("title");
        frame.setSize(600, 500);

        JPanel votingPanel = new JPanel();
        JPanel labelPanel = new JPanel();
        JPanel mainPanel = new JPanel();

        JButton button1 = new JButton("yes");
        votingPanel.add(button1);

        JButton button2 = new JButton("no");
        votingPanel.add(button2);

        JTextField text = new JTextField();
        text.setColumns(10);
        votingPanel.add(text);
        JButton submit = new JButton("enter");
        votingPanel.add(submit);



        votingPanel.setSize(100,300);
        button1.setSize(100,100);

        JLabel label = new JLabel("votes: 0");
        labelPanel.add(label);

        JLabel otherLabel = new JLabel();
        labelPanel.add(otherLabel);

        labelPanel.setSize(100,100);

        class actionmovlistener implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                votes+=1;
                label.setText("votes: " + votes);
            }
        }
        ActionListener actionmovlistener = new actionmovlistener();
        button1.addActionListener(actionmovlistener);

        class submitListener implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                if(otherOptions.contains(text.getText()))
                {
                    otherOpVotes.set(otherOptions.indexOf(text.getText()), otherOpVotes.get(otherOptions.indexOf(text.getText()))+1);
                }
                else
                {
                    otherOptions.add(text.getText());
                    otherOpVotes.add(1);
                }
                String opsAndVotesStr = "";
                for(int i = 0; i<otherOptions.size(); i++)
                {
                    if(i>0)
                    {
                        opsAndVotesStr+=", ";
                    }
                    opsAndVotesStr+= (otherOptions.get(i) + " votes: " + otherOpVotes.get(i) + "\n");
                }
                otherLabel.setText(opsAndVotesStr);
                votingPanel.updateUI();
                text.setText(null);//clear text field
            }
        }
        ActionListener submitListener= new submitListener();
        submit.addActionListener(submitListener);

        mainPanel.add(labelPanel);
        mainPanel.add(votingPanel);
        frame.add(mainPanel);

        frame.setVisible(true);
    }
}

