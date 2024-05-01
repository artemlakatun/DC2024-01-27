package org.example.publisher.impl.label.mapper.Impl;

import org.example.publisher.impl.label.Label;
import org.example.publisher.impl.label.mapper.LabelMapper;
import org.example.publisher.impl.label.dto.LabelRequestTo;
import org.example.publisher.impl.label.dto.LabelResponseTo;
import org.example.publisher.impl.tweet.Tweet;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class LabelMapperImpl implements LabelMapper {
    @Override
    public LabelRequestTo labelToRequestTo(Label label) {
        List<BigInteger> ids = new ArrayList<>();
        for (var item: label.getTweets()) {
            ids.add(item.getId());
        }

        return new LabelRequestTo(
                label.getTg_id(),
                label.getName(),
                ids
        );
    }

    @Override
    public List<LabelRequestTo> labelToRequestTo(Iterable<Label> labels) {
        return StreamSupport.stream(labels.spliterator(), false)
                .map(this::labelToRequestTo)
                .collect(Collectors.toList());
    }

    @Override
    public Label dtoToEntity(LabelRequestTo labelRequestTo, List<Tweet> twets) {
        return new Label(
                labelRequestTo.getId(),
                labelRequestTo.getName(),
                twets
        );
    }

    @Override
    public LabelResponseTo labelToResponseTo(Label label) {
        List<BigInteger> ids = new ArrayList<>();
        for (var item: label.getTweets()) {
            ids.add(item.getId());
        }

        return new LabelResponseTo(
                label.getTg_id(),
                label.getName(),
                ids
        );
    }

    @Override
    public List<LabelResponseTo> labelToResponseTo(Iterable<Label> labels) {
        return StreamSupport.stream(labels.spliterator(), false)
                .map(this::labelToResponseTo)
                .collect(Collectors.toList());
    }
}
