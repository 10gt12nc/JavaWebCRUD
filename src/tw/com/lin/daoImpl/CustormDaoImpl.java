package tw.com.lin.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tw.com.lin.bean.Customer;
import tw.com.lin.dao.CustomerDao;
import tw.com.lin.dbUtils.DBConnectionUtils;

public class CustormDaoImpl implements CustomerDao {

	@Override
	public void addUser(Customer cus) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConnectionUtils.getDB().getConnection();
			String addSQL = "insert into customer(username,password,password2,email)" + "value(?,?,?,?);";
			ps = conn.prepareStatement(addSQL);
			ps.setString(1, cus.getUsername());
			ps.setString(2, cus.getPassword());
			ps.setString(3, cus.getPassword2());
			ps.setString(4, cus.getEmail());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnectionUtils.getDB().close(ps);
			DBConnectionUtils.getDB().close(conn);

		}
	}

	@Override
	public List<Customer> getAll() {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Customer> list = new ArrayList<Customer>();
		try {
			conn = DBConnectionUtils.getDB().getConnection();
			String sql = "select id, username, password, password2, email from customer";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String username = rs.getString(2);
				String password = rs.getString(3);
				String password2 = rs.getString(4);
				String email = rs.getString(5);
				Customer cus = new Customer(id, username, password, password2, email);
				list.add(cus);
			}
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			DBConnectionUtils.getDB().close(rs);
			DBConnectionUtils.getDB().close(ps);
			DBConnectionUtils.getDB().close(conn);
		}
		return list;
	}

	@Override
	public void deleteUser(Integer id) {

		Connection conn = null;
		PreparedStatement ps = null;
		String iid = String.valueOf(id);
		try {
			conn = DBConnectionUtils.getDB().getConnection();
			String sql = "delete from customer where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, iid);
			ps.execute();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			DBConnectionUtils.getDB().close(ps);
			DBConnectionUtils.getDB().close(conn);
		}
	}

	@Override
	public void updateUser(String password, String password2, String id) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConnectionUtils.getDB().getConnection();
			String sql = "update customer set password= ?,password2=? where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, password2);
			ps.setString(3, id);
			ps.execute();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			DBConnectionUtils.getDB().close(ps);
			DBConnectionUtils.getDB().close(conn);
		}
	}

	@Override
	public List<Customer> getUserPass(String username, String email) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Customer> list = new ArrayList<Customer>();
		try {
			conn = DBConnectionUtils.getDB().getConnection();
			String sql = "select id, username, password, password2, email from customer where username=? and email=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, email);
			rs = ps.executeQuery();
			while (rs.next()) {
				int Tid = rs.getInt(1);
				String Tname = rs.getString(2);
				String Tpass = rs.getString(3);
				String Tpass2 = rs.getString(4);
				String Tmail = rs.getString(5);
				Customer cus = new Customer(Tid, Tname, Tpass, Tpass2, Tmail);
				list.add(cus);
			}
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			DBConnectionUtils.getDB().close(rs);
			DBConnectionUtils.getDB().close(ps);
			DBConnectionUtils.getDB().close(conn);
		}
		return list;
	}

	@Override
	public List<Customer> getUserEmail() {
		return null;
	}

	@Override
	public List<Customer> getUserName() {
		return null;
	}

	@Override
	public int getLogin(String username, String password, int a) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConnectionUtils.getDB().getConnection();
			String sql = "select id from customer where username=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				if (count > 0) {
					a += 1;
					System.out.println("登入成功");
				} else {
					System.out.println("登入失敗0");
				}
			} else {
				System.out.println("登入失敗1");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			DBConnectionUtils.getDB().close(rs);
			DBConnectionUtils.getDB().close(ps);
			DBConnectionUtils.getDB().close(conn);
		}
		return a;
	}

	@Override
	public int getPassLogin(String username, String email, int a) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConnectionUtils.getDB().getConnection();
			String sql = "select id from customer where username=? and email=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				if (count > 0) {
					a += 1;
					System.out.println("有");
				} else {
					System.out.println("沒有0");
				}
			} else {
				System.out.println("沒有1");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			DBConnectionUtils.getDB().close(rs);
			DBConnectionUtils.getDB().close(ps);
			DBConnectionUtils.getDB().close(conn);
		}
		return a;
	}

}
