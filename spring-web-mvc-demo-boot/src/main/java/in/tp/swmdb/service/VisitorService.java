package in.tp.swmdb.service;

import in.tp.swmdb.exception.InvalidVisitorException;
import in.tp.swmdb.model.Visitor;

public interface VisitorService {
	boolean isValid(Visitor visitor) throws InvalidVisitorException;
	Visitor computeAge(Visitor visitor);
}
