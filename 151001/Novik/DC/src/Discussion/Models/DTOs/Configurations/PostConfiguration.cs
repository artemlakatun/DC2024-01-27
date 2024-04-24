﻿using Discussion.Models.Entity;

namespace Discussion.Models.DTOs.Configurations;

public class CassandraMappings : Cassandra.Mapping.Mappings
{
    public CassandraMappings()
    {
        For<Post>().PartitionKey(p => p.country)
            .Column(p => p.newsId)
            .Column(p => p.id);
    }
}