package in.tp.scd.service;

import java.time.LocalTime;

public class GtreetNoteProviderTimeBasedImpl implements GreetNoteProvider {

	public String getGreetNote() {
		String greetNote;
		
		int h = LocalTime.now().getHour();
		
		if(h>=4 && h<=11) greetNote="Good Morning ";
		else if(h>11 && h<=15) greetNote="Good Noon ";
		else greetNote="Good Evening ";
		
		return greetNote;
	}

}
