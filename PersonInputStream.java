import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class PersonInputStream {

    public static Person readPersonFromFile(File file) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Person personRead = (Person) ois.readObject();
        ois.close();
		fis.close();
        return personRead;
    }

}

