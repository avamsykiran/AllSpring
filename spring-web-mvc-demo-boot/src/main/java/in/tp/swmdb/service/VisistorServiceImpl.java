package in.tp.swmdb.service;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Service;

import in.tp.swmdb.exception.InvalidVisitorException;
import in.tp.swmdb.model.Visitor;

@Service
public class VisistorServiceImpl implements VisitorService {

	public Visitor computeAge(Visitor visitor) {
		if(visitor!=null) {
			LocalDate today = LocalDate.now();
			int age = Period.between(visitor.getDateOfBirth(), today).getYears();
			visitor.setAge(age);
		}
		
		return visitor;
	}

	@Override
	public boolean isValid(Visitor visitor) throws InvalidVisitorException {
		boolean isOk = true;
		
		if(LocalDate.now().isBefore(visitor.getDateOfBirth())) {
			isOk=false;
			throw new InvalidVisitorException("You can not be born in future!");
		}
		
		return isOk;
	}

}
