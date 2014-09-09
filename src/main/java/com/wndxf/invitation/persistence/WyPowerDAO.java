package com.wndxf.invitation.persistence;

import com.wndxf.invitation.persistence.model.WyPower;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WyPowerDAO {
	
	public List<WyPower> getPageList(@Param("start") Integer start, @Param("limit") Integer limit);
	
	public List<WyPower> query(@Param("wyPower") WyPower wyPower);

	public WyPower load(@Param("id") Integer id);

	public void update(@Param("wyPower") WyPower wyPower);

	public void insert(@Param("wyPower") WyPower wyPower);

	public void delete(@Param("id") Integer id);
}
