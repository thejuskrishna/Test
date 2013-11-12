package scripts;

import java.io.File;
import java.io.IOException;

import lib.Library;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliTest{
	
	public static void main(String args[]) throws IOException
	{
		Library lib = new Library();
		Screen regionToSearch = lib.startSikuli();
		Match match = null;
		try {
			System.out.println(new File(".").getCanonicalPath()+"\\src\\img\\windowButton.png");
			match = regionToSearch.wait(new File(".").getCanonicalPath()+"\\src\\img\\windowButton.png");
			
			if(match != null)
			{
				lib.MouseClick(match);
			}
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Image not found");
		}
	}

}
