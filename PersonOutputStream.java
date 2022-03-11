import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PersonOutputStream {

    public PersonOutputStream() {
    }

    public static void writePersonToFile(Person personWrite, File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(personWrite);
        oos.flush();
        oos.close();
        fos.close();
    }    

}
