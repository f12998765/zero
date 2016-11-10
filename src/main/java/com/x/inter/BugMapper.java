package com.x.inter;

import com.x.model.Bug;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BugMapper extends BaseUpMapper<Bug>{


}