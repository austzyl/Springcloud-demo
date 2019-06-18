package com.nr.job.eureka.client.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Created by yaleizhu on 2019/4/3.
 * description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Job implements Serializable{
    private String jobName;
    private String jobStatus;
    private String createTime;
    private String author;
}
