



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

/**
 *
 * @author Melissa Case
 */
@WebServlet("/PopulateTable")
public class PopulateTable extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     *
     */
    public PopulateTable() {
        
    }
	
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		ArrayList<Books> books=new ArrayList<>();
		books=FetchData.getAllBooks();
		Gson gson = new Gson();
		JsonElement element = gson.toJsonTree(books, new TypeToken<List<Books>>() {}.getType());

		JsonArray jsonArray = element.getAsJsonArray();
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
		
	}

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
