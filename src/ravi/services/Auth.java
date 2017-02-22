package ravi.services;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.codehaus.jackson.map.ObjectMapper;

import Dao.AuthDao;
import models.Beans;
import oauth.signpost.basic.DefaultOAuthConsumer;

public class Auth {
	
	
	static AuthDao dao;
	static{
		dao = new AuthDao();
	}
	
	
	public static String getJsonDataFromEventUrl(String eventUrl) {
        String responseJson = "";

        try {
            DefaultOAuthConsumer e = new DefaultOAuthConsumer("techpriti-151942","r4RQ27ktItxK1o6y");
            URL url = new URL(eventUrl);
            HttpURLConnection request = (HttpURLConnection)url.openConnection();
            request.setRequestProperty("Accept", "application/json");
            e.sign(request);
            int responseCode = request.getResponseCode();
            System.out.println("Sending \'GET\' request to URL : {}"+ eventUrl);
            System.out.println("Response Code : {}" +  Integer.valueOf(responseCode));
            BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
            StringBuffer response = new StringBuffer();

            String inputLine;
            while((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();
            responseJson = response.toString();
            System.out.println("Response json from app direct server is - {}" +  responseJson);
            Beans bean = new Beans();
            bean = new ObjectMapper().readValue(responseJson, Beans.class);
            dao.createBean(bean);
            
        } 
        
        catch (Exception var) {
            System.out.println("Error fetching data from eventUrl - {}" + var.getMessage());
        }

        return responseJson;
}
}
