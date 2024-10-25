package usermanagement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("username");
		String password = request.getParameter("password");

		if (name.isEmpty() || password.isEmpty()) {
			response.sendRedirect("login.jsp");
		} else {
			try {
				Connection con = Connector.getConnect();

				String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, name);
				stmt.setString(2, password);

				ResultSet rs = stmt.executeQuery();

				if (rs.next()) {
					HttpSession session = request.getSession();
					session.setAttribute("username", name);
					session.setAttribute("role", rs.getString("role"));
					String role = rs.getString("role");
					if (role.equals("admin")) {
						response.sendRedirect("createSoftware.jsp");
					} else if (role.equals("employee")) {
						response.sendRedirect("requestAccess.jsp");
					} else {
						response.sendRedirect("pendingRequests.jsp");
					}
				} else {
					request.setAttribute("error", "Username or password invalid");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}

			} catch (SQLException | ClassNotFoundException e) {
				e.getStackTrace();
			}
		}
	}

}
