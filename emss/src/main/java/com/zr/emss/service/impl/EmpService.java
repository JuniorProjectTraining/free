package com.zr.emss.service.impl;

import com.zr.emss.dao.IEmpDao;
import com.zr.emss.dao.impl.EmpDao;
import com.zr.emss.pojo.Emp;
import com.zr.emss.service.IEmpService;

/**
 * 
 * 服务接口的实现类
 * 
 * @author Administrator
 *
 */
public class EmpService implements IEmpService {
	// 获取到专门处理持久层方面的对象
	private IEmpDao empDao = new EmpDao();
	
	@Override
	public Emp findEmpByNicknameAndPassword(String nickname, String password) {

		// 获取到专门处理持久层方面的对象
		IEmpDao empDao = new EmpDao();

		// 调用dao中的方法
		return empDao.findEmpByNicknameAndPassword(nickname, password);
	}
	
	@Override
	public int findEmpByNickname(String nickname) {
		return empDao.findEmpByNickname(nickname);
	}

	@Override
	public void registerEmp(Emp emp) {
		empDao.registerEmp(emp);
	}
}
