package com.example.discussion.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Violation {

    private final String note;
    private final long status;
}