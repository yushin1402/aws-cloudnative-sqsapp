package org.debugroom.mynavi.sample.aws.sqs.app.batch.step;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SampleTasklet implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution stepContribution,
                                ChunkContext chunkContext) throws Exception {


        StepExecution stepExecution = chunkContext.getStepContext().getStepExecution();

        String param = stepExecution.getJobParameters().getString("param");

        log.info(this.getClass().getName() + "#execute() starteds. input param : " + param);

        ExecutionContext jobExecutionContext = stepExecution.getJobExecution().getExecutionContext();

        jobExecutionContext.put("paramBySampleTasklet", "/test.txt");

        return RepeatStatus.FINISHED;

    }

}

