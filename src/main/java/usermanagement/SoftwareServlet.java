package usermanagement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SoftwareServlet
 */
@WebServlet("/SoftwareServlet")
public class SoftwareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SoftwareServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String softwarename = request.getParameter("softwareName");
		String description = request.getParameter("description");
		String accessLevel = request.getParameter("accessLevels");

		try {
			Connection con = Connector.getConnect();
			String sql = "INSERT INTO software(software_name,description,access_levels) VALUES (?,?,?)";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, softwarename);
			ps.setString(2, description);
			ps.setString(3, accessLevel);
			ps.executeUpdate();

			request.setAttribute("software"," Created Successfully");
			request.getRequestDispatcher("createSoftware.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
