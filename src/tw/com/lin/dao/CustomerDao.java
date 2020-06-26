package tw.com.lin.dao;

import java.util.List;

import tw.com.lin.bean.Customer;

public interface CustomerDao {

	public void addUser(Customer cus);

	public void deleteUser(Integer id);

	public void updateUser(String password, String password2, String id);

	public List<Customer> getAll();

	public List<Customer> getUserName();

	public List<Customer> getUserEmail();

	public List<Customer> getUserPass(String username, String email);

	public int getLogin(String username, String password, int a);

	public int getPassLogin(String username, String email, int a);

}
