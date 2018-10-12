package cn.mldn.util.dao;

import java.sql.SQLException;
import java.util.List;

public interface IBaseDao <K,V>{
	public boolean doCreate(V vo) throws SQLException;
	public boolean doUpdate(V vo) throws SQLException;
	public boolean doRemove(V vo) throws SQLException;
	public V findById(K id)throws SQLException;
	public List<V> findAll() throws SQLException;
	public List<V> findAll(Integer currentPage,Integer lineSize) throws SQLException;
	public List<V> findAllSplit(Integer currentPage,Integer lineSize,String column,String keyWord) throws SQLException;
	public Integer getAllCount() throws SQLException;
	public Integer getAllCount(String column,String keyWord) throws SQLException;
}
