package com.jbc.zipcodelookup;

import com.redis.om.spring.repository.RedisDocumentRepository;

public interface ZipCodeRepo extends RedisDocumentRepository<ZipCode, String> {
}
