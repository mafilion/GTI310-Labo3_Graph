import parser.*;
import java.io.FileNotFoundException;

/**
 * The Application class defines a template method to call the elements to
 * solve the problem Unreal-Networks is faï¿½ing.
 * 
 * @author Franï¿½ois Caron <francois.caron.7@ens.etsmtl.ca>
 */
public class Application {

	/**
	 * The Application's entry point.
	 * 
	 * The main method makes a series of calls to find a solution to the
	 * problem. The program awaits two arguments, the complete path to the
	 * input file, and the complete path to the output file.
	 * 
	 * @param args The array containing the arguments to the files.
	 * @throws FileNotFoundException 
	 */
	public static void main(String args[]) throws FileNotFoundException {
		System.out.println("Unreal Networks Solver !");
		String filename = "C:\\input\\Vendeur.txt";

		ConcreteParser concreteParser = new ConcreteParser();
		//Si le format n'est pas respecte, le programme se ferme. Jai teste, ca fonctionne.
		if(!(concreteParser.fileFormatIsCorrect(filename))){
			System.out.println("Le format de fichier n'est pas respecté!");
			System.exit(0);
		}

		Graph input = concreteParser.parse(filename);
		
		
		
	}
}
