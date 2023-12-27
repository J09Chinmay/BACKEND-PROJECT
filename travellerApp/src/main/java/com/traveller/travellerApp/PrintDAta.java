// package com.traveller.travellerApp;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;

// public class PrintDAta {
// private final String url = "jdbc:postgresql://localhost/postgres";
// private final String user = "postgres";
// private final String password = "chinmay09";

// public Connection connect() throws SQLException {
// return DriverManager.getConnection(url, user, password);
// }

// public void getStates() {

// String SQL = "SELECT * FROM state";

// try (Connection conn = connect();
// Statement stmt = conn.createStatement();
// ResultSet rs = stmt.executeQuery(SQL)) {
// displayState(rs);
// } catch (SQLException ex) {
// System.out.println(ex.getMessage());
// }
// }

// private void displayState(ResultSet rs) throws SQLException {
// while (rs.next()) {
// // System.out.println(rs.getString("popular_place"));
// System.out.println(rs.getString("pincode"));
// }
// }

// public static void main(String[] args) {
// PrintDAta printData = new PrintDAta();
// printData.getStates();
// }
// }
