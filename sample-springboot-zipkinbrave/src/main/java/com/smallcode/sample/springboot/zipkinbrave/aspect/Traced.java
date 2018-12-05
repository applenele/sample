package com.smallcode.sample.springboot.zipkinbrave.aspect;

import brave.sampler.DeclarativeSampler.RateForMethod;

/**
 * @author lenny
 * @Title: Traced
 * @ProjectName sample
 * @Description: TODO
 * @date 2018-12-0523:43
 **/
public class Traced implements RateForMethod {

  @Override
  public Float get(Object method) {
    return null;
  }


}
