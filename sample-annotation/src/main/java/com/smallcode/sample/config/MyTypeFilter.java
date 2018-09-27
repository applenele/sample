package com.smallcode.sample.config;

import java.io.IOException;

import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

/**
 * 自定义过滤
 * @author niele
 * @date 2018/9/27
 */
public class MyTypeFilter implements TypeFilter {


	/**
	 * metadataReader 当前类的信息
	 * @param metadataReader
	 * @param metadataReaderFactory
	 * @return
	 * @throws IOException
	 */
	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		String className = classMetadata.getClassName();
		System.out.println("mytypefilter--->" + className);
		if (className.contains("er")) {
			return true;
		}
		return false;
	}
}
