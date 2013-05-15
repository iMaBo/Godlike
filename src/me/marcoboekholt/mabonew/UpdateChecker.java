package me.marcoboekholt.mabonew;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class UpdateChecker {
	
	
	private main plugin;
	private URL filesFeed;
	public String link;
	
	public UpdateChecker(main plugin, String url){
		this.plugin = plugin;
		
		try {
			this.filesFeed = new URL(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean updateNeeded() {
		try{
			InputStream input = this.filesFeed.openConnection().getInputStream();
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(input);
			
			Node latestFile = document.getElementsByTagName("item").item(0);
			NodeList children = latestFile.getChildNodes();
			
			String version = children.item(1).getTextContent().replaceAll("[a-zA-Z ]", "");
			
			if (!plugin.getDescription().getVersion().equals(version)){
				this.link = children.item(3).getTextContent();
				return true;
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
}
