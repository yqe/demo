/**
 * 
 */
/**
 * @author acer-pc
 *
 */
package goodsblService;

public interface GoodsBLService {

	public String GoodsInquiry(String ID);// 显示该ID快件的物流信息

	public String[] Goodsgetinfo(String ID);// 显示该ID快件的托运信息（收件人姓名，电话等）

	public String Goodsgetfee(Double weight, String type, String depatureplace, String destination);// 显示快件的运费

	public String Goodsgetdate(String depatureplace, String destination);// 显示快件的预计到达日期
}