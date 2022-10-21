package in.tp.swmdb.model;

import java.util.Map;

public class ArithmeticModel {
	private double operand1;
	private double operand2;
	private Map<String,Double> results;
	
	public double getOperand1() {
		return operand1;
	}
	public void setOperand1(double operand1) {
		this.operand1 = operand1;
	}
	public double getOperand2() {
		return operand2;
	}
	public void setOperand2(double operand2) {
		this.operand2 = operand2;
	}
	public Map<String, Double> getResults() {
		return results;
	}
	public void setResults(Map<String, Double> results) {
		this.results = results;
	}
	
	
}
