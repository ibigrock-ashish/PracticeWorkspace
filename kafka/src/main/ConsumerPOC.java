import java.util.Properties;
import java.util.Arrays;
import java.util.Random;
import java.io.FileReader;
import java.io.InputStream;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import com.google.common.io.Resources;

public class ConsumerPOC {

	public static void main(String[] args) throws Exception {

		// Check arguments length value
		if (args.length == 0) {
			System.out.println("Enter topic name");
			return;
		}

		// Kafka consumer con figuration settings
		String topicName = args[0].toString();
		// Properties props = new Properties();

		try (FileReader props = new FileReader("./resources/consumer.yml")) {
			Properties properties = new Properties();
			properties.load(props);
			if (properties.getProperty("group.id") == null) {
				properties.setProperty("group.id", "group-" + new Random().nextInt(100000));
			}

			properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
			properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

			KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);

			// Kafka Consumer subscribes list of topics here.
			consumer.subscribe(Arrays.asList(topicName));

			// print the topic name
			System.out.println("Subscribed to topic " + topicName);
			int i = 0;

			while (true) {
				ConsumerRecords<String, String> records = consumer.poll(100);
				for (ConsumerRecord<String, String> record : records)

					// print the offset,key and value for the consumer records.
					
					System.out.printf("offset = %d, key = %s, value = %s\n", record.offset(), record.key(),
							record.value());
			}
		}
	}
}
