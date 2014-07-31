package com.wndxf.invitation.persistence;

import com.wndxf.invitation.persistence.model.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UsersDAO {
	
	public List<Users> getPageList(@Param("start") Integer start, @Param("limit") Integer limit);
	
	public List<Users> query(@Param("users") Users users);

	public Users load(@Param("username") String username,@Param("password") String password);

	public void update(@Param("users") Users users);

	public void insert(@Param("users") Users users);

	public void delete(@Param("id") Integer id);
}
