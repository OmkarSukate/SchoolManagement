package schoolmanagement;

import java.io.IOException;
import java.io.PipedWriter;
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

@WebServlet("/accountcreated")
public class AccountCreated extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=(String)req.getParameter("id");
		int id1=Integer.parseInt(id);
		String name=(String)req.getParameter("name");
		String email=(String)req.getParameter("email");
		String age=req.getParameter("age");
		int age1=Integer.parseInt(age);
		String mobno=(String)req.getParameter("mobno");
		long mobno1=Long.parseLong(mobno);
		String password=req.getParameter("password");
		
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Omkar");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		
		Principal p=new Principal();
		p.setId(id1);
		p.setName(name);
		p.setEmail(email);
		p.setAge(age1);
		p.setMobno(mobno1);
		p.setPassword(password);
		
		et.begin();
		em.persist(p);
		et.commit();
		
		PrintWriter pw=resp.getWriter();
		pw.write("Account created");
		
		RequestDispatcher rd=req.getRequestDispatcher("login.html");
		rd.include(req, resp);
		resp.setContentType("text/html");
		
	
	}
}
