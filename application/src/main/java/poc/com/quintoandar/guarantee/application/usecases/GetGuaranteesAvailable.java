package poc.com.quintoandar.guarantee.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poc.com.quintoandar.guarantee.domain.base.DomainBusinessException;
import poc.com.quintoandar.guarantee.domain.ports.repository.RiskCategoryRepository;
import poc.com.quintoandar.guarantee.domain.usecases.getguaranteeavailable.DomainGetGuaranteesAvailable;
import poc.com.quintoandar.guarantee.domain.usecases.getguaranteeavailable.GetGuaranteesAvailableInput;
import poc.com.quintoandar.guarantee.domain.usecases.getguaranteeavailable.GetGuaranteesAvailableOutput;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetGuaranteesAvailable implements DomainGetGuaranteesAvailable {

    private final RiskCategoryRepository riskCategoryRepository;

    public GetGuaranteesAvailable(RiskCategoryRepository riskCategoryRepository) {
        this.riskCategoryRepository = riskCategoryRepository;
    }

    @Override
    public List<GetGuaranteesAvailableOutput> execute(GetGuaranteesAvailableInput input) throws DomainBusinessException {
        var riskCategory = this.riskCategoryRepository
                .findById(input.getRiskCategoryId())
                .orElseThrow(() -> new DomainBusinessException("Categoria de risco não encontrada"));

        return riskCategory
                .getAllowedGuarantees()
                .stream()
                .map(guarantee -> GetGuaranteesAvailableOutput.builder()
                        .guaranteeId(guarantee.getId())
                        .description(guarantee.getName())
                        .value(input.getBaseValue() != null ? guarantee.getPreviewValue(input.getBaseValue()) : null)
                        .build())
                .collect(Collectors.toList());
    }
}
