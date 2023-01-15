import java.sql.*;

public class JDBC01_Query3 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");
        Statement st = con.createStatement();

       /*
       id INT PRIMARY KEY,
		isim VARCHAR(50),
		sehir VARCHAR(50),
		maas INT,
		sirket VARCHAR(20)
        */

        // -- sirketi honda olan calisanlarin listesini olusturunuz
        ResultSet veri =st.executeQuery("SELECT *\n" +
                "    FROM calisanlar\n" +
                "    WHERE sirket='Honda';");

        while (veri.next()){
            System.out.println( veri.getInt("id")+" "+veri.getString("isim")+" "+veri.getString("sehir")+
                    " "+veri.getInt("maas")+" "+veri.getString("sirket"));
        }
        con.close();
        st.close();
        veri.close();
    }
}
