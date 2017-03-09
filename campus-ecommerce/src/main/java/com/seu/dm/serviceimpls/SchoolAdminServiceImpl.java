package com.seu.dm.serviceimpls;

import com.seu.dm.entities.SchoolAdmin;
import com.seu.dm.mappers.SchoolAdminMapper;
import com.seu.dm.services.SchoolAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 张老师 on 2017/3/3.
 */
@Service
public class SchoolAdminServiceImpl implements SchoolAdminService {
    @Autowired
    private SchoolAdminMapper schoolAdminMapper;

    @Override
    public int addAdim(SchoolAdmin schoolAdmin) {
        return schoolAdminMapper.insert(schoolAdmin);
    }

    @Override
    public int deleteAdim(Integer id) {
        return schoolAdminMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateAdim(SchoolAdmin schoolAdmin) {
        return schoolAdminMapper.updateByPrimaryKey(schoolAdmin);
    }

    @Override
    public SchoolAdmin findAdim(Integer id) {
        return schoolAdminMapper.selectByPrimaryKey(id);
    }
}
