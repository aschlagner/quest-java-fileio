import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

public class TeamOutputStream {
    
    public static void writeTeamToFile(ArrayList<Person> personsWrite, File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);

        for (Person person : personsWrite) {
            oos.writeObject(person);
        }
        oos.flush();
        oos.close();
        fos.close();
        
    }
    
}
