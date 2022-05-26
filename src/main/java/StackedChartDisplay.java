import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class StackedChartDisplay {
    public static void display(String title, ArrayList<String> string_info, ArrayList<Integer> num_info) {

        JFrame frame = new JFrame(title);
        frame.setSize(700, 600);

        StackedChart chart = new StackedChart(string_info, num_info);
        frame.add(chart);


        frame.setVisible(true);
    }

    public static class StackedChart extends JComponent {
        ArrayList<String> string_info;
        ArrayList<Integer> num_info;

        StackedChart(ArrayList<String> string_info, ArrayList<Integer> num_info) {
            this.string_info = string_info;
            this.num_info = num_info;
        }

        public void paintComponent(Graphics g) {
            int point_x = 100;
            int point_y = 75;
            int width = 300;
            int max_height = 0;

            for (int n = 0; n < num_info.size(); n++) {
                max_height += num_info.get(n);
            }
            ArrayList<Color>colors = new ArrayList<>();
            colors.add(Color.blue);
            colors.add(Color.black);
            colors.add(Color.yellow);
            colors.add(Color.green);
            colors.add(Color.pink);
            colors.add(Color.orange);

            for (int a = 0; a < num_info.size(); a++) {
                g.setColor(colors.get(a));
                double percentage = (double)(num_info.get(a)) / (double) max_height;
                System.out.println(point_y +", height: " + (int)(300*percentage));
                g.fillRect(point_x, point_y, width, (int)(300*percentage));
                point_y += (int)(300*percentage);

            }
            g.setColor(Color.BLACK);
            g.drawRect(75, 75, 400, 300);
            g.drawString("0%", 30, 375);
            g.drawString("25%", 30, 300);
            g.drawString("50%", 30, 225);
            g.drawString("75%", 30, 150);
            g.drawString("100%", 30, 75);

            int y_value = 500;

            for (int b = 0; b < string_info.size(); b++) {
                g.setColor(colors.get(b));
                g.fillRect(550, y_value, 30, 20);
                y_value -= 20;
                g.drawString(string_info.get(b), 600, y_value);
            }

        }
    }
}
