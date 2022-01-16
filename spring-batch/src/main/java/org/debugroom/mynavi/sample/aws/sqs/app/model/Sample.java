package org.debugroom.mynavi.sample.aws.sqs.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Sample implements Serializable {

    private String stepParam;

}
