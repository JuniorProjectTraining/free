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

		// 接收請求參數
		String cmd = req.getParameter("cmd");

		if ("login".equals(cmd)) {
			login(req, resp);
		} else if ("register".equals(cmd)) {
			register(req, resp);
		}
	}

	/**
	 * 这个方法主要用来做注册功能
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 首先获取到前台页面传递的数据
		try {
			String nickname = request.getParameter("nickname");
			String password = request.getParameter("password");
			String gender = request.getParameter("gender");
			double salary = Double.parseDouble(request.getParameter("salary"));
			/**
			 * 可以首先判断昵称是否已经被使用, 如果被使用, 则不允许注册.
			 */
			// 获取到服务对象
			IEmpService service = new EmpService();

			// 调用判断用户名是否存在的方法.
			// 1表示存在, 非1表示不存在
			int flag = service.findEmpByNickname(nickname);

			if (flag == 1) {
				// 把提示信息放入到请求域中
				response.getWriter().write("昵称已存在, 请重新填写信息");
				// 请求转发
				response.setHeader("refresh", "3;url=/emss/register.jsp");

				return;
			} else {
				// 把所有的数据封装到实体对象中
				Emp emp = new Emp(1, nickname, password, gender, salary);

				// 调用注册的方法
				service.registerEmp(emp);

				response.getWriter().write("注册成功, 5s后跳转到登录页面");

				response.setHeader("refresh", "5;url=/emss/login.jsp");
			}
		} catch (Exception e) {
			response.getWriter().write("注册失败, 请重新填写正确且完整的信息");
			response.setHeader("refresh", "3;url=/emss/register.jsp");
		}
	}

	/**
	 * 这是专门用于处理登录功能的方法
	 * 
	 * @param rep
	 * @param resp
	 * @throws IOException
	 */
	private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		/**
		 * 思路：1.获取到用户输入的昵称和密码 2.然后去数据库当中查找是否正好有对应昵称和密码的用户存在 3.如果存在，则允许登录
		 * 4.如果不存在，则告诉用户：账号或密码有误，请检查后登录，或者是点击“注册”
		 */

		// 获取到用户输入的昵称和密码
		String nickname = req.getParameter("nickname");
		String password = req.getParameter("password");

		// 然后去数据库中查找是否正好有对应昵称和密码的用户存在
		IEmpService service = new EmpService();

		Emp emp = service.findEmpByNicknameAndPassword(nickname, password);

		if (emp != null) {
			resp.getWriter().write("登录成功, 3s后跳转到操作页面");
			resp.setHeader("refresh", "3;url=/emss/caozuo.jsp");
			return;
		} else {
			resp.getWriter().write("账号或密码有误, 请检查后登录");
			resp.setHeader("refresh", "3;url=/emss/login.jsp");
		}
	}

}
