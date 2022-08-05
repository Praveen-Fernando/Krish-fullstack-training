package com.praveen.fueldistributionsystem.orderservice.service;

//import com.praveen.fueldistributionsystem.orderservice.model.OrderSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import java.util.Objects;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class SequenceGeneratorService {

    @Autowired
    private MongoOperations mongoOperations;

//    public int getSequenceNumber(String sequenceName){
//        OrderSequence orderSequence = mongoOperations.findAndModify(query(where("_orderId").is(sequenceName)),
//                new Update().inc("seqNo",1), options().returnNew(true).upsert(true),
//                OrderSequence.class);
//        return !Objects.isNull(orderSequence) ? orderSequence.getSeqNo() : 1;
//    }
}
