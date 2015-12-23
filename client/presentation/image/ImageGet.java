package image;

import java.awt.Image;
import java.io.FileInputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class ImageGet {

	public static final Image StORAGE_BGP = createImage("image/StorageBgp.jpg");
	
	public static final Image StORAGE_CMD = createImage("image/StorageCMD.jpg");
	
	public static final Image StORAGE_IN=createImage("image/StorageIn.jpg");
	
	public static final Image StORAGE_OUT=createImage("image/StorageOut.jpg");
	
	public static Image getImageByState(String state) {
		switch (state) {
		case "StorageBGP":
			return StORAGE_BGP;
		case "StorageCMD":
			return StORAGE_CMD;
		case "InStorage":
			return StORAGE_IN;
		case "OutStorage":
			return StORAGE_OUT;
		default:
			break;
		}
		return null;
	}
	
	protected static ImageIcon createImageIcon(String path) {
		ImageIcon icon = new ImageIcon(path);
		return icon;
	}

	protected static Image createImage(String path) {
		try {
			Image image = ImageIO.read(new FileInputStream(path));
			return image;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return null;
	}
}
