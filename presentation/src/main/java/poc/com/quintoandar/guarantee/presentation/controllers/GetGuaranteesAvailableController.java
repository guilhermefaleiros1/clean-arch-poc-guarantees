package poc.com.quintoandar.guarantee.presentation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import poc.com.quintoandar.guarantee.domain.base.DomainBusinessException;
import poc.com.quintoandar.guarantee.domain.usecases.getguaranteeavailable.DomainGetGuaranteesAvailable;
import poc.com.quintoandar.guarantee.domain.usecases.getguaranteeavailable.GetGuaranteesAvailableInput;
import poc.com.quintoandar.guarantee.domain.usecases.getguaranteeavailable.GetGuaranteesAvailableOutput;

import java.util.List;

@RestController
@RequestMapping("/v1/guarantees")
public class GetGuaranteesAvailableController {

    private final DomainGetGuaranteesAvailable getGuaranteesAvailable;

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public GetGuaranteesAvailableController(DomainGetGuaranteesAvailable getGuaranteesAvailable, KafkaTemplate<String, String> kafkaTemplate) {
        this.getGuaranteesAvailable = getGuaranteesAvailable;
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/available/{id}")
    public ResponseEntity<List<GetGuaranteesAvailableOutput>> execute(
            @PathVariable("id") Long id,
            @RequestParam(required = false) Long value) throws DomainBusinessException {
        var user = this.getGuaranteesAvailable.execute(new GetGuaranteesAvailableInput(id, value));
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
