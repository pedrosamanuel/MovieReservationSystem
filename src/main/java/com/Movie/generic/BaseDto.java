package com.Movie.generic;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BaseDto<T> {

    private T id;

}