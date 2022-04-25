package présentation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionClientel extends JFrame{
    private JPanel rootPanel;
    private JButton ajouterClientButton;
    private JButton afficherClientsButton;
    public GestionClientel(){
        setContentPane(rootPanel);
        setSize(900,600);
        setVisible(true);
        setTitle("La gestion des clients");
        setResizable(false);
        setLocation(500,200);
        ajouterClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AjouterClient ajouterClient = new AjouterClient();
            }
        });
    }
}
