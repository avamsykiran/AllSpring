package in.tp.swmdb.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import in.tp.swmdb.model.ArithmeticModel;
@Service
public class ArithmeticServiceImpl implements ArithmeticService {

	@Override
	public void computeResults(ArithmeticModel model) {
		if(model!=null) {
			double op1 = model.getOperand1();
			double op2 = model.getOperand2();
			
			Map<String,Double> results = new HashMap<>();
			
			results.put("Sum", op1+op2);
			results.put("Difference", op1-op2);
			results.put("Product", op1*op2);
			results.put("Quitiont", op1/op2);
			results.put("Reminder", op1%op2);
			
			model.setResults(results);
		}
	}

}
