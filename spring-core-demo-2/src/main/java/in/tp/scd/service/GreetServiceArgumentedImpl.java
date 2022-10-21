package in.tp.scd.service;

public class GreetServiceArgumentedImpl implements GreetService {

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
