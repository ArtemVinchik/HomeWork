package GrLibrary;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GrLibrary extends Frame implements WindowListener {

    public void windowOpened(WindowEvent e) {};

    public void windowClosing(WindowEvent e) {
        dispose();
        System.exit(0);
    };

    public void windowClosed(WindowEvent e) {};
    public void windowIconified(WindowEvent e) {};
    public void windowDeiconified(WindowEvent e) {};
    public void windowActivated(WindowEvent e) {};
    public void windowDeactivated(WindowEvent e) {};

    public void paint(Graphics g) {

        Dimension rc = getSize();
        Insets in = getInsets();

        int RH = rc.width;
        int RW = rc.height;

        int minX = in.left;
        int maxX = RH - in.right;
        int minY = in.top;
        int maxY = RW - in.bottom;
        int x1, y1, x2, y2;
        int cr,cq,cb;
        int d;
        int cx, cy, dx, dy;
        float wdk=3.0f;

        cx = Math.abs(maxX - minX) / 2;
        cy = Math.abs(maxY - minY) / 2;
        dx = maxX / 10;
        dy = maxY / 10;

        g.setColor(new Color(185, 15, 75));
        String txt = "Вивед квадратної матриці з випадковими числами";
        g.setFont(new Font("Times New Roman", Font.BOLD, 22));
        int nf = g.getFontMetrics().stringWidth(txt);
        g.drawString(txt, nf / 2 - 220, nf / 2 - 200);

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(wdk));


        // TO DO
        g.setColor(new Color(0, 0, 0));
        g.setFont(new Font("Trebuchet Ms", Font.BOLD, 28));

        int n = 5;
        int[][] A = new int[n][n];


        y1 = 100;
        dx = 60;
        dy = 40;
        for (int i = 0; i < n; i++) {
            x1 = 50;
            txt = "";
            for (int j = 0; j < n; j++) {
                do {
                    A[i][j] = rnd(-99, 99);
                } while (Math.abs(A[i][j]) < 10 || Math.abs(A[i][j]) > 99);
                txt += A[i][j];
                g.drawString(txt, x1, y1);
                if (A[i][j] < 0) x1 += dx;
                else x1 += (dx + 1.5);

                txt = "";
            }
            y1 += dy;
        }
        g.setColor(new Color(185, 15, 75));
        txt = "----------------------------------------";
        g.drawString(txt, nf / 2 - 220, nf / 2 +50);
        g.setFont(new Font("Times New Roman", Font.BOLD, 22));
        g.setColor(new Color(0, 0, 0));
        g.setFont(new Font("Trebuchet Ms", Font.BOLD, 28));
        y1 = 360;
        dx = 60;
        dy = 40;
        for (int i = 0; i < n; i++) {
            x1 = 50;
            txt = "";
            for (int j = 0; j < n; j++) {
                if (i==j)txt += "*";else txt += A[i][j];
                g.drawString(txt, x1, y1);
                if (A[i][j] < 0) x1 += dx;
                else x1 += (dx + 1.5);

                txt = "";
            }
            y1 += dy;
        }

    }
    private static int rnd(int min, int max) {
        return (new Random()).ints(min,max).iterator().nextInt();
    }

    public GrLibrary() {
        super("Графічні примітиви.");
        addWindowListener(this);
        setLayout(null);
        setLocation(120,100);
        setSize(800,600);
        show();
    }
}