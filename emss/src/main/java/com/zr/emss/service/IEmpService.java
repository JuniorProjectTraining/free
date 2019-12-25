package com.zr.emss.service;

import com.zr.emss.pojo.Emp;

/**
 * ����ӿ� 
 *
 */
public interface IEmpService {
	/**
	 * ͨ���ǳƺ��������emp����
	 * @param nickname
	 * @param password
	 * @return
	 */
	Emp findEmpByNicknameAndPassword(String nickname, String password);
	
	/**
	 * �����ǳ��ж��û��Ƿ����
	 * 
	 * @param nickname
	 * @return
	 */
	int findEmpByNickname(String nickname);

	/**
	 * ע��Ա����Ϣ
	 * 
	 * @param emp
	 */
	void registerEmp(Emp emp);
}