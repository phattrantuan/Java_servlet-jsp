package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CheckedDataDAO;
import DAO.DetailsReadExcelDAO;
import DAO.detailsExamExcelDAO;
import DB.DBConnection;

/**
 * Servlet implementation class addFileExcel_Read
 */
@WebServlet("/addFileExcel_Read")
public class addFileExcel_Read extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addFileExcel_Read() {
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
		int id = Integer.parseInt(request.getParameter("idexam"));
		String address = request.getParameter("address");
		
		boolean check = DetailsReadExcelDAO.ImportExcel(request, response, conn, address, id); 
		
		if(check) {
			CheckedDataDAO.CheckedRead(request, conn, id);
			
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
