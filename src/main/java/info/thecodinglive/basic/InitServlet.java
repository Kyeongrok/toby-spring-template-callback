package info.thecodinglive.basic;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/init")
public class InitServlet extends HttpServlet {
    public void init(){
        System.out.println("init call");
    }
}
