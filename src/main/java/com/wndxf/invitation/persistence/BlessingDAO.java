package com.wndxf.invitation.persistence;

import com.wndxf.invitation.persistence.model.Blessing;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BlessingDAO {

    public List<Blessing> getPageList(@Param("blessing") Blessing blessing,@Param("start") Integer start, @Param("limit") Integer limit);

    public int count(@Param("blessing") Blessing blessing);

    public List<Blessing> query(@Param("blessing") Blessing blessing);

    public Blessing load(@Param("id") Integer id);

    public int update(@Param("blessing") Blessing blessing);

    public int insert(@Param("blessing")Blessing blessing);

    public int delete(@Param("id") Integer id);
}
