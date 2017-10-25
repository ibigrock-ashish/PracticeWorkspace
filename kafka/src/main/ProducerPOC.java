import java.io.FileReader;
import java.util.Properties;
import java.util.Random;

import org.apache.kafka.clients.producer.Producer;

import org.apache.kafka.clients.producer.KafkaProducer;

import org.apache.kafka.clients.producer.ProducerRecord;

public class ProducerPOC {

	public static void main(String[] args) throws Exception {

		// Check arguments length value
		if (args.length == 0) {
			System.out.println("Enter topic name");
			return;
		}

		// Kafka consumer configuration settings
		String topicName = args[0].toString();
		// Properties props = new Properties();

		try (FileReader props = new FileReader("./resources/producer.yml")) {
			Properties properties = new Properties();
			properties.load(props);
			if (properties.getProperty("group.id") == null) {
				properties.setProperty("group.id", "group-" + new Random().nextInt(100000));
			}

			properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
			properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
			properties.put("partition.assignment.strategy", "range");
			properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
			properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

			Producer<String, String> producer = new KafkaProducer<String, String>(properties);

			for (int i = 0; i < 10; i++)
				producer.send(new ProducerRecord<String, String>(topicName, Integer.toString(i),
						"Hi Number is " + Integer.toString(i)));
			System.out.println("Message sent successfully");
			producer.close();

		}
	}
}