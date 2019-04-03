package upgrade.bodyparts;

import main.Attack;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;
import upgrade.bodyparts.BodyPart;
import util.ResourceLoader;

public class PartFactory {

    public static BodyPart getPart(String name) throws SlickException
    {
        Attack at1 = new Attack("Punch!", 5);
        switch(name)
        {
            case "dog_leg":
                Image dogLeg = ResourceLoader.getImage("dog_leg");
                return new BodyPart("dog_leg", "leg", at1, 5, dogLeg, new Point(dogLeg.getWidth()/2, 20));
            case "dog_arm":
                Image dogArm = ResourceLoader.getImage("dog_arm");
                return new BodyPart("dog_arm", "arm", at1, 5, dogArm, new Point(dogArm.getWidth()/2, 15));
            case "dog_head":
                Image dogHead = ResourceLoader.getImage("dog_head");
                return new BodyPart("dog_head", "head", at1, 5, dogHead, new Point(0, dogHead.getHeight() - 40));
            case "dog_tail":
                Image dogTail = ResourceLoader.getImage("dog_tail");
                return new BodyPart("dog_tail", "tail", at1, 5, dogTail, new Point (dogTail.getWidth()-15, dogTail.getHeight()/2));
            case "dog_body":
                 Image dogBody = ResourceLoader.getImage("dog_body");
                 return new BodyPart("dog_body", "body", at1, 5, dogBody, null);

            case "ostrich_head":
                Image ostrichHead = ResourceLoader.getImage("ostrich_head");
                return new BodyPart("ostrich_head", "head", at1, 5, ostrichHead, new Point(0, ostrichHead.getHeight() - 20));

            case "rat_leg":
                Image ratLeg = ResourceLoader.getImage("rat_leg");
                return new BodyPart("rat_leg", "leg", at1, 5, ratLeg, new Point(ratLeg.getWidth()/2, 20));
            case "rat_arm":
                Image ratArm = ResourceLoader.getImage("rat_arm").getScaledCopy(0.8f);
                return new BodyPart("rat_arm", "arm", at1, 5, ratArm, new Point(ratArm.getWidth()/1.66f, 20));
            case "rat_head":
                Image ratHead = ResourceLoader.getImage("rat_head");
                return new BodyPart("rat_head", "head", at1, 5, ratHead, new Point(20, ratHead.getHeight() - 40));
            case "rat_tail":
                Image ratTail = ResourceLoader.getImage("rat_tail");
                return new BodyPart("rat_tail", "tail", at1, 5, ratTail, new Point (ratTail.getWidth()-15, ratTail.getHeight()/2));
            case "rat_body":
                Image ratBody = ResourceLoader.getImage("rat_body");
                return new BodyPart("rat_body", "body", at1, 5, ratBody,null);

            default:
                throw new SlickException("Not a valid animal part.");
        }
    }
}