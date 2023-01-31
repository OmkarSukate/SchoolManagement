package schoolmanagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Student1Driver extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name1=req.getParameter("name");
		String pass1=req.getParameter("password");
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Omkar");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Query q=em.createQuery("select a from Principal a where a.name=?1 and a.password=?2");
		q.setParameter(1, name1);
		q.setParameter(2, pass1);
		
		List<Principal> p1=q.getResultList();
		if(p1.size()>0) {
			RequestDispatcher rd=req.getRequestDispatcher("student07.html");
			rd.forward(req, resp);
		}
		else {
		
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.forward(req, resp);
			
		}
	}
}
