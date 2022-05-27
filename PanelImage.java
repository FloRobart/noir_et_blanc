import javax.swing.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class PanelImage extends JPanel
{
	private Controleur ctrl;

	private ImageIcon imgIcon;
	private BufferedImage bufImg;


	public PanelImage( Controleur ctrl )
	{
		this.ctrl = ctrl;


		this.imgIcon =  new ImageIcon(this.ctrl.getFichierImage());
        this.bufImg  = new BufferedImage( this.imgIcon.getIconWidth(), this.imgIcon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
        this.imgIcon.paintIcon(this, bufImg.createGraphics(), 0,0);
	}

	public void majBufImg()
	{ 
		this.imgIcon = new ImageIcon(this.ctrl.getFichierImage());
        this.bufImg  = new BufferedImage( this.imgIcon.getIconWidth(), this.imgIcon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
        this.imgIcon.paintIcon(this, bufImg.createGraphics(), 0,0);
	}

	public void majIhm() { this.bufImg = this.ctrl.recupBufImg(); }

	public BufferedImage getBufImage() { return this.bufImg; }


	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);

		this.imgIcon = new ImageIcon(this.ctrl.getFichierImage());
        this.bufImg  = new BufferedImage( this.imgIcon.getIconWidth(), this.imgIcon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
        this.imgIcon.paintIcon(this, bufImg.createGraphics(), 0,0);

		g.drawImage(this.imgIcon.getImage(), 0, 0, this);
	}
}