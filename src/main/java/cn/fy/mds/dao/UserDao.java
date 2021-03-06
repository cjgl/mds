package cn.fy.mds.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.fy.mds.model.User;

@Mapper
public interface UserDao {
	public void addUser(User user);
	public void modUser(User user);
	public void delUser(User user);
	public User queryUser(User user);
	public List<User> queryUserList(User user);
	public Integer checkUser(User user);
}
