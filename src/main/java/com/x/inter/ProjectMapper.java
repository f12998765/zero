package com.x.inter;

import com.x.model.Project;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);

    //查询所有
    List<Project> selectAll();

    //查询所有-分页
    List<Project> selectPage(@Param(value = "startPos") Integer startPos, @Param(value = "pageSize") Integer pageSize);

    //查询所有-获取总条数
    int getCount();


    List<Project> selectByUserId(int userid);

    List<Project> selectAllById(List<Integer> ids);
}