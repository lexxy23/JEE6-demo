/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ext.demo.jee6.notify.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dstrauss
 */
@WebServlet(urlPatterns = {"/notify"}, asyncSupported = true)
public class WebNotifyEndpoint extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  }
  
}
