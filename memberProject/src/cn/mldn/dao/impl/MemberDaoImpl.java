package cn.mldn.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.mldn.dao.IMemberDao;
import cn.mldn.util.dbc.DatabaseConnection;
import cn.mldn.vo.Member;

public class MemberDaoImpl implements IMemberDao {
	private PreparedStatement pstmt=null;	
	@Override
	public boolean doCreate(Member vo) throws SQLException {
		String sql="insert into member(mid,name,birthday,salary,note,del) values(?,?,?,?,?,?)";
		this.pstmt=DatabaseConnection.getConnection().prepareStatement(sql);
		this.pstmt.setString(1, vo.getMid());
		this.pstmt.setString(2, vo.getName());
		this.pstmt.setDate(3, new java.sql.Date(vo.getBirthday().getTime()));
		this.pstmt.setDouble(4, vo.getSalary());
		this.pstmt.setString(5, vo.getNote());
		this.pstmt.setInt(6, vo.getDel());
		return this.pstmt.executeUpdate()>0;
	}

	@Override
	public boolean doUpdate(Member vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Member vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Member findById(String id) throws SQLException {
		Member member=null;
		String sql="select mid,name,birthday,salary,note,del from member where mid=?";
		this.pstmt=DatabaseConnection.getConnection().prepareStatement(sql);
		this.pstmt.setString(1, id);
		ResultSet res=this.pstmt.executeQuery();
		Member member2 = member;
		if(res.next()){
			member2.setMid(res.getString(1));
			member2.setName(res.getString(2));
			member2.setBirthday(res.getDate(3));
			member2.setSalary(res.getDouble(4));
			member2.setNote(res.getString(5));
			member2.setDel(res.getInt(6));
		}
		return member2;
	}

	@Override
	public List<Member> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> findAll(Integer currentPage, Integer lineSize)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> findAllSplit(Integer currentPage, Integer lineSize,
			String column, String keyWord) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllCount() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
