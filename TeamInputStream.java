import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TeamInputStream {

    public static ArrayList<Person> readTeamFromFile(File file) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);

        ArrayList<Person> personsRead = new ArrayList<>();
        try {
            while (true) {
                Person person = (Person) ois.readObject();
                personsRead.add(person);
            }
        } catch (java.io.EOFException e) {
            System.err.println("EOF - Input stream will close connection.");
            ois.close();
		    fis.close();
        }
        return personsRead;
    }
}

