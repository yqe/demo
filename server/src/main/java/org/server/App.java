package org.server;

import distancedata.DistanceData;
import documentdata.CondemnDocu;
import documentdata.EarnedDocu;
import documentdata.GoodsDocu;
import documentdata.TransferDocu;
import financedata.Initialaccount;
import goodsdata.ExpressTrail;
import managedata.CheckProfit;
import managedata.ManageAccount;
import managedata.ManageCostData;
import storagedata.InputStorageDocu;
import storagedata.LookStorage;
import storagedata.OutStorageDocu;
import strategydata.EmploeeData;
import strategydata.StrategyData;
import transdata.VehicleMaintance;
import userdata.UserData;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        StrategyData s=new StrategyData();
        EmploeeData d=new EmploeeData();
        DistanceData dis=new DistanceData();
        UserData	u=new UserData();
        ManageCostData ma=new ManageCostData();
        InputStorageDocu input=new InputStorageDocu();
        VehicleMaintance v=new VehicleMaintance();
        GoodsDocu g=new GoodsDocu();
        CheckProfit check=new CheckProfit();
        EarnedDocu ea=new EarnedDocu();
        Initialaccount in=new Initialaccount();
        TransferDocu tran=new TransferDocu();
        ExpressTrail expre=new ExpressTrail();
        ManageAccount macc=new ManageAccount();
        CondemnDocu con=new CondemnDocu();
        OutStorageDocu out=new OutStorageDocu();
        LookStorage look=new LookStorage();
        try {
			//s.observe(); 
			//s.updatesalary("总经理", 50000);
			//s.updateconstant(30);
			//d.find("114500");
			//d.delete("114500");
			//d.insertEmp(new EmploeePO("营业厅业务员","1298500","啊皮豪",50000,"男",20,"15111001110","321282199605111140","江苏省常熟市虞山镇大皮村1号","南京","025000"));
			//System.out.println(d.findbyname("啊皮豪"));
        	//d.findbypos("营业厅");
			//d.update(new EmploeePO("总经理","114500","啊皮豪",50000,"女",20,"15111001110","321282199605111140","江苏省常熟市虞山镇大皮村1号"));
        	//System.out.println(dis.getdistance("天津", "北京"));
			//u.getLoginPO("24");
			//u.delete("1124");
			//u.insert(new UserInfoPO("1124","5678"));
			//ma.find();
        	//u.update(new UserInfoPO("1124","2","jj","tt"));
        	//input.storagenum("010000", "20151124");
        	//v.update(new VehicleMaintanceInfoPO("112", "23", "22", "22", "22", "fjejw", "ef", "222", "22", "22", "22"));
        	//g.insert(new GoodsDocuPO("3231", "ggg", "fefe", "effe", "efef", "fef", "iii", "1232321", 20, 30, "333", "413", 40, "ggg", 10, 20, 30, 30, 80, "rrr", "3", "ttt", "ttt", "yyy"));
//        	System.out.println(check.getcosttotal());
//        	System.out.println(check.getearnedtotal());
//        	System.out.println(check.profiottotal());
        	//ea.insert(new EarnedPO("2015-11-12", 20, "张三", "114500", "025000"));
        	//System.out.println(s.getconstance());
        	//in.insert(new InitializeAccountPO("112355", "营业厅", 30, 20, 80, 100));
        	//System.out.println(g.getgoodsidmax());
        	//System.out.println(tran.isArrivaltransfer("025000", "1111"));
        	//g.insert(new GoodsDocuPO("张二", "南京大学", "南京大学", "110", "李四", "北京大学", "北京大学", "119", 20, 30, "普通快递", "141250191", 20, "好东西", 1, 20, 20, 20, 8000, "好东西", "纸箱", "20151125", "20151125", "阿皮"));
        	//ea.insert(new EarnedPO("2015-12-30", 200, "李二", "141250191", "021000"));
        	//System.out.println("您快递编号为"+expre.find("1412501733").getGoodsID()+expre.find("1412501733").getBusstrail()+expre.find("1412501733").getCentertrail());
//        	System.out.println(macc.delete("1"));
        	//ArrayList<CondemnDocuPO> list=con.findall();
        	//System.out.println(list.get(1).getType()+" "+list.get(2).getID()+" "+list.get(1).getState());
        	//ea.insert(new EarnedPO("2015-12-26", 30, "啊皮豪", "11122", "2234"));
        	//boolean t=ma.insert(new CostManagePO("2015-12-26", 20, "fefe", "456", "哈哈", "哈哈"));
        	//System.out.println(t);
        	//con.update();
//        	InputStorageList inslt=new InputStorageList();
//        	inslt.addInputStoragePO(new InputStorageDocuPO("1111111111", "2015-01-04", "天津", "1", "3", "3", "4", "025000"));
//       	input.InputStorageAdd(inslt);
        	//System.out.println(input.storagenum("025000", "2016-01-01", "2016-01-04"));
        	//System.out.println(look.getstorednum("025000"));
        	
//        	System.out.println(look.findmoney("025000"));
        	//System.out.println(out.OutStorageNum("025000", "2015-01-04", "2016-01-06"));
//        	System.out.println(dis.getdistance("北京", "上海"));
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
