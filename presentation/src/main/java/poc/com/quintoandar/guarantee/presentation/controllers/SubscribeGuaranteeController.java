package poc.com.quintoandar.guarantee.presentation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import poc.com.quintoandar.guarantee.domain.base.DomainBusinessException;
import poc.com.quintoandar.guarantee.domain.usecases.subscribeguarantee.DomainSubscribeGuarantee;
import poc.com.quintoandar.guarantee.domain.usecases.subscribeguarantee.SubscribeGuaranteeInput;
import poc.com.quintoandar.guarantee.domain.usecases.subscribeguarantee.SubscribeGuaranteeOutput;


@RestController
@RequestMapping("/v1/guarantees")
public class SubscribeGuaranteeController {

    private final DomainSubscribeGuarantee subscribeGuarantee;

    @Autowired
    public SubscribeGuaranteeController(DomainSubscribeGuarantee subscribeGuarantee) {
        this.subscribeGuarantee = subscribeGuarantee;
    }

    @PostMapping("/subscribe")
    public ResponseEntity<SubscribeGuaranteeOutput> execute(
            @RequestBody SubscribeGuaranteeInput request) throws DomainBusinessException {
        var response = this.subscribeGuarantee.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
