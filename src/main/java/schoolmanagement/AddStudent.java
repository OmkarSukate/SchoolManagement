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

@WebServlet("/addstudent")
public class AddStudent extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id=(String)req.getParameter("id");
		int id1=Integer.parseInt(id);
		String name=(String)req.getParameter("name");
		String fees=(String)req.getParameter("fees");
		double fees1=Double.parseDouble(fees);
		String stream=(String)req.getParameter("stream");
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Omkar");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Student070 s=new Student070();
		s.setId(id1);
		s.setName(name);
		s.setStream(stream);
		s.setFees(fees1);
		
		et.begin();
		em.persist(s);
		et.commit();
		
		PrintWriter pw=resp.getWriter();
		pw.write("Student added");
		
		RequestDispatcher rd=req.getRequestDispatcher("studentvalidationnew.html");
		rd.include(req, resp);
		resp.setContentType("text/html");
		
	}
}
