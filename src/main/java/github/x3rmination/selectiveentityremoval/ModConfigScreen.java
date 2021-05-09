package github.x3rmination.selectiveentityremoval;


import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public class ModConfigScreen extends Screen {

    public ModConfigScreen(Text title) {
        super(new TranslatableText("title.SelectiveEntityRemoval.config"));
    }
}
