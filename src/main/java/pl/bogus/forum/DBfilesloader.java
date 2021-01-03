package pl.bogus.forum;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;


public class DBfilesloader {

    public static void main(String[] args) throws FileNotFoundException {


        PrintWriter outputFile = new PrintWriter("/home/linux-user/IdeaProjects/forum/src/main/resources/data.sql");

        for (int i = 1; i <= 100; i++) {
            outputFile.println("INSERT  INTO post (id, title, content, created) values (" + i + ", 'test post" + i + "', 'content " + i + "', '" + LocalDateTime.now().minusDays(100 - i) + "' );");

        }
        int counter = 1;
        for (int j = 1; j <= 100; j++) {
            for (int k = 1; k <= 5; k++) {
                outputFile.println("INSERT  INTO comment (id, post_id,  content, created) values (" + counter + ", " + k + ", 'comment" + counter + "', '" + LocalDateTime.now().minusDays(100 - counter) + "' );");
                counter++;
            }
        }
        outputFile.flush();
    }


}



