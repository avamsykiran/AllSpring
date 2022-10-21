package in.tp.scd.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("gs2")
public class GreetServiceArgumentedImpl implements GreetService {

	@Value("${scd.service.greetNote:Hai}")
	private String greetNote;

	public GreetServiceArgumentedImpl() {
		//Left unimplemented.
	}
	
	public GreetServiceArgumentedImpl(String greetNote) {
		super();
		this.greetNote = greetNote;
	}

	public String greet(String userName) {
		StringBuilder sb = new StringBuilder(greetNote!=null?greetNote:"Hello ");
		sb.append(userName);
		return sb.toString();
	}

	public String getGreetNote() {
		return greetNote;
	}

	public void setGreetNote(String greetNote) {
		this.greetNote = greetNote;
	}

}
