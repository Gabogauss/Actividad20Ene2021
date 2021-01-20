package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest peticion,
			HttpServletResponse respuesta)
		throws ServletException, IOException{
		String nombre=peticion.getParameter("nombre");
		String apellido=peticion.getParameter("apellido");
		String correo=peticion.getParameter("correo");
		int edad=Integer.parseInt(peticion.getParameter("edad"));
		String varcorreo="";
		//decision sobre edad
		if(edad>17) {
			varcorreo=correo;
		}else {
			varcorreo="El sujeto es menor de edad, no podemos mostrar su correo.";
		}
		
		
		peticion.getSession().setAttribute("nombre", nombre);
		peticion.getSession().setAttribute("apellido", apellido);
		peticion.getSession().setAttribute("varcorreo", varcorreo);
		respuesta.sendRedirect("index.jsp");
	}

}
