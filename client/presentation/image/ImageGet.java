package image;

import java.awt.Image;

public class ImageGet {

	public Image GetFinanceImage(String state) {
		return new ImageGetR().GetFinanceImage(state);
	}

	public static Image getImageByState(String state) {
		return new ImageGetR().getImageByState(state);
	}
}
