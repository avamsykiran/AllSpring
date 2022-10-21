package in.tp.swmd.service;

import org.springframework.stereotype.Service;

import in.tp.swmd.model.Loan;

@Service
public class LoanServiceImpl implements LoanService {

	@Override
	public void computeInterest(Loan loan) {
		if(loan!=null) {
			loan.setInterest((loan.getPrincipal()*loan.getRate()*loan.getTime())/100.0);
		}
	}

}
