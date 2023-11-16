import javax.swing.*;
import java.awt.*;

public class MyGundamTest {
    public int ProjectCount;
    public String[] ProjectName;
    public String description;
    private static final int LIMIT_LEN = 20;
    Color[] colors = {new Color(246, 86, 86),
            new Color(86, 91, 180),
            new Color(54, 122, 67),
            new Color(117, 133, 42)};

    public void show(){
        JDialog dialog = new JDialog();
        dialog.setSize(50, 50);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Set the title bar to null to hide it
        dialog.setUndecorated(true);

        JLabel label = new JLabel("This is a dialog with no title.");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        dialog.add(label);
        dialog.setVisible(true);
        //dialog.dispose();

    }

    public static char getDir(Point startPoint, Point endPoint) {
        double y = -endPoint.y + startPoint.y;

        double x = endPoint.x - startPoint.x;

        double len = Math.sqrt(y * y + x * x);

        if (len < LIMIT_LEN) return 'X';

        y /= len;
        x /= len;

        double deg = Math.atan2(y, x) * 180 / Math.PI;

        if (deg >= 45 && deg < 135) return 'U';
        else if (deg < -45 && deg >= -135) return 'D';
        else if (deg >= 135 || deg < -135) return 'L';
        else if (deg >= -45 || deg < 45) return 'R';
        return 'X';
    }

    public void print(){
        for(int i=0;i<5;i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println("*");
            }
        }
    }

}
