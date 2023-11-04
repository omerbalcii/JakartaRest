package com.bilgeadam.jakartarest;

import jakarta.ws.rs.ApplicationPath;

// @WebServlet(urlPatterns = "hello")
@ApplicationPath(value = "/")
public class Application extends jakarta.ws.rs.core.Application // extends HttpServlet
{
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
//	{
//		super.doGet(req, resp);
//	}
}