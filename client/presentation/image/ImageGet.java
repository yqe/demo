package image;

import java.awt.Image;
import java.io.FileInputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImageGet {

	public static final Image adduser = createImage("image/adduser.jpg");

	public static final Image admincontrol = createImage("image/admincontrol.jpg");

	public static final Image arrival = createImage("image/arrival.jpg");

	public static final Image authority = createImage("image/authority.jpg");

	public static final Image background = createImage("image/background.jpg");

	public static final Image boclerkcontrol = createImage("image/boclerkcontrol.jpg");

	public static final Image buildaccount = createImage("image/buildaccount.jpg");

	public static final Image changepassword = createImage("image/changepassword.jpg");

	public static final Image changestorage = createImage("image/changestorage.jpg");

	public static final Image check = createImage("image/check.jpg");

	public static final Image checkstorage = createImage("image/checkstorage.jpg");

	public static final Image collection = createImage("image/collection.jpg");

	public static final Image countstorage = createImage("image/countstorage.jpg");

	public static final Image couriercontrol = createImage("image/couriercontrol.jpg");

	public static final Image dispatch = createImage("image/dispatch.jpg");

	public static final Image financemaincontrol = createImage("image/FinanceCMD.jpg");

	public static final Image instorage = createImage("image/instorage.jpg");

	public static final Image load = createImage("image/load.jpg");

	public static final Image logoff = createImage("image/logoff.jpg");

	public static final Image Maintenance = createImage("image/Maintenance.jpg");

	public static final Image outstorage = createImage("image/outstorage.jpg");

	public static final Image send = createImage("image/send.jpg");

	public static final Image storagemaincontrol = createImage("image/storagemaincontrol.jpg");

	public static final Image transit = createImage("image/transit.jpg");

	public static final Image transitload = createImage("image/transitload.jpg");

	public static final Image transitmaincontrol = createImage("image/transitmaincontrol.jpg");

	public static final Image Finance_BGP = createImage("image/FinanceBGP.jpg");
	public static final Image Finance_CMD = createImage("image/FinanceCMD.jpg");
	public static final Image Finance_Checkbill = createImage("image/checkbill.jpg");
	public static final Image Finance_costman = createImage("image/costman.jpg");
	public static final Image Finance_costincome = createImage("image/costincome.jpg");
	public static final Image Finance_stateofrun = createImage("image/stateofrun.jpg");
	public static final Image Finace_accman=createImage("image/accman.jpg");
	
	public static Image GetFinanceImage(String state) {
		switch (state) {
		case "FinanceBGP":
			return Finance_BGP;
		case "FinanceCMD":
			return Finance_CMD;
		case "CheckBill":
			return Finance_Checkbill;
		case "CostMan":
			return Finance_costman;
		case "CostIncome":
			return Finance_costincome;
		case "StateOfRun":
			return Finance_stateofrun;
		default:
			return Finace_accman;
		}
	}

	public static Image getImageByState(String state) {
		switch (state) {
		case "adduser":
			return adduser;
		case "admincontrol":
			return admincontrol;
		case "arrival":
			return arrival;
		case "authority":
			return authority;
		case "background":
			return background;
		case "boclerkcontrol":
			return boclerkcontrol;
		case "buildaccount":
			return buildaccount;
		case "changepassword":
			return changepassword;
		case "changestorage":
			return changestorage;
		case "check":
			return check;
		case "checkstorage":
			return checkstorage;
		case "collection":
			return collection;
		case "countstorage":
			return countstorage;
		case "couriercontrol":
			return couriercontrol;
		case "dispatch":
			return dispatch;
		case "financemaincontrol":
			return financemaincontrol;
		case "instorage":
			return instorage;
		case "load":
			return load;
		case "logoff":
			return logoff;
		case "Maintenance":
			return Maintenance;
		case "outstorage":
			return outstorage;
		case "send":
			return send;
		case "storagemaincontrol":
			return storagemaincontrol;
		case "transit":
			return transit;
		case "transitload":
			return transitload;
		case "transitmaincontrol":
			return transitmaincontrol;
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
