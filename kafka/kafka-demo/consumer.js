import {Kafka} from 'kafkajs';

const kafka = new Kafka({
    clientId: 'employee-service',
    brokers: ['localhost:9092'],
});

const consumer = kafka.consumer({
    groupId: 'project',
    retry: {
        initialRetryTime: 100,
        retries: 0,
    },
});

await consumer.subscribe({topic: 'employee-topic', fromBeginning: true});

await consumer.run({
    autoCommit: false,
    
    eachMessage : async ({topic, partition, message, heartbeat}) =>{
        console.log({        
        partition,
        offset: message.offset,
        value: message.value.toString(),
    });

    await  new Promise((resolve) => setTimeout(resolve, 1000));

    await heartbeat();
    
    //if(message.offset == 21) throw new Error("Something");
    
    await consumer.commitOffsets({
        topic, 
        partition,
        offset: Number(message.offset + 1).toString(),
    });
},
});
