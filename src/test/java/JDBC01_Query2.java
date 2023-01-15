import java.sql.*;

public class JDBC01_Query2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");
        Statement st = con.createStatement();

        /*=============================ORNEK 2==========================================
         ORNEK2: Ankara'da yasayan calisanlarin isim ve maaslarini  maas ters
          sirali olarak listeleyiniz.
        ========================================================================*/
        ResultSet veri =st.executeQuery("SELECT isim, maas FROM calisanlar WHERE sehir='Ankara' ORDER BY maas DESC");

        while (veri.next()){
            System.out.println(veri.getString("isim")+" " +veri.getInt("maas"));
        }


         /*=======================================================================
          ORNEK3: Maasi en yuksek 3 kisinin adini, yasadigi sehri ve maasini
           maas sirali listeyiniz.
        ========================================================================*/


        System.out.println("=====================ORNEK3==================================");

        String sorgu ="SELECT isim, sehir, maas FROM calisanlar ORDER BY maas DESC LIMIT 3";
        ResultSet veri2 = st.executeQuery(sorgu);
        while (veri2.next()){
            System.out.println(veri2.getString(1)+" "+veri2.getString(2)+" "+veri2.getInt(3));
        }

        /*
        not1 : Sorgulama icin get ile istenirse sütun (field) ismini yazabilecegimiz gibi sutun index
        (field olusturulma sirasina gore) yazilabilir.
        not2 : sorgunuzda select'ten sonra sadece belli fieldlari dondurmasini istiyorsak
        get ile cagirdigimiz field indexleri sorguda belirttiginiz sirayla ifae etmemiz lazim
         */

        con.close();
        st.close();
        veri.close();
        veri2.close();
    }
}
