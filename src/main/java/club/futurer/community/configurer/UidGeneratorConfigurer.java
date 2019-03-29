package club.futurer.community.configurer;

import club.futurer.community.business.uidgenerator.UidGenerator;
import club.futurer.community.business.uidgenerator.impl.CachedUidGenerator;
import club.futurer.community.business.uidgenerator.worker.WorkerIdAssigner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Uid CacheUidGenerator
 */
@Configuration
@AutoConfigureAfter({CommunityDruidDBConfigurer.class})
public class UidGeneratorConfigurer {

    @Autowired
    private WorkerIdAssigner workerIdAssigner;

    @Bean
    public UidGenerator uidGenerator() {
        CachedUidGenerator generator = new CachedUidGenerator();
        generator.setWorkerIdAssigner(workerIdAssigner);
        generator.setTimeBits(30);
        generator.setWorkerBits(27);
        generator.setSeqBits(6);
        generator.setEpochStr("2018-10-31");
        return generator;
    }
}
