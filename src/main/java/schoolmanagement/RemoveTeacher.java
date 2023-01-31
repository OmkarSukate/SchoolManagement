package schoolmanagement;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/remove1")
public class RemoveTeacher extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		String id=(String)req.getParameter("id");
		int id1=Integer.parseInt(id);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Omkar");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Teacher s=em.find(Teacher.class, id1);
		et.begin();
		em.remove(s);
		et.commit();
		
		PrintWriter pw=resp.getWriter();
		pw.write("Removed");
		resp.setContentType("text/html");
		
		RequestDispatcher rd=req.getRequestDispatcher("Teachervalidation.html");
		rd.include(req, resp);
	}
}
