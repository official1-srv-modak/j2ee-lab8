import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;

public class FeedTag extends SimpleTagSupport {
    private List<Feed> items;

    public void setItems(List<Feed> items) {
        this.items = items;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();

        if (items != null) {
            for (Feed feed : items) {
                out.println("<h3>" + feed.getTitle() + "</h3>");
                out.println("<p>" + feed.getDescription() + "</p>");
                out.println("<small>" + feed.getDate() + "</small>");
                out.println("<hr/>");
            }
        }
    }
}
