

import java.util.Properties;
import java.io.FileInputStream;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

class PropertiesFile
{
	static Properties prop = new Properties();
	
	public static void readFile()
	{
		try
		{
		InputStream inp = new FileInputStream("/Users/b0224547/eclipse-workspace/AirtelThanksApplication/config/config.properties");
		prop.load(inp);
		System.out.println(prop.getProperty("browser"));
		}
		catch(Exception f)
		{
			System.out.println("File not found");
		}
		
	}
	
	public static void writeFile()
	{
		try
		{
		OutputStream o = new FileOutputStream("/Users/b0224547/eclipse-workspace/AirtelThanksApplication/config/config.properties");
		prop.setProperty("username", "Payal");
		prop.store(o, null);
		}
		catch(Exception f)
		{
			System.out.println("File not found");
		}
		
	}
	
	public static void main(String args[])
	{
		readFile();
		writeFile();
	}
	
}