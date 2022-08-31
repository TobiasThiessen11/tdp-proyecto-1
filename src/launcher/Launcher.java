package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	try {
            		Student me= new Student(126647,"Thiessen","Tobias","tobiasthiessen@live.com.ar","https://github.com/TobiasThiessen11","/images/Foto.png");
            		SimplePresentationScreen gui = new SimplePresentationScreen(me);
            		gui.setVisible(true);
            	}
            	catch (Exception e) {
            		e.printStackTrace();
            	}
            }
        });
    }
}