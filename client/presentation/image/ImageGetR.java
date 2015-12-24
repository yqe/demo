package image;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

public class ImageGetR {

	public  final Image adduser = createImage("/imagero/adduser.jpg");

	public  final Image admincontrol = createImage("/imagero/admincontrol.jpg");

	public  final Image arrival = createImage("/imagero/arrival.jpg");

	public  final Image authority = createImage("/imagero/authority.jpg");

	public  final Image background = createImage("/imagero/background.jpg");

	public  final Image boclerkcontrol = createImage("/imagero/boclerkcontrol.jpg");

	public  final Image buildaccount = createImage("/imagero/buildaccount.jpg");

	public  final Image changepassword = createImage("/imagero/changepassword.jpg");

	public  final Image changestorage = createImage("/imagero/changestorage.jpg");

	public  final Image check = createImage("/imagero/check.jpg");

	public  final Image checkstorage = createImage("/imagero/checkstorage.jpg");

	public  final Image collection = createImage("/imagero/collection.jpg");

	public  final Image countstorage = createImage("/imagero/countstorage.jpg");

	public  final Image couriercontrol = createImage("/imagero/couriercontrol.jpg");

	public  final Image dispatch = createImage("/imagero/dispatch.jpg");

	public  final Image financemaincontrol = createImage("/imagero/FinanceCMD.jpg");
	
	public  final Image Inquiry = createImage("/imagero/Inquiry.jpg");

	public  final Image instorage = createImage("/imagero/instorage.jpg");

	public  final Image load = createImage("/imagero/load.jpg");

	public  final Image logoff = createImage("/imagero/logoff.jpg");

	public  final Image Maintenance = createImage("/imagero/Maintenance.jpg");

	public  final Image outstorage = createImage("/imagero/outstorage.jpg");

	public  final Image send = createImage("/imagero/send.jpg");

	public  final Image storagemaincontrol = createImage("/imagero/storagemaincontrol.jpg");

	public  final Image transit = createImage("/imagero/transit.jpg");

	public  final Image transitload = createImage("/imagero/transitload.jpg");

	public  final Image transitmaincontrol = createImage("/imagero/transitmaincontrol.jpg");
	
//	public  final Image managercontrol = createImage("/imagero/managercontrol.jpg");
	
//	public  final Image staff = createImage("/imagero/staff.jpg");
	
//	public  final Image addemployee = createImage("/imagero/addemployee.jpg");
	
//	public  final Image deleteemployee = createImage("/imagero/deleteemployee.jpg");
	
//	public  final Image checkdocuments = createImage("/imagero/checkdocuments.jpg");

	public  final Image Finance_BGP = createImage("/imagero/FinanceBGP.jpg");
	public  final Image Finance_CMD = createImage("/imagero/FinanceCMD.jpg");
	public  final Image Finance_Checkbill = createImage("/imagero/checkbill.jpg");
	public  final Image Finance_costman = createImage("/imagero/costman.jpg");
	public  final Image Finance_costincome = createImage("/imagero/costincome.jpg");
	public  final Image Finance_stateofrun = createImage("/imagero/stateofrun.jpg");
	public  final Image Finace_accman=createImage("/imagero/accman.jpg");
	
	public  Image GetFinanceImage(String state) {
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

	public  Image getImageByState(String state) {
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
		case "Inquiry":
			return Inquiry;
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
		case "managercontrol":
			return null;
		case "staff":
			return null;
		case "checkdocuments":
			return null;
		case "deleteemployee":
			return null;
		case "addemployee":
			return null;
			
		default:
			break;
		}
		return null;
	}


	protected Image createImage(String path) {
		try {
			BufferedImage bimg=ImageIO.read(getClass().getResource(path));
//			Image image = ImageIO.read(new FileInputStream(path));
			return bimg;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return null;
	}
}
