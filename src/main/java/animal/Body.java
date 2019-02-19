package animal;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Rectangle;

public class Body extends Part{

    private float x, y;
    private Point headP, armRightP, armLeftP, legLeftP, legRightP, tailP;

    public Body(float x, float y, Image image)
    {
        super(PartType.BODY, image, null);
        this.x = x;
        this.y = y;
        box = new Rectangle(x,y, image.getWidth(), image.getHeight());

        headP = new Point(x+box.getWidth()*0.9f, y+(box.getHeight()*0.33f));
        armRightP = new Point(x+box.getWidth()*0.8f, y+box.getHeight()*0.4f);
        armLeftP = new Point(x+box.getWidth()*0.7f, y+box.getHeight()*0.3f);
        legRightP = new Point (x+box.getWidth()*0.3f, y+box.getHeight()*0.3f);
        legLeftP = new Point (x+box.getWidth()*0.2f, y+box.getHeight()*0.2f);
        tailP = new Point(x, y+box.getHeight()*0.4f);
    }

    public void attachHead(Part p) {
        p.attachTo(headP);
    }

    public void attachArmLeft(Part p) {
        p.attachTo(armLeftP);
    }

    public void attachArmRight(Part p) {
        p.attachTo(armRightP);
    }

    public void attachLegLeft(Part p) {
        p.attachTo(legLeftP);
    }

    public void attachLegRight(Part p) {
        p.attachTo(legRightP);
    }

    public void attachTail(Part p) {
        p.attachTo(tailP);
    }
}
