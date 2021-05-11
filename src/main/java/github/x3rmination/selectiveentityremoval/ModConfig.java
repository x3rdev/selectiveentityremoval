package github.x3rmination.selectiveentityremoval;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;



@Config(name = "selectiveentityremoval")
public class ModConfig extends PartitioningSerializer.GlobalData {



    @ConfigEntry.Gui.TransitiveObject
    GeneralConfig general = new GeneralConfig();


    public GeneralConfig getGeneral() {
        return general;
    }

    @Config(name = "entities")
    public static class GeneralConfig implements ConfigData {



        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity area_affect_cloud = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        public ConfEntity armor_stand = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity arrow = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity bat = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity bee = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity blaze = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity boat = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity cat = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity cave_spider = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity chest_minecart = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity chicken = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity client_player = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity cod = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity commandblock_minecart= new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity cow = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity creeper = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity dolphin = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity donkey = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity dragon_fireball = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity drowned = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity egg = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity elder_guardian = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity endcrystal = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity enderdragon = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity enderdragonpart = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity enderpearl = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity enderman = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity endermite = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity evoker = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity evokerfangs = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity experiencebottle = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity experienceorb = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity eyeofender = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity fallingblock = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity fireball = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity fireworkrocket = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity fishingbobber = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity fox = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity furnaceminecart = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity ghast = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity giant = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity guardian = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity hoglin = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity hopperminecart = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity horse = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity husk = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity illusioner = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity irongolem = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity item = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity itemframe = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity leashknot = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity lightning = new ConfEntity(true, 100);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity llama = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity llamaspit = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity magma_cube = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity minecart = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity mooshroom = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity mule = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity ocelot = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity otherclientplayer = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity painting = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity panda = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity parrot = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity phantom = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity pig = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity piglin = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity piglinbrute = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity pillager = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity polarbear = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity potion = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity pufferfish = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity rabbit = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity ravager = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity salmon = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity serverplayer = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity sheep = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity shulker = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity shulkerbullet = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity silverfish = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity skeleton = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity skeletonhorse = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity slime = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity smallfireball = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity snowgolem = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity snowball = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity spawner_minecart = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity spectral_arrow = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity spider = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity squid = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity stray = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity strider = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity tnt = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity tnt_minecart = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity trader_llama = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity trident = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity tropical_fish = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity turtle = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity vex = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity villager = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity vindicator = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity wandering_trader = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity witch = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity wither = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity wither_skeleton = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity wither_skull = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity wolf = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity zoglin = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity zombie = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity zombie_horse = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity zombie_villager = new ConfEntity(true, 60);

        @ConfigEntry.Gui.CollapsibleObject
        ConfEntity zombified_piglin = new ConfEntity(true, 60);






        public static class ConfEntity {
            boolean Enabled = true;
            double Range = 60.0;
            ConfEntity(boolean enabled, double range) {
                Enabled = enabled;
                Range = range;
            }
        }




    }


}
