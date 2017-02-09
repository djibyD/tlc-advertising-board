package servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		this.getServletContext().getRequestDispatcher( "/WEB-INF/mainBoard.jsp" ).forward(req, resp );
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		String title = req.getParameter("title");
	    String price = req.getParameter("price");
	    DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
	    Date date = null;
	    try {
			date = formatter.parse(req.getParameter("date"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   Add add = new Add(title, price, date);
	   ObjectifyService.ofy().save().entity(add).now();
	}
	

}
