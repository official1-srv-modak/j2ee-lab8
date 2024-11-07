import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class FeedController
 */
@WebServlet("/FeedController")
public class FeedController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String jsonPath = getServletContext().getRealPath("/WEB-INF/feeds.json");

        try {
            List<Feed> feedList = FeedParser.parseFeeds(jsonPath);

            request.setAttribute("feeds", feedList);

            String viewType = request.getParameter("viewType");
            if ("custom".equals(viewType)) {
                request.getRequestDispatcher("/WEB-INF/views/feedListCustomTag.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/WEB-INF/views/feedListJSTL.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error loading feeds.");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
