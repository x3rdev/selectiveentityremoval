package github.x3rmination.selectiveentityremoval;

import com.google.gson.annotations.Expose;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import java.util.HashMap;
import java.util.Map;


@Config(name = "selectiveentityremoval")
public class ModConfig extends PartitioningSerializer.GlobalData {



    @ConfigEntry.Category("nbt_general")
    @ConfigEntry.Gui.TransitiveObject
    GeneralConfig general = new GeneralConfig();


    @Config(name = "nbt_general")
    public static class GeneralConfig implements ConfigData {

        boolean enableTooltips = true;


        boolean modisworking = false;
    }





}
