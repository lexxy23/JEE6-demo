/**
 *
 */
package ext.demo.jee6.webapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A simple hello world Servlet.
 *
 * @author  dstrauss
 */
@WebServlet(
    name = "s1",
    urlPatterns = { "/s1" },
    loadOnStartup = 1
)
public class ServiceServlet extends HttpServlet {

    /**
     * The svuid.
     */
    private static final long serialVersionUID = 991469417704817184L;

    /**
     * The target encoding.
     */
    private String targetEncoding = "utf-8";

    /**
     * Inits the servlet.
     */
    public ServiceServlet() {
        // nothing to do
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
        StringBuffer sb = new StringBuffer();
        sb.append("Hello, world");
        arg1.setContentType("text/plain");
        arg1.setCharacterEncoding(targetEncoding);
        ServletOutputStream sos = arg1.getOutputStream();
        sos.write(sb.toString().getBytes(targetEncoding));
    }
}
