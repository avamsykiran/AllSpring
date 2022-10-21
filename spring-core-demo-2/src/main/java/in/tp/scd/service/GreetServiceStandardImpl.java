package in.tp.scd.service;

public class GreetServiceStandardImpl implements GreetService {

	public String greet(String userName) {
		//return "Hello " + userName;
		StringBuilder sb = new StringBuilder("Hello ");
		sb.append(userName);
		return sb.toString();
	}

}
