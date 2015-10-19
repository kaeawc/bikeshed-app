package io.kaeawc.bikeshed;

import java.util.Arrays;
import java.util.List;

import io.kaeawc.bikeshed.data.models.Photo;

public class Photos {

    public List<Photo> getAll() {
        return Arrays.asList(
                new Photo(),
                new Photo(),
                new Photo()
        );
    }
}
