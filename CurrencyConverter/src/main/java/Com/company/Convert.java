package Com.company;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/currency")
public class Convert extends HttpServlet{
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException 
	{

	PrintWriter out = response.getWriter();
	try {
	String s = request.getParameter("from-currency");
	String s1 = request.getParameter("To-currency");

	Double amount = Double.parseDouble(request.getParameter("amt"));
	 double res=0.0;
	 if(s.equals("Rupee")) {
		 if(s1.equals("Rupee")) {
			 res =1 *amount;
		 }
		 if(s1.equals("Doller")) {
			 res =0.012 *amount;
		 }
         if(s1.equals("euro")) {
        	 res =0.011 *amount;
		 }
         if(s1.equals("Canadian Dollar")) {
        	 res =0.016 *amount;
         }
         if(s1.equals("Australian Dollar")) {
        	 res =0.019 *amount;
         }
         if(s1.equals("Nepalese Rupee")) {
        	 res =1.60*amount;
         }
         if(s1.equals("Philippine Peso")) {
        	 res =0.68 *amount;
         }
       
	 }
    
	 if(s.equals("Doller")) {
		 if(s1.equals("Doller")) {
			 res = 1 *amount;
		 }
		 if(s1.equals("Rupee")) {
			 res = 83.24 *amount;
		 }
         if(s1.equals("euro")) {
        	 res =0.94 *amount;
		 }
         if(s1.equals("Canadian Dollar")) {
        	 res =1.35 *amount;
         }
         if(s1.equals("Australian Dollar")) {
        	 res =1.55 *amount;
         }
         if(s1.equals("Nepalese Rupee")) {
        	 res =133.29*amount;
         }
         if(s1.equals("Philippine Peso")) {
        	 res =56.79 *amount;
         }
       
	 }
	 if(s.equals("euro")) {
		 if(s1.equals("euro")) {
			 res = 1 *amount;
		 }
		 if(s1.equals("Rupee")) {
			 res = 88.96 *amount;
		 }
         if(s1.equals("Doller")) {
        	 res =1.07 *amount;
		 }
         if(s1.equals("Canadian Dollar")) {
        	 res =1.44 *amount;
         }
         if(s1.equals("Australian Dollar")) {
        	 res =1.65 *amount;
         }
         if(s1.equals("Nepalese Rupee")) {
        	 res =142.46*amount;
         }
         if(s1.equals("Philippine Peso")) {
        	 res =60.69 *amount;
         }
       
	 }
	 if(s.equals("Canadian Dollar")) {
		 if(s1.equals("Canadian Dollar")) {
			 res = 1 *amount;
		 }
		 if(s1.equals("Rupee")) {
			 res = 61.87 *amount;
		 }
         if(s1.equals("Doller")) {
        	 res =0.74 *amount;
		 }
         if(s1.equals("euro")) {
        	 res =0.70 *amount;
         }
         if(s1.equals("Australian Dollar")) {
        	 res =1.15 *amount;
         }
         if(s1.equals("Nepalese Rupee")) {
        	 res =99.09*amount;
         }
         if(s1.equals("Philippine Peso")) {
        	 res =42.20 *amount;
         }
       
	 }
	 if(s.equals("Australian Dollar")) {
		 if(s1.equals("Australian Dollar")) {
			 res = 1 *amount;
		 }
		 if(s1.equals("Rupee")) {
			 res = 53.77 *amount;
		 }
         if(s1.equals("Doller")) {
        	 res =0.65  *amount;
		 }
         if(s1.equals("Canadian Dollar")) {
        	 res =0.87 *amount;
         }
         if(s1.equals("euro")) {
        	 res =0.60 *amount;
         }
         if(s1.equals("Nepalese Rupee")) {
        	 res =86.13*amount;
         }
         if(s1.equals("Philippine Peso")) {
        	 res =36.69 *amount;
         }
       
	 }
	 if(s.equals("Nepalese Rupee")) {
		 if(s1.equals("Nepalese Rupee")) {
			 res = 1 *amount;
		 }
		 if(s1.equals("Rupee")) {
			 res =0.62*amount;
		 }
         if(s1.equals("Doller")) {
        	 res =0.0075 *amount;
		 }
         if(s1.equals("Canadian Dollar")) {
        	 res =0.010 *amount;
         }
         if(s1.equals("Australian Dollar")) {
        	 res =0.012 *amount;
         }
         if(s1.equals("euro")) {
        	 res =0.0070*amount;
         }
         if(s1.equals("Philippine Peso")) {
        	 res =0.43 *amount;
         }
       
	 }
	 if(s.equals("Philippine Peso")) {
		 if(s1.equals("Philippine Peso")) {
			 res = 1 *amount;
		 }
		 if(s1.equals("Rupee")) {
			 res = 1.47 *amount;
		 }
         if(s1.equals("Doller")) {
        	 res =0.018 *amount;
		 }
         if(s1.equals("Canadian Dollar")) {
        	 res =0.024 *amount;
         }
         if(s1.equals("Australian Dollar")) {
        	 res =0.027 *amount;
         }
         if(s1.equals("Nepalese Rupee")) {
        	 res =2.35*amount;
         }
         if(s1.equals("euro")) {
        	 res =0.016 *amount;
         }
       
	 }

	out.println("<html>");
	out.println("<head>");
	out.println("<title>Servlet currency</title>");
	out.println("</head>");
	out.println("<body bgcolor='yellow'>");
	out.println("<h3>"+s+" "+amount+" "+"to "+s1+" "+res+"</h2>");
	out.println("</body>");
	out.println("</html>");


	} finally {
	out.close();
	}
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	processRequest(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	processRequest(request, response);
	}
	@Override
	public String getServletInfo() {
	return "Short description";
	}// </editor-fold>
	}

