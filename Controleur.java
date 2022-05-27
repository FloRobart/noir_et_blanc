import java.awt.image.BufferedImage;


public class Controleur
{
    private FrameImage ihm;
    private Metier     metier;

    private String sFichierImage;


    public Controleur()
    {
        this.sFichierImage = "./images/bleu.png";

        this.ihm           = new FrameImage(this);
        this.metier        = new Metier(this);
        this.metier.couleur();
    }

    public void maj2() { this.ihm.maj2(); }

    public String getFichierImage()           { return this.sFichierImage;                 }
	public void   setFichierImage(String fic) { this.sFichierImage = fic; this.ihm.maj();  }

    public BufferedImage getBufImage() { return this.ihm.getBufImage   (); }
    public BufferedImage recupBufImg() { return this.metier.recupBufImg(); }

    public void couleur() { this.metier.couleur(); }


    public static void main(String[] args) {
        new Controleur();
    }
}