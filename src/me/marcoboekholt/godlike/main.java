package me.marcoboekholt.godlike;

import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class main extends JavaPlugin {

	protected UpdateChecker updateChecker;

	public void onEnable() {
		
		try {
			metrics metrics = new metrics(this); metrics.start();
			} catch (IOException e) { // Failed to submit the stats :-(
			System.out.println("Error Submitting stats!");
			}
		
		// Create a config file if the user does not have one already
		if (!getConfig().contains("config.version")) {
			// Set up config fields
			getConfig().set("updates.enabled", Boolean.valueOf(true));
			getConfig().set("cooldown.speed", Boolean.valueOf(true));
			getConfig().set("cooldown.apple", Boolean.valueOf(true));
			getConfig().set("cooldown.power", Boolean.valueOf(true));
			getConfig().set("config.version", Integer.valueOf(2));

			// Notify the user
			getLogger()
					.info("Created a new config file. You might want to edit it to fit to your needs.");

			// Save configuration
			this.saveConfig();
		}

		if (getConfig().getBoolean("updates.enabled", true)) {
			// Check for updates
			UpdateChecker.updateNeeded(this);
		}
	}

	public void onDisable() {
	}

	ArrayList<Player> cooldown = new ArrayList<Player>();

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		final Player player = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("God")) {
			if (args.length == 0) {
				sender.sendMessage(ChatColor.RED + "Godlike version 2.1");
				sender.sendMessage(ChatColor.GOLD
						+ "/God <Sword|Armour|Bow|Horse|Tools|Apple|Power|Speed|info>");
				return true;
			} else if (args[0].equalsIgnoreCase("info")) {
				player.sendMessage("Godlike information!");
				player.sendMessage(ChatColor.GRAY + "You can:");

				if (!player.hasPermission("Godlike.sword")) {
					player.sendMessage(ChatColor.GOLD + "Spawn a God Sword - "
							+ ChatColor.RED + "" + ChatColor.BOLD + "NO");
				} else {
					player.sendMessage(ChatColor.GOLD + "Spawn a God Sword - "
							+ ChatColor.GREEN + "YES");
				}

				if (!player.hasPermission("Godlike.armour")) {
					player.sendMessage(ChatColor.GOLD + "Spawn God Armour - "
							+ ChatColor.RED + "" + ChatColor.BOLD + "NO");
				} else {
					player.sendMessage(ChatColor.GOLD + "Spawn God Armour - "
							+ ChatColor.GREEN + "YES");
				}

				if (!player.hasPermission("Godlike.bow")) {
					player.sendMessage(ChatColor.GOLD + "Spawn a God Bow - "
							+ ChatColor.RED + "" + ChatColor.BOLD + "NO");
				} else {
					player.sendMessage(ChatColor.GOLD + "Spawn a God Bow - "
							+ ChatColor.GREEN + "YES");
				}

				if (!player.hasPermission("Godlike.tools")) {
					player.sendMessage(ChatColor.GOLD + "Spawn God Tools - "
							+ ChatColor.RED + "" + ChatColor.BOLD + "NO");
				} else {
					player.sendMessage(ChatColor.GOLD + "Spawn God Tools - "
							+ ChatColor.GREEN + "YES");
				}

				if (!player.hasPermission("Godlike.apple")) {
					player.sendMessage(ChatColor.GOLD
							+ "Get a golden apple effect - " + ChatColor.RED
							+ "" + ChatColor.BOLD + "NO");
				} else {
					player.sendMessage(ChatColor.GOLD
							+ "Get a golden apple effect - " + ChatColor.GREEN
							+ "YES");
				}

				if (!player.hasPermission("Godlike.power")) {
					player.sendMessage(ChatColor.GOLD
							+ "Get defence and strength effects - "
							+ ChatColor.RED + "" + ChatColor.BOLD + "NO");
				} else {
					player.sendMessage(ChatColor.GOLD
							+ "Get defence and strength effects - "
							+ ChatColor.GREEN + "YES");
				}

				if (!player.hasPermission("Godlike.speed")) {
					player.sendMessage(ChatColor.GOLD
							+ "Get speed potion effect - " + ChatColor.RED + ""
							+ ChatColor.BOLD + "NO");
				} else {
					player.sendMessage(ChatColor.GOLD
							+ "Get speed potion effect - " + ChatColor.GREEN
							+ "YES");
				}

			} else if (args[0].equalsIgnoreCase("Sword")) {
				if (sender.isOp()) {
					if ((sender instanceof Player)) {
						ItemStack sword = new ItemStack(Material.DIAMOND_SWORD,
								1);
						sword.addEnchantment(Enchantment.KNOCKBACK, 2);
						sword.addEnchantment(Enchantment.DAMAGE_ALL, 5);
						sword.addEnchantment(Enchantment.FIRE_ASPECT, 2);
						PlayerInventory pl = player.getInventory();
						pl.addItem(sword);
						player.sendMessage(ChatColor.DARK_RED + ("*~*")
								+ ChatColor.GREEN + (" You've got a sword!"));
					} else {
						sender.sendMessage(ChatColor.RED
								+ "You must be a player to do this!");
					}
				} else {
					((Player) sender)
							.sendMessage(ChatColor.DARK_RED
									+ "You do not have the permission to use this command.");
				}
			} else if (args[0].equalsIgnoreCase("Bow")) {
				if (sender.isOp()) {
					if ((sender instanceof Player)) {
						ItemStack bow = new ItemStack(Material.BOW, 1);
						ItemStack arrow = new ItemStack(Material.ARROW, 64);
						bow.addEnchantment(Enchantment.ARROW_DAMAGE, 5);
						bow.addEnchantment(Enchantment.ARROW_INFINITE, 1);
						bow.addEnchantment(Enchantment.ARROW_FIRE, 1);
						bow.addEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
						PlayerInventory pl = player.getInventory();
						pl.addItem(bow);
						pl.addItem(arrow);
						player.sendMessage(ChatColor.DARK_RED + ("*~*")
								+ ChatColor.GREEN
								+ (" You've got a bow and arrows!"));
					} else {
						sender.sendMessage(ChatColor.RED
								+ "You must be a player to do this!");
					}
				} else {
					((Player) sender)
							.sendMessage(ChatColor.DARK_RED
									+ "You do not have the permission to use this command.");
				}
			} else if (args[0].equalsIgnoreCase("Armour")) {
				if (sender.isOp()) {
					if ((sender instanceof Player)) {
						ItemStack helmet = new ItemStack(
								Material.DIAMOND_HELMET, 1);
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
						player.sendMessage(ChatColor.DARK_RED + ("*~*")
								+ ChatColor.GREEN + (" You've got the armour!"));
					} else {
						sender.sendMessage(ChatColor.RED
								+ "You must be a player to do this!");
					}
				} else {
					((Player) sender)
							.sendMessage(ChatColor.DARK_RED
									+ "You do not have the permission to use this command.");
				}
			} else if (args[0].equalsIgnoreCase("Horse")) {
				if (args.length == 1) {
					player.sendMessage(ChatColor.GOLD + "Usage: /God Horse <Iron|Gold|Diamond|Saddle>");					
				} else if (args[1].equalsIgnoreCase("Iron")) {
					ItemStack IronHA = new ItemStack(417, 1);
					
					PlayerInventory pl = player.getInventory();
					pl.addItem(IronHA);
				} else if (args[1].equalsIgnoreCase("Gold")) {
					ItemStack GoldHA = new ItemStack(418, 1);
					
					PlayerInventory pl = player.getInventory();
					pl.addItem(GoldHA);
				} else if (args[1].equalsIgnoreCase("Diamond")) {
					ItemStack DiamondHA = new ItemStack(419, 1);
					
					PlayerInventory pl = player.getInventory();
					pl.addItem(DiamondHA);
				} else if (args[1].equalsIgnoreCase("Saddle")) {
					ItemStack HorseSL = new ItemStack(Material.SADDLE, 1);
					
					PlayerInventory pl = player.getInventory();
					pl.addItem(HorseSL);
				}
				
				
			}
			
			else if (args[0].equalsIgnoreCase("Tools")) {
				if (sender.isOp()) {
					if ((sender instanceof Player)) {
						ItemStack pickaxe = new ItemStack(
								Material.DIAMOND_PICKAXE, 1);
						pickaxe.addEnchantment(Enchantment.DIG_SPEED, 5);
						pickaxe.addEnchantment(Enchantment.SILK_TOUCH, 1);
						pickaxe.addEnchantment(Enchantment.DURABILITY, 3);
						pickaxe.addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 3);

						ItemStack axe = new ItemStack(Material.DIAMOND_AXE, 1);
						axe.addEnchantment(Enchantment.DIG_SPEED, 5);
						axe.addEnchantment(Enchantment.SILK_TOUCH, 1);
						axe.addEnchantment(Enchantment.DURABILITY, 3);
						pickaxe.addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 3);

						ItemStack spade = new ItemStack(Material.DIAMOND_SPADE,
								1);
						spade.addEnchantment(Enchantment.DIG_SPEED, 5);
						spade.addEnchantment(Enchantment.SILK_TOUCH, 1);
						spade.addEnchantment(Enchantment.DURABILITY, 3);
						pickaxe.addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 3);

						ItemStack hoe = new ItemStack(Material.DIAMOND_HOE, 1);
						hoe.addEnchantment(Enchantment.DURABILITY, 3);

						PlayerInventory pl = player.getInventory();
						pl.addItem(pickaxe);
						pl.addItem(axe);
						pl.addItem(spade);
						pl.addItem(hoe);
						player.sendMessage(ChatColor.DARK_RED + ("*~*")
								+ ChatColor.GREEN + (" You've got the tools!"));
					} else {
						sender.sendMessage(ChatColor.RED
								+ "You must be a player to do this!");
					}
				} else {
					((Player) sender)
							.sendMessage(ChatColor.DARK_RED
									+ "You do not have the permission to use this command.");
				}
			} else if (args[0].equalsIgnoreCase("apple")) {
				if (sender.isOp()) {
					if ((sender instanceof Player)) {
						if (getConfig().getBoolean("cooldown.apple", true)) {
							if (cooldown.contains(player)) {
								player.sendMessage(ChatColor.RED
										+ "please wait until your potion effect is done");
								return true;
							}
						}
						player.addPotionEffect(new PotionEffect(
								PotionEffectType.FIRE_RESISTANCE, 2400, 1));
						player.addPotionEffect(new PotionEffect(
								PotionEffectType.REGENERATION, 2400, 1));
						player.addPotionEffect(new PotionEffect(
								PotionEffectType.DAMAGE_RESISTANCE, 2400, 1));

						player.sendMessage(ChatColor.DARK_RED
								+ ("*~*")
								+ ChatColor.GREEN
								+ (" You now have the golden apple effect for about 2 minutes!"));
						cooldown.add(player);
						Bukkit.getServer().getScheduler()
								.scheduleSyncDelayedTask(this, new Runnable() {
									public void run() {
										cooldown.remove(player);
									}
								}, 2400);
					} else {
						sender.sendMessage(ChatColor.RED
								+ "You must be a player to do this!");
					}
				} else {
					((Player) sender)
							.sendMessage(ChatColor.DARK_RED
									+ "You do not have the permission to use this command.");
				}
			} else if (args[0].equalsIgnoreCase("power")) {
				if (sender.isOp()) {
					if ((sender instanceof Player)) {
						if (getConfig().getBoolean("cooldown.power", true)) {
							if (cooldown.contains(player)) {
								player.sendMessage(ChatColor.RED
										+ "please wait until your potion effect is done");
								return true;
							}
						}
						player.addPotionEffect(new PotionEffect(
								PotionEffectType.DAMAGE_RESISTANCE, 2400, 1));
						player.addPotionEffect(new PotionEffect(
								PotionEffectType.INCREASE_DAMAGE, 2400, 1));

						player.sendMessage(ChatColor.DARK_RED
								+ ("*~*")
								+ ChatColor.GREEN
								+ (" You now have defence and strength effects for about 2 minutes!"));
						cooldown.add(player);
						Bukkit.getServer().getScheduler()
								.scheduleSyncDelayedTask(this, new Runnable() {
									public void run() {
										cooldown.remove(player);
									}
								}, 2400);
					} else {
						sender.sendMessage(ChatColor.RED
								+ "You must be a player to do this!");
					}
				} else {
					((Player) sender)
							.sendMessage(ChatColor.DARK_RED
									+ "You do not have the permission to use this command.");
				}
			} else if (args[0].equalsIgnoreCase("speed")) {
				if (sender.isOp()) {
					if ((sender instanceof Player)) {
						if (getConfig().getBoolean("cooldown.speed", true)) {
							if (cooldown.contains(player)) {
								player.sendMessage(ChatColor.RED
										+ "please wait until your potion effect is done");
								return true;
							}
						}
						player.addPotionEffect(new PotionEffect(
								PotionEffectType.SPEED, 2400, 1));

						player.sendMessage(ChatColor.DARK_RED
								+ ("*~*")
								+ ChatColor.GREEN
								+ (" You now have a speed potion effect for about 2 minutes!"));
						cooldown.add(player);
						Bukkit.getServer().getScheduler()
								.scheduleSyncDelayedTask(this, new Runnable() {
									public void run() {
										cooldown.remove(player);
									}
								}, 2400);
					} else {
						sender.sendMessage(ChatColor.RED
								+ "You must be a player to do this!");
					}
				} else {
					((Player) sender)
							.sendMessage(ChatColor.DARK_RED
									+ "You do not have the permission to use this command.");
				}
			}
			return false;
		}
		return false;
	}
}