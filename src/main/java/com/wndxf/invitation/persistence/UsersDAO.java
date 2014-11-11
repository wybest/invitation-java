package com.wndxf.invitation.persistence;

import com.wndxf.invitation.persistence.model.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UsersDAO {
	
	public List<Users> getPageList(@Param("users") Users users,@Param("start") Integer start, @Param("limit") Integer limit);
	
	public List<Users> query(@Param("users") Users users);

	public Users load(@Param("username") String username,@Param("password") String password);
    public Users loadByName(@Param("username") String username);

    public Users loadById(@Param("id") int id);

    public int touch(@Param("users") Users users);

	public int update(@Param("users") Users users);

    public int open(@Param("users") Users users);

	public int insert(@Param("users") Users users);

	public int delete(@Param("id") Integer id);
}
