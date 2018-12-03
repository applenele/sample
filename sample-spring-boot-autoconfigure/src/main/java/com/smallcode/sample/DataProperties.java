package com.smallcode.sample;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Auther: lenny
 * @Date: 2018/12/2 17:46
 * @Description:
 */
@ConfigurationProperties(prefix = "sample.data")
public class DataProperties {

	public Boolean show = true;

	public Boolean getShow() {
		return show;
	}

	public void setShow(Boolean show) {
		this.show = show;
	}
}
