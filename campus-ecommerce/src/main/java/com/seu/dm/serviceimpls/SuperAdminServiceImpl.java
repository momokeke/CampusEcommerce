package com.seu.dm.serviceimpls;

import com.seu.dm.entities.SuperAdmin;
import com.seu.dm.mappers.SuperAdminMapper;
import com.seu.dm.services.SuperAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Greeting on 2017/3/14.
 */
@Service
public class SuperAdminServiceImpl implements SuperAdminService {
    @Autowired
    SuperAdminMapper superAdminMapper;
    @Override
    public boolean checkSuperAdmin(SuperAdmin superAdmin) {
        if(superAdminMapper.getSuperAdmin(superAdmin) == null){
            return false;
        }
        return true;
    }
}
