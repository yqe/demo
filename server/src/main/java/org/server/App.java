package org.server;

import distancedata.DistanceData;
import documentdata.EarnedDocu;
import documentdata.GoodsDocu;
import managedata.CheckProfit;
import managedata.ManageCostData;
import po.EarnedPO;
import po.EmploeePO;
import storagedata.InputStorageDocu;
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
        try {
			//s.observe(); 
			//s.updatesalary("总经理", 50000);
			//s.updateconstant(30);
			//d.find("114500");
			//d.delete("114500");
			//d.insertEmp(new EmploeePO("营业厅业务员","124500","啊皮豪",50000,"男",20,"15111001110","321282199605111140","江苏省常熟市虞山镇大皮村1号","营业厅"));
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
//        	System.out.println(check.profittotal());
        	//ea.insert(new EarnedPO("2015-11-12", 20, "张三", "114500", "025000"));
        	//System.out.println(s.getconstance());
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
