package in.tp.scd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetServiceAdvancedImpl implements GreetService {

	@Autowired
	private GreetNoteProvider gnp;
	
	public GreetNoteProvider getGnp() {
		return gnp;
	}

	public void setGnp(GreetNoteProvider gnp) {
		this.gnp = gnp;
	}


	public String greet(String userName) {
		StringBuilder sb = new StringBuilder(gnp.getGreetNote());
		sb.append(userName);
		return sb.toString();
	}

}
