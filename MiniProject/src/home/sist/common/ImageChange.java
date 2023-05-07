package home.sist.common;
import java.awt.*;
import javax.swing.ImageIcon;
public class ImageChange {
	public static Image getImage(ImageIcon li, int width,int height)
	{
		Image deimg = li.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return deimg;
	}
}
