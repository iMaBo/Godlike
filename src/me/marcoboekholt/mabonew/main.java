package me.marcoboekholt.mabonew;
 
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;
 
public class main extends JavaPlugin {
 
       
        public void onEnable(){
                getLogger().info("[pluginname] is Enabled!");
               
        }
       
        public void onDisable(){
                getLogger().info("[pluginname is Disabled");
        }
       
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
                Player player = (Player)sender;
                if(cmd.getName().equalsIgnoreCase("Sword")){
                	ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);            
                		sword.addEnchantment(Enchantment.KNOCKBACK, 2);
                		sword.addEnchantment(Enchantment.DAMAGE_ALL, 5);
                		sword.addEnchantment(Enchantment.FIRE_ASPECT, 2);
                		PlayerInventory pl = player.getInventory();
                		pl.addItem(sword);
                    	player.sendMessage(ChatColor.DARK_RED + ("*~*") + ChatColor.GREEN + (" You got a sword!"));
                }
                else if(cmd.getName().equalsIgnoreCase("Bow")){
                        ItemStack bow = new ItemStack(Material.BOW, 1);
                        ItemStack arrow = new ItemStack(Material.ARROW, 64);
                        bow.addEnchantment(Enchantment.ARROW_DAMAGE, 5);
                        bow.addEnchantment(Enchantment.ARROW_INFINITE, 1);
                        bow.addEnchantment(Enchantment.ARROW_FIRE, 1);
                        bow.addEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
                        PlayerInventory pl = player.getInventory();
                        pl.addItem(bow);
                        pl.addItem(arrow);
                        player.sendMessage(ChatColor.DARK_RED + ("*~*") + ChatColor.GREEN + (" You got a bow and sword!"));
                }
                else if(cmd.getName().equalsIgnoreCase("Armour")){
                        ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET, 1);
                        helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                        helmet.addEnchantment(Enchantment.PROTECTION_FIRE, 4);
                        helmet.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 4);
                        helmet.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
                        helmet.addEnchantment(Enchantment.THORNS, 3);
                        helmet.addEnchantment(Enchantment.OXYGEN, 3);
                        helmet.addEnchantment(Enchantment.WATER_WORKER, 1);
                       
                        ItemStack body = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
                        body.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                        body.addEnchantment(Enchantment.PROTECTION_FIRE, 4);
                        body.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 4);
                        body.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
                        body.addEnchantment(Enchantment.THORNS, 3);
                       
                        ItemStack legs = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
                        legs.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                        legs.addEnchantment(Enchantment.PROTECTION_FIRE, 4);
                        legs.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 4);
                        legs.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
                        legs.addEnchantment(Enchantment.THORNS, 3);
                       
                        ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS, 1);
                        boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                        boots.addEnchantment(Enchantment.PROTECTION_FIRE, 4);
                        boots.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 4);
                        boots.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
                        boots.addEnchantment(Enchantment.THORNS, 3);
                        boots.addEnchantment(Enchantment.PROTECTION_FALL, 4);
 
                        PlayerInventory pl = player.getInventory();
                        pl.addItem(helmet);
                        pl.addItem(body);
                        pl.addItem(legs);
                        pl.addItem(boots);
                        player.sendMessage(ChatColor.DARK_RED + ("*~*") + ChatColor.GREEN + (" You got the armour!"));
                }
                return false;
               
        }
}