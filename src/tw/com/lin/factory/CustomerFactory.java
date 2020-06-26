package tw.com.lin.factory;

import tw.com.lin.dao.CustomerDao;
import tw.com.lin.daoImpl.CustormDaoImpl;

public class CustomerFactory {

	public static CustomerDao getCustomerDaoFactory() {
		return new CustormDaoImpl();
	}
}
