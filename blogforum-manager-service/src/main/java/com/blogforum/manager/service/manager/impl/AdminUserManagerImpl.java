package com.blogforum.manager.service.manager.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogforum.common.enums.BizErrorEnum;
import com.blogforum.common.exception.BusinessException;
import com.blogforum.common.tools.blogforumResult;
import com.blogforum.manager.common.utils.MD5SaltUtils;
import com.blogforum.manager.pojo.entity.AdminUser;
import com.blogforum.manager.pojo.page.Page;
import com.blogforum.manager.service.dao.AdminUserService;
import com.blogforum.manager.service.manager.AdminUserManager;

@Service
public class AdminUserManagerImpl implements AdminUserManager {

	private static Logger	logger	= Logger.getLogger(AdminUserManagerImpl.class);
	@Autowired
	private AdminUserService	adminUserService;

	@Override
	public blogforumResult insert(AdminUser adminUser) {
		// 给用户的密码进行加密
		String salt = MD5SaltUtils.randomCreateSalt();
		String encodePWD = MD5SaltUtils.encode(adminUser.getPassword(), salt);
		adminUser.setPassword(encodePWD);
		adminUser.setSalt(salt);
		adminUser.setCreateDate(new Date());
		try {
			adminUserService.save(adminUser);
		} catch (Exception e) {
			logger.error("插入数据库失败:" + adminUser.toString(), e);
			return blogforumResult.build(BizErrorEnum.DATABASE_INSERT, "false");
		}

		return blogforumResult.ok();
	}

	@Override
	public AdminUser getByUserPwd(AdminUser adminUser) {
		AdminUser newAdminUser = null;
		try {
			newAdminUser = adminUserService.getByUserPwd(adminUser);
		} catch (Exception e) {
			logger.error(BizErrorEnum.DATABASE_EXCEPTION.getMsg(), e);
			return newAdminUser;
		}

		return newAdminUser;
	}

	@Override
	public AdminUser getByID(Integer adminUserId) {
		return adminUserService.getByID(adminUserId);
	}

	@Override
	public AdminUser getByUserName(String username) {
		AdminUser newAdminUser = null;
		try {
			newAdminUser = adminUserService.getByUserName(username);
		} catch (Exception e) {
			logger.error(BizErrorEnum.DATABASE_EXCEPTION.getMsg(), e);
			throw new BusinessException(BizErrorEnum.DATABASE_EXCEPTION);
		}

		return newAdminUser;
	}

	@Override
	public void update(AdminUser adminUser) {

		AdminUser oldAdminUser = adminUserService.getByID(adminUser.getId());
		if (oldAdminUser == null) {
			throw new BusinessException("找不到被修改的管理员");
		}
		if (StringUtils.isNotEmpty(adminUser.getPassword())) {
			// 给用户的密码进行加密
			String salt = MD5SaltUtils.randomCreateSalt();
			String encodePWD = MD5SaltUtils.encode(adminUser.getPassword(), salt);
			adminUser.setPassword(encodePWD);
			adminUser.setSalt(salt);
		}else {
			adminUser.setPassword(null);
		}
		adminUser.setRoleId(adminUser.getRoleId());
		adminUserService.update(adminUser);
	}

	@Override
	public blogforumResult queryListPage(Integer pageSize, Integer pageNo) {
		
		Page<AdminUser> queryList = adminUserService.queryList(new Page<AdminUser>(pageNo, pageSize), new AdminUser());
		
		return blogforumResult.ok(queryList);
	}

	@Override
	public void delete(Integer id) {
		adminUserService.delete(new AdminUser(id));
		
	}

}
