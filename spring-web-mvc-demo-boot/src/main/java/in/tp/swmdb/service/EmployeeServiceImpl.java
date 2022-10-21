package in.tp.swmdb.service;

import org.springframework.stereotype.Service;

import in.tp.swmdb.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public void computeAllowences(Employee e) {
		e.setHra(e.getBasic()*0.23);
		e.setTa(e.getBasic()*0.13);
	}

}
