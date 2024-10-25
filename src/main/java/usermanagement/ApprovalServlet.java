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

/**
 * Servlet implementation class ApprovalServlet
 */
@WebServlet("/ApprovalServlet")
public class ApprovalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ApprovalServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		int requestId = Integer.parseInt(request.getParameter("id"));

        System.out.println("Request ID: " + requestId);

        try {
        	Connection conn = Connector.getConnect();
            // Get software details by ID
            String sqlSoftware = "SELECT * FROM software WHERE id = ?";
            PreparedStatement stmtSoftware = conn.prepareStatement(sqlSoftware);
            stmtSoftware.setInt(1, requestId);
            ResultSet rsSoftware = stmtSoftware.executeQuery();

            // Check if software with the ID exists
            if (!rsSoftware.next()) {
                int softwareId = rsSoftware.getInt("id"); // Assuming "id" is the column name in software table
//                String accessType = request.getParameter("accessType"); // Assuming accessType comes from the request
//                String reason = request.getParameter("reason");  // Assuming reason comes from the request

                // Insert access request into the database
                String sqlRequest = "INSERT INTO requests (user_id, software_id, access_type, reason, status) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement stmtRequest = conn.prepareStatement(sqlRequest);
                // Assuming user ID is retrieved elsewhere (session, form data, etc.)
                stmtRequest.setInt(1, softwareId ); 
                stmtRequest.setInt(2, softwareId);
//                stmtRequest.setString(3, accessType);
//                stmtRequest.setString(4, reason);
                stmtRequest.setString(5, "pending");
                stmtRequest.executeUpdate();

                response.sendRedirect("requestAccess.jsp");
            } else {
                throw new SQLException("Software not found");
            }
            response.sendRedirect("requestAccess.jsp");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
		
	}
}
