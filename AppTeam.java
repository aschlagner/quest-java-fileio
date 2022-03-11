import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;

public class AppTeam {
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

        File file = new File("persons.data");
         
        // Data generation and storage in ArrayList
        System.out.println("\nCreate an ArrayList \"personsList\":");
        ArrayList<Person> personsList = new ArrayList<>();
        personsList.add(new Person("Joe", 41));
        personsList.add(new Person("Jane", 42));
        personsList.add(new Person("Jeff", 43));
        personsList.add(new Person("Jill", 44));
        for (Person person : personsList) {
            System.out.println("Person " + person.toString());
        }

        // Data storage from ArrayList to File
        System.out.println("\nThe ArrayList \"personsList\" is written to the file \"" + file + "\".");
        TeamOutputStream.writeTeamToFile(personsList, file);
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
        
        // Clearing the ArrayList in memory
        System.out.println("\nThe ArrayList \"personsList\" is now emptied with: \npersonsList.clear();\n");
        personsList.clear();

        // Read out the saved file and return it to an ArrayList
        System.out.println("Start reading from saved file \"" + file + "\".");
        ArrayList<Person> newPersonsList = TeamInputStream.readTeamFromFile(file);
        System.out.println("File has been read.\n");
        
        // Output of the new ArrayList
        System.out.println("Data output from new ArrayList \"newPersonsList\":");
        for (Person newPerson : newPersonsList) {
            System.out.println("New: Person " + newPerson.toString());
        }

    }
}
