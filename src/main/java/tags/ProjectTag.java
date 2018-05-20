package tags;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class ProjectTag extends SimpleTagSupport{

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.println("<div class=\"panel-group panels\">\n" +
                "                        <div class=\"panel panel-default\">\n" +
                "                            <div class=\"panel-heading\">\n" +
                "                                <h4 class=\"panel-title\">\n" +
                "                                    <a data-toggle=\"collapse\" href=\"#collapse1\">New Project Tag</a>\n" +
                "                                </h4>\n" +
                "                            </div>\n" +
                "                            <div id=\"collapse1\" class=\"panel-collapse collapse\">\n" +
                "                                <div class=\"panel-body\">Panel Body</div>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                    </div>");
    }
}
