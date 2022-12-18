import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * GUI zum Spiel
 *
 * Interaktive Steuerung des Wï¿½rfelspiels
 * Durch Drï¿½cken auf den Wï¿½rfel-Button wird eine neue Zahl gewï¿½rfelt,
 * Die gewï¿½rfelte Zahl wird durch ein entsprechendes Wï¿½rfelbild angezeigt.
 * Die Wï¿½rfelbilder werden aus Dateien 0.jpg bis 6.jpg eingelesen.
 *  * In den Textfeldern kï¿½nnen Betrï¿½ge eingegeben werden.
 * Die gesamte GUI implementiert den ActionListener fï¿½r sï¿½mtliche Komponenten
 *
 * TODO
 * GUI ist eng gekoppelt an Spiel.
 * Bei einer Erweiterung auf andere Wettmï¿½glichkeiten oder auf andere "Wï¿½rfel" wï¿½ren an verschiedenen Stellen
 * umfangreichere Anpassungen notwendig.
 * Ausreichend fï¿½r dieses Spiel und relativ leicht lesbar.
 *
 * @author Prof. Dr. Heiko Tapken
 * @version 31.10.2022
 *
 */

public class GUI extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    Spiel mySpiel;

    private final static String CMD_NEXT = "wuerfeln";
    private final static String CMD_EXIT = "beenden";
    private final static String CMD_NEW = "neues Spiel";
    private final static String CMD_CONTINUE = "weiter";

    private ImageIcon[] wuerfelBilder;

    private JLabel lblStartguthaben;
    private JLabel lblAktuellesGuthaben;
    private JLabel lblGerade;
    private JLabel lblUngerade;

    private JButton btnWuerfel;

    private JTextField txtStartguthaben;
    private JTextField txtAktuellesGuthaben;
    private JTextField txtWettbetragGerade;
    private JTextField txtWettbetragUngerade;

    private JPanel wuerfelPanel;
    private JPanel guthabenPanel;
    private JPanel wettenPanel;
    private JPanel buttonPanel;

    /**
     * Konstruktor
     * @param einSpiel Referenz auf Spiel
     * @throws IOException falls Wï¿½rfelbilder nicht gelesen werden kï¿½nnen
     */
    public GUI(Spiel einSpiel) throws IOException {
        super("Wurf-Wetten");
        mySpiel = einSpiel;

        wuerfelBilder = new ImageIcon[7];

        wuerfelBilder[0] = new ImageIcon(ImageIO.read(getClass().getResource("/resource/0.jpg")));
        wuerfelBilder[1] = new ImageIcon(ImageIO.read(getClass().getResource("/resource/1.jpg")));
        wuerfelBilder[2] = new ImageIcon(ImageIO.read(getClass().getResource("/resource/2.jpg")));
        wuerfelBilder[3] = new ImageIcon(ImageIO.read(getClass().getResource("/resource/3.jpg")));
        wuerfelBilder[4] = new ImageIcon(ImageIO.read(getClass().getResource("/resource/4.jpg")));
        wuerfelBilder[5] = new ImageIcon(ImageIO.read(getClass().getResource("/resource/5.jpg")));
        wuerfelBilder[6] = new ImageIcon(ImageIO.read(getClass().getResource("/resource/6.jpg")));
	/*	wuerfelBilder[1] = new ImageIcon(ImageIO.read(new File("1.jpg")));
		wuerfelBilder[2] = new ImageIcon(ImageIO.read(new File("2.jpg")));
		wuerfelBilder[3] = new ImageIcon(ImageIO.read(new File("3.jpg")));
		wuerfelBilder[4] = new ImageIcon(ImageIO.read(new File("4.jpg")));
		wuerfelBilder[5] = new ImageIcon(ImageIO.read(new File("5.jpg")));
		wuerfelBilder[6] = new ImageIcon(ImageIO.read(new File("6.jpg")));
*/

        wuerfelPanel = new JPanel();
        wuerfelPanel.setLayout(new FlowLayout());
        btnWuerfel = new JButton();
        btnWuerfel.setIcon(wuerfelBilder[0]);
        btnWuerfel.setActionCommand(CMD_NEXT);
        btnWuerfel.addActionListener(this);
        wuerfelPanel.add(btnWuerfel);

        guthabenPanel = new JPanel();
        guthabenPanel.setLayout(new GridLayout(2, 0));
        lblStartguthaben = new JLabel("Startguthaben");
        txtStartguthaben = new JTextField();
        txtStartguthaben.setEditable(false);
        lblAktuellesGuthaben = new JLabel("Aktuelles Guthaben");
        txtAktuellesGuthaben = new JTextField();
        txtAktuellesGuthaben.setEditable(false);
        guthabenPanel.add(lblStartguthaben);
        guthabenPanel.add(txtStartguthaben);
        guthabenPanel.add(lblAktuellesGuthaben);
        guthabenPanel.add(txtAktuellesGuthaben);

        wettenPanel = new JPanel();
        wettenPanel.setLayout(new GridLayout(2, 0));
        lblGerade = new JLabel  (" Wettbetrag gerade   ");
        txtWettbetragGerade = new JTextField();
        lblUngerade = new JLabel(" Wettbetrag ungerade ");
        txtWettbetragUngerade = new JTextField();
        wettenPanel.add(lblGerade);
        wettenPanel.add(txtWettbetragGerade);
        wettenPanel.add(lblUngerade);
        wettenPanel.add(txtWettbetragUngerade);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        addJButton(buttonPanel, "Weiter", CMD_CONTINUE, this);
        addJButton(buttonPanel, "Neues Spiel", CMD_NEW, this);
        addJButton(buttonPanel, "Ende", CMD_EXIT, this);

        getContentPane().setLayout(new GridLayout(4, 0));
        getContentPane().add(wuerfelPanel);
        getContentPane().add(guthabenPanel);
        getContentPane().add(wettenPanel);
        getContentPane().add(buttonPanel);

        setTextFields();

        pack();
        setVisible(true);

    }

    /**
     * Hilfsmethode zum Hinzufï¿½gen eines Buttons
     * Verwendung im Konstruktor
     *
     * @param aJPanel
     * @param label
     * @param actionCommand
     * @param aListener
     */
    private void addJButton(JPanel aJPanel, String label, String actionCommand,
                            ActionListener aListener) {
        JButton aJButton;
        aJButton = new JButton(label);
        aJButton.setActionCommand(actionCommand);
        aJButton.addActionListener(aListener);
        aJPanel.add(aJButton);
    }

    /**
     * Setzen der Textfelder mit den aktuelle Spielwerten
     */
    private void setTextFields() {
        txtStartguthaben.setText(Integer.toString(mySpiel.getStartguthaben()));
        txtAktuellesGuthaben.setText(Integer.toString(mySpiel.getAktuellesGuthaben()));
        txtWettbetragGerade.setText(Integer.toString(mySpiel.getWettbetragGerade()));
        txtWettbetragUngerade.setText(Integer.toString(mySpiel.getWettbetragUngerade()));
    }

    /**
     * Spielzug
     * ï¿½berprï¿½fung, ob die Hï¿½he der Wettbetrï¿½ge zulï¿½ssig ist
     */
    private void doNext() {
        if (mySpiel.setWettbetraege(mySpiel.getWettbetragGerade(), mySpiel.getWettbetragUngerade())) {
            int zahl = mySpiel.wuerfeln();
            mySpiel.auswertenSpielzug(zahl);
            btnWuerfel.setIcon(wuerfelBilder[zahl]);
        }
        else {
            JOptionPane.showMessageDialog(this, "FEHLER: Hï¿½he der Wettbetrï¿½ge falsch");
        }
        setTextFields();
    }

    /**
     * Spiel wird neu initialisiert.
     */
    private void doNew() {
        mySpiel.init();
        setTextFields();
    }

    /**
     * Weiter Spielen
     * Die Eintrï¿½ge in den Textfeldern werden ï¿½berprï¿½ft.
     */
    private void doContinue() {
        btnWuerfel.setIcon(wuerfelBilder[0]);
        String wettbetragGeradeString = txtWettbetragGerade.getText();
        String wettbetragUngeradeString = txtWettbetragUngerade.getText();
        int wettbetragGerade = 0;
        int wettbetragUngerade = 0;
        try {
            wettbetragGerade = Integer.parseInt(wettbetragGeradeString);
            wettbetragUngerade = Integer.parseInt(wettbetragUngeradeString);
            if (mySpiel.setWettbetraege(wettbetragGerade, wettbetragUngerade)) {
                JOptionPane.showMessageDialog(this, "Wettbetrï¿½ge OK");
            }
            else {
                JOptionPane.showMessageDialog(this, "FEHLER: Hï¿½he der Wettbetrï¿½ge falsch");
            }
        }
        catch (NumberFormatException nfx) {
            JOptionPane.showMessageDialog(this, "FEHLER: Kein ganzzahliger Wettbetrag");
        }
        setTextFields();
    }

    /**
     * Beenden des Spiels und des Programms
     */
    private void doExit() {
        System.exit(0);
    }

    /**
     * Zu implementierende Methode des Interfaces ActionListener
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        String cmd = ae.getActionCommand();
        if (cmd.equals(CMD_NEXT)) {
            doNext();
        }
        if (cmd.equals(CMD_EXIT)) {
            doExit();
        }
        if (cmd.equals(CMD_NEW)) {
            doNew();
        }
        if (cmd.equals(CMD_CONTINUE)) {
            doContinue();
        }
    }

}
