package com.x.inter;

import com.x.model.Task;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskMapper extends BaseUpMapper<Task>{


}