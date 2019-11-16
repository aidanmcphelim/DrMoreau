package upgrade.bodyparts;

import combat.Attack;
import data.framework.BodyPart;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Point;
import util.ResourceLoader;

public class NullBodyPart implements BodyPart {

    public String getName() {
        return "";
    }

    public String getType() {
        return "";
    }

    public int getHp() {
        return 0;
    }

    public Point getAttachPoint() {
        return new Point(0,0);
    }

    public Image getImage() {
        return ResourceLoader.getImage("null");
    }

    public float getWidth() {
        return 0;
    }

    public float getHeight() {
        return 0;
    }

    public Attack getAttack() { return new Attack("Null", 0,0); }

    public int getLevel() { return 0; }
}
