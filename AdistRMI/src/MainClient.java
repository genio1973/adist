import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by Plinio on 07.11.2016.
 */
public class MainClient {
    public static void main(String[] args) throws Exception {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 6000);
            ICalculatrice stub = (ICalculatrice) registry.lookup("Calculatrice");

            String operateur="";
            double ans=0;
            double value=0;

            //Scanner in = new Scanner(System.in);
            BufferedReader consoleRead=new BufferedReader(new InputStreamReader(System.in));

            while (true)
            {
                System.out.println("ANS : " + ans);
                System.out.println("Op +, *, -, / (c to clear and q to quit) : ");
                operateur = consoleRead.readLine();
                if(operateur.contains("c") || operateur.contains("C"))
                    ans=0;
                else{
                    //Quitter sur l'opérateur conetant la lettre q
                    if (operateur.contains("q") || operateur.contains("Q"))
                        break;

                    System.out.println("Valeur : ");
                    value = Double.valueOf(consoleRead.readLine());

                    //Envoi requete
                    switch (operateur) {
                        case "+":
                            ans = stub.Add(ans, value);
                            break;
                        case "-":
                            ans = stub.Sub(ans, value);
                            break;
                        case "*":
                            ans = stub.Mul(ans, value);
                            break;
                        case "/":
                            ans = stub.Div(ans, value);
                            break;
                    }

                    //Efface la console
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.println("OP = " + operateur + " et valeur = " + value);
                }

            }

            System.out.println("END");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
