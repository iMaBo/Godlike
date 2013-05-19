package me.marcoboekholt.godlike;

import java.io.InputStream;
import java.net.URL;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class UpdateChecker {
	
	public static void updateNeeded(main plugin) {
		try{
			plugin.getLogger().info("Checking for updates...");
			
			InputStream input = (new URL("http://dev.bukkit.org/server-mods/godlike/files.rss")).openConnection().getInputStream();
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(input);
			
			Node latestFile = document.getElementsByTagName("item").item(0);
			NodeList children = latestFile.getChildNodes();
			
			String version = children.item(1).getTextContent().replaceAll("[a-zA-Z ]", "");
			
			if (!plugin.getDescription().getVersion().equals(version)){
				plugin.getLogger().info("There is an update available.");
				plugin.getLogger().info("You might want to upgrade to version " + version + " at " + children.item(3).getTextContent());
			}
		}
		catch (Exception e){
			plugin.getLogger().info("Could not check for updates. Do you have a working internet connection?");
			e.printStackTrace();
		}
	}
	
}
