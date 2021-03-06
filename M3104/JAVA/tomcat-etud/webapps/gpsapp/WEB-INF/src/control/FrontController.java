package control;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import control.listeners.*;
import java.util.ArrayList;

/**
 *
 * @author lesommer
 */
public class FrontController extends HttpServlet {

	private ArrayList<UrlMapping> rules=new ArrayList<UrlMapping>();
	private ApplicationController appController;

    public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ServletContext sc = getServletContext();
		if(sc.getAttribute("ApplicationController") == null) {
		    this.appController = ApplicationController.getInstance();
		    sc.setAttribute("ApplicationController", this.appController);
			rules.add(new UrlMapping("main",null,"/jsp/MainView.jsp"));
			rules.add(new UrlMapping("error",null,"/jsp/Error.jsp"));
			rules.add(new UrlMapping("journey_list", new JourneyListListener(), "/jsp/JourneyListView.jsp"));
			rules.add(new UrlMapping("journey", new JourneyListener(), "/jsp/JourneyView.jsp"));
			rules.add(new UrlMapping("journey_form", null, "/jsp/JourneyFromView.jsp"));
			rules.add(new UrlMapping("journey_add", new JourneyAddListener() , "/jsp/JourneyAddView.jsp"));
			rules.add(new UrlMapping("coordinate_form", new CoordinateFormListener(), "/jsp/CoordinateFormView.jsp"));
            rules.add(new UrlMapping("coordinate_add", new CoordinateAddListener(), "/jsp/CoordinateAddView.jsp"));

		    this.appController.setRules(rules);
		}
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response)
  	throws IOException, ServletException {
  		this.processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
   		this.processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request,  HttpServletResponse response)
	throws IOException, ServletException {
    	this.appController.processRequest(request, response, getServletContext());
	}

}
