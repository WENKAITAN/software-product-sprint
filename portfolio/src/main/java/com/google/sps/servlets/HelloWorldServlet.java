package com.google.sps.servlets;


import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {
  
  String fact[] = new String[2];
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    fact[0] = " { \"hobby\" : \"i love basketball\" }";
    fact[1] = " { \"quote\" : \"My favorite quote is Being the richest man in the cemetery doesn’t matter to me. Going to bed at night saying we’ve done something wonderful… that’s what matters to me.\" }";
    // Convert the server stats to JSON
    String json = "[" + fact[0] + "," + fact[1] + "]";
    response.setContentType("application/json");
    response.getWriter().println(json);

  }
}
