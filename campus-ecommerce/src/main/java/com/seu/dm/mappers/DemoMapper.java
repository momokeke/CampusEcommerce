package com.seu.dm.mappers;

import com.seu.dm.entities.DemoEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Greeting on 2017/2/25.
 */
public interface DemoMapper {
    @Select("select * from demos")
    List<DemoEntity> getDemos();

    @Select("select * from demos where id = #{id}")
    DemoEntity getDemoById(Integer id);
}
