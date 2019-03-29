//package com.mealcome.warehouse.configurer;
//
//import com.mealcome.warehouse.notify.service.NotifyService;
//import org.quartz.CronTrigger;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
//import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
//import org.springframework.scheduling.quartz.SchedulerFactoryBean;
//
///**
// * Created by ZYC on 2017/1/16.
// */
////@Configuration
////@EnableScheduling
//public class SchedulerConfigurer {
//    private static Logger logger = LoggerFactory.getLogger(SchedulerConfigurer.class.getName());
//
//    @Autowired
//    private SchedulerFactoryBean schedulerFactoryBean;
//
//    @Bean(name="localSyncFactoryBean")
////    @Qualifier("localSyncFactoryBean")
//    public MethodInvokingJobDetailFactoryBean localSyncJobDetailFactoryBean(NotifyService notifyService){
//        MethodInvokingJobDetailFactoryBean jobDetailFactoryBean = new MethodInvokingJobDetailFactoryBean();
//        //TODO 这里可以有setBeanName，setClass等等
//        jobDetailFactoryBean.setTargetObject(notifyService);
//        jobDetailFactoryBean.setTargetMethod("allottingDelayNotify");
//        jobDetailFactoryBean.setConcurrent(false);
//        return jobDetailFactoryBean;
//    }
//
//////    @Bean(name="localSyncFactoryBean")
////////    @Qualifier("localSyncFactoryBean")
//////    public MethodInvokingJobDetailFactoryBean localSyncJobDetailFactoryBean(MaxIdService maxIdService){
//////        MethodInvokingJobDetailFactoryBean jobDetailFactoryBean = new MethodInvokingJobDetailFactoryBean();
//////        //TODO 这里可以有setBeanName，setClass等等
//////        jobDetailFactoryBean.setTargetObject(maxIdService);
//////        jobDetailFactoryBean.setTargetMethod("maxId");
//////        jobDetailFactoryBean.setConcurrent(false);
//////        return jobDetailFactoryBean;
//////    }
////
//    @Bean(name="localSyncCronTrigger")
//    public CronTriggerFactoryBean localSyncCronTriggerBean(@Qualifier("localSyncFactoryBean") MethodInvokingJobDetailFactoryBean localSyncFactoryBean){
//        CronTriggerFactoryBean triggerFactoryBean = new CronTriggerFactoryBean();
//        triggerFactoryBean.setJobDetail(localSyncFactoryBean.getObject());
//        triggerFactoryBean.setCronExpression("0 0/5 * ? * *");//每隔5分钟触发
////        triggerFactoryBean.setCronExpression(wiseConfig.getLocalSyncCron());
//        return triggerFactoryBean;
//    }
//
//    @Bean(name="schedulerFactoryBean")
//    public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean[] cronTriggerFactoryBeans){
//        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
//        if(cronTriggerFactoryBeans != null && cronTriggerFactoryBeans.length > 0){
//            CronTrigger[] triggers = new CronTrigger[cronTriggerFactoryBeans.length];
//            for(int i = 0; i < cronTriggerFactoryBeans.length; i++){
//                triggers[i] = cronTriggerFactoryBeans[i].getObject();
//            }
//            schedulerFactoryBean.setTriggers(triggers);
//        }
//        schedulerFactoryBean.setStartupDelay(10);
//        return schedulerFactoryBean;
//    }
//
//}
