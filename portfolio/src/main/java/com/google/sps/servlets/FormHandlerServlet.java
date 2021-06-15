package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;


@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the value entered in the form.
    String firstName = getParameter(request, "firstname", "");
    String lastName = getParameter(request, "lastname", "");
    String title = getParameter(request, "title", "");
    String subject = getParameter(request, "subject", "");
    //Create a datastore
    long timestamp = System.currentTimeMillis();
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("contactMe");
    FullEntity contactMeEntity = 
        Entity.newBuilder(keyFactory.newKey())
        .set("firstName", firstName)
        .set("lastName", lastName)
        .set("title", title)
        .set("subject", subject)
        .set("timestamp", timestamp)
        .build();
    datastore.put(contactMeEntity);

    response.sendRedirect("/index.html");
  }
    /**
   * @return the request parameter, or the default value if the parameter
   *         was not specified by the client
   */
  private String getParameter(HttpServletRequest request, String name, String defaultValue) {
    String value = request.getParameter(name);
    if (value == null) {
      return defaultValue;
    }
    return value;
  }
}