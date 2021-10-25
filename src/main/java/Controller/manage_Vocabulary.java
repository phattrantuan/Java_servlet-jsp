package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Bean.vocabulary;
import DAO.HomeDAO;

import DAO.PaginationDAO;
import DAO.manageVocabularyDAO;
import DB.DBConnection;

/**
 * Servlet implementation class manage_Vocabulary
 */
@WebServlet("/manage_Vocabulary")
public class manage_Vocabulary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public manage_Vocabulary() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
Connection conn = DBConnection.CreateConnection();
		
		String getcurrentpage = request.getParameter("pageid");
	
		int currentpage = Integer.parseInt(getcurrentpage);

		int currentpag1 = Integer.parseInt(request.getParameter("pageid"));
		
		
	int total_record = HomeDAO.countslider(conn,"vocabulary");
		
		int totalItemsPerPage = 4;
	
		
		
		int totalpage = total_record/totalItemsPerPage;
		int totalpagecheck = total_record%totalItemsPerPage;
		if(totalpagecheck>0)
		{
			totalpage=totalpage+1;
		}
		
		
		
		if(currentpage > totalpage)
		{
			currentpage = totalpage;
		}
		else if (currentpage <1) {
			currentpage= 1;
			
		}
		else {	
		}

		int start = (currentpage-1)*totalItemsPerPage;

		//List<Emp> list = QuizDAO.selectAnswser(1,3 , conn);
		List<vocabulary> listTitle =PaginationDAO.selectVocabulary(start, totalItemsPerPage, conn, request);
		
		
		
		
		
	request.setAttribute("listvocalbulary", listTitle);		
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("totalpage",totalpage);
		request.setAttribute("pageid",getcurrentpage);
		request.setAttribute("currentpag1",currentpag1);

		
		

		
		
		
RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Admin/manageVocabulary.jsp");
		rd.forward(request, response);
		
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

		String title = request.getParameter("titleExam");
		
		//String content = request.getParameter("content");
		
		vocabulary voc= new vocabulary();
		voc.setVocabularyname(title);
		
		

		boolean test= manageVocabularyDAO.InsertVocabulary(request, conn, voc);
		
		
		if (test) {
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Admin/addimageVocabulary.jsp");
			rd.forward(request, response);
			
		}
		else {
			request.setAttribute("mgsregister", "register Faild");
			
		}
	}

}
