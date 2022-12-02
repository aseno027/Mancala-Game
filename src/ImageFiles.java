import javax.swing.ImageIcon;

/**
 * Class that helps other classes to access image files.
 * 
 * @author	Team Bagle
 * @version	1.0.1
 */
public class ImageFiles {
	private ImageIcon[] pitImages;
	private ImageIcon[] mancalaImages;
	
	/**
	 * Constructor
	 * - pitImages will be initialized with pit images.
	 * - mancalaImages will be initialized with mancala images.
	 * - Each array's index means the number of stones in pit or mancala.
	 * - 0 index is storing the empty image of pit or mancala.
	 */
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
	
	
	/**
	 * Method that returns pit image with stones
	 * 
	 * @param	stoneNum			number of stones in pit
	 * @return	pitImages[stoneNum]	pit image with number of stones that parameter passed
	 */
	public ImageIcon getPitImg(int stoneNum) {
		return pitImages[stoneNum];
	}
	
	
	/**
	 * Method that returns mancala image with stones
	 * 
	 * @param	stoneNum				number of stones in mancala
	 * @return	mancalaImages[stoneNum]	mancala image with number of stones that parameter passed
	 */
	public ImageIcon getMancalaImg(int stoneNum) {
		return mancalaImages[stoneNum];
	}
	
}
