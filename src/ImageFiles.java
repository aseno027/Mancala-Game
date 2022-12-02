import javax.swing.ImageIcon;


public class ImageFiles {
	private ImageIcon[] pitImages;
	private ImageIcon[] mancalaImages;
	
	public ImageFiles() {
		pitImages = new ImageIcon[21];
		mancalaImages = new ImageIcon[26];
		
		pitImages[0] = new ImageIcon(ImageFiles.class.getResource("./img/empty.jpg"));

		mancalaImages[0] = new ImageIcon(ImageFiles.class.getResource("./img/emptyman.jpg"));
		
		
		for(int i = 1; i < pitImages.length; i++) {
			String imgPath = "./img/pit" + i + ".jpg";
			pitImages[i] = new ImageIcon(ImageFiles.class.getResource(imgPath));

		}
		
		for(int i = 1; i < mancalaImages.length; i++) {
			String imgPath = "./img/man" + i + ".jpg";
			mancalaImages[i] = new ImageIcon(ImageFiles.class.getResource(imgPath));
		}
		
		
	}
	
	
	public ImageIcon getPitImg(int stoneNum) {
		return pitImages[stoneNum];
	}
	
	public ImageIcon getMancalaImg(int stoneNum) {
		return mancalaImages[stoneNum];
	}
	
}
