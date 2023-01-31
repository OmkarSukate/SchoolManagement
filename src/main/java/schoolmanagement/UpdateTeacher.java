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

@WebServlet("/updateteacher")
public class UpdateTeacher extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=(String)req.getParameter("id");
		int id1=Integer.parseInt(id);
		String name=(String)req.getParameter("name");
		String sal=(String)req.getParameter("sal");
		double sal1=Double.parseDouble(sal);
		String sub=(String)req.getParameter("subject");
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Omkar");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Teacher s=new Teacher();
		s.setId(id1);
		s.setName(name);
		s.setSubject(sub);
		s.setSal(sal1);
		
		et.begin();
		em.merge(s);
		et.commit();
		
		PrintWriter pw=resp.getWriter();
		pw.write("Student added");
		
		RequestDispatcher rd=req.getRequestDispatcher("Teachervalidation.html");
		rd.include(req, resp);
		resp.setContentType("text/html");
	}
}
