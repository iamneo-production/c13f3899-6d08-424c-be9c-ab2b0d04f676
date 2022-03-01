package controller;
import java.io.IOException;
import java.sql.*;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ZodiacDao;
import model.User;

@WebServlet("/")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			case "/list":
				listUser(request, response);
				break;
			case "/findPage":
				findPage(request, response);
			    break;
			case "/findUser":
			     findUser(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response)  throws SQLException,ServletException, IOException {


		String userName = request.getParameter("userName");
		String userBirthDate = request.getParameter("userBirthDate");
		String userBirthTime = request.getParameter("userBirthTime");
	    String userDistrict = request.getParameter("userDistrict");
		String userId = request.getParameter("userId");

		System.out.println("********"+userName);
		User newUser = new User(userName,userBirthDate,userBirthTime,userDistrict);
		newUser.setUserId(Integer.parseInt(userId));
		ZodiacDao.updateUser(newUser);
	//	response.sendRedirect("list.jsp");
	request.setAttribute("user", newUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
	
			dispatcher.forward(request, response);


    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException,ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println("id" +id);
		int userId  = Integer.parseInt(id);
		User user =  ZodiacDao.viewUserById(userId);
		System.out.println("user" +user);
		request.setAttribute("user", user);
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("editPage.jsp");
			dispatcher.forward(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)  throws SQLException,ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println("id" +id);
		int userId  = Integer.parseInt(id);
		 ZodiacDao.deleteUser(userId);
		 request.setAttribute("msg", "");
		 RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");	
		 dispatcher.forward(request, response);

    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException,ServletException, IOException {
    
	
		String userName = request.getParameter("userName");
		String userBirthDate = request.getParameter("userBirthDate");
		String userBirthTime = request.getParameter("userBirthTime");
	    String userDistrict = request.getParameter("userDistrict");
		System.out.println("********"+userName);
		User newUser = new User(userName,userBirthDate,userBirthTime,userDistrict);
		ZodiacDao.addUser(newUser);
	//	response.sendRedirect("list.jsp");
	request.setAttribute("msg", "User Created Succefully.. ");
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
	
			dispatcher.forward(request, response);
		
	
	}
	private void findUser(HttpServletRequest request, HttpServletResponse response) throws SQLException,ServletException, IOException {
    
	
		String userName = request.getParameter("userName");
		String userBirthDate = request.getParameter("userBirthDate");
		String userBirthTime = request.getParameter("userBirthTime");
	    String userDistrict = request.getParameter("userDistrict");

		User user = new User(userName,userBirthDate,userBirthTime,userDistrict);
		
		int id = ZodiacDao.findUser(user);
		user =  ZodiacDao.viewUserById(id);

		request.setAttribute("user", user);
		if(id==0) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("findPage.jsp?msg=nodata");
			dispatcher.forward(request, response);
		}else {
		RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
		dispatcher.forward(request, response);
		}
	}
	
	private void findPage(HttpServletRequest request, HttpServletResponse response) throws SQLException,ServletException, IOException {
    
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("findPage.jsp");
		dispatcher.forward(request, response);
	
	}
  
    
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				request.setAttribute("msg", "");
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}
	
	

    private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> listUser = ZodiacDao.list();
		request.setAttribute("users", listUser);
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("findPage.jsp");
		dispatcher.forward(request, response);
	}

	}