package com.zr.emss.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.emss.pojo.Emp;
import com.zr.emss.service.IEmpService;
import com.zr.emss.service.impl.EmpService;

@SuppressWarnings("serial")
@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		// ����Ո�󅢔�
		String cmd = req.getParameter("cmd");

		if ("login".equals(cmd)) {
			login(req, resp);
		} else if ("register".equals(cmd)) {
			register(req, resp);
		}
	}

	/**
	 * ���������Ҫ������ע�Ṧ��
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���Ȼ�ȡ��ǰ̨ҳ�洫�ݵ�����
		try {
			String nickname = request.getParameter("nickname");
			String password = request.getParameter("password");
			String gender = request.getParameter("gender");
			double salary = Double.parseDouble(request.getParameter("salary"));
			/**
			 * ���������ж��ǳ��Ƿ��Ѿ���ʹ��, �����ʹ��, ������ע��.
			 */
			// ��ȡ���������
			IEmpService service = new EmpService();

			// �����ж��û����Ƿ���ڵķ���.
			// 1��ʾ����, ��1��ʾ������
			int flag = service.findEmpByNickname(nickname);

			if (flag == 1) {
				// ����ʾ��Ϣ���뵽��������
				response.getWriter().write("�ǳ��Ѵ���, ��������д��Ϣ");
				// ����ת��
				response.setHeader("refresh", "3;url=/emss/register.jsp");

				return;
			} else {
				// �����е����ݷ�װ��ʵ�������
				Emp emp = new Emp(1, nickname, password, gender, salary);

				// ����ע��ķ���
				service.registerEmp(emp);

				response.getWriter().write("ע��ɹ�, 5s����ת����¼ҳ��");

				response.setHeader("refresh", "5;url=/emss/login.jsp");
			}
		} catch (Exception e) {
			response.getWriter().write("ע��ʧ��, ��������д��ȷ����������Ϣ");
			response.setHeader("refresh", "3;url=/emss/register.jsp");
		}
	}

	/**
	 * ����ר�����ڴ�����¼���ܵķ���
	 * 
	 * @param rep
	 * @param resp
	 * @throws IOException
	 */
	private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		/**
		 * ˼·��1.��ȡ���û�������ǳƺ����� 2.Ȼ��ȥ���ݿ⵱�в����Ƿ������ж�Ӧ�ǳƺ�������û����� 3.������ڣ���������¼
		 * 4.��������ڣ�������û����˺Ż���������������¼�������ǵ����ע�ᡱ
		 */

		// ��ȡ���û�������ǳƺ�����
		String nickname = req.getParameter("nickname");
		String password = req.getParameter("password");

		// Ȼ��ȥ���ݿ��в����Ƿ������ж�Ӧ�ǳƺ�������û�����
		IEmpService service = new EmpService();

		Emp emp = service.findEmpByNicknameAndPassword(nickname, password);

		if (emp != null) {
			resp.getWriter().write("��¼�ɹ�, 3s����ת������ҳ��");
			resp.setHeader("refresh", "3;url=/emss/caozuo.jsp");
			return;
		} else {
			resp.getWriter().write("�˺Ż���������, ������¼");
			resp.setHeader("refresh", "3;url=/emss/login.jsp");
		}
	}

}