package présentation;

import com.agence.entities.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AjouterClient extends JFrame{
    private JPanel rootPanel;
    private JTextField nom;
    private JButton ajouterButton;
    private JTextField prenom;
    private JTextField email;
    private JTextField tel;
    private JTextField adresse;
    private JLabel resultat;

    public AjouterClient(){
        setContentPane(rootPanel);
        setSize(400,600);
        setVisible(true);
        setTitle("Ajout clients");
        setResizable(false);
        setLocation(500,200);
        ajouterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name = nom.getText();
                String firstName = prenom.getText();
                String mail = email.getText();
                String telephone = tel.getText();
                String adr = adresse.getText();

                if (name != "" && firstName != "" && mail != "" && telephone != "" && adr != ""){
                    System.out.println("good");
                    ArrayList<String> data = new ArrayList<>();
                    data.add(name);
                    data.add(firstName);
                    data.add(mail );
                    data.add(telephone);
                    data.add(adr);
                    Client client = new Client();
                    client.createClient(data);
                    name = "";
                    firstName = "";
                    mail = "";
                    telephone = "";
                    adr = "";
                }else {
                    resultat.setText("Veillez inserer des donnees valide");
                }
            }
        });
    }
}
