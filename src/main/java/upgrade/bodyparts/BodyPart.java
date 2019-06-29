package upgrade.bodyparts;

import combat.Attack;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;
import util.ResourceLoader;

public class BodyPart implements AbstractBodyPart {

    private String name, type;
    private int hp;
    private Image image;
    private Attack attack;

    private Point attachPoint;

    public BodyPart(String name, String type, Attack attack, int hp, Point attachPoint) throws SlickException
    {
        this.name = name;
        this.type = type;
        this.attack = attack;
        this.hp = hp;
        this.image = ResourceLoader.getImage(name);
        this.attachPoint = attachPoint;
    }

    public String getName(){return name;}

    public String getType(){return type;}

    public int getHp(){return hp;}

    public Point getAttachPoint(){
        return attachPoint;
    }


    public Image getImage() {
        return image;
    }

    public float getWidth(){
        return image.getWidth();
    }

    public float getHeight(){
        return image.getHeight();
    }

    public Attack getAttack() {
        return attack;
    }
}
