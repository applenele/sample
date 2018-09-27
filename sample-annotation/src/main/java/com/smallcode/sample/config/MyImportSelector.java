package com.smallcode.sample.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 *
 *  自定义逻辑返回需要导入到容器的组件bean吗
 * @author niele
 * @date 2018/9/28
 */
public class MyImportSelector implements ImportSelector {


	/**
	 * 返回值，就是要导入到容器的中的组件全类名
	 * @param importingClassMetadata 返回标注@ImportSelector的@Import 类的全部注解
	 * @return
	 */
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {


		return new String[]{"com.smallcode.sample.domain.Blue","com.smallcode.sample.domain.Yellow"};
	}
}
