package com.example.bookmarked;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.sql.Timestamp;

public class DBHelper extends SQLiteOpenHelper {
    SQLiteDatabase DB;
    public DBHelper(Context context) {
        super(context, "AppData.db", null, 1);
        DB = getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Users(username TEXT primary key, password TEXT, fname TEXT, lname TEXT, address TEXT, contact TEXT, email TEXT, question INT, answer TEXT, firstlogin INT)");
        DB.execSQL("create Table Books(title TEXT primary key, author TEXT, genre TEXT, price DOUBLE, synopsis TEXT, image TEXT)");
        DB.execSQL("create Table Cart(UID INTEGER primary key autoincrement, User TEXT, Book TEXT)");
        DB.execSQL("create Table Sales(UID INTEGER primary key autoincrement, User TEXT, Name TEXT, Phone TEXT, Address TEXT, Books TEXT, Itemtotal DOUBLE, Tax DOUBLE, Shipping DOUBLE, Voucher DOUBLE, Subtotal DOUBLE, Total DOUBLE, Payment TEXT, Datetime default current_timestamp)");
        /*

        */
    }
    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("drop Table if exists Userdetails");
    }

    public void populate(){
        Cursor cursor = DB.rawQuery("Select * from Users where username = ?", new String[]{"admin"});
        if (cursor.getCount() > 0) {
            //quack
        } else {
            addUser("admin","4826","Admin S.","Trator","Cebu City, Cebu", "0987654321","admin@admin.com", 8, "admin");
            addBook("The Legendary Mechanic", "Qi Peija", "Manhwa", 1000.0, "What do you do when you wake up and find yourself inside the very game that you love? What do you do when you realize you that you have not only become an NPC - you have even been thrown back in time to before the game even launched! What will happen when our protagonist's two realities coincide? Han Xiao was a professional power leveler before his transmigration. Using his past life's knowledge, Han Xiao sweeps through the universe as he prepares for the arrival of the players. This is definitely not your typical transmigration novel.","the_legendary_mechanic");
            addBook("Birth of the Demonic Sword", "Eve of Chaos", "Manhwa", 2000.0 ,"So, that's how my life ends, what a waste of time it was... These were the last thoughts of a young man, shot by accident in a fight between local gangs. Little did he know that he would soon wake up in another world, a world of cultivation! This is the story of the whoreson of a wealthy family, of a transmigrator that had no purpose in his previous life, of a demon that will make power his reason to keep on living. Noah Balvan, after he transmigrated, will have to fight against his social status and the many difficulties of the world he was reborn in to obtain the power to stand free in the sky above anyone!","birth_of_the_demonic_sword");
            addBook("Super Gene", "Twelve-Winged Dark Seraphim",	"Manhwa",	2000.0	,"In the magnificent interstellar era, mankind has finally developed teleport technology, but when trying to teleport, they are not sent to the future, the past, or any land known to men... This mysterious space is called God’s Sanctuary, where lived numerous unknown creatures. Here, humans will make the greatest leap in their evolution to create the most glorious epoch in history.","super_gene");
            addBook("I Shall Seal the Heavens","Er Gen",	"Manhwa",	1370.0	,"What I want, the Heavens shall not lack! What I don’t want, had better not exist in the Heavens! This is a story which originates between the Eighth and Ninth Mountains, the world in which the strong prey upon the weak. “My Name is Meng Hao! The Ninth Generation Demon Sealer, I shall seal the Heavens!","i_shall_seal_the_heavens");
            addBook("Coiling Dragon",	"I Eat Tomatoes",	"Fantasy - Cultivation - Action",	1500.0	,"Empires rise and fall on the Yulan Continent. Saints, immortal beings of unimaginable power, battle using spells and swords, leaving swathes of destruction in their wake. Magical beasts rule the mountains, where the brave – or the foolish – go to test their strength. Even the mighty can fall, feasted on by those stronger. The strong live like royalty; the weak strive to survive another day.This is the world which Linley is born into. Raised in the small town of Wushan, Linley is a scion of the Baruch clan, the clan of the once-legendary Dragonblood Warriors. Their fame once shook the world, but the clan is now so decrepit that even the heirlooms of the clan have been sold off. Tasked with reclaiming the lost glory of his clan, Linley will go through countless trials and tribulations, making powerful friends but also deadly enemies. Come witness a new legend in the making. The legend of Linley Baruch.","coiling_dragon");
            addBook("Castle of Black Iron","Drunk Tiger",	"Fantasy - Steampunk - Action",	1350.0	,"After the Catastrophe, every rule in the world was rewritten. In the Age of Black Iron, steel, iron, steam engines and fighting force became the crux in which human beings depended on to survive. A commoner boy by the name Zhang Tie was selected by the gods of fortune and was gifted a small tree which could constantly produce various marvelous fruits. At the same time, Zhang Tie was thrown into the flames of war, a three-hundred-year war between humans and demons on the vacant continent. Using crystals to tap into the potentials of the human body, one must cultivate to become stronger. The thrilling legends of mysterious clans, secrets of Oriental fantasies, numerous treasures and legacies in the underground world — All in the Castle of Black Iron!","castle_of_black_iron");
            addBook("Harry Potter and the Philosopher's Stone",	"J. K. Rowling",	"Fantasy - Cultivation",	1200.0	,"Harry Potter has no idea how famous he is. That is because he is being raised by his miserable aunt and uncle who are terrified Harry will learn that he is really a wizard, just as his parents were. But everything changes when Harry is summoned to attend an infamous school for wizards, and he begins to discover some clues about his illustrious birthright. From the surprising way he is greeted by a lovable giant, to the unique curriculum and colorful faculty at his unusual school, Harry finds himself drawn deep inside a mystical world he never knew existed and closer to his own noble destiny.","harry_potter_and_the_philosophers_stone");
            addBook("Emperor of Solo Play","D-Dart",	"Fantasy - Cultivation",	800.0,	"Year 2035. The virtual reality game, Warlord, changed the world. An Jaehyun was one of the many who wished to change his life through the game. After dedicating his life to the game, he was met with a betrayal. A betrayal by his comrades. As a result, he lost everything. But a chance was given to him. A chance to redo everything again! “I won’t play with others ever again. Whatever the outcome, I’ll show that I can do it alone.” Others rolled a dice to split the spoils of victory. An Jaehyun ate it all by himself. It was the start of An Jaehyun’s solo game life.","emperor_of_solo_play");
            addBook("Warlock of the Magus World","The Plagiarist",	"Fantasy - Cultivation",	1200.0	,"Leylin is transported from an advanced technological era into a medieval world— except there’s magic. Equipped with only his quick wits and an A.I. chip fused to his soul, he sets out to become the most powerful magus the world has ever known. In a land divided into the Light and Dark Magi, the weak can either be cattle or disposable slaves. Only the strong can determine their lives, and only they have the luxury for virtue. Yet strength is only a tool for Leylin, like any other. His goal, in the end, is his own.","warlock_of_the_magus_world");
            addBook("Way of the Devil","Get Lost",	"Mature - Seinen - Supernatural",	1500.0, "Lu Sheng was an ordinary civil servant in the modern world. After waking from a drunken stupor one day, he found himself trapped in a dangerous world where demons, ghosts and supernatural monsters terrorize the land. In this world, ordinary mortals live in dark fear and helplessness, without any means to fight against the supernatural. As Lu Sheng struggles desperately for survival, he stumbles upon a game mod he had designed for a mobile phone app in his previous life. It unexpectedly becomes his special ability, which enables him to instantly level up any skill he learns, albeit at a cost. Thus, Lu Sheng begins his journey, striving for power beyond the reach of a mortal as he treads the way…of the Devil…","way_of_the_devil");
            addBook("The Return","Nicholas Sparks",	"Conteporary - Fiction",	445.0, "Trevor Benson never intended to move back to New Bern, North Carolina. But when a mortar blast outside the hospital where he worked as an orthopedic surgeon sent him home from Afghanistan with devastating injuries, the dilapidated cabin he’d inherited from his grandfather seemed as good a place to regroup as any. Tending to his grandfather’s beloved bee hives while preparing for a second stint in medical school, Trevor isn’t prepared to fall in love with a local . . . yet, from their very first encounter, Trevor feels a connection with deputy sheriff Natalie Masterson that he can’t ignore. But even as she seems to reciprocate his feelings, she remains frustratingly distant, making Trevor wonder what she’s hiding.","the_return");
            addBook("Miss Peregrines Home For Peculiar Children",	"Ransom Riggs",	"Fantasy",	200.0, "A mysterious island. An abandoned orphanage. A strange collection of very curious photographs. It all waits to be discovered in Miss Peregrine's Home for Peculiar Children, an unforgettable novel that mixes fiction and photography in a thrilling reading experience. As our story opens, a horrific family tragedy sets sixteen-year-old Jacob journeying to a remote island off the coast of Wales, where he discovers the crumbling ruins of Miss Peregrine's Home for Peculiar Children. As Jacob explores its abandoned bedrooms and hallways, it becomes clear that the children were more than just peculiar. They may have been dangerous. They may have been quarantined on a deserted island for good reason. And somehow-impossible though it seems-they may still be alive. A spine-tingling fantasy illustrated with haunting vintage photography, Miss Peregrine's Home for Peculiar Children will delight adults, teens, and anyone who relishes an adventure in the shadows.","miss_peregrines_home_for_peculiar_children");
            addBook("The Hunger Games","Suzanne Collins", "Sci-fi - Fantasy",	557.0,	"In the ruins of a place once known as North America lies the nation of Panem, a shining Capitol surrounded by twelve outlying districts. The Capitol is harsh and cruel and keeps the districts in line by forcing them all to send one boy and one girl between the ages of twelve and eighteen to participate in the annual Hunger Games, a fight to the death on live TV.Sixteen-year-old Katniss Everdeen regards it as a death sentence when she steps forward to take her sister's place in the Games. But Katniss has been close to death before -- and survival, for her, is second nature. Still, if she is to win, she will have to start making choices that weigh survival against humanity and life against love.","the_hunger_games");
            addBook("Percy Jackson and The Olympians #1: The Lightning Thief", "Rick Riordan",	"Fantasy",	550.0,	"Percy Jackson is a good kid, but he can't seem to focus on his schoolwork or control his temper. And lately, being away at boarding school is only getting worse - Percy could have sworn his pre-algebra teacher turned into a monster and tried to kill him. When Percy's mom finds out, she knows it's time that he knew the truth about where he came from, and that he go to the one place he'll be safe. She sends Percy to Camp Half Blood, a summer camp for demigods (on Long Island), where he learns that the father he never knew is Poseidon, God of the Sea. Soon a mystery unfolds and together with his friends—one a satyr and the other the demigod daughter of Athena - Percy sets out on a quest across the United States to reach the gates of the Underworld (located in a recording studio in Hollywood) and prevent a catastrophic war between the gods.","percy_jackson_and_the_olympians_1_the_lightning_thief");
            addBook("The Maze Runner", "James Dashner",	"Sci-fi - Dystopian",	300.0,	"When Thomas wakes up in the lift, the only thing he can remember is his name. He’s surrounded by strangers—boys whose memories are also gone. Outside the towering stone walls that surround the Glade is a limitless, ever-changing maze. It’s the only way out—and no one’s ever made it through alive.Then a girl arrives. The first girl ever. And the message she delivers is terrifying: Remember. Survive. Run.","the_maze_runner");
        }
    }

    public boolean addUser(String username, String password, String firstname, String lastname, String address, String contactnumber, String email, int question, String answer)

    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("fname", firstname);
        contentValues.put("lname", lastname);
        contentValues.put("address", address);
        contentValues.put("contact", contactnumber);
        contentValues.put("email", email);
        contentValues.put("question", question);
        contentValues.put("answer", answer);
        contentValues.put("firstlogin", 1);
        long result=DB.insert("Users", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }

    public boolean addBook(String title, String author, String genre, double price, String synopsis, String image){
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("author", author);
        contentValues.put("genre", genre);
        contentValues.put("price", price);
        contentValues.put("synopsis", synopsis);
        contentValues.put("image", image);
        long result=DB.insert("Books", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }

    public boolean addSale(String username, String payment){
        String[] shipping = getShipping(username);
        Cursor cart = retrieveCart(username);
        String books = "";
        int total_items = cart.getCount();
        double items_subtotal = 0;
        double preTax = 0;
        double tax = 0;
        double ship = 50;
        double voucher = 0;
        double subtotal = 0;
        double final_total = 0;
        cart.moveToFirst();
        while(!cart.isAfterLast()){
            String[] bookInfo = bookInfo(cart.getString(2));
            books += cart.getString(2);
            double price = Double.parseDouble(bookInfo[3]);
            items_subtotal += price;
            if(!cart.isLast()){
                books += "$";
            }
            cart.moveToNext();
        }
        preTax = items_subtotal/1.12;
        tax = preTax*0.12;
        if(total_items > 5){
            ship += (total_items-5)*8;
        }
        subtotal = items_subtotal + ship;
        voucher = subtotal*-0.05;
        final_total = subtotal+voucher;
        Timestamp datetime = new Timestamp(System.currentTimeMillis());

        ContentValues contentValues = new ContentValues();
        contentValues.put("User", username);
        contentValues.put("Name", shipping[0]);
        contentValues.put("Phone", shipping[1]);
        contentValues.put("Address", shipping[2]);
        contentValues.put("Books", books);
        contentValues.put("Itemtotal", preTax);
        contentValues.put("Tax", tax);
        contentValues.put("Shipping", ship);
        contentValues.put("Voucher", voucher);
        contentValues.put("Subtotal", subtotal);
        contentValues.put("Total", final_total);
        contentValues.put("Payment", payment);
        long result=DB.insert("Sales", null, contentValues);
        if(result==-1){
            return false;
        }else{
            emptyCart(username);
            return true;
        }
    }

    public boolean isUnique(String column, String value){
        Cursor cursor;
        if(column.equals("username")){
            cursor = DB.rawQuery("Select * from Users where username = ?",new String[]{value});
        }
        else{
            cursor = DB.rawQuery("Select * from Users where email = ?",new String[]{value});
        }
        if (cursor.getCount() > 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean loginCheck (String username, String password)
    {
        Cursor cursor = DB.rawQuery("Select * from Users where username = ? AND password = ?", new String[]{username, password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean firstLogin(String username, String password)
    {
        Cursor cursor = DB.rawQuery("Select firstlogin from Users where username = ? AND password = ?", new String[]{username, password});
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            int res = cursor.getInt(0);
            if (res > 0){
                ContentValues contentValues = new ContentValues();
                contentValues.put("firstlogin", 0);
                DB.update("Users", contentValues, "username=?", new String[]{username});
                return true;
            }
            else{
                return false;
            }

        } else {
            return false;
        }
    }

    public boolean checkEmail(String email){
        Cursor cursor = DB.rawQuery("Select * from Users where email = ?", new String[]{email});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public String[] getQuestion(String email){
        Cursor cursor = DB.rawQuery("Select question, answer from Users where email = ?", new String[]{email});
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            String[] reply = {cursor.getInt(0)+"",cursor.getString(1)};
            return reply;
        } else {
            return new String[]{"-1","0"};
        }
    }

    public boolean changePassEmail(String email, String password){
        ContentValues contentValues = new ContentValues();
        contentValues.put("password", password);
        long result = DB.update("Users", contentValues, "email=?", new String[]{email});
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public String getUserFirstName(String username){
        Cursor cursor = DB.rawQuery("Select fname from Users where username = ?", new String[]{username});
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            String res = cursor.getString(0);
            String[] names = res.split(" ");
            return names[0];

        } else {
            return "";
        }
    }

    public String getUserFullName(String username){
        Cursor cursor = DB.rawQuery("Select fname, lname from Users where username = ?", new String[]{username});
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            String fname = cursor.getString(0);
            String lname = cursor.getString(1);
            return fname + " " + lname;

        } else {
            return "";
        }
    }

    public String getAddress(String username){
        Cursor cursor = DB.rawQuery("Select address from Users where username = ?", new String[]{username});
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            String res = cursor.getString(0);
            return res;

        } else {
            return "";
        }
    }

    public String[] getShipping(String username){
        Cursor cursor = DB.rawQuery("Select fname, lname, contact, address from Users where username = ?", new String[]{username});
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            String fname = cursor.getString(0);
            String lname = cursor.getString(1);
            String fullname = fname + " " + lname;
            String phone = cursor.getString(2);
            String home = cursor.getString(3);
            return new String[]{fullname, phone, home};

        } else {
            return new String[]{""};
        }
    }

    public String[] bookInfo(String bookName){
        Cursor cursor = DB.rawQuery("Select * from Books where title = ?",new String[]{bookName});
        if (cursor.getCount() > 0) {
            String[] entries = new String[6];
            cursor.moveToFirst();
            for(int i = 0; i <6; i++){
                entries[i] = cursor.getString(i);
            }
            cursor.close();
            return entries;
        } else {
            cursor.close();
            return new String[]{};
        }

    }

    public boolean addToCart(String username, String title){
        ContentValues contentValues = new ContentValues();
        contentValues.put("User", username);
        contentValues.put("Book", title);
        long result=DB.insert("Cart", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }

    public boolean removeFromCart(String UID){
        ContentValues contentValues = new ContentValues();
        long result=DB.delete("Cart", "UID = ?", new String[]{UID});
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor retrieveCart(String username){
        Cursor cursor = DB.rawQuery("Select * from Cart where User = ?",new String[]{username});
        return cursor;
    }

    public boolean emptyCart(String username){
        ContentValues contentValues = new ContentValues();
        long result=DB.delete("Cart", "User = ?", new String[]{username});
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor searchBooks(String arg){
        String wild = "%" + arg + "%";
        Cursor cursor = DB.rawQuery("Select * from Books where (title LIKE ? OR author LIKE ? OR genre LIKE ?)",new String[]{wild ,wild, wild});
        return cursor;
    }

    public void cleanup(){
        DB.close();
    }

}
