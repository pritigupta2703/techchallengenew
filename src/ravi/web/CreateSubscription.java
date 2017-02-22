package ravi.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import ravi.model.Suscription;
import ravi.model.TestJson;
import ravi.model.User;
import ravi.services.Auth;

@WebServlet(name = "CreateSubscription")
public class CreateSubscription extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        String eventUrl = (String) request.getParameter("eventUrl");
        
        PrintWriter out = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        
        Suscription sc = new Suscription ("789xyz" ,"true");
        
        System.out.println("****************"+eventUrl);
        
       String data = Auth.getJsonDataFromEventUrl(eventUrl);
        
       System.out.println(data);
        
        String json = mapper.writeValueAsString(sc);
        
        out.print(json);
    
     

    }
	
	
    }


	


