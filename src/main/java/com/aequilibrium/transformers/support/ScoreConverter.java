package com.aequilibrium.transformers.support;

import com.aequilibrium.transformers.domain.Score;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ScoreConverter implements AttributeConverter<Score, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Score attribute) {
        return attribute.intValue();
    }

    @Override
    public Score convertToEntityAttribute(Integer dbData) {
        return new Score(dbData);
    }
}