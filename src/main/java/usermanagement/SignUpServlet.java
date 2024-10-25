package usermanagement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public SignUpServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");

		if (userName.isEmpty() || password.isEmpty()) {
			response.sendRedirect("signup.jsp");
		} else {
			try {
				Connection con = Connector.getConnect();
				
				String sqlQu = "INSERT INTO users (username,password,role) VALUES(?,?,?)";
				PreparedStatement ps = con.prepareStatement(sqlQu);
				ps.setString(1, userName.toLowerCase());
				ps.setString(2, password);
				ps.setString(3, role);

				ps.executeUpdate();

				if (role.equals("employee")) {
					response.sendRedirect("requestAccess.jsp");
				} else if (role.equals("admin")) {
					response.sendRedirect("createSoftware.jsp");
				} else if (role.equals("manager")) {
					response.sendRedirect("pendingRequests.jsp");
				}

			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
