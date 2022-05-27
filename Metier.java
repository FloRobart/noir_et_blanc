import java.awt.image.BufferedImage;
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;


public class Metier
{
    private Controleur ctrl;
    private BufferedImage bufImg;

    private int   nbPixel;
    private int[] tabColor;
    private List<Color> lstColor;


    public Metier(Controleur ctrl)
    {
        this.ctrl     = ctrl;
        this.bufImg   = this.ctrl.getBufImage();

        this.nbPixel  = this.bufImg.getWidth()*this.bufImg.getHeight();
        this.tabColor  = new int[this.nbPixel];
        this.lstColor = new ArrayList<Color>();
    }

    public BufferedImage recupBufImg() { return this.bufImg; }

    public void couleur()
    {
        // réinitialisation de tout les éléments
        this.bufImg    = this.ctrl.getBufImage();
        this.nbPixel   = this.bufImg.getWidth()*this.bufImg.getHeight();
        this.tabColor  = new int[this.nbPixel];
        this.lstColor.removeAll(this.lstColor);

        // Récupération de tout les pixels de l'image dans un tableau
        this.tabColor = this.bufImg.getRGB(0, 0, this.bufImg.getWidth(), this.bufImg.getHeight(), this.tabColor, 0, this.bufImg.getWidth());
        
        // Transformation du tableau en ArrayList
        for (int i : this.tabColor)
            this.lstColor.add(new Color(i));

        // Traitement des pixels
        int nuanceGris;
        Color couleur;
        int y = 0, x = 0;
        for (Color c : lstColor)
        {
            nuanceGris = (c.getRed() + c.getGreen() + c.getBlue ()) / 3;
            
            couleur = new Color(nuanceGris, nuanceGris, nuanceGris);
            this.bufImg.setRGB(x, y, couleur.getRGB());
            x ++;

            if (x == this.bufImg.getWidth())
            {
                x = 0;
                y ++;
            }
        }

        // Affichage du résutat du traitement des pixels
        System.out.println(this.lstColor.get(0).getRGB());
        System.out.println(this.lstColor.get(0).getRed() + " | " + this.lstColor.get(0).getGreen() + " | " + this.lstColor.get(0).getBlue());

        this.ctrl.maj2();

        System.out.println("\n\n");

        // Récupération de tout les pixels de l'image dans un tableau
        this.tabColor = this.bufImg.getRGB(0, 0, this.bufImg.getWidth(), this.bufImg.getHeight(), this.tabColor, 0, this.bufImg.getWidth());
        
        // Transformation du tableau en ArrayList
        for (int i : this.tabColor)
            this.lstColor.add(new Color(i));
        
        System.out.println(this.lstColor.get(0).getRGB());
        System.out.println(this.lstColor.get(0).getRed() + " | " + this.lstColor.get(0).getGreen() + " | " + this.lstColor.get(0).getBlue());
    }
}
