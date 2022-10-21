package in.tp.scd.service;

import org.springframework.stereotype.Service;

@Service("gs1")
public class GreetServiceStandardImpl implements GreetService {

	public String greet(String userName) {
		//return "Hello " + userName;
		StringBuilder sb = new StringBuilder("Hello ");
		sb.append(userName);
		return sb.toString();
	}

}
