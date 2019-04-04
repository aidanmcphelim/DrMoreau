package upgrade.bodyparts;

import main.Attack;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;
import upgrade.bodyparts.AbstractBodyPart;

public class BodyPart implements AbstractBodyPart {

    private String name, type;
    private int hp;
    private Image image;
    private Attack attack;

    private Point attachPoint;

    public BodyPart(String name, String type, Attack attack, int hp, Image image, Point attachPoint) throws SlickException
    {
        this.name = name;
        this.type = type;
        this.attack = attack;
        this.hp = hp;
        this.image = image;
        this.attachPoint = attachPoint;
        if(attachPoint != null) {
            image.getGraphics().setColor(Color.black);
            image.getGraphics().drawOval(attachPoint.getX(), attachPoint.getY(), 10, 10);
            image.getGraphics().flush();
        }
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
}
