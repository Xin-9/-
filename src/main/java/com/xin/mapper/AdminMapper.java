package com.xin.mapper;

import com.xin.entity.Admin;


public interface AdminMapper {

	Admin selectAdminByLoginnameAndLoginpass(Admin admin);

}
