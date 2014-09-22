package com.mdnet.travel.core.utils;

import java.io.UnsupportedEncodingException;

/**
 * MD5的算法在RFC1321 中定义 在RFC 1321中，给出了Test suite用来检验你的实现是否正确： MD5 ("") =
 * d41d8cd98f00b204e9800998ecf8427e MD5 ("a") = 0cc175b9c0f1b6a831c399e269772661
 * MD5 ("abc") = 900150983cd24fb0d6963f7d28e17f72 MD5 ("message digest") =
 * f96b697d7cb7938d525a2f31aaf161d0 MD5 ("abcdefghijklmnopqrstuvwxyz") =
 * c3fcd3d76192e4007dfb496cca67e13b
 * 
 * @author haogj
 * 
 *         传入参数：一个字节数组 传出参数：字节数组的 MD5 结果字符串
 */
public class MD5 {
	public static String getMD5(byte[] source) {
		String s = null;
		char hexDigits[] = { // 用来将字节转换成 16 进制表示的字符
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
				'e', 'f' };
		try {
			java.security.MessageDigest md = java.security.MessageDigest
					.getInstance("MD5");
			md.update(source);
			byte tmp[] = md.digest(); // MD5 的计算结果是一个 128 位的长整数，
			// 用字节表示就是 16 个字节
			char str[] = new char[16 * 2]; // 每个字节用 16 进制表示的话，使用两个字符，
			// 所以表示成 16 进制需要 32 个字符 
			int k = 0; // 表示转换结果中对应的字符位置
			for (int i = 0; i < 16; i++) { // 从第一个字节开始，对 MD5 的每一个字节
				// 转换成 16 进制字符的转换
				byte byte0 = tmp[i]; // 取第 i 个字节
				str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换,
				// >>> 为逻辑右移，将符号位一起右移
				str[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
			}
			s = new String(str); // 换后的结果转换为字符串

		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	public static void main(String[] argv) { 
		// 计算 "a" 的 MD5
		// 代码，应该为：0cc175b9c0f1b6a831c399e269772661

//		String = 
		System.out.println(MD5.getMD5("a".getBytes()));

		//System.out.println(MD5.getMD5("abc".getBytes()));
		String xml="12345<?xml version=\"1.0\" encoding=\"GBK\" standalone=\"yes\"?><PackageList xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">    <Package>        <Header>            <RequestType>01</RequestType>            <UUID>f402a5b4-cbec-4104-93e7-1fdf9952f1af</UUID>            <ComId>2050992495</ComId>            <From>taobao</From>            <SendTime>2013-01-09 13:44:50</SendTime>            <TaoBaoSerial>1610546163395</TaoBaoSerial>            <ComSerial xsi:nil=\"true\"/>            <Asyn>0</Asyn>            <ReturnUrl>http://cooperation.baoxian.taobao.com/cooperation/</ReturnUrl>            <ProductCode>514105</ProductCode>        </Header>        <Request>            <Order>                <TBOrderId>1610546163395</TBOrderId>                <TotalPremium>250000</TotalPremium>                <PostFee>0</PostFee>                <InsBeginDate xsi:nil=\"true\"/>                <InsEndDate xsi:nil=\"true\"/>                <InsPeriod xsi:nil=\"true\"/>                <ApplyNum>5</ApplyNum>                <Item>                    <ItemId>1500027891443</ItemId>                    <SkuRiskCode>hongkang1</SkuRiskCode>                    <ProductCode>514105</ProductCode>                    <ProductName>������1</ProductName>                    <Amount xsi:nil=\"true\"/>                    <Premium>50000</Premium>                    <ActualPremium>50000</ActualPremium>                    <DiscountRate>10000</DiscountRate>                </Item>            </Order>            <ApplyInfo>                <Holder>                    <CustomList>                        <Custom key=\"HolderName\">��־��</Custom>                        <Custom key=\"save-holder\">1</Custom>                        <Custom key=\"HolderEmail\">fengzhigang@hongkang-life.com</Custom>                        <Custom key=\"HolderCardType\">1</Custom>                        <Custom key=\"HolderCardNo\">140202198101226510</Custom>                        <Custom key=\"HolderBirthday\">1981-01-22</Custom>                        <Custom key=\"HolderSex\">1</Custom>                        <Custom key=\"HolderResidentProvince\">110000</Custom>                        <Custom key=\"HolderResidentCity\">110100</Custom>                        <Custom key=\"HolderMobile\">13811294149</Custom>                        <Custom key=\"HolderAddress\">�뿵����</Custom>                        <Custom key=\"HolderZip\">100089</Custom>                    </CustomList>                </Holder>                <InsuredInfo>                    <IsHolder>0</IsHolder>                    <InsuredList>                        <Insured>                            <CustomList>                                <Custom key=\"InsuredRelation\">1</Custom>                            </CustomList>                            <BenefitInfo>                                <IsLegal>1</IsLegal>                                <BenefitList/>                            </BenefitInfo>                        </Insured>                    </InsuredList>                </InsuredInfo>                <OtherInfo>                    <CustomList/>                </OtherInfo>            </ApplyInfo>        </Request>    </Package></PackageList>";

		//
		try {
			System.out.println(MD5.getMD5(xml.getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}
