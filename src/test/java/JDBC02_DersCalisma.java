import java.sql.*;

public class JDBC02_DersCalisma {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");
        Statement st = con.createStatement();

        // mart_satislar tablosunu siliniz

    //    String dropTable = "DROP TABLE mart_satislar";
    //    if (!st.execute(dropTable)){
    //        System.out.println("mart_satislar tablosu basariyla silindi!");
    //    }else {
    //        System.out.println("mart_satislar tablosu silinemedi!");
    //    }

        /*
        mart_satislar adinda bir tablocreate ediniz
        urun_id 'si int,   musteri_isim varchar,     urun_isim varchar,        urun_fiyat int
         */

    //    String createTable = "CREATE TABLE mart_satislar(urun_id INT, musteri_isim VARCHAR(20), urun_isim VARCHAR(10), urun_fiyat INT)";

    //    if (!st.execute(createTable)){
    //        System.out.println("mart_satislar tablosu create edildi!");
    //    }else {
    //        System.out.println("mart_satislar tablosu create edilemedi !!");
    //    }

        /*
        tabloya asagidaki bilgileri ekleyelim
        INSERT INTO mart_satislar VALUES (10, 'Ali', 'Honda',75000);
        INSERT INTO mart_satislar VALUES (10, 'Ayse', 'Honda',95200);
        INSERT INTO mart_satislar VALUES (20, 'Hasan', 'Toyota',107500);
        INSERT INTO mart_satislar VALUES (30, 'Mehmet', 'Ford', 112500);
        INSERT INTO mart_satislar VALUES (20, 'Ali', 'Toyota',88000);
        INSERT INTO mart_satislar VALUES (10, 'Hasan', 'Honda',150000);
        INSERT INTO mart_satislar VALUES (40, 'Ayse', 'Hyundai',140000);
        INSERT INTO mart_satislar VALUES (20, 'Hatice', 'Toyota',60000);
         */

    //    String [] insertVeri ={"INSERT INTO mart_satislar VALUES (10, 'Ali', 'Honda',75000)",
    //                           "INSERT INTO mart_satislar VALUES (10, 'Ayse', 'Honda',95200)",
    //                           "INSERT INTO mart_satislar VALUES (20, 'Hasan', 'Toyota',107500)",
    //                           "INSERT INTO mart_satislar VALUES (30, 'Mehmet', 'Ford', 112500)",
    //                           "INSERT INTO mart_satislar VALUES (20, 'Ali', 'Toyota',88000)",
    //                           "INSERT INTO mart_satislar VALUES (10, 'Hasan', 'Honda',150000)",
    //                           "INSERT INTO mart_satislar VALUES (40, 'Ayse', 'Hyundai',140000)",
    //                           "INSERT INTO mart_satislar VALUES (20, 'Hatice', 'Toyota',60000);"};


    //    for (String each:insertVeri) {
    //            st.addBatch(each);
    //    }
    //    st.executeBatch();
    //    System.out.println("Veriler eklendi");


        //mart_satislar tablosundaki urun_fiyat'i 100.000' den dusuk olan urunlerin fiyatlarina %10 zam yapiniz.

        //String updateVeri = "UPDATE mart_satislar SET urun_fiyat=urun_fiyat*1.1 WHERE urun_fiyat<100000";
        //int degisiklik = st.executeUpdate(updateVeri);
        //System.out.println(degisiklik + " satirda degisiklik yapildi");


        //son olarak da mart_satislar listesdeki tum bilgileri getiriniz

        String sorgu = "SELECT * FROM mart_satislar";
        ResultSet veri = st.executeQuery(sorgu);

        while (veri.next()){
            System.out.println(veri.getInt(1)+" " +veri.getString(2)+" "+
                    veri.getString(3)+" "+veri.getInt(4));
        }
        con.close();
        st.close();
        veri.close();
    }
}
