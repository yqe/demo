package image;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

public class ImageGetR {

	public final String adduser = "/imagero/adduser.jpg";

	public final String admincontrol = "/imagero/admincontrol.jpg";

	public final String arrival = ("/imagero/arrival.jpg");

	public final String authority = ("/imagero/authority.jpg");

	public final String background = ("/imagero/background.jpg");

	public final String boclerkcontrol = ("/imagero/boclerkcontrol.jpg");

	public final String buildaccount = ("/imagero/buildaccount.jpg");

	public final String changepassword = ("/imagero/changepassword.jpg");

	public final String changestorage = ("/imagero/changestorage.jpg");

	public final String check = ("/imagero/check.jpg");

	public final String checkstorage = ("/imagero/checkstorage.jpg");

	public final String collection = ("/imagero/collection.jpg");

	public final String countstorage = ("/imagero/countstorage.jpg");

	public final String couriercontrol = ("/imagero/couriercontrol.jpg");

	public final String dispatch = ("/imagero/dispatch.jpg");

	public final String financemaincontrol = ("/imagero/FinanceCMD.jpg");

	public final String Inquiry = ("/imagero/Inquiry.jpg");

	public final String instorage = ("/imagero/instorage.jpg");

	public final String load = ("/imagero/load.jpg");

	public final String logoff = ("/imagero/logoff.jpg");

	public final String Maintenance = ("/imagero/Maintenance.jpg");

	public final String outstorage = ("/imagero/outstorage.jpg");

	public final String send = ("/imagero/send.jpg");

	public final String storagemaincontrol = ("/imagero/storagemaincontrol.jpg");

	public final String transit = ("/imagero/transit.jpg");

	public final String transitload = ("/imagero/transitload.jpg");

	public final String transitmaincontrol = ("/imagero/transitmaincontrol.jpg");

	 public final String managercontrol = ("/imagero/managercontrol.jpg");

	 public final String staff = ("/imagero/staff.jpg");

	 public final String addemployee = ("/imagero/addemployee.jpg");

	 public final String deleteemployee = ("/imagero/deleteemployee.jpg");

	 public final String checkdocuments = ("/imagero/checkdocuments.jpg");
	 
	 public final String error = ("/imagero/error.jpg");

	public final String Finance_BGP = ("/imagero/FinanceBGP.jpg");
	public final String Finance_CMD = ("/imagero/FinanceCMD.jpg");
	public final String Finance_Checkbill = ("/imagero/checkbill.jpg");
	public final String Finance_costman = ("/imagero/costman.jpg");
	public final String Finance_costincome = ("/imagero/costincome.jpg");
	public final String Finance_stateofrun = ("/imagero/stateofrun.jpg");
	public final String Finace_accman = ("/imagero/accman.jpg");

	public Image GetFinanceImage(String state) {
		switch (state) {
		case "FinanceBGP":
			return createImage(Finance_BGP);
		case "FinanceCMD":
			return createImage(Finance_CMD);
		case "CheckBill":
			return createImage(Finance_Checkbill);
		case "CostMan":
			return createImage(Finance_costman);
		case "CostIncome":
			return createImage(Finance_costincome);
		case "StateOfRun":
			return createImage(Finance_stateofrun);
		default:
			return createImage(Finace_accman);
		}
	}

	public Image getImageByState(String state) {
		switch (state) {
		case "adduser":
			return createImage(adduser);
		case "admincontrol":
			return createImage(admincontrol);
		case "arrival":
			return createImage(arrival);
		case "authority":
			return createImage(authority);
		case "background":
			return createImage(background);
		case "boclerkcontrol":
			return createImage(boclerkcontrol);
		case "buildaccount":
			return createImage(buildaccount);
		case "changepassword":
			return createImage(changepassword);
		case "changestorage":
			return createImage(changestorage);
		case "check":
			return createImage(check);
		case "checkstorage":
			return createImage(checkstorage);
		case "collection":
			return createImage(collection);
		case "countstorage":
			return createImage(countstorage);
		case "couriercontrol":
			return createImage(couriercontrol);
		case "dispatch":
			return createImage(dispatch);
		case "financemaincontrol":
			return createImage(financemaincontrol);
		case "instorage":
			return createImage(instorage);
		case "Inquiry":
			return createImage(Inquiry);
		case "load":
			return createImage(load);
		case "logoff":
			return createImage(logoff);
		case "Maintenance":
			return createImage(Maintenance);
		case "outstorage":
			return createImage(outstorage);
		case "send":
			return createImage(send);
		case "storagemaincontrol":
			return createImage(storagemaincontrol);
		case "transit":
			return createImage(transit);
		case "transitload":
			return createImage(transitload);
		case "transitmaincontrol":
			return createImage(transitmaincontrol);
		case "managercontrol":
			return createImage(managercontrol);
		case "staff":
			return createImage(staff);
		case "checkdocuments":
			return createImage(checkdocuments);
		case "deleteemployee":
			return createImage(deleteemployee);
		case "addemployee":
			return createImage(addemployee);
		case "error":
			return createImage(error);
		default:
			return createImage(null);
		}

	}

	protected Image createImage(String path) {
		try {
			BufferedImage bimg = ImageIO.read(getClass().getResource(path));
			// Image image = ImageIO.read(new FileInputStream(path));
			return bimg;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return null;
	}
}
