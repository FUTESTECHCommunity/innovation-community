package club.futurer.community.business.uidgenerator.worker;

/**
 * Represents a worker id assigner for {@link DefaultUidGenerator}
 * 
 */
public interface WorkerIdAssigner {

    /**
     * Assign worker id for {@link DefaultUidGenerator}
     * 
     * @return assigned worker id
     */
    long assignWorkerId();

}
