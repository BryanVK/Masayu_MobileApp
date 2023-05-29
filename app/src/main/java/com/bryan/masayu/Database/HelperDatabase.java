package com.bryan.masayu.Database;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.bryan.masayu.Cart;
import com.bryan.masayu.Food;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HelperDatabase extends SQLiteOpenHelper {

    public static final String DBNAME = "data.db";

    public HelperDatabase(@Nullable Context context) {
        super(context, "data.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE MsUsers(email TEXT PRIMARY KEY, username TEXT, password TEXT)");
        db.execSQL("CREATE TABLE cart(cartID INTEGER PRIMARY KEY AUTOINCREMENT, foodID INTEGER, userEmail TEXT)");
        db.execSQL("CREATE TABLE MsFoods(foodID INTEGER PRIMARY KEY, foodName TEXT, price INTEGER, image TEXT, description TEXT, ingredients TEXT, step TEXT)");
        db.execSQL("INSERT INTO MsUsers VALUES('bryan@gmail.com', 'bvk', '123Bryan')");

        db.execSQL("INSERT INTO MsFoods VALUES(1, 'Soto Betawi', 20000, 'https://asset.kompas.com/crops/4cHVRsPOm6gAvoT1bCGBQNnxFlk=/0x0:1000x667/750x500/data/photo/2022/04/17/625be6a0e520b.jpg'" +
                ", 'Soto Betawi merupakan soto yang khas dari daerah DKI Jakarta. Seperti halnya Soto Madura dan Soto Sulung, soto Betawi juga menggunakan jeroan. Selain jeroan, sering kali organ-organ lain juga disertakan, seperti mata, terpedo, dan juga hati.'" +
                ",'500g jerohan (usus, paru, dan babat)\n" +
                "500g daging sapi skengkel (paha atas)\n" +
                "2 buah kentang, dikupas, dibelah 4 bagian, dan digoreng\n" +
                "2 batang serai, dimemarkan\n" +
                "3 lembar daun salam\n" +
                "3 lembar daun jeruk\n" +
                "1½ liter santan sedang kentalnya\n" +
                "2 sdm air jeruk limo\n" +
                "2 sdm bawang goreng\n" +
                "1 batang daun bawang diiris halus\n" +
                "1 buah tomat dipotong 8 bagian\n" +
                "1 sdm daun sledri dirajang halus\n" +
                "1 batang kayu manis\n" +
                "1 sdt garam\n" +
                "1 sdm gula\n" +
                "minyak untuk menumis\n" +
                "emping melinjo goreng\n" +
                "Bumbu yang dihaluskan:\n" +
                "3 siung bawang putih\n" +
                "7 buah bawang merah\n" +
                "3 butir kemiri\n" +
                "2 sdt jintan\n" +
                "2 sdt lada\n" +
                "3 sdt ketumbar'" +
                " , 'Bersihkan jerohan, kemudian rebus hingga ¾ empuk. Angkat dan sisihkan.\n" +
                "Rebus santan hingga mendidih dengan api kecil. Masukkan jeroan dan daging. Rebus kembali hingga keduanya matang.\n" +
                "Tumis bumbu yang dihaluskan hingga harum dan matang. Masukkan serai, daun salam, daun jeruk, dan kayu manis. Setelah bumbu benar-benar harum dan matang, masukkan jeroan, daging, garam, dan gula ke dalam rebusan.\n" +
                "Angkat jeroan dan daging. Potong-potong sesuai selera, lalu goreng. Sisihkan.\n" +
                "Cara menyajikan: Letakkan potongan kentang goreng, potongan jeroan dan daging, daun bawang, daun sledri, dan air jeruk limau di dasar mangkok. Siram dengan kuah soto. Terakhir, taburi dengan bawang goreng. Hidangkan dengan emping melinjo.' )");

        db.execSQL("INSERT INTO MsFoods VALUES (2, 'Sate Maranggi', 25000, 'https://asset.kompas.com/crops/FDAcmidsNYJDL80i55bj7pbXqyk=/95x0:939x563/750x500/data/photo/2022/07/10/62ca309364500.jpeg'," +
                " 'Sate maranggi (Sunda: ᮞᮒᮦ ᮙᮛᮀᮌᮤ, translit. Saté maranggi) adalah makanan asli Sunda di Indonesia yang biasa ditemukan di daerah Jawa Barat, khususnya Purwakarta. Sate maranggi merupakan makanan khas Sunda. Istilah maranggi sendiri dalam bahasa Sunda merupakan istilah petukangan, yakni \"seorang ahli pembuat sarung keris\".'," +
                " 'Bahan utama\n" +
                "\n" +
                "500\n" +
                "g daging sapi\n" +
                "5\n" +
                "lembar daun pepaya\n" +
                "1\n" +
                "sdm gula merah\n" +
                "2\n" +
                "sdm air asam jawa\n" +
                "5\n" +
                "sdm\n" +
                "Bango Kecap Manis Pedas\n" +
                "½\n" +
                "sdt\n" +
                "Royco Kaldu Sapi\n" +
                "½\n" +
                "sdt lada bubuk\n" +
                "2\n" +
                "sdm minyak sayur\n" +
                "Bumbu halus\n" +
                "\n" +
                "2\n" +
                "siung bawang putih\n" +
                "5\n" +
                "butir bawang merah\n" +
                "1\n" +
                "cm jahe\n" +
                "1\n" +
                "cm lengkuas\n" +
                "1\n" +
                "sdt ketumbar butiran\n" +
                "Bahan pelengkap\n" +
                "\n" +
                "5\n" +
                "sdm\n" +
                "Bango Kecap Manis Pedas\n" +
                "2\n" +
                "sdm bawang merah goreng', " +
                "'Balut daging menggunakan daun pepaya supaya empuk dan diamkan 30 menit" +
                "Blender bawang merah, bawang putih, ketumbar yang telah disangrai, jahe dan lengkuas. " +
                "Lalu, tumis hingga bumbu matang." +
                "Campurkan daging dengan bumbu yang telah ditumis, air asam jawa, lada, garam, sedikit minyak dan gula merah." +
                "Aduk hingga tercampur rata." +
                "Tusuk daging menggunakan tusuk sate.Potong kecil tomat dan cabe, " +
                "lalu campur dengan bahan sambal kecap lainnya, sisihkan." +
                "Bakar sate menggunakan api atau panggang menggunakan griller, sesekali diolesi dengan kecap manis." +
                "Bakar hingga matang dan siap disajikan dengan sambal kecap.')");

        db.execSQL("INSERT INTO MsFoods VALUES (3, 'Ayam Kalasan', 35000, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQORefokYNWhQ-VAawctuKyV584BBGLTzN4Yg&usqp=CAU'" +
                ", 'Ayam Gorèng Kalasan adalah masakan ayam goreng dengan bumbu khusus yang berasal dari daerah Kalasan, Sleman Yogyakarta.'" +
                ",'1 ekor ayam kampung muda (potong 4 bagian)\n" +
                "2 sdm air jeruk nipis\n" +
                "2 lembar daun salam\n" +
                "2 sdt bawang putih halus\n" +
                "500 ml air kelapa\n" +
                "30 gram gula merah (sisir halus)\n" +
                "1 sdm kecap manis\n" +
                "Secukupnya garam\n" +
                "Secukupnya minyak untuk menggoreng\n" +
                "Bumbu halus:\n" +
                "6 butir bawang merah\n" +
                "4 siung bawang putih\n" +
                "1/2 sdt merica butiran\n" +
                "1 cm lengkuas muda'" +
                ", 'Langkah 1\n" +
                "Lumuri ayam yg sdh dicuci bersih dg air jeruk nipis & bawang putih halus, diamkan 30 menit.\n" +
                "Langkah 2\n" +
                "Didihkan air kelapa, masukkan bumbu halus, garam, daun salam, kecap manis & gula merah, aduk rata, masukkan ayam, masak dg api kecil sampai air menyusut dan ayam empuk, angkat, tiriskan sampai ayam dingin.\n" +
                "Langkah 3\n" +
                "Goreng ayam dalam minyak panas sampai matang kecoklatan, angkat, tiriskan, sahikan segera dengan sambal dan lalapan.')");

        db.execSQL("INSERT INTO MsFoods VALUES (4, 'Nasi Ulam', 45000, 'https://asset.kompas.com/crops/zs7NJcZxVF6uPbLMbaR1jkBmg50=/3x0:700x465/750x500/data/photo/2020/12/04/5fca3186946ed.jpg'" +
                ", 'Nasi ulam adalah hidangan nasi yang dicampur berbagai bumbu dan rempah, khususnya daun pegagan (Centella asiatica) atau kadang diganti daun kemangi, sayuran, dan berbagai bumbu, serta ditemani beberapa macam lauk-pauk. '" +
                ",'3 cup beras cuci bersih\n" +
                "2 lembar daun salam\n" +
                "1 batang serai geprek\n" +
                "Seiris lengkuas cuci bersih\n" +
                "secukupnya Garam\n" +
                "Bahan serundeng:\n" +
                "300 gr kelapa parut\n" +
                "1 sdm bumbu putih halus (bawang merah + bawang putih + kemiri)\n" +
                "secukupnya Gula jawa\n" +
                "selera Garam dan kaldu bubuk sesua\n" +
                "1 lembar daun salam\n" +
                "1 batang serai\n" +
                "Sepotong lengkuas\n'" +
                ", 'Langkah 1\n" +
                "Masak nasi di magic com seperti biasa dengan tambahan bahan bahan terlampir\n" +
                "Langkah 2\n" +
                "Tumis bumbu putih, daun salam, lengkuas dan serai dengan sedikitminyak\n" +
                "Langkah 3\n" +
                "Setelah harum, masukkan gula jawa\n" +
                "Langkah 4\n" +
                "Masukkan kelapa parut, kecilkan api kompor, aduk terus sampai kering\n" +
                "Langkah 5\n" +
                "Masukkan garam dan kaldu bubuk sesuai selera, tes rasa\n" +
                "Langkah 6\n" +
                "Setelah serundeng kering, siap di sajikan. Bisa disimpan dalam wadah kedap udara, tunggu dingin\n" +
                "Langkah 7\n" +
                "Saran penyajian:\n" +
                "Nasi yang sudah matang di campir dengan serundeng. Siapkan lauk tambahan seperti telur dadar iris, bakwan, ayam goreng dan lainnya sesuai selera')");

        db.execSQL("INSERT INTO MsFoods VALUES (5, 'Mie Aceh', 55000" +
                ", 'https://asset.kompas.com/crops/7tBNI9-TCa-oOq8tQTahf0ua1fg=/0x0:968x645/750x500/data/photo/2021/01/27/6010ce2cc1805.jpg'" +
                ", 'Mi aceh adalah masakan mi pedas khas Aceh di Indonesia. Mie kuning tebal dengan irisan daging sapi, daging kambing atau makanan laut (udang dan cumi) disajikan dalam sup sejenis kari yang gurih dan pedas. '" +
                ",'1 bungkus mie lidi medan\n" +
                "1 iket sawi hijau cuci bersih dan potong-potong\n" +
                "Segenggam toge\n" +
                "2 batang Daun bawang\n" +
                "200 gr Udang buang kulitnya (untuk campuran di bumbu halus)\n" +
                "200 gr Udang Utuh Buang kotoran kepala nya (toping)\n" +
                "10 Bakso sapi potong lebar (toping)\n" +
                "5 sosis potong sering tebal (toping)\n" +
                "5 Cabai Rawit utuh (yg Orange)\n" +
                "Bumbu halus :\n" +
                "16 Bawang Merah\n" +
                "8 Bawang putih\n" +
                "8 kemiri\n" +
                "10 cabai merah\n" +
                "1 Ruas Jahe\n'" +
                ", 'Langkah 1\n" +
                "Blender semua bahan bumbu halus + Udang yang sudah dikupas kulit nya blender dengan campur minyak goreng baru (jangan menggunakan air y)\n" +
                "Langkah 2\n" +
                "Masak mie lidi dengan di rendam air banyak yang panas masak sampai matang.\n" +
                "Langkah 3\n" +
                "Tumis bumbu Halus sampai harum, masukkan udang masak sampai udang berubah warna hingga udang matang.\n" +
                "Langkah 4\n" +
                "Masukkan bakso, sosis aduk rata, tuang semua bumbu pelengkap, aduk rata.\n" +
                "Langkah 5\n" +
                "Masak sayuran sawi hijau dan toge aduk rata, masukkan mie lidi yang sudah direbus adu aduk sampai bumbu nya tercampur rata di mie nya dan terakhir masukkan daun bawang aduk rata, matikan api.\n')");

        db.execSQL("INSERT INTO MsFoods VALUES (6, 'Nasi Kapau', 35000, 'https://asset.kompas.com/crops/5BIcuJ3MRzfyTUzplb6kAwQZjyc=/109x0:954x563/750x500/data/photo/2022/04/01/6246d73c00ebe.jpg'" +
                ", 'Nasi Kapau adalah nasi ramas khas nagari Kapau, Tilatang Kamang, Kabupaten Agam, Sumatra Barat, yang berjarak 4 kilometer dari Kota Bukittinggi atau 74 kilometer dari Kota Padang.'" +
                ",'1 ikat kacang panjang\n" +
                "1/2 buah nangka muda di rebus dl\n" +
                "1 ons rebung bila ada, kl tdk ada tdk apa2\n" +
                "2 buah santan kara\n" +
                "Sedikit tetelan sapi bila ada gak ada jg gpp\n" +
                "Bumbu halus :\n" +
                "10 siung bawang merah\n" +
                "5 siung bawang putih\n" +
                "1 ons cabe keriting\n" +
                "8 buah cabe rawit bila suka pedas bs di tambah lagi\n" +
                "5 buah kemiri\n" +
                "1 ruas jahe\n" +
                "1,5 ruas kunyit\n" +
                "2 cm lengkuas\n" +
                "1/2 sdt ketumbar\n" +
                "1/4 sdt merica\n" +
                "Sedikit pala\n" +
                "Sedikit jinten'" +
                ", 'Langkah 1\n" +
                "Potong2 kacang panjang, dan rebus nangka dan rebung (krn aq pas gak ada rebung jadi gak ku kasih)\n" +
                "Langkah 2\n" +
                "Blender bumbu sampai halus, dan siapkan bumbu cemplung nya\n" +
                "Langkah 3\n" +
                "Lalu tumis bumbu nya dan masukkan jg bumbu cemplungnya, aduk2 rata sampai bau harum\n" +
                "Langkah 4\n" +
                "Setelah bau harum dan bumbu kelihatan sdh matang masukkan kacang panjang dan tetelan sapi sedikit\n" +
                "Langkah 5\n" +
                "Lalu tambahkan nangka yg sdh di rebus, aduk2 rata\n" +
                "Langkah 6\n" +
                "Tambah air secukupnya, masukkan garam, gula, kaldu bubuk\n" +
                "Langkah 7\n" +
                "Lalu masukkan santan kara aduk2 rata dan tes rasa\n" +
                "Langkah 8\n" +
                "Dan nasi kapau minang siap di hidangkan bersama gulai nangka, rendang, sambal ijo,rebusan daun singkong dan telor dadar padang')");

        db.execSQL("INSERT INTO MsFoods VALUES (7, 'Cuanki', 25000, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQjz6jYjJ5xg_Z3VZ1TCFsL8TZf9ErnbdJlUKkR5X7Cva8P8hGujvizsfElcYUlmwFbZrI&usqp=CAU'" +
                ", 'Cuanki merupakan salah satu jajanan yang populer dari kota Bandung yang berbahan dasar ikan, daging sapi, tepung tapioka, dan bumbu penyedap lainnya yang disajikan dengan kuah kaldu yang kuat berisi bakso, siomay kukus, siomay goreng, tahu goreng, dan tahu rebus dengan taburan bawang goreng dan daun seledri.'" +
                ",'250 gr Kerupuk udang (dipatahin dulu ya, rendam di air panas terlebih dahulu sampai agak mengembang)\n" +
                "4 siung bawang putih\n" +
                "1 jempol Kencur (1 jempol utuh ya, bukan ruasnya)\n" +
                "3 buah cabe rawit merah (bisa disesuaikan selera ya. Klo 3 buah ini pedes banget buat yg suka pedes biasa aja)\n" +
                "500 ml air\n" +
                "Minyak goreng untuk menumis\n" +
                "Penyedap rasa ayam/sapi/jamur\n" +
                "Vetsin (opsional)\n" +
                "Garam'" +
                ", 'Langkah 1\n" +
                "Haluskan bawang putih, kencur dan cabe rawit merah.\n" +
                "Langkah 2\n" +
                "Panaskan minyak goreng. Tumis bumbu halus sampai harum. Tuang rendaman kerupuk udang tambahkan air. Aduk rata.\n" +
                "Langkah 3\n" +
                "Bumbui dengan penyedap, vetsin dan garam. Tes rasa ya, sesuaikan dengan selera masing2. Masak sampai air menyusut dan kerupuk matang. Sebelum air menyusut banyak, masukkan pelengkapnya. (tingkat kematangan kerupuk sesuai selera ya, banyaknya kuah klo udah jadi juga sesuai selera. Bisa dibuat berkuah banyak atau nyemek2).')");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS MsUsers");
        db.execSQL("DROP TABLE IF EXISTS cart");
        db.execSQL("DROP TABLE IF EXISTS MsFoods");
    }

    public Boolean insertData(String email, String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("email", email);
        values.put("username", username);
        values.put("password", password);

        long result = db.insert("MsUsers", null, values);

        db.close();

        if (result == -1){
            return false;
        } else {
            return true;
        }
    }

    public Boolean checkEmail(String email){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("SELECT * FROM MsUsers WHERE  email = ?", new String[]{email});

        if (cursor.getCount() > 0){
            return true;
        } else {
            return false;
        }
    }



    public Boolean checkEmailPassword(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM MsUsers WHERE email = ? AND password = ?", new String[]{email, password});

        if (cursor.getCount() > 0){
            return true;
        } else {
            return false;
        }
    }

    public Boolean insertCart(Integer foodID, String userEmail) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("foodID", foodID);
        values.put("userEmail", userEmail);

        long result = db.insert("cart", null, values);

        db.close();

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public ArrayList<Food> getAllFoods(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM MsFoods",null);

        ArrayList<Food> list = new ArrayList<>();
        if (cursor.moveToFirst()){
            do {
                Food food = new Food();
                food.setNameFood(cursor.getString(1));
                food.setPrice(cursor.getInt(2));
                food.setImage(cursor.getString(3));
                food.setDescription(cursor.getString(4));
                food.setIngredients(cursor.getString(5));
                food.setStep(cursor.getString(6));
                list.add(food);
            } while (cursor.moveToNext());

        }
        return list;
    }

    public ArrayList<Cart> getAllCarts(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM cart WHERE userEmail = ?",new String[]{email});

        ArrayList<Cart> list = new ArrayList<>();
        if (cursor.moveToFirst()){
            do {
                Cart cart = new Cart();
                cart.setFoodId(cursor.getInt(1));
                cart.setUserEmail(cursor.getString(2));
                list.add(cart);


            } while (cursor.moveToNext());

        }
        return list;
    }

    public Integer getFoodId(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT foodID FROM MsFoods WHERE foodName = ? ", new String[]{name});
        cursor.moveToFirst();
        return cursor.getInt(0);
    }

}




