package src;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

@SuppressWarnings("serial")
public class square extends JComponent {

    private Board b;
    private final int color;
    private Piece occupyingPiece;
    private boolean dispiece;

    private int xNum;
    private int YNum;

    square(Board b, int c, int xNum, int yNum) {

        this.b = b;
        this.color = c;
        this.dispiece = true;
        this.xNum = xNum;
        this.YNum = yNum;

        this.setBorder(BorderFactory.createEmptyBorder());

    }

    public int getColor() {
        return this.color;
    }

    public Piece getoccupingPiece() {
        return this.occupyingPiece;
    }

    public boolean isOccupied() {
        return (this.occupyingPiece != null);
    }

    public int getxNum() {
        return xNum;
    }

    public int getYNum() {
        return YNum;
    }

    public void setDisplay(boolean v) {
        this.dispiece = v;
    }

    public void put(Piece p) {
        this.occupyingPiece = p;
        p.setPosition(this);
    }

    public Piece removePiece() {
        Piece p = this.occupyingPiece;
        this.occupyingPiece = null;
        return p;
    }

    public void capture(Piece p) {
        Piece k = getoccupingPiece();
        if (k.getColor() == 0) {
            b.Bpieces.remove(k);

        }
        if (k.getColor() == 1) {
            b.wpieces.remove(k);
        }
        this.occupyingPiece = p;

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (this.color == 1) {
            g.setColor(new Color(221, 192, 127));
        } else {
            g.setColor(new Color(101, 67, 33));
        }
        g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        if (occupyingPiece != null && dispiece) {
            occupyingPiece.draw(g);
        }
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int reseult = 1;

        reseult = prime * reseult + xNum;
        reseult = prime * reseult + YNum;
        return reseult;
    }

}
