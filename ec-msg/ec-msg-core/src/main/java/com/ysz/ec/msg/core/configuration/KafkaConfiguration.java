package com.ysz.ec.msg.core.configuration;

import com.ysz.ec.common.ext.kafka.KafkaAckEnum;
import com.ysz.ec.common.ext.kafka.KafkaProducerBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/30 <br/> <B>版本：</B><br/>
 */
@Configuration
public class KafkaConfiguration {

  @Bean
  public KafkaProducerBean msgProducer() {
    KafkaProducerBean msgProducer = new KafkaProducerBean();
    msgProducer.setAck(KafkaAckEnum.ONE);
    //设置为1, 会大量影响性能，但是 batchSize为1 + ack为1 保证消息发送完之后，能知道发送结果，并根据结果做出反应
    //可以根据实际情况调整，如果想追求更高的性能，可以设置值更高
    msgProducer.setBatchSize(1);

    return msgProducer;
  }
}
