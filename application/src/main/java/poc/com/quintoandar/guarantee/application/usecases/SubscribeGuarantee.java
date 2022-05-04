package poc.com.quintoandar.guarantee.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poc.com.quintoandar.guarantee.domain.base.DomainBusinessException;
import poc.com.quintoandar.guarantee.domain.entities.GuaranteeSubscription;
import poc.com.quintoandar.guarantee.domain.ports.repository.GuaranteeRepository;
import poc.com.quintoandar.guarantee.domain.ports.repository.GuaranteeSubscriptionRepository;
import poc.com.quintoandar.guarantee.domain.usecases.subscribeguarantee.DomainSubscribeGuarantee;
import poc.com.quintoandar.guarantee.domain.usecases.subscribeguarantee.SubscribeGuaranteeInput;
import poc.com.quintoandar.guarantee.domain.usecases.subscribeguarantee.SubscribeGuaranteeOutput;

import java.util.concurrent.atomic.AtomicReference;

@Service
public class SubscribeGuarantee implements DomainSubscribeGuarantee {

    private final GuaranteeSubscriptionRepository guaranteeSubscriptionRepository;

    private final GuaranteeRepository guaranteeRepository;

    @Autowired
    public SubscribeGuarantee(GuaranteeSubscriptionRepository guaranteeSubscriptionRepository,
                              GuaranteeRepository guaranteeRepository) {
        this.guaranteeSubscriptionRepository = guaranteeSubscriptionRepository;
        this.guaranteeRepository = guaranteeRepository;
    }

    @Override
    public SubscribeGuaranteeOutput execute(SubscribeGuaranteeInput input) throws DomainBusinessException {
        var guarantee = this.guaranteeRepository
                .findById(input.getGuaranteeId())
                .orElseThrow(() -> new DomainBusinessException(404, "Garantia não encontrada!"));

        var subscription = new AtomicReference<GuaranteeSubscription>(null);
        this.guaranteeSubscriptionRepository
                .findByDocumentationId(input.getDocumentationId())
                .ifPresentOrElse(
                        (existentSubscription) -> {
                            existentSubscription.restoreGuarantee(input.getValue(), guarantee);
                            this.guaranteeSubscriptionRepository.save(existentSubscription);
                            subscription.set(existentSubscription);
                        },
                        () -> {
                            var newSubscription = this.guaranteeSubscriptionRepository
                                    .save(new GuaranteeSubscription(input.getUserId(), input.getValue(),
                                            guarantee, input.getDocumentationId()));
                            subscription.set(newSubscription);
                        });

        return new SubscribeGuaranteeOutput(subscription.get().getId());
    }
}
