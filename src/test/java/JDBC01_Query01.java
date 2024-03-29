
import java.sql.*;

public class JDBC01_Query01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1- ilgili driver'i yuklemeliyiz  - MySQL kullandigimizi bildiriyoruz
        // driver'i bulamama ihtimaline karsi forname methodu benden
        //ClassNotFoundException icin main methoda exception firlatmami istiyor
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2-  baglantiyi olusturmak icin username ve password girisi yapmaliyiz
        // burada da username ve password'un yanlis olma ihtimaline karsi
        //getconnnetion methodu  SQLException firlatmami istiyor.
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");

        //3- SQL Query'leri icin bir Statement objesi olusturup javada kendimize SQL sorgulari icin bir alan acacagiz.

        Statement st = con.createStatement();

        //4- SQL sorgularini yazip, calistirabiliriz

        ResultSet veri =st.executeQuery("SELECT * FROM calisanlar");

        //5- sonuclari gormek icin Iteration ile Set icerindeki elemanlari while dongusu icerisinde yazdiracagiz.

        while (veri.next()){
            System.out.println(veri.getInt("id")+" "+ veri.getString("isim")+" "
            +veri.getString("sehir")+" "+veri.getInt("maas")+" "+veri.getString("sirket"));
        }

        //6- olusturulan neseneleri close() ile kapatiyoruz ki bellekten kaldiralim

        con.close();
        st.close();
        veri.close();
    }
}