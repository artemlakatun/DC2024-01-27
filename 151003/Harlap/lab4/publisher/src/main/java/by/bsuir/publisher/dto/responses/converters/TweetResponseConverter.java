package by.bsuir.publisher.dto.responses.converters;

import by.bsuir.publisher.domain.Tweet;
import by.bsuir.publisher.dto.responses.TweetResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TweetResponseConverter {
    @Mapping(source = "author.id", target = "authorId")
    TweetResponseDto toDto(Tweet tweet);
}
