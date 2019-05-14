package com.cognizant.projectmanager.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import com.cognizant.projectmanager.pojo.Counter;


@Service
public class CounterService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Autowired 
	private MongoOperations mongo;
	
	
	public long getNextSequence(String collectionName) {
		log.info("Inside getNextSequence()");
		Query query = new Query(Criteria.where("_id").is(collectionName));
		log.info("Query : "+query.toString());
		FindAndModifyOptions options = new FindAndModifyOptions();
		options.returnNew(true);
		options.upsert(false);
		options.remove(false);
		log.info("Options : "+options.toString());
		Counter counter = mongo.findAndModify(
	      query, 
	      new Update().inc("seq", 1),
	      options,
	      Counter.class
	     );
		log.info("ID : "+counter.getId()+" && Seq : " + counter.getSeq());
	    return counter.getSeq();
	  }
}
