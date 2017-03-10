package parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConcreteParser implements Parser{

	@Override
	public Graph parse(String filename) throws FileNotFoundException {
		File file = new File(filename);
		Scanner scanner = new Scanner(file);
		Graph graph = null;
		
		//trois premières lignes du fichier, je n'ai pas réussi a
		//faire fonctionner lorsque la ligne pour le noeud de départ est vide
		//donc il faut mettre un chiffre a la ligne 3. Chaque Next passe a la ligne suivante.
		int citiesNumber = scanner.nextInt();
		int infiniteNumber = scanner.nextInt();
		int firstNode = scanner.nextInt();

		System.out.println("cities: " + citiesNumber);
		System.out.println("infinite: " + infiniteNumber);
		System.out.println("first node: " + firstNode);

		//Pour avoir le nombre de lignes qu'aura besoin le tableau a deux dimensions
		//Incrémente la variable pour chaque infos de chaque ligne partant de la 1ere ligne de noeuds 
		//jusquau dernier
		int a = 0;
		while(scanner.hasNextInt() && !(scanner.next().equals("$"))){
			a++;
		}

		//On divise le a par 3, car il y a 3 infos par lignes, on veut
		//seulement le nombre de lignes
		int[][] nodes = new int[a/3][3];
		//Refaire un scanner pour repartir au debut du fichier
		scanner = new Scanner(file);
		//passer les 3 premieres lignes
		scanner.nextInt();
		scanner.nextInt();
		scanner.nextInt();

		//commencer a mettre les infos dans le tableau a 2 dimensions
		for(int i = 0; i < nodes.length; i++){
			for(int j = 0; j < 3; j++){
				nodes[i][j] = scanner.nextInt();
			}
		}

		//affichage du tableau a deux dimensions contenant les noeuds et leur poids
		for(int i = 0; i < nodes.length; i++){
			for(int j = 0; j < 3; j++){
				System.out.print(nodes[i][j] + "\t");
				if(j == 2){
					System.out.println();
				}
			}
		}
		return graph = new Graph(citiesNumber, infiniteNumber, firstNode, nodes);
	}

	/**
	 * Permet de verifier si le fichier suit le format voulu 
	 * @param filename Le fichier d'entree
	 * @return True si le fichier respecte le format, false sinon
	 * @throws FileNotFoundException
	 */
	public boolean fileFormatIsCorrect(String filename) throws FileNotFoundException{

		List<String> lines = new ArrayList<String>();
		File file = new File(filename);
		Scanner scanner = new Scanner(file);
		String line1 = scanner.nextLine();
		String line2 = scanner.nextLine();
		String line3 = scanner.nextLine();
		boolean headerIsCorrect = false, dataIsCorrect = false, endIsCorrect = false;

		//Les lignes de filename sont ajoutees a la liste
		while(scanner.hasNextLine()){
			lines.add(scanner.nextLine());
		}

		//Verifie les 3 premieres lignes du fichier(header)
		if (line1.matches("\\d+") && line2.matches("\\d+") && (line3.matches("\\d+") || line3.matches(""))){
			headerIsCorrect = true;
		}		

		//Verifie si les données sont dans le bon format, ainsi que la fin du fichier
		for (String line : lines) {
			if(line.matches("\\d+" + "\\t" + "\\d+" + "\\t" + "\\d+")){
				dataIsCorrect = true;
			}else if (line.equals("$")){
				endIsCorrect = true;
			}else{
				return false;
			}
		}

		if (headerIsCorrect && dataIsCorrect && endIsCorrect){
			return true;
		}else{
			return false;
		}
	}
}