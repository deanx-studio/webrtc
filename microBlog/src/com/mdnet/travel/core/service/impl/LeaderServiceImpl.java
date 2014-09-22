package com.mdnet.travel.core.service.impl;

import net.zhinet.travel.pojo.basepojo.TicketInfo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mdnet.travel.core.service.ILeaderService;
import com.mdnet.travel.core.service.ProxyService;
import com.mdnet.travel.core.vo.ShowProductInfo;

@Service(ILeaderService.SERVICE_NAME)
@Scope("prototype")
@Transactional(readOnly = false)
public class LeaderServiceImpl implements ILeaderService {

	@Override
	public ShowProductInfo[] getProductList(ProxyService proxyService,
			int pageNo) {

		TicketInfo[] ti = proxyService.getTicketsByCatalog(23, pageNo);
		ShowProductInfo[] ps = null;
		if (ti != null) {
			ps = new ShowProductInfo[ti.length];
			for (int i = 0; i < ti.length; i++) {
				ps[i] = new ShowProductInfo();
				ps[i].setName(ti[i].getTicketName());
				ps[i].setImg(ti[i].getImgUrl());
				ps[i].setMediaID(Integer.parseInt(ti[i].getTicketMemo()));
				ps[i].setProductID(ti[i].getTicketId());
			}
		}
		/*
		 * ShowProductInfo[] ps = new ShowProductInfo[4]; ps[0] = new
		 * ShowProductInfo(); ps[0].setName("美国西部大环线野之旅"); ps[0].setImg(
		 * "http://xdujia.com/resources/media/201408/0138b0e776f1c74f71b9e8d24c576408.jpg"
		 * ); ps[0].setMediaID(116); ps[0].setProductID(0);
		 * 
		 * ps[1] = new ShowProductInfo(); ps[1].setName("夏威夷7日精彩之旅");
		 * ps[1].setImg(
		 * "http://xdujia.com/resources/media/201408/712a924eabc77f4eef3271c6df766a7a.jpg"
		 * ); ps[1].setProductID(0); ps[1].setMediaID(117);
		 * 
		 * ps[2] = new ShowProductInfo(); ps[2].setName("黄石国家公园探秘之旅");
		 * ps[2].setImg(
		 * "http://xdujia.com/resources/media/201408/a003339ae5bec34ef45924e74c09ead7.jpg"
		 * ); ps[2].setMediaID(118); ps[2].setProductID(0);
		 * 
		 * ps[3] = new ShowProductInfo(); ps[3].setName("美国西海岸、夏威夷12日浪漫之旅");
		 * ps[3].setImg(
		 * "http://xdujia.com/resources/media/201408/e99253109f1fc2467d783b2263eaeeca.jpg"
		 * ); ps[3].setMediaID(119); ps[3].setProductID(0);
		 */
		return ps;
	}

}
