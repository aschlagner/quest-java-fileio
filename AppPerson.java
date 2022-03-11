import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class AppPerson {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        
        File file = new File("person.data");

        System.out.println("\nCreate an Object \"person\" from Type Person:");
        Person person = new Person("Lonesome Cowboy", 76);
        System.out.println("Person " + person.toString());

        // Saving to file
        System.out.println("\nThe generated person is written to file \"" + file + "\".");
        PersonOutputStream.writePersonToFile(person, file);
        System.out.println("The new file \"" + file + "\" has the following size: " + file.length() + " bytes.\n");
        
        // Raw output from the new file with the way from David
        System.out.println("From David: Look at raw data from raw file \"" + file + "\":");
        FileInputStream testFileInputStream = new FileInputStream(file);
        int content, counter = 0;
        while((content = testFileInputStream.read()) != -1) {
            System.out.printf("%02X ", content);
            if(counter >= 15) {
                System.out.println();
                counter = 0;
            } else {
                counter++;
            }
        }
        if (counter != 0) System.out.println();
        testFileInputStream.close();

        // Clearing the object person in memory
        System.out.println("\nThe Object \"person\" is now emptied with: \nperson = null;\n");
        person = null;

        // Read out and output the saved file
        System.out.println("Start reading from saved file \"" + file + "\".");
        Person newPerson = PersonInputStream.readPersonFromFile(file);
        System.out.println("File has been read.\n");
        System.out.println("Data output from new Object \"newPerson\":");
        System.out.println("New: Person " + newPerson.toString());
   
    }

}
