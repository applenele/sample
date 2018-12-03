package com.smallcode.sample;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Auther: lenny
 * @Date: 2018/12/2 17:48
 * @Description:
 */
public class DataService {

	@Autowired
	private DataProperties dataProperties;

	public void show() {
		if ((dataProperties.getShow() != null) && (dataProperties.getShow() == true)) {
			System.out.println("可以显示了");
		}
		else {
			System.out.println("默认不显示");
		}
	}
}
