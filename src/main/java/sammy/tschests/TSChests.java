package sammy.tschests;

import org.bukkit.plugin.java.JavaPlugin;
import sammy.tschests.commands.tschest;
import sammy.tschests.listeners.OpenChest;

import java.io.File;

public final class TSChests extends JavaPlugin {

    @Override
    public void onEnable() {
        //config setup
        File config = new File(getDataFolder() + File.separator + "config.yml");
        if(!config.exists()) {
            getConfig().options().copyDefaults(true);
            saveDefaultConfig();
        }
        else{
            reloadConfig();
        }
        // commands
        getCommand("tschest").setExecutor(new tschest(this));
        // listeners
        new sammy.tschests.listeners.OpenChest(this);
    }

}
