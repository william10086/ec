package com.ysz.ec.common.ext.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.Properties;
import java.util.concurrent.Future;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/29 <br/> <B>版本：</B><br/>
 */
public class KafkaProducerBean implements InitializingBean, DisposableBean {

  /**
   * <pre>
   * The number of acknowledgements the producer requires the leader to have received before
   * considering a request complete.
   * This controls the durability of records that are sent.
   * The following setting are allowed:
   *
   * acks = 0 :
   *    (1) the producer will not wait for any acknowledgement from the server ata ll.
   *    (2) the record will immediately added to the socket buffer and considered as sent
   *    (3) retries will be ignored because the client will don't know any failure
   * acks = 1:
   *    (1) the leader will write the record to its local log but will respond without awaiting
   *    any followers
   *    (2) if the leader fail immediately after acknowledging but before the followers have
   *    replicated it ,the record will be lost
   * acks = all: the leader will wait for the full set of in-sync replicas
   *
   * </pre>
   */
  private KafkaAckEnum ack = KafkaAckEnum.ONE;

  /**
   * <pre>
   *   (1) Setting a value > 0  will cause the client to resend any record whose send fails with a
   *   potentially transient error.
   *
   *   (2) Allowing retries without setting max.in.flight.requests.per.connection to 1 will
   *   potentially change the ordering of the records
   * </pre>
   */
  private Integer retries = 0;

  /**
   * host1:port1,host2:port2,...
   */
  private String bootstrapServers = "localhost:9200";

  /**
   * <pre>
   *   The producer will attempt to batch records into fewer records whenever multiple records
   *   are being sent to the same partition.
   *
   *   This help performance on both client and server.
   *   (1) No attempt will be made to batch records larger than this size
   *   (2) Requests sent ot brokers will contain multiple batches, one for each partition with
   *   data available to be sent .
   *   (3) A small batch will make batching less common and may reduce throughput
   *
   *
   * </pre>
   */
  private Integer batchSize = 16384;

  /**
   * <pre>
   *   like Nagle's algorithm in TCP.
   * </pre>
   */
  private Long lingerMs = 100L;


  /**
   * (1) The total bytes of memory the producer can use to buffer records (2) if records are send
   * faster than they can be deliverd to the server , the producer will block for max.block.ms (3)
   */
  private Long bufferMemoryBytes = 33554432L;

  private String keySerializer = "org.apache.kafka.common.serialization.StringSerializer";
  private String valueSerializer = "org.apache.kafka.common.serialization.StringSerializer";


  private KafkaProducer<String, String> producer;

  @Override
  public void destroy() throws Exception {
    if (producer != null) {
      producer.close();
    }
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    Properties props = new Properties();
    props.put("bootstrap.servers", bootstrapServers);
    props.put("acks", ack.getVal());
    props.put("retries", retries);
    props.put("batch.size", batchSize);
    props.put("linger.ms", lingerMs);
    props.put("buffer.memory", bufferMemoryBytes);
    props.put("key.serializer", keySerializer);
    props.put("value.serializer", valueSerializer);
    producer = new KafkaProducer<>(props);
  }


  /**
   * Asynchronously send a record to a topic .
   */
  public Future<RecordMetadata> sendAsString(String topic, String value) {
    return producer.send(new ProducerRecord<String, String>(topic, value));
  }

  public Future<RecordMetadata> sendAsString(String topic, String key, String value) {
    return producer.send(new ProducerRecord<String, String>(topic, key, value));
  }

  public void setAck(KafkaAckEnum ack) {
    this.ack = ack;
  }

  public void setRetries(Integer retries) {
    this.retries = retries;
  }

  public void setBootstrapServers(String bootstrapServers) {
    this.bootstrapServers = bootstrapServers;
  }

  public void setBatchSize(Integer batchSize) {
    this.batchSize = batchSize;
  }

  public void setLingerMs(Long lingerMs) {
    this.lingerMs = lingerMs;
  }

  public void setBufferMemoryBytes(Long bufferMemoryBytes) {
    this.bufferMemoryBytes = bufferMemoryBytes;
  }

  public void setKeySerializer(String keySerializer) {
    this.keySerializer = keySerializer;
  }

  public void setValueSerializer(String valueSerializer) {
    this.valueSerializer = valueSerializer;
  }
}
