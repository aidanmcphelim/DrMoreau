package data.mob;

import combat.stats.Stat;
import combat.stats.Stats;
import data.bodyparts.BodyPart;
import data.bodyparts.PartFactory;
import data.framework.IBodyPart;
import data.framework.PartType;
import org.newdawn.slick.SlickException;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MobCreator {

    public static Mob getMob(String name, int level) throws SlickException
    {
        switch(name) {
            case "dog":
                return makeDog(level);
            case "rat":
                return makeRat(level);
            case "Dr.Moreau":
                Map<PartType, IBodyPart> parts = new HashMap<>();
                Stats stats = new Stats();
                stats.put(Stat.MAX_HP, 100f);
                stats.put(Stat.CURRENT_HP, stats.get(Stat.MAX_HP));
                stats.put(Stat.ATTACK_DMG, 20f);
                IBodyPart body = new BodyPart("Dr.Moreau", stats, new HashMap<>());
                parts.put(PartType.BODY, body);
                return new Mob("Dr.Moreau", parts);
        }
        return null;
    }

    private static Mob makeDog(int level) throws SlickException
    {
        Map<PartType, IBodyPart> parts = new TreeMap<>();
        parts.put(PartType.HEAD, PartFactory.getPart("dog_head", level));
        parts.put(PartType.LEFT_ARM, PartFactory.getPart("dog_arm", level));
        parts.put(PartType.RIGHT_ARM, PartFactory.getPart("dog_arm", level));
        parts.put(PartType.LEFT_LEG, PartFactory.getPart("dog_leg", level));
        parts.put(PartType.RIGHT_LEG, PartFactory.getPart("dog_leg", level));
        parts.put(PartType.TAIL, PartFactory.getPart("dog_tail", level));
        parts.put(PartType.BODY, PartFactory.getPart("dog_body", level));


        return new Mob("Dog", parts);
    }

    private static Mob makeRat(int level) throws SlickException
    {
        Map<PartType, IBodyPart> parts = new TreeMap<>();
        parts.put(PartType.HEAD, PartFactory.getPart("rat_head", level));
        parts.put(PartType.RIGHT_ARM, PartFactory.getPart("rat_arm", level));
        parts.put(PartType.LEFT_ARM, PartFactory.getPart("rat_arm", level));
        parts.put(PartType.RIGHT_LEG, PartFactory.getPart("rat_leg", level));
        parts.put(PartType.LEFT_LEG, PartFactory.getPart("rat_leg", level));
        parts.put(PartType.TAIL, PartFactory.getPart("rat_tail", level));
        parts.put(PartType.BODY, PartFactory.getPart("rat_body", level));

        return new Mob("Rat", parts);
    }

//    private static Mob makeBunny(int level) throws SlickException
//    {
//        BodyPart body = PartFactory.getPart("bunny_body", level);
//
//        SuperImage image = CreatureComposer.composeImage(((BodyBodyPart) body).getConnectors(),
//                PartFactory.getPart("bunny_head", level),
//                PartFactory.getPart("bunny_arm", level),
//                PartFactory.getPart("bunny_arm", level),
//                PartFactory.getPart("bunny_leg", level),
//                PartFactory.getPart("bunny_leg", level),
//                PartFactory.getPart("bunny_tail", level),
//                PartFactory.getPart("bunny_body", level));
//        image.flipH(true);
//
//        ArrayList<BodyPart> parts = new ArrayList<>();
//        parts.add(PartFactory.getPart("bunny_head", level));
//        parts.add(PartFactory.getPart("bunny_arm", level));
//        parts.add(PartFactory.getPart("bunny_arm", level));
//        parts.add(PartFactory.getPart("bunny_leg", level));
//        parts.add(PartFactory.getPart("bunny_leg", level));
//        parts.add(PartFactory.getPart("bunny_tail", level));
//        parts.add(PartFactory.getPart("bunny_body", level));
//
//        return new Mob("Bunny", level + 8, 3, 5, parts, image);
//    }

//    private static Mob makePenguin(int level) throws SlickException
//    {
//        BodyPart body = PartFactory.getPart("penguin_body", level);
//
//        SuperImage image = CreatureComposer.composeImage(((BodyBodyPart) body).getConnectors(),
//                PartFactory.getPart("penguin_head", level),
//                PartFactory.getPart("penguin_arm", level),
//                PartFactory.getPart("penguin_arm", level),
//                PartFactory.getPart("penguin_leg", level),
//                PartFactory.getPart("penguin_leg", level),
//                PartFactory.getPart("penguin_tail", level),
//                PartFactory.getPart("penguin_body", level));
//        image.flipH(true);
//
//        ArrayList<BodyPart> parts = new ArrayList<>();
//        parts.add(PartFactory.getPart("penguin_head", level));
//        parts.add(PartFactory.getPart("penguin_arm", level));
//        parts.add(PartFactory.getPart("penguin_arm", level));
//        parts.add(PartFactory.getPart("penguin_leg", level));
//        parts.add(PartFactory.getPart("penguin_leg", level));
//        parts.add(PartFactory.getPart("penguin_tail", level));
//        parts.add(PartFactory.getPart("penguin_body", level));
//
//        return new Mob("Penguin", level, 4, 5, parts, image);
//    }
//
//    private static Mob makeLion(int level) throws SlickException
//    {
//        BodyPart body = PartFactory.getPart("lion_body", level);
//
//        SuperImage image = CreatureComposer.composeImage(((BodyBodyPart) body).getConnectors(),
//                PartFactory.getPart("lion_head", level),
//                PartFactory.getPart("lion_arm", level),
//                PartFactory.getPart("lion_arm", level),
//                PartFactory.getPart("lion_leg", level),
//                PartFactory.getPart("lion_leg", level),
//                PartFactory.getPart("dog_tail", level),
//                PartFactory.getPart("lion_body", level));
//        image.flipH(true);
//
//        ArrayList<BodyPart> parts = new ArrayList<>();
//        parts.add(PartFactory.getPart("lion_head", level));
//        parts.add(PartFactory.getPart("lion_arm", level));
//        parts.add(PartFactory.getPart("lion_arm", level));
//        parts.add(PartFactory.getPart("lion_leg", level));
//        parts.add(PartFactory.getPart("lion_leg", level));
//        parts.add(PartFactory.getPart("dog_tail", level));
//        parts.add(PartFactory.getPart("lion_body", level));
//
//        return new Mob("Lion", 2*level + 5, 4, 5, parts, image);
//    }
//    private static Mob makeElephant(int level) throws SlickException
//    {
//        BodyPart body = PartFactory.getPart("elephant_body", level);
//
//        SuperImage image = CreatureComposer.composeImage(((BodyBodyPart) body).getConnectors(),
//                PartFactory.getPart("elephant_head", level),
//                PartFactory.getPart("elephant_arm", level),
//                PartFactory.getPart("elephant_arm", level),
//                PartFactory.getPart("elephant_leg", level),
//                PartFactory.getPart("elephant_leg", level),
//                PartFactory.getPart("elephant_tail", level),
//                PartFactory.getPart("elephant_body", level));
//        image.flipH(true);
//
//        ArrayList<BodyPart> parts = new ArrayList<>();
//        parts.add(PartFactory.getPart("elephant_head", level));
//        parts.add(PartFactory.getPart("elephant_arm", level));
//        parts.add(PartFactory.getPart("elephant_arm", level));
//        parts.add(PartFactory.getPart("elephant_leg", level));
//        parts.add(PartFactory.getPart("elephant_leg", level));
//        parts.add(PartFactory.getPart("elephant_tail", level));
//        parts.add(PartFactory.getPart("elephant_body", level));
//
//        return new Mob("Elephant", 3*(level/2) + 5, 4, 5, parts, image);
//    }
//
//    private static Mob makeBeaver(int level) throws SlickException
//    {
//        BodyPart body = PartFactory.getPart("beaver_body", level);
//
//        SuperImage image = CreatureComposer.composeImage(((BodyBodyPart) body).getConnectors(),
//                PartFactory.getPart("beaver_head", level),
//                PartFactory.getPart("beaver_arm", level),
//                PartFactory.getPart("beaver_arm", level),
//                PartFactory.getPart("beaver_leg", level),
//                PartFactory.getPart("beaver_leg", level),
//                PartFactory.getPart("beaver_tail", level),
//                PartFactory.getPart("beaver_body", level));
//        image.flipH(true);
//
//        ArrayList<BodyPart> parts = new ArrayList<>();
//        parts.add(PartFactory.getPart("beaver_head", level));
//        parts.add(PartFactory.getPart("beaver_arm", level));
//        parts.add(PartFactory.getPart("beaver_arm", level));
//        parts.add(PartFactory.getPart("beaver_leg", level));
//        parts.add(PartFactory.getPart("beaver_leg", level));
//        parts.add(PartFactory.getPart("beaver_tail", level));
//        parts.add(PartFactory.getPart("beaver_body", level));
//
//        return new Mob("Beaver", level+3, 4, 5, parts, image);
//    }
//
//    private static Mob makeOstrich(int level) throws SlickException
//    {
//        BodyPart body = PartFactory.getPart("ostrich_body", level);
//
//        SuperImage image = CreatureComposer.composeImage(((BodyBodyPart) body).getConnectors(),
//                PartFactory.getPart("ostrich_head", level),
//                PartFactory.getPart("ostrich_arm", level),
//                PartFactory.getPart("ostrich_arm", level),
//                PartFactory.getPart("ostrich_leg", level),
//                PartFactory.getPart("ostrich_leg", level),
//                PartFactory.getPart("ostrich_tail", level),
//                PartFactory.getPart("ostrich_body", level));
//        image.flipH(true);
//
//        ArrayList<BodyPart> parts = new ArrayList<>();
//        parts.add(PartFactory.getPart("ostrich_head", level));
//        parts.add(PartFactory.getPart("ostrich_arm", level));
//        parts.add(PartFactory.getPart("ostrich_arm", level));
//        parts.add(PartFactory.getPart("ostrich_leg", level));
//        parts.add(PartFactory.getPart("ostrich_leg", level));
//        parts.add(PartFactory.getPart("ostrich_tail", level));
//        parts.add(PartFactory.getPart("ostrich_body", level));
//
//        return new Mob("Ostrich", level*2 + 4, 4, 5, parts, image);
//    }
}
