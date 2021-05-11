package github.x3rmination.selectiveentityremoval;

import java.lang.reflect.Field;

public class ConfigProvider {

    ModConfig cfg;

    public ConfigProvider(ModConfig cfg) {
        this.cfg = cfg;
    }

    public Boolean getEnabledFor(String entityid) {

        ModConfig.GeneralConfig.ConfEntity entity = null;
        try {
            entity = getConfEntity(entityid);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            return true;
        }
        return entity.Enabled;
    }

    public double getRangeFor(String entityid) {

        ModConfig.GeneralConfig.ConfEntity entity = null;
        try {
            entity = getConfEntity(entityid);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            return 1000;
        }

        return entity.Range;
    }

    private ModConfig.GeneralConfig.ConfEntity getConfEntity(String entityid) throws NoSuchFieldException, IllegalAccessException {
        ModConfig.GeneralConfig genConf = cfg.getGeneral();

        Field field = genConf.getClass().getDeclaredField(entityid);
        field.setAccessible(true);
        return (ModConfig.GeneralConfig.ConfEntity) field.get(genConf);
    }

    public static void main(String[] args)  {

        ModConfig cfg = new ModConfig();

        ConfigProvider cfgprovider = new ConfigProvider(cfg);


        System.out.println(cfgprovider.getEnabledFor("bat"));
        System.out.println(cfgprovider.getRangeFor("bat"));
    }
}
