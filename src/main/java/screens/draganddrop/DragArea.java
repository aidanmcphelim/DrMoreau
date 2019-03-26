package screens.draganddrop;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

public class DragArea {

    private Rectangle rect;
    private int homex, homey;
    private Draggable part;

    public DragArea(int x, int y, int width, int height) {
        rect = new Rectangle(x, y, width, height);
        homex = x + width/2;
        homey = y + height/2;
    }


    public void render(GameContainer gc, Graphics g) {
        g.setColor(Color.white);
        g.draw(rect);
    }

    public int getHomex(){
        return homex;
    }

    public int getHomey(){
        return homey;
    }

    public Rectangle getRect() {
        return rect;
    }


    public void link(Draggable d){
        this.part = d;
        d.setHome(this);
    }

    public void setPart(Draggable p){
        this.part = p;
    }

    public Draggable getPart() {
        return part;
    }
}