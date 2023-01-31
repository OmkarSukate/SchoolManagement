package schoolmanagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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

@WebServlet("/update")
public class UpdateStudentDriver extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=(String)req.getParameter("id");
		int id1=Integer.parseInt(id);
		String name=(String)req.getParameter("name");
		String stream=(String)req.getParameter("stream");
		String fees=(String)req.getParameter("fees");
		double fees1=Double.parseDouble(fees);
		
		//List<Student070> s=new ArrayList<Student070>();
		
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("Omkar");
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			
			Student070 s1=new Student070();
			s1.setId(id1);
			s1.setName(name);
			s1.setStream(stream);
			s1.setFees(fees1);
			
			et.begin();
			em.merge(s1);
			et.commit();
			
			PrintWriter pw=resp.getWriter();
			pw.write("Student updated");
			
			RequestDispatcher rd=req.getRequestDispatcher("studentvalidation.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
			
		
	}
}
