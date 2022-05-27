import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;


public class FrameImage extends JFrame implements ActionListener
{
    private Controleur     ctrl;

    private JMenuItem     menuiFichierOuvrir;
	private JMenuItem     menuiFichierQuitter;

	private PanelImage    panelImage;

    
    public FrameImage(Controleur ctrl)
    {
        this.ctrl = ctrl;

        this.setTitle   ( "Visualisation d'images" );
		this.setLocation(0, 0);
		this.setSize    (200, 200);

		/*-------------------------*/
		/* Création des composants */
		/*-------------------------*/

		/* Barre de Menu */
		/* - - - - - - - */
		JMenuBar menuBar  = new JMenuBar();

		JMenu menuFichier = new JMenu("Fichier");
		menuFichier.setMnemonic('F');

		this.menuiFichierOuvrir  = new JMenuItem("Ouvrir");
		this.menuiFichierQuitter = new JMenuItem("Quitter");

		this.menuiFichierOuvrir .setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		this.menuiFichierQuitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));


		/* Panel         */
		/* - - - - - - - */
		this.panelImage = new PanelImage(ctrl);


		/*-------------------------------*/
		/* positionnement des composants */
		/*-------------------------------*/

		/* . . . . . . . */
		/* Barre de Menu */
		/* . . . . . . . */
		menuFichier.add(this.menuiFichierOuvrir);
		menuFichier.add(this.menuiFichierQuitter);

		menuBar.add(menuFichier);
		this.setJMenuBar(menuBar);


		/* . . . . . . . */
		/* Panel         */
		/* . . . . . . . */
		this.add(this.panelImage);


		/*-------------------------------*/
		/* Activation des composants     */
		/*-------------------------------*/

		/* . . . . . . . */
		/* Barre de Menu */
		/* . . . . . . . */
		this.menuiFichierOuvrir .addActionListener(this);
		this.menuiFichierQuitter.addActionListener(this);


		/*-------------------------------*/
		/* Finalisation                  */
		/*-------------------------------*/
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible( true );
	}

	// Déclenche la méthode paintComponent du PanelImage puis met a jour le métier puis déclanche les calculs des couleurs des de l'image
	public void maj() { this.panelImage.repaint(); this.panelImage.majBufImg(); this.ctrl.couleur(); this.panelImage.majIhm(); }
	public void maj2() { this.panelImage.repaint(); this.panelImage.majBufImg(); this.panelImage.majIhm(); }

	public BufferedImage getBufImage() { return this.panelImage.getBufImage(); }


	public void actionPerformed ( ActionEvent e )
	{
		// Création et ouverture d'un JFileChooser pour affecter
		if ( e.getSource() == this.menuiFichierOuvrir )
		{
			JFileChooser fc = new JFileChooser("./images");

			fc.setMultiSelectionEnabled(false);

			int returnVal = fc.showOpenDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION)
				this.ctrl.setFichierImage(fc.getSelectedFile().getAbsolutePath());
		}

		// Fermeture de l'application
		if ( e.getSource() == this.menuiFichierQuitter )
		{
			this.dispose();
		}
    }
}