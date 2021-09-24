package Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.account;
import DAO.LoginDAO;
import DB.DBConnection;

/**
 * Servlet implementation class SignUpController
 */
@WebServlet("/SignUpController")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getCharacterEncoding()==null)
		{
			request.setCharacterEncoding("UTF-8");
		}
		
		Connection conn = DBConnection.CreateConnection();
		
		
		String username = request.getParameter("name");
		
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		boolean check = LoginDAO.checkaccount(username, conn, request);
		
		if(check)
		{
			account account  = new account();
			account.setUsername(username);
			account.setPassword(pass);
			account.setEmail(email);
			boolean test1 = LoginDAO.InsertAccount(request, conn,account );
			
			if (test1) {
				
				request.setAttribute("mgsregister", "register success");
				
			}
		}
		

	
		else {
			request.setAttribute("mgsregister", "register Faild because the account is already registered ");
			
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/signup.jsp");
		rd.forward(request, response);
	}

}
