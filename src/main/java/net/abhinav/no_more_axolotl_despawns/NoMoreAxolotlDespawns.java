package net.abhinav.no_more_axolotl_despawns;

import org.bukkit.Bukkit;
import org.bukkit.entity.Axolotl;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class NoMoreAxolotlDespawns extends JavaPlugin {

    @Override
    public void onEnable() {
        // Schedule a task to prevent Axolotls from despawning every tick
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Entity entity : Bukkit.getWorlds().get(0).getEntities()) {
                    if (entity instanceof Axolotl) {
                        Axolotl axolotl = (Axolotl) entity;
                        // Apply the PersistenceRequired tag to prevent despawn
                        axolotl.setPersistent(true);
                    }
                }
            }
        }.runTaskTimer(this, 0L, 1L); // Runs every tick (1L)
    }

    @Override
    public void onDisable() {
    }
}
