package tst.project.config;

import org.springframework.stereotype.Service;

import tst.project.service.EurekaFeignService;

@Service
public class EurekaFeignServiceFailure implements EurekaFeignService{

	@Override
    public String getInfo() {
        String message = "feign网络繁忙，请稍后再试-_-。PS：服务消费者自己提供的信息";
        return message;
    }

}
